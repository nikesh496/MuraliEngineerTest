package com.example.muraliengineertest.repository;

import com.example.muraliengineertest.model.Hits;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

//    https://hn.algolia.com/api/v1/search_by_date?tags=story&page=1

    @GET("api/v1/search_by_date?tags=story")
    Call<List<Hits>> getHits( @Query("page") int page);

    //tags=story

}
