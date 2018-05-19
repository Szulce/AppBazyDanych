package com.example.szulce241d.appbazydanych;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//to chyba przerobic na ticket
class JourneyListAdapter extends ArrayAdapter<Connections> {

    private Context mContext;
    private int mResource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String source = getItem(position).getSource();
        String destination = getItem(position).getDestination();

        //create object
        Connections connections = new Connections();
        //set variables
        connections.setSource(source);
        connections.setDestination(destination);

        LayoutInflater layoutInflater =  LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        //prepare textViews
        TextView sourceUserpanelTextView = (TextView) convertView.findViewById(R.id.source_UserList);
        TextView destinationUserPanelTextView =(TextView) convertView.findViewById(R.id.destination_userList);

        sourceUserpanelTextView.setText(source);
        destinationUserPanelTextView.setText(destination);

        //some features
        CardView ticketSeeCardView= (CardView) convertView.findViewById(R.id.ticketjournayUserButton);
        ticketSeeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if checked in see ticket else go to check in
                //sprawdzanie czy checked in
                boolean checked_in = false;
                if(checked_in)
                {
                    Intent intent = new Intent(v.getContext(),TicketActivity.class);
                    mContext.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(v.getContext(),CheckInActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });

        return convertView;
    }

    public JourneyListAdapter(Context context, int resource, ArrayList<Connections> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
}
