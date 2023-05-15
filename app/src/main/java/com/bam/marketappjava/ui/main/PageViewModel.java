package com.bam.marketappjava.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.bam.marketappjava.data.room.LocalDataBase;
import com.bam.marketappjava.data.room.category.Category;
import com.bam.marketappjava.data.room.product.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PageViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Product>> productLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> categories  = new MutableLiveData<>();

    public PageViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getProducts(){
        return productLiveData;
    }

    public LiveData<List<Category>> getCategories(){
        return categories;
    }

    public void sortByCategory(int id){
        new Thread(() -> {
            List<Product> products = LocalDataBase.getInstance(getApplication()).productDao().getByCategory(id);
            productLiveData.setValue(products);
        }).start();
    }


}