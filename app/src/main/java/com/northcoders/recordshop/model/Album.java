package com.northcoders.recordshop.model;

public class Album {
    private long id;
    private String name;
    private String genre;
    private int releaseYear;
    private int stockQuantity;
    private String createdAt;
    private String modifiedAt;

    public Album() {
    }

    public Album(long id, String name, String genre, int releaseYear, int stockQuantity, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
