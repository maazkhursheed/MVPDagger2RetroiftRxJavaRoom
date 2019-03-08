package com.litgmet.testapp.utils;

import com.litgmet.testapp.MyApplication;
import com.litgmet.testapp.db.SampleDatabase;
import com.litgmet.testapp.models.PostsData;

import java.util.List;

public class Methodical {

//    public static void setData(List<PostsData> data){
//        SampleDatabase.getInstance(MyApplication.getAppContext()).daoAccess().insertMultipleListRecord(data);
//    }

    public static List<PostsData> setData(List<PostsData> data){
       return data;
    }

//    public static List<PostsData> getData(){
//        return SampleDatabase.getInstance(MyApplication.getAppContext()).daoAccess().fetchAllPostsData();
//    }



}

