package com.bam.marketappjava.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bam.marketappjava.R;
import com.bam.marketappjava.data.adapters.ProductRecyclerView;
import com.bam.marketappjava.data.room.product.Product;
import com.bam.marketappjava.databinding.FragmentMainBinding;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentMainBinding binding;
    private ProductRecyclerView productRecyclerView;

    public static PlaceholderFragment newInstance(int id) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productRecyclerView = new ProductRecyclerView();

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        if (savedInstanceState != null) {
            pageViewModel.sortByCategory(savedInstanceState.getInt(ARG_SECTION_NUMBER));
        }
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pageViewModel.getProducts().observe(getViewLifecycleOwner(), products -> {
            productRecyclerView.setList(products);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}