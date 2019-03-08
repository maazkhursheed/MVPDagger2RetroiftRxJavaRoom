package com.litgmet.testapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.litgmet.testapp.models.PostsData;

    @Database(entities = {PostsData.class}, version = 1)
    public abstract class SampleDatabase extends RoomDatabase {

        private static volatile SampleDatabase INSTANCE;
        public abstract DaoAccess daoAccess();

        public static SampleDatabase getInstance(Context context) {
            if (INSTANCE == null) {
                synchronized (SampleDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                SampleDatabase.class, "maaz.db")
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
    }

