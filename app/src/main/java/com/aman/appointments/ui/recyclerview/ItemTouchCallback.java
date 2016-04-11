package com.aman.appointments.ui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Aman on 11-04-2016.
 */
public class ItemTouchCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperAdapter adapter;
    public ItemTouchCallback(ItemTouchHelperAdapter adapter){
        this.adapter=adapter;
    }
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int swipeFlags=ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(-1,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition(),direction);
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
