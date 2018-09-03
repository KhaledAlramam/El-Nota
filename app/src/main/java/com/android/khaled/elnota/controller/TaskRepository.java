package com.android.khaled.elnota.controller;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.android.khaled.elnota.model.AppDatabase;
import com.android.khaled.elnota.model.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    public TaskRepository(Application application) {
        AppDatabase dp = AppDatabase.getDatabase(application);
        mTaskDao = dp.taskDao();
        mAllTasks = mTaskDao.queryAll();
    }

    //TODO add get Task By id usage to get 1 task

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void insert(Task task) {
        new insertAsyncTask(mTaskDao).execute(task);
    }

    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDao mAsyncTaskDao;

        insertAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mAsyncTaskDao.insert(tasks[0]);
            return null;
        }
    }
}