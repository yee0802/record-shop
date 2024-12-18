package com.northcoders.recordshop.model;

public class Artist {
    private long id;
    private String name;
    private String createdAt;
    private String modifiedAt;

    public Artist() {
    }

    public Artist(long id, String name, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }
}
