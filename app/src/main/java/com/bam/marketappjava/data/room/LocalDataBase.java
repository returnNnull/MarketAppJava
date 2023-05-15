package com.bam.marketappjava.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bam.marketappjava.data.room.category.CategoryDao;
import com.bam.marketappjava.data.room.product.Product;
import com.bam.marketappjava.data.room.product.ProductDao;


@Database(entities = {Product.class}, version = 1)
public abstract class LocalDataBase extends RoomDatabase {
    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();

    private static volatile LocalDataBase INSTANCE;

    public static LocalDataBase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDataBase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LocalDataBase.class, "DB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}