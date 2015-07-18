package edu.niu.rasheedullakhan.project.DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by rasheedullakhan on 4/17/15.
 */
public class Place implements Serializable {
    String name,house,about,thumb,built;
    double lat,longi;
    ArrayList<Image> imageArrayList;

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public String getAbout() {
        return about;
    }

    public double getLat() {
        return lat;
    }

    public double getLongi() {
        return longi;
    }

    public String getThumb() {
        return thumb;
    }

    public String getBuilt() {
        return built;
    }


    public ArrayList<Image> getImageArrayList() {
        return imageArrayList;
    }

    public Place(String name, String house, String about, double lat, double longi, String thumb, String built,ArrayList<Image> imageArrayList) {
        this.name = name;
        this.house = house;
        this.about = about;
        this.lat = lat;
        this.longi = longi;
        this.thumb = thumb;
        this.built = built;
        this.imageArrayList=new ArrayList<Image>();
        this.imageArrayList=imageArrayList;
    }
}
