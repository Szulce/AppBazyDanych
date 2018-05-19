package com.example.szulce241d.appbazydanych;

public class Ticket {

    private User owner;
    private Connections connectionTicket;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Connections getConnectionTicket() {
        return connectionTicket;
    }

    public void setConnectionTicket(Connections connectionTicket) {
        this.connectionTicket = connectionTicket;
    }
}
