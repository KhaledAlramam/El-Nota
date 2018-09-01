package com.android.khaled.elnota.controller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.android.khaled.elnota.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> queryAll();

    @Query("SELECT * FROM task_table WHERE id=:id")
    Task getTaskById(int id);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);
}
