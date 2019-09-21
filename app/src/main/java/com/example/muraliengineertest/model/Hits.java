package com.example.muraliengineertest.model;

public class Hits {

    //title,createdas,switck

    private String title;
    private String created_at;

    public Hits(String title, String created_at){
        this.title = title;
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated_at() {
        return created_at;
    }

}
