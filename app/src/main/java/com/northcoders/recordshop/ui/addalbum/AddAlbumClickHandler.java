package com.northcoders.recordshop.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Artist;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandler {
    private Album album;
    private Context context;
    private MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandler(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onSubmitButtonClick(View view) {
        Artist artist = album.getArtist();

        if (artist == null || artist.getName() == null || artist.getName().isEmpty()) {
            Toast.makeText(context, "Artist field must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (album.getName() == null || album.getName().isEmpty()) {
            Toast.makeText(context, "Album name must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (album.getGenre() == null || album.getGenre().isEmpty()) {
            Toast.makeText(context, "Genre must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (album.getReleaseYear() == null) {
            Toast.makeText(context, "Release year must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (album.getStockQuantity() == null) {
            Toast.makeText(context, "Stock quantity must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Album albumToAdd = new Album(
                album.getName(),
                album.getArtist(),
                album.getGenre(),
                album.getCoverArtUrl(),
                album.getReleaseYear(),
                album.getStockQuantity());

        Intent intent = new Intent(context, MainActivity.class);

        mainActivityViewModel.addAlbum(albumToAdd);

        context.startActivity(intent);
    }
}
