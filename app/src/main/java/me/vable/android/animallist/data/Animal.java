package me.vable.android.animallist.data;

import java.io.Serializable;

/**
 * Created by Varavut on 9/28/2014.
 */
public class Animal implements Serializable {
    private String name;
    private String imageUrl;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
