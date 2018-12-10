package com.lowfiend.pagingtest.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import com.lowfiend.pagingtest.data.ItemData;
import com.lowfiend.pagingtest.model.Item;
import java.util.List;

/**
 * Created by Neyo on 2018/12/10.
 */
public class PageKeyFactogry extends PageKeyedDataSource<Integer, Item> {
    @Override public void loadInitial(@NonNull LoadInitialParams<Integer> params,
            @NonNull LoadInitialCallback<Integer, Item> callback) {

        int size = params.requestedLoadSize;
        List<Item> items = ItemData.getItem(size);

        callback.onResult(items, items.get(0).getId(), items.get(items.size()-1).getId());
    }

    @Override public void loadBefore(@NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, Item> callback) {

    }

    @Override public void loadAfter(@NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, Item> callback) {

        int key = params.key;
        int size = params.requestedLoadSize;

        List<Item> items = ItemData.getIncreaseItems(key + 1, size);

        callback.onResult(items, items.get(items.size() - 1).getId());
    }
}
