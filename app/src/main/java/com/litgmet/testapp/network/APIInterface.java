package com.litgmet.testapp.network;

import com.litgmet.testapp.models.PostsData;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface APIInterface {

    @GET("posts")
    Observable<List<PostsData>> getAllPosts();
}
