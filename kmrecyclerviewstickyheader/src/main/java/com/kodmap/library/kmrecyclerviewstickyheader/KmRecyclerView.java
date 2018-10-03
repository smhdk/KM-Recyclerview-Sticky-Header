package com.kodmap.library.kmrecyclerviewstickyheader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class KmRecyclerView extends RecyclerView {
    public KmRecyclerView(@NonNull Context context) {
        super(context);
    }

    public KmRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KmRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        super.setAdapter(adapter);
        if (getAdapter() instanceof KmStickyListener) {
            setStickyItemDecoration();
        }
    }

    private void setStickyItemDecoration() {
        KmHeaderItemDecoration itemDecoration = new KmHeaderItemDecoration((KmStickyListener) getAdapter());
        this.addItemDecoration(itemDecoration);
    }

}
