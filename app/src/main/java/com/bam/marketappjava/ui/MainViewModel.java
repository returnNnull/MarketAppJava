package com.bam.marketappjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bam.marketappjava.data.room.LocalDataBase;
import com.bam.marketappjava.data.room.category.Category;
import com.bam.marketappjava.data.room.product.Product;

import java.util.List;
import java.util.Objects;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<Category>> categories;
    private LiveData<List<Product>> products = LocalDataBase.getInstance(getApplication()).productDao().getAll();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Category>> getCategories(){
        if (categories == null){
            categories = LocalDataBase.getInstance(getApplication()).categoryDao().getAll();
        }
        return categories;
    }

    public int getCategorySize(){
        return Objects.requireNonNull(categories.getValue()).size();
    }
}
