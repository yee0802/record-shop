package com.northcoders.recordshop.ui.addalbum;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentAddNewAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Artist;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumFragment extends Fragment {
    FragmentAddNewAlbumBinding binding;
    AddAlbumClickHandler clickHandler;
    MainActivityViewModel viewModel;
    Album album;

    public AddNewAlbumFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        album = new Album();
        album.setArtist(new Artist());
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_album, container, false);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        View view = binding.getRoot();
        clickHandler = new AddAlbumClickHandler(album, getContext(), viewModel);

        binding.setAlbum(album);
        binding.setClickHandler(clickHandler);

        return view;
    }
}