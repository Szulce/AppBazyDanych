package com.example.szulce241d.appbazydanych;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserPanelActivity extends AppCompatActivity {


    private CardView goSeachCardView;
    private ListView userJournayListView;
    private TextView userLogin;
    private TextView userEmail;
    private TextView userName;
    private TextView userSurname;
    private TextView userNationality;
    private TextView userBirtdate;
    private TextView userDocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        userLogin = (TextView) findViewById(R.id.userLoginTextView);
        userEmail = (TextView) findViewById(R.id.userEmailTextView);
        userDocuments = (TextView) findViewById(R.id.userDocumentsTextView);
        userBirtdate = (TextView) findViewById(R.id.userbirthdateTextView);
        userNationality = (TextView) findViewById(R.id.userNationalityTextView);
        userName = (TextView) findViewById(R.id.userNameTextView);
        userSurname = (TextView) findViewById(R.id.userSurnameTextView);

        //seting user panel
        //get User ale ja go jeszcze nie wiec
        User user = new User();
        user.setLogin("Magda9455");
        user.setSurname("Szulc");
        user.setName("Magda");
        user.setEmail("szulcmagdalena241d@gmail.com");
        user.setNationality("Polish");
        user.setDocument("none");
        user.setBirthdate("14.04.1997");

        //seting fields in userpanel
        userLogin.setText(user.getLogin());
        userEmail.setText(user.getEmail());
        userName.setText(user.getName());
        userSurname.setText(user.getSurname());
        userNationality.setText(user.getNationality());
        userBirtdate.setText(user.getBirthdate());
        userDocuments.setText(user.getDocument());



        //managing listView
        userJournayListView = (ListView) findViewById(R.id.listJournayOfUser);

        //sztuczne dane
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

        ArrayList<Connections> listofBoughtConnections = new ArrayList<>();
        listofBoughtConnections.add(LONDON_PARIS);
        listofBoughtConnections.add(PARIS_LONDON);
        listofBoughtConnections.add(TOKYO_ROMA);
        listofBoughtConnections.add(ROMA_LONDON);
        listofBoughtConnections.add(LONDON_PARIS);
        listofBoughtConnections.add(PARIS_LONDON);
        listofBoughtConnections.add(TOKYO_ROMA);
        listofBoughtConnections.add(ROMA_LONDON);
        listofBoughtConnections.add(LONDON_PARIS);
        listofBoughtConnections.add(PARIS_LONDON);
        listofBoughtConnections.add(TOKYO_ROMA);
        listofBoughtConnections.add(ROMA_LONDON);

        JourneyListAdapter journeyListAdapter = new JourneyListAdapter(UserPanelActivity.this,R.layout.list_of_journay,listofBoughtConnections);
        userJournayListView.setAdapter(journeyListAdapter);


        //go to search activity
        goSeachCardView =(CardView) findViewById(R.id.goSearchUserCardView);
        goSeachCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserPanelActivity.this,SearchActivity.class);
                //trzeba jakos przkazać usera
                startActivity(intent);
            }
        });
    }
}
