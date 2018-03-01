package Networking;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import Networking.model.Project;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by pratikb on 01-03-2018.
 */

public class WebserviceRepo {
    private Webservices webservices;
    private static WebserviceRepo repo;
    MutableLiveData<List<Project>> data;

    WebserviceRepo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
               webservices = retrofit.create(Webservices.class);
    }

    public static WebserviceRepo getRepoInstance() {
        if (repo == null) {
            repo = new WebserviceRepo();
        }
        return repo;

    }

    public LiveData<List<Project>> getprojectlist(String id) {
        data = new MutableLiveData<>();
        webservices.getProjectList(id).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Response<List<Project>> response, Retrofit retrofit) {
                Log.d("getresponce",new Gson().toJson(response));
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                data.setValue(null);
            }
        });


        return data;
    }


}
