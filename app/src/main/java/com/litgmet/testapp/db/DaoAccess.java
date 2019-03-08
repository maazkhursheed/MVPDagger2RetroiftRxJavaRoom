package com.litgmet.testapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.litgmet.testapp.models.PostsData;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void insertMultipleListRecord(List<PostsData> postsList);

    @Query("SELECT * FROM PostsData")
    List<PostsData> fetchAllPostsData();

    @Update
    void updatePostsRecord(PostsData postsData);

    @Delete
    void deletePostRecord(PostsData postsData);

}
