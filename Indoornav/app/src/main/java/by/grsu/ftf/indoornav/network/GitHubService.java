package by.grsu.ftf.indoornav.network;

import java.util.List;

import by.grsu.ftf.indoornav.network.response.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Вадим on 23.09.2017.
 */

public interface GitHubService {

    String baseUrl="https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
