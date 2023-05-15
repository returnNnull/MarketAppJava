package com.bam.marketappjava.data.room.product;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import java.util.Optional;

@Dao
public interface ProductDao {

    @Query("Select * from Product")
    LiveData<List<Product>> getAll();

    @Query("Select * from Product where categoryId = :categoryId")
    List<Product> getByCategory(int categoryId);

    @Query("Select * from Product where id = :id")
    Optional<Product> getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product entity);

    @Delete
    void delete(Product entity);
}