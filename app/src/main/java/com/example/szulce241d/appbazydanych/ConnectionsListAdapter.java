package com.example.szulce241d.appbazydanych;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ConnectionsListAdapter extends ArrayAdapter<Connections> {

    private Context mContext;
    private int mResource;
    private boolean counter;

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        //get information about ticket
         String source = getItem(position).getSource();
        String destination = getItem(position).getDestination();
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        int price = getItem(position).getPrice();
        String clasa = getItem(position).getClasa();
        String moreInf = getItem(position).getDetailedDescription();
        final String id_connection = getItem(position).getId();

        //create object
        Connections connections = new Connections();
        //set variables
        connections.setClasa(clasa);
        connections.setSource(source);
        connections.setDate(date);
        connections.setDestination(destination);
        connections.setPrice(price);
        connections.setTime(time);
        connections.setMoreInf(moreInf);
        connections.setId(id_connection);


        LayoutInflater layoutInflater =  LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        //prepare textViews
        TextView sourceTextView = (TextView) convertView.findViewById(R.id.sourceTextView);
        TextView destinationTextView =(TextView) convertView.findViewById(R.id.destinationTextView);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.timeTextView);
        TextView clasaTextView = (TextView) convertView.findViewById(R.id.moreclasaTextView);
        TextView moreinfTextView = (TextView) convertView.findViewById(R.id.moreinfoTextView);
        TextView priceTextView = (TextView) convertView.findViewById(R.id.priceListTicketTextView);

       //set all textViews
        sourceTextView.setText(source);
        destinationTextView.setText(destination);
        dateTextView.setText(date);
        timeTextView.setText(time);
        clasaTextView.setText(clasa);
        moreinfTextView.setText(moreInf);
        priceTextView.setText(price+" $");
        moreinfTextView.setText(moreInf);

        //some features
        CardView buyButton = (CardView) convertView.findViewById(R.id.buyfoundedCardView);
        CardView moreButton= (CardView) convertView.findViewById(R.id.moreButtonCardView);



       buyButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //validation if user is logged
               boolean user_logged = true;
               if(user_logged) {
                   //change activity to buy
                   Intent intent_buy = new Intent(v.getContext(), BuyActivity.class);
                   //to id inaczej przekazać
                   intent_buy.putExtra("connection_id",id_connection);
                   mContext.startActivity(intent_buy);
               }
               else
               {
                   //go to main page
                   Intent intent_log = new Intent(v.getContext(),MainActivity.class);

                   String input ="You are not logged in.\nIn order to purchase flight ticket , first log in or register.";

                   Toast toast = Toast.makeText(mContext,input,Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                   mContext.startActivity(intent_log);

               }
           }
       });

        //one field

        final View finalConvertView = convertView;
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout moreInfoLayout = (LinearLayout) finalConvertView.findViewById(R.id.moreInfoLayout);
                if(counter) {
                    moreInfoLayout.setVisibility(View.VISIBLE);
                counter=false;
                }
                else {
                    moreInfoLayout.setVisibility(View.GONE);
                    counter = true;

                }
       }
    });


        return convertView;

    }


    public ConnectionsListAdapter(Context context, int resource, ArrayList<Connections> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        this.counter = true;
    }
}
