package me.jonas.urlshortener.shorten;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Random;

@Entity
@Table
public class Shorten {
    @Id
    @UuidGenerator
    private String shorten;
    private String points;

    public Shorten(String points){
        this.points = points;
    }

    public Shorten(String points, String shorten){
        this.points = points;
        this.shorten = shorten;
    }

    public Shorten() {

    }

    public String getShorten(){
        return shorten;
    }

    public void setShorten(String shorten){
        this.shorten = shorten;
    }

    public String getPoints(){
        return points;
    }

    public void setPoints(String points){
        this.points = points;
    }

}
