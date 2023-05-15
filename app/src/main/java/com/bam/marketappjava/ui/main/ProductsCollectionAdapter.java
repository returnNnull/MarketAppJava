package com.bam.marketappjava.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ProductsCollectionAdapter extends FragmentStateAdapter {

    private int size;

    public ProductsCollectionAdapter(@NonNull FragmentActivity fragmentActivity, int size) {
        super(fragmentActivity);
        this.size = size;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PlaceholderFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
