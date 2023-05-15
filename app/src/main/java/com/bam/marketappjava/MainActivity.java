package com.bam.marketappjava;

import android.os.Bundle;

import com.bam.marketappjava.data.room.LocalDataBase;
import com.bam.marketappjava.data.room.category.Category;
import com.bam.marketappjava.ui.MainViewModel;
import com.bam.marketappjava.ui.main.ProductsCollectionAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import com.bam.marketappjava.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TabLayout tabs = binding.tabs;
        ViewPager2 viewPager2 = binding.viewPager;

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.getCategories().observe(this, categories -> {
            viewPager2.setAdapter(new ProductsCollectionAdapter(this, categories.size()));
            new TabLayoutMediator(tabs, viewPager2, (tab, position) -> {
                tab.setText(categories.get(position).getName());
            }).attach();
        });


        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }
}