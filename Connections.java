package com.example.szulce241d.appbazydanych;

public class Connections {

    //data
    private String id;
    private String source ;
    private String destination;
    private String date ;
    private String time ;
    private int price ;
    private String clasa ;
    private String moreInf ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public void setMoreInf(String moreInf) { this.moreInf = moreInf;}

    public String getDetailedDescription() {
        return moreInf;
    }


}
