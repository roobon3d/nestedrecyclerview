package com.example.nestedrecyclerview;

import java.util.ArrayList;

public class EventDates {
    private String date;
    private ArrayList<Events> eventsArrayList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Events> getEventsArrayList() {
        return eventsArrayList;
    }

    public void setEventsArrayList(ArrayList<Events> eventsArrayList) {
        this.eventsArrayList = eventsArrayList;
    }
}

