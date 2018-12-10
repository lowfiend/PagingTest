package com.lowfiend.pagingtest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import com.lowfiend.pagingtest.model.Item;
import com.lowfiend.pagingtest.paging.ItemDataFactory;

/**
 * Created by Neyo on 2018/12/10.
 */
public class MainVM extends ViewModel {

    private int PAGE_SIZE = 10;
    private int INITIAL_LOAD_KEY = 0;

    LiveData<PagedList<Item>> mItemLiveData;

    public MainVM() {
        ItemDataFactory itemDataFactory = new ItemDataFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(PAGE_SIZE *2)
                .setPageSize(PAGE_SIZE).build();
        mItemLiveData = new LivePagedListBuilder<>(itemDataFactory, config).setInitialLoadKey(INITIAL_LOAD_KEY).build();

    }
}
