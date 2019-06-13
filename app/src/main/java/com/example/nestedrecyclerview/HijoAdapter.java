package com.example.nestedrecyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HijoAdapter extends RecyclerView.Adapter<HijoAdapter.MyViewHolder> {

    //private List<Movie> moviesList;

    private EventInformation eventInformation;
    private ArrayList<Events> eventsArrayList;
    private Activity activity;

    public HijoAdapter(Activity activity, ArrayList<Events> eventsArrayList) {
        this.eventsArrayList = eventsArrayList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hijo_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        Events events = eventsArrayList.get(position);
        holder.event_list_event_name.setText(events.getEventName());
        holder.event_list_event_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("event name=",eventsArrayList.get(position).getEventName());
            }
        });



    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_list_event_name;


        public MyViewHolder(View view) {
            super(view);
            event_list_event_name = (TextView) view.findViewById(R.id.textoMensaje);

        }
    }
}
