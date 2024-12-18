package com.northcoders.recordshop.service;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData;

    public AlbumRepository(Application application) {
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();

        assert albumApiService != null;
        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("AlbumRepository", "Error fetching all albums", t);
            }
        });

        return mutableLiveData;
    }
}
