package com.example.szulce241d.appbazydanych;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView searchCardView;
    private CardView loginCardView;
    private CardView registerCardView;

    //po zalogowaniu ta stona powinna byc niedostepna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //go to search section
        searchCardView = (CardView) findViewById(R.id.SearchCardView);
        searchCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        //go to login section
        loginCardView = (CardView) findViewById(R.id.LoginCardView);
        loginCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm=true;
                //tutaj logowanie do bazy i potwierdzenie
                if(confirm) {

                    Intent intent = new Intent(MainActivity.this,UserPanelActivity.class);
                    startActivity(intent);

                }else {
                    //alert wrong password or login
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Wrong username or password .\n  Try again .");
                    builder.setTitle("WRONG");
                    builder.setCancelable(true);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });

        //go to register section
        registerCardView = (CardView) findViewById(R.id.RegisterCardView);
        registerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterAcivity.class);
                startActivity(intent);
            }
        });
    }
}
