package com.example.muraliengineertest.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.muraliengineertest.model.Hits;
import com.example.muraliengineertest.repository.APIInterface;
import com.example.muraliengineertest.repository.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Hits>> hitList;

    public LiveData<List<Hits>> getHits() {
        //if the list is null
        if (hitList == null) {
            hitList = new MutableLiveData<List<Hits>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return hitList;
    }

    private void loadHeroes() {


        APIInterface api = RetrofitClient.getClient().create(APIInterface.class);

        Call<List<Hits>> call = api.getHits(1);



        call.enqueue(new Callback<List<Hits>>() {
            @Override
            public void onResponse(Call<List<Hits>> call, Response<List<Hits>> response) {
                hitList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hits>> call, Throwable t) {

            }
        });

    }

}
