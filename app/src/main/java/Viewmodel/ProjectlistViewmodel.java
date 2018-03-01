package Viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import Networking.WebserviceRepo;
import Networking.model.Project;

/**
 * Created by pratikb on 01-03-2018.
 */

public class ProjectlistViewmodel extends ViewModel {
    private LiveData<List<Project>> projectlistObeserver;

    ProjectlistViewmodel() {
        projectlistObeserver = WebserviceRepo.getRepoInstance().getprojectlist("google");

    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectlistObeserver;
    }

}
