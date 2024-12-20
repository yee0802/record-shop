package com.northcoders.recordshop.ui.updatealbum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {
    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandler handler;
    private Album album;
    private static final String ALBUM_KEY = "album_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new UpdateAlbumClickHandler(this, album, viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(handler);
    }
}