package com.example.nestedrecyclerview;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PadreAdapter extends     RecyclerView.Adapter<PadreAdapter.MyViewHolder> {


   // private ArrayList<Fichaje> listaFichajes;

    private EventInformation eventInformation;
    private Activity activity;

    public PadreAdapter(EventInformation eventInformation, Activity activity) {
        this.eventInformation = eventInformation;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.padre_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventDates eventDates = eventInformation.getEventsDatesList().get(position);
        holder.event_list_parent_date.setText(eventDates.getDate());

        LinearLayoutManager hs_linearLayout = new LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false);
        holder.event_recycler_view_child.setLayoutManager(hs_linearLayout);
        holder.event_recycler_view_child.setHasFixedSize(true);
        HijoAdapter hijoAdapter = new HijoAdapter(this.activity,eventInformation.getEventsDatesList().get(position).getEventsArrayList());
        holder.event_recycler_view_child.setAdapter(hijoAdapter);

    }

    @Override
    public int getItemCount() {
        return eventInformation.getEventsDatesList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_list_parent_date;
        public RecyclerView event_recycler_view_child;

        public MyViewHolder(View view) {
            super(view);
            event_list_parent_date = (TextView) view.findViewById(R.id.padre_fecha);
            event_recycler_view_child = (RecyclerView)view.findViewById(R.id.rv_hijo);
        }
    }
}