package by.grsu.ftf.indoornav.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Вадим on 23.09.2017.
 */

public class ApiFactory {

    private static GitHubService api;


    private static void createApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        api = retrofit.create(GitHubService.class);
    }

    public static GitHubService create() {
        if (api == null) {
            createApi();
        }
        return api;
    }

}
