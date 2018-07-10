package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// COMPLETED Make this class extend ViewModel
class AddTaskViewModel extends ViewModel {

    // COMPLETED Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> mTaskEntry;
    private static final String TAG = AddTaskViewModel.class.getSimpleName();

    // COMPLETED Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    AddTaskViewModel(@NonNull AppDatabase appDatabase, int taskId) {
        Log.d(TAG, "Actively retrieving a specific task from the DataBase");
        mTaskEntry = appDatabase.taskDao().loadTaskById(taskId);

    }

    // COMPLETED Create a getter for the task variable
    LiveData<TaskEntry> getTask() {
        return this.mTaskEntry;
    }
}
