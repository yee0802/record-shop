package com.northcoders.recordshop.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshop.BR;

public class Album extends BaseObservable implements Parcelable {
    private Long id;
    private String name;
    private Artist artist;
    private String genre;
    private String coverArtUrl;
    private Integer releaseYear;
    private Integer stockQuantity;
    private String createdAt;
    private String modifiedAt;

    public Album() {
    }

    public Album(String name, Artist artist, String genre, String coverArtUrl, int releaseYear, int stockQuantity) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.coverArtUrl = coverArtUrl;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }

    protected Album(Parcel in) {
        id = in.readLong();
        name = in.readString();
        artist = in.readParcelable(Artist.class.getClassLoader(), Artist.class);
        genre = in.readString();
        coverArtUrl = in.readString();
        releaseYear = in.readInt();
        stockQuantity = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeParcelable(artist, flags);
        dest.writeString(genre);
        dest.writeString(coverArtUrl);
        dest.writeInt(releaseYear);
        dest.writeInt(stockQuantity);
    }
}
