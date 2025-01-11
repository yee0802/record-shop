package com.northcoders.recordshop.ui.mainactivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.widget.SearchView;


import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentHomeBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HomeFragment extends Fragment implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albumsFromViewModel = new ArrayList<>();
    private FragmentHomeBinding binding;
    private MainActivityViewModel mainActivityViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SearchView searchView;
    private List<Album> filteredAlbumsList = new ArrayList<>();
    private static final String ALBUM_KEY = "album_key";

    public HomeFragment() {}

    private void fetchAlbums() {
        mainActivityViewModel.getAllAlbums().observe(getViewLifecycleOwner(), new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumsFromViewModel = albums;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.mainRecyclerView;

        albumAdapter = new AlbumAdapter(getActivity(), albumsFromViewModel, mainActivityViewModel.getApplication(), this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        View view = binding.getRoot();

        fetchAlbums();

        swipeRefreshLayout = view.findViewById(R.id.main_swipe_to_refresh);

        swipeRefreshLayout.setOnRefreshListener(() -> new Handler(Looper.getMainLooper()).postDelayed(() -> {
            fetchAlbums();

            swipeRefreshLayout.setRefreshing(false);
        }, 2000));

        searchView = view.findViewById(R.id.main_search_view);
        searchView.clearFocus();

        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.WHITE);
        searchEditText.setHintTextColor(Color.WHITE);

        ImageView searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        searchIcon.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        ImageView closeIcon = searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        closeIcon.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), UpdateAlbumActivity.class);

        if (filteredAlbumsList == null || filteredAlbumsList.isEmpty()) {
            intent.putExtra(ALBUM_KEY, albumsFromViewModel.get(position));
        } else {
            intent.putExtra(ALBUM_KEY, filteredAlbumsList.get(position));
        }

        startActivity(intent);
    }


    private void filterList(String newText) {
        filteredAlbumsList.clear();
        String lowerCaseText = newText.toLowerCase();

        Predicate<Album> matchesQuery = album -> album.getName().toLowerCase().contains(lowerCaseText)
                || album.getArtist().getName().toLowerCase().contains(lowerCaseText);

        albumsFromViewModel.stream()
                .filter(matchesQuery)
                .forEach(filteredAlbumsList::add);

        if (filteredAlbumsList.isEmpty()) {
            Toast.makeText(getActivity(), "No albums found!", Toast.LENGTH_SHORT).show();
        }

        albumAdapter.setFilteredList(filteredAlbumsList);
    }
}