package com.example.swapi;

//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.ViewModel;
//import android.arch.paging.LivePagedListBuilder;
//import android.arch.paging.PageKeyedDataSource;
//import android.arch.paging.PagedList;
//import android.arch.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ItemViewModel extends ViewModel {

    LiveData<PagedList<Results>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Results>> liveDataSource;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                       .setPageSize(5)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
