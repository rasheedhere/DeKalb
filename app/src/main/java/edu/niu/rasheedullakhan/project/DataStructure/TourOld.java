package edu.niu.rasheedullakhan.project.DataStructure;

/**
 * Created by rasheedullakhan on 4/7/15.
 */
public class TourOld {
    String num,tour,description;

    public TourOld(String num,String tour, String description) {
        this.num=num;
        this.description = description;
        this.tour = tour;
    }

    public String getTour() {
        return tour;
    }

    public String getDescription() {
        return description;
    }
    public String getNum(){
        return num;
    }
}
