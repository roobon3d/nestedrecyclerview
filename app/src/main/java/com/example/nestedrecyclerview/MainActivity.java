package com.example.nestedrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recViewPadre;
    PadreAdapter padreAdapter;

    String jsonString = "{\n" +
            "    \"Id\" : \"1\",\n" +
            "    \"Name\" : \"Ganesha\",\n" +
            "    \"Location\" : \"Bengaluru\",\n" +
            "    \"Event info\" : [ \n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"Date\" : \"29-9-16\",\n" +
            "\t\t\t\t\t\t\t\"events\" : [ \n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventId\" : \"1\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventName\" : \"event one\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}, \n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventId\" : \"2\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventName\" : \"event two\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t}, \n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"Date\" : \"30-9-16\",\n" +
            "\t\t\t\t\t\t\t\"events\" : [ \n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventId\" : \"3\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventName\" : \"event three\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}, \n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventId\" : \"4\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"eventName\" : \"event four\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<EventDates> eventDatesArrayList;
        EventInformation eventInformation = new EventInformation();;

        try {
            //pasing jason data
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonDatesArray = jsonObject.getJSONArray("Event info");
            eventDatesArrayList = new ArrayList<>();
            for (int indexDates=0;indexDates<jsonDatesArray.length();indexDates++){
                EventDates eventDates = new EventDates();
                JSONObject jsonDateobject = jsonDatesArray.getJSONObject(indexDates);
                String date = jsonDateobject.getString("Date");
                eventDates.setDate(date);
                JSONArray jsonArrayevents = jsonDateobject.getJSONArray("events");
                ArrayList<Events> eventsArrayList = new ArrayList<>();
                for (int indexEvents=0;indexEvents<jsonArrayevents.length();indexEvents++){
                    Events events = new Events();
                    JSONObject eventObj = jsonArrayevents.getJSONObject(indexEvents);
                    events.setEventId(eventObj.getString("eventId"));
                    events.setEventName(eventObj.getString("eventName"));
                    eventsArrayList.add(events);
                }
                eventDates.setEventsArrayList(eventsArrayList);
                eventDatesArrayList.add(eventDates);
            }
            eventInformation.setEventsDatesList(eventDatesArrayList);
            Log.d("message",eventInformation.toString());
        }catch (Exception e){

        }
        //parent recyclerview
        recViewPadre = (RecyclerView) findViewById(R.id.rv_padre);
        padreAdapter = new PadreAdapter(eventInformation,MainActivity.this);
        recViewPadre.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recViewPadre.setLayoutManager(mLayoutManager);
        recViewPadre.setItemAnimator(new DefaultItemAnimator());
        recViewPadre.setAdapter(padreAdapter);


    }
}