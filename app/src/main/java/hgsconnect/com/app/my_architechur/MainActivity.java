package hgsconnect.com.app.my_architechur;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Observable;

import Networking.WebserviceRepo;
import Networking.model.Project;
import Viewmodel.ProjectlistViewmodel;

public class MainActivity extends AppCompatActivity {


   ListView listview;
   TextView txt;
   Listadapter listadapter;
    List<Project> my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
     //   WebserviceRepo.getRepoInstance().getprojectlist("google");

        ProjectlistViewmodel viewmodel=ViewModelProviders.of(this).get(ProjectlistViewmodel.class);
        observeViewModel(viewmodel);


       //  getLifecycle().addObserver(new Myoberver());
    }

    private void observeViewModel(final ProjectlistViewmodel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                 Log.d("data",new Gson().toJson(projects));
                    listadapter=new Listadapter(MainActivity.this,projects);
                    listview.setAdapter(listadapter);
                }
            }
        });
    }


}
