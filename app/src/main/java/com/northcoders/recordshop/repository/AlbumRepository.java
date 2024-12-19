package com.northcoders.recordshop.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.service.AlbumApiService;
import com.northcoders.recordshop.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private final Application application;
    private MutableLiveData<List<Album>> mutableLiveData;
    private AlbumApiService albumApiService;

    public AlbumRepository(Application application) {
        this.application = application;
        mutableLiveData = new MutableLiveData<>();
        albumApiService = RetrofitInstance.getService();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
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

    public void addAlbum(Album album) {
        Call<Album> call = albumApiService.addAlbum(album);

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album added successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Unable to add Album", Toast.LENGTH_SHORT).show();
                Log.e("AlbumRepository", "Error adding an album", t);
            }
        });
    }
}
