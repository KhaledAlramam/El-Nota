package com.android.khaled.elnota;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.khaled.elnota.model.Task;
import com.android.khaled.elnota.view.TaskViewModel;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private TaskViewModel mTaskViewModel;


    @OnClick(R.id.fab) void addTask(){
        Intent newTask=new Intent(MainActivity.this, AddTask.class);
        startActivity(newTask);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RecyclerView recyclerView = findViewById(R.id.list);
        final TaskListAdapter adapter = new TaskListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTaskViewModel= ViewModelProviders.of(this).get(TaskViewModel.class);
        mTaskViewModel.getmAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                adapter.setTasks(tasks);
            }
        });
    }
}
