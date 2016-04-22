package com.hrayr.pizza;

public class Pizza {
    String name;
    int imageId;
    String description;

    Pizza(String name, int imageId, String description){
        this.name = name;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageId(){ return imageId; }

    public void setDescription(String description){
        this.description = description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setImageId(int imageId){
        this.imageId = imageId;
    }
}

