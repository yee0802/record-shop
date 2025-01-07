package com.northcoders.recordshop.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentHomeBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albumsFromViewModel = new ArrayList<>();
    private FragmentHomeBinding binding;
    private MainActivityViewModel mainActivityViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
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

        return view;
    };

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), UpdateAlbumActivity.class);

        intent.putExtra(ALBUM_KEY, albumsFromViewModel.get(position));

        startActivity(intent);
    }

}