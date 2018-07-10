package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.example.android.todolist.database.AppDatabase;

// COMPLETED Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // COMPLETED Add two member variables. One for the database and one for the taskId
    private AppDatabase mDb;
    private int mTaskId;

    // COMPLETED Initialize the member variables in the constructor with the parameters received
    public AddTaskViewModelFactory(AppDatabase mDb, int taskId) {
        this.mDb = mDb;
        this.mTaskId = taskId;
    }

    // COMPLETED Uncomment the following method
    // Note: This can be reused with minor modifications
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
