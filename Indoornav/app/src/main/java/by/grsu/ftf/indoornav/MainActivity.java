package by.grsu.ftf.indoornav;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.indoornav.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import by.grsu.ftf.beaconlib.BeaconControllerService;
import by.grsu.ftf.indoornav.network.ApiFactory;
import by.grsu.ftf.indoornav.network.response.Repo;
import by.grsu.ftf.indoornav.storage.Storage;
import by.grsu.ftf.indoornav.storage.TestBeacon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/*
 * This class is the main, some kind of kernel program.
 * The program goes to the Bluetooth class at startup, which checks if Bluetooth is turned on.
 */

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private ListView listView;
    private static List<String> LIST_BEACON = new ArrayList<>();
    static ArrayAdapter<String> mAdapter;

    private BroadcastReceiver br;
    public static final String KEY_INTENT_FILTER = "by.grsu.ftf.indoornav.FILTER_ACTIVITY";
    public static final String KEY_VALUE_LIST = "KEY_VALUE_LIST";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnClickListeners();
        initBroadcast();
        goToNetwork();
    }

    private void initViews() {
        start = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.button1);
        listView = (ListView) findViewById(R.id.ListView);
        mAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, LIST_BEACON);
    }

    private void setOnClickListeners() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, BeaconControllerService.class));
                startService(new Intent(MainActivity.this, TestBeacon.class));
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, BeaconControllerService.class));
                stopService(new Intent(MainActivity.this, TestBeacon.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        regReceiver();

        String LIST_A = Storage.getRepository(getApplicationContext());
        String[] MASSIF_BEACON = LIST_A.split(",");
        LIST_BEACON.clear();
        for (int i = 0; i < MASSIF_BEACON.length; i++) {
            LIST_BEACON.add(MASSIF_BEACON[i]);
        }
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }

    private void regReceiver() {
        registerReceiver(br, new IntentFilter(KEY_INTENT_FILTER));
    }

    private void initBroadcast() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra(KEY_VALUE_LIST)) {
                    String LIST_A = intent.getStringExtra(KEY_VALUE_LIST);

                    Storage.setRepository(getApplicationContext(), LIST_A);
                    String[] MASSIF_BEACON = LIST_A.split(",");
                    LIST_BEACON.clear();
                    for (int i = 0; i < MASSIF_BEACON.length; i++) {
                        LIST_BEACON.add(MASSIF_BEACON[i]);
                    }
                    listView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }
            }
        };
    }

    private void goToNetwork(){
        List<Float> floatList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            floatList.add((float)i);
        }
        Log.d("LOG_LIST_MY",floatList.toString());

        List<Float> g = new Gson().fromJson(floatList.toString(),new TypeToken<List<Float>>(){}.getType());


        ApiFactory.create().listRepos("user").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Toast.makeText(MainActivity.this,"onResponse",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
