package Networking;

import java.util.List;

import Networking.model.Project;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by pratikb on 01-03-2018.
 */

public interface Webservices {
    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);
}
