package com.northcoders.recordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshop.BR;

public class Album extends BaseObservable {
    private long id;
    private String name;
    private Artist artist;
    private String genre;
    private String coverArtUrl;
    private int releaseYear;
    private int stockQuantity;
    private String createdAt;
    private String modifiedAt;

    public Album() {
    }

    public Album(long id, String name, Artist artist, String genre, String coverArtUrl, int releaseYear, int stockQuantity, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.coverArtUrl = coverArtUrl;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getCoverArtUrl() {
        return coverArtUrl;
    }

    public void setCoverArtUrl(String coverArtUrl) {
        this.coverArtUrl = coverArtUrl;
        notifyPropertyChanged(BR.coverArtUrl);
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }
}
