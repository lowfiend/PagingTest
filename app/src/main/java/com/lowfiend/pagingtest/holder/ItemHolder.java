package com.lowfiend.pagingtest.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.lowfiend.pagingtest.R;
import com.lowfiend.pagingtest.model.Item;

/**
 * Created by Neyo on 2018/12/10.
 */
public class ItemHolder extends RecyclerView.ViewHolder {

    private TextView viewId;
    private TextView viewName;


    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        viewId = itemView.findViewById(R.id.view_id);
        viewName = itemView.findViewById(R.id.view_name);
    }

    public void bindTo (Item item) {
        viewId.setText("" + item.getId());
        viewName.setText(item.getName());
    }
}
