package com.bam.marketappjava.data.adapters;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.bam.marketappjava.R;
import com.bam.marketappjava.data.room.product.Product;
import com.bam.marketappjava.databinding.ProductItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductRecyclerView extends RecyclerView.Adapter<ProductRecyclerView.ViewHolder> {

    private List<Product> __list = new ArrayList<>();
    private ItemClickListener __listener;


    public interface ItemClickListener {
        void click(Product product);
    }

    public void observe(ItemClickListener listener) {
        __listener = listener;
    }

    public void setList(List<Product> list) {
        __list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().setProduct(__list.get(position));
        holder.getBinding().getRoot().setOnClickListener(v -> {
            __listener.click(__list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return __list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ProductItemBinding __binding ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            __binding = DataBindingUtil.findBinding(itemView);
        }

        public ProductItemBinding getBinding() {
            return __binding;
        }
    }
}
