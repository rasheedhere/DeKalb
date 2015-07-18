package edu.niu.rasheedullakhan.project.DataStructure;

import java.io.Serializable;

/**
 * Created by rasheedullakhan on 4/24/15.
 */
public class Image implements Serializable {
    String mImage,mDescription;

    public Image(String image, String description) {
        this.mImage = image;
        this.mDescription = description;
    }

    public String getImage() {
        return mImage;
    }

    public String getDescription() {
        return mDescription;
    }
}
