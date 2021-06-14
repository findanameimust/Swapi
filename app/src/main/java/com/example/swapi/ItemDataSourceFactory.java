package com.example.swapi;

//import android.arch.lifecycle.MutableLiveData;
//import android.arch.paging.DataSource;
//import android.arch.paging.PageKeyedDataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer,Results >> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Results>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
