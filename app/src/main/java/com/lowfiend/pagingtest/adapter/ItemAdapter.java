package com.lowfiend.pagingtest.adapter;

import android.arch.paging.PagedList;
import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lowfiend.pagingtest.R;
import com.lowfiend.pagingtest.holder.ItemHolder;
import com.lowfiend.pagingtest.model.Item;

/**
 * Created by Neyo on 2018/12/10.
 */
public class ItemAdapter extends PagedListAdapter<Item, ItemHolder> {

    private View mEmptyView;

    public ItemAdapter() {
        super(mItemCallback);
    }

    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
    }

    @Override public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);

        return new ItemHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        Item item = getItem(position);
        itemHolder.bindTo(item);
    }

    @Override public void submitList(PagedList<Item> pagedList) {
        super.submitList(pagedList);
        mEmptyView.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    private static final DiffUtil.ItemCallback<Item> mItemCallback = new DiffUtil.ItemCallback<Item>() {
        @Override public boolean areItemsTheSame(Item oldItem, Item newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override public boolean areContentsTheSame(Item oldItem, Item newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };
}

