package edu.niu.rasheedullakhan.project.DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by rasheedullakhan on 4/17/15.
 */
public class Tour implements Serializable{
    String name,streets,about,built,thumb;
    ArrayList<String> keyfacts;
    ArrayList<Place> place;

    public Tour(String name, String streets, String about, String built, String thumb) {
        this.name = name;
        this.streets = streets;
        this.about = about;
        this.built = built;
        this.thumb = thumb;
    }



    public void setKeyfacts(ArrayList<String> keyfacts) {
        this.keyfacts=new ArrayList<String>();
        this.keyfacts = keyfacts;
    }

    public void setPlace(ArrayList<Place> place) {
        this.place=new ArrayList<Place>();
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getStreets() {
        return streets;
    }

    public String getAbout() {
        return about;
    }

    public String getBuilt() {
        return built;
    }

    public String getThumb() {
        return thumb;
    }

    public ArrayList<String> getKeyfacts() {
        return keyfacts;
    }

    public ArrayList<Place> getPlace() {
        return place;
    }
}
