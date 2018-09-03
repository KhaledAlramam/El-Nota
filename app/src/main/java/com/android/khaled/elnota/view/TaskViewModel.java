package com.android.khaled.elnota.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.android.khaled.elnota.controller.TaskDao;
import com.android.khaled.elnota.controller.TaskRepository;
import com.android.khaled.elnota.model.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mTaskRepository;
    private LiveData<List<Task>> mAllTasks;

    public TaskViewModel(Application application){
        super(application);
        mTaskRepository= new TaskRepository(application);
        mAllTasks=mTaskRepository.getAllTasks();
    }


    public LiveData<List<Task>> getmAllTasks() {
        return mAllTasks;
    }

    public void insert(Task task){
        mTaskRepository.insert(task);
    }

    
}
