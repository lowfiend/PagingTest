package com.lowfiend.pagingtest.paging;

import android.arch.paging.DataSource;
import com.lowfiend.pagingtest.model.Item;

/**
 * Created by Neyo on 2018/12/10.
 */
public class ItemDataFactory extends DataSource.Factory<Integer, Item> {

    private PageKeyFactogry mPageKeyFactogry = new PageKeyFactogry();

    @Override public DataSource<Integer, Item> create() {
        return mPageKeyFactogry;
    }

    public PageKeyFactogry getPageKeyFactogry() {
        return mPageKeyFactogry;
    }
}
