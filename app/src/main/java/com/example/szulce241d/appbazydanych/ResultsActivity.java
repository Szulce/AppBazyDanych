package com.example.szulce241d.appbazydanych;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {


    private ListView foundConnections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseults);


        //Log.d("ResultsActivity","on create : Started");
        //all fields

        foundConnections = (ListView) findViewById(R.id.listOfResults);

        //tutaj tworzysz obiekty które maja być wrzucone do listy
        Connections LONDON_PARIS = new Connections();
        Connections PARIS_LONDON = new Connections();
        Connections TOKYO_ROMA =new Connections();
        Connections ROMA_LONDON = new Connections();

        LONDON_PARIS .setDestination("Paris");
        LONDON_PARIS.setSource("London");
        LONDON_PARIS.setMoreInf("more info paris london");
        LONDON_PARIS.setTime("2 h");
        LONDON_PARIS.setPrice(26);
        LONDON_PARIS.setDate("27.04.2018");
        LONDON_PARIS.setClasa("economic");

        PARIS_LONDON.setSource("Paris");
        PARIS_LONDON.setDestination("London");
        PARIS_LONDON.setMoreInf("more info paris london");
        PARIS_LONDON.setTime("2 h 30 min");
        PARIS_LONDON.setDate("28.04.2018");
        PARIS_LONDON.setPrice(88);
        PARIS_LONDON.setClasa("economic");

        TOKYO_ROMA.setSource("Tokyo");
        TOKYO_ROMA.setDestination("Roma");
        TOKYO_ROMA.setPrice(155);
        TOKYO_ROMA.setDate("19.05.2019");
        TOKYO_ROMA.setTime("11 h");
        TOKYO_ROMA.setMoreInf("tokio roma info");
        TOKYO_ROMA.setClasa("economic");

        ROMA_LONDON.setSource("Roma");
        ROMA_LONDON.setDestination("London");
        ROMA_LONDON.setMoreInf("tokio roma more info");
        ROMA_LONDON.setTime("9 h");
        ROMA_LONDON.setDate("11.03.2019");
        ROMA_LONDON.setPrice(600);
        ROMA_LONDON.setClasa("economic");

        //create list of objects
        ArrayList<Connections> listofFoundedConnections = new ArrayList<>();
        listofFoundedConnections.add(LONDON_PARIS);
        listofFoundedConnections.add(PARIS_LONDON);
        listofFoundedConnections.add(TOKYO_ROMA);
        listofFoundedConnections.add(ROMA_LONDON);

        //create adapter
        ConnectionsListAdapter connectionListAdapter = new ConnectionsListAdapter(ResultsActivity.this,R.layout.linst_of_results_layout,listofFoundedConnections);
        foundConnections.setAdapter(connectionListAdapter);





    }

}
