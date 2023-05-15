package com.bam.marketappjava.data.room.category;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("select * from Category")
    LiveData<List<Category>> getAll();
}
