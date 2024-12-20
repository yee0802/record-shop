package com.northcoders.recordshop.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.repository.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepository.getMutableLiveData();
    }

    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

    public void updateAlbum(Long id, Album album) {
        albumRepository.updateAlbum(id, album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteAlbum(id);
    }
}
