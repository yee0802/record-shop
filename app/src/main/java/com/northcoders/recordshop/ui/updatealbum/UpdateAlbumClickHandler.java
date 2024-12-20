package com.northcoders.recordshop.ui.updatealbum;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {
    private Context context;
    private Album album;
    private MainActivityViewModel model;

    public UpdateAlbumClickHandler(Context context, Album album, MainActivityViewModel model) {
        this.context = context;
        this.album = album;
        this.model = model;
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    public void onSubmitButtonClick(View view) {

        Album updatedAlbum = new Album(
                album.getName(),
                album.getArtist(),
                album.getGenre(),
                album.getCoverArtUrl(),
                album.getReleaseYear(),
                album.getStockQuantity()
        );

        if (Objects.equals(updatedAlbum.getArtist(), null) ||
                Objects.equals(updatedAlbum.getGenre(), "") ||
                Objects.equals(updatedAlbum.getName(), "") ||
                Objects.equals(updatedAlbum.getCoverArtUrl(), "") ||
                Objects.equals(updatedAlbum.getReleaseYear(), null) ||
                Objects.equals(updatedAlbum.getStockQuantity(), null)) {
            Toast.makeText(context, "Missing field(s) in request body", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            model.updateAlbum(album.getId(), updatedAlbum);

            context.startActivity(intent);
        }
    }

    public void onDeleteButtonClick(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        Log.i("body", album.toString());
        alertBuilder.setTitle("Delete this album?")
                .setMessage("This will delete " + album.getName() + " by " + album.getArtist().getName() + " permanently.")
                .setPositiveButton("Delete", (dialog, id) -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    model.deleteAlbum(album.getId());
                    context.startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, which) -> { });
        alertBuilder.show();
    }

}