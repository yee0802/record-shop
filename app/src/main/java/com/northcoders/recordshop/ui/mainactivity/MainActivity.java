package com.northcoders.recordshop.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityMainBinding;
import com.northcoders.recordshop.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albumsFromViewModel = new ArrayList<>();
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding binding;
    private MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);

        fetchAlbums();
    }

    private void fetchAlbums() {
        mainActivityViewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumsFromViewModel = albums;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.mainRecyclerView;

        albumAdapter = new AlbumAdapter(albumsFromViewModel, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();
    }
}