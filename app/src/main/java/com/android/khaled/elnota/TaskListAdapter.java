package com.android.khaled.elnota;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.khaled.elnota.model.Task;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>{
    class TaskViewHolder extends RecyclerView.ViewHolder{
        private final TextView taskItemView;
        private TaskViewHolder(View itemView){
            super(itemView);
            taskItemView=itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of words


    public TaskListAdapter(Context context){
        mInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.task_item,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if (mTasks != null) {
            Task currentTask = mTasks.get(position);
            holder.taskItemView.setText(currentTask.getTaskName());

        }else {
            holder.taskItemView.setText("Add tasks.!");
        }
    }

    void setTasks(List<Task> tasks){
        mTasks = tasks;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;

    }
}
