package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.AlbumItemLayoutBinding;
import com.northcoders.recordshop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<Album> albumList;
    private Context context;
    private final RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.albumList = albumList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private AlbumItemLayoutBinding binding;

        public AlbumViewHolder(@NonNull AlbumItemLayoutBinding albumItemLayoutBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumItemLayoutBinding.getRoot());
            this.binding = albumItemLayoutBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item_layout,
                parent,
                false
        );

        return new AlbumViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.binding.setAlbum(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
