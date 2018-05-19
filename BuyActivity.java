package com.example.szulce241d.appbazydanych;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class BuyActivity extends AppCompatActivity {

    private TextView ticketDescriptionTextView;
    private TextView totalPriceTextView;
    private CheckBox firstOnBoardCheckBox;
    private CheckBox additionalLuggage;
    private Spinner luggageOptionSpinner;
    private CardView backButtonBuyCradView;
    private CardView payCardView;

    String [] luggageOption={"cabin bag: 55x40x20 10kg\t Free ",
                             "cabin bag: 56x36x23 7kg\npersonal item: 40x30x10 \t\t 12$ ",
                             "cabin bag: 55x40x20 10kg\nsmaller bag: 35x20x20\t\t 35$ "};
    Double [] luggagePrice={0.0,12.0,35.0};
    ArrayAdapter<String> arrayAdapter;

    private double totalPrice;
    private boolean checkedAdditionalLuggage;
    private boolean checkedFirstOnBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        checkedAdditionalLuggage = true;
        checkedFirstOnBoard = true;

        ticketDescriptionTextView = (TextView) findViewById(R.id.ticketDescriptionTextView);
        totalPriceTextView = (TextView) findViewById(R.id.totalPriceBuyTextView);
        firstOnBoardCheckBox = (CheckBox) findViewById(R.id.firstOnBoardCheckBox);
        additionalLuggage = (CheckBox) findViewById(R.id.additionalLuggageCheckBox);
        luggageOptionSpinner = (Spinner) findViewById(R.id.luggageSpinner);
        backButtonBuyCradView = (CardView) findViewById(R.id.backbuyCardView);
        payCardView = (CardView) findViewById(R.id.PayCardView);

        //set description
        Connections LONDON_PARIS = new Connections();
        LONDON_PARIS .setDestination("Paris");
        LONDON_PARIS.setSource("London");
        LONDON_PARIS.setMoreInf("more info paris london");
        LONDON_PARIS.setTime("2 h");
        LONDON_PARIS.setPrice(26);
        LONDON_PARIS.setDate("27.04.2018");
        LONDON_PARIS.setClasa("economic");

        Ticket ticket = new Ticket();
        ticket.setConnectionTicket(LONDON_PARIS);

        ticketDescriptionTextView.setText(ticket.getConnectionTicket().getSource()+"  -   "+
        ticket.getConnectionTicket().getDestination()+"\n"
                +ticket.getConnectionTicket().getDate()+"             duration : "+
                ticket.getConnectionTicket().getTime()+"\nClass : "+
                ticket.getConnectionTicket().getClasa()+"\n                               Ticket Price  "+
                ticket.getConnectionTicket().getPrice()+" $");
        //tutaj powinno pobrać cene z poprzedniego view
         totalPrice = ticket.getConnectionTicket().getPrice();

        //totalPriceTextView.setText(totalPrice+"");
        totalPriceTextView.setText("0.0");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,luggageOption);
        luggageOptionSpinner.setAdapter(arrayAdapter);
        luggageOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private int luggageOpt = -1;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:{
                        // record ="1";
                        //add to price
                       if(luggageOpt != -1)
                       {
                           totalPrice-=luggagePrice[luggageOpt];
                           totalPriceTextView.setText(totalPrice+"");
                       }
                       luggageOpt=0;
                    }
                        break;
                    case 1:{
                        //record ="2";
                        //add to price
                        if(luggageOpt != -1)
                        {
                            totalPrice-=luggagePrice[luggageOpt];
                        }
                        luggageOpt=1;
                        totalPrice+=luggagePrice[luggageOpt];
                        totalPriceTextView.setText(totalPrice+"");
                    }
                        break;
                    case 2:{
                        // record ="3";
                        //add to price
                        if(luggageOpt != -1)
                        {
                            totalPrice-=luggagePrice[luggageOpt];
                        }
                        luggageOpt=2;
                        totalPrice+=luggagePrice[luggageOpt];
                        totalPriceTextView.setText(totalPrice+"");

                    }
                        break;
                }
            }

            //it is never gonna happen
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BuyActivity.this);
                builder.setMessage("Choose luggage option");
                builder.setTitle("Option Empty");
                builder.setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        additionalLuggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkedAdditionalLuggage) {//add to price
                    totalPrice += 120;
                    totalPriceTextView.setText(totalPrice + "");
                    checkedAdditionalLuggage = false;
                    //zapamietaj zeby potem wyslac do bazy danych
                }
                else
                {
                    totalPrice-=120;
                    totalPriceTextView.setText(totalPrice+"");
                    checkedAdditionalLuggage = true;
                }
            }
        });

        firstOnBoardCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedFirstOnBoard) {  //add to price
                    totalPrice += 19.00;
                    totalPriceTextView.setText(totalPrice + "");
                    checkedFirstOnBoard=false;
                }
                else
                {
                    totalPrice-=19.00;
                    totalPriceTextView.setText(totalPrice+"");
                    checkedFirstOnBoard = true;
                }
                }
        });


        backButtonBuyCradView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyActivity.this,ResultsActivity.class);
                //mozliwe ze jescze raz  wyniki trzba policzyć
                startActivity(intent);
            }
        });

        payCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyActivity.this,UserPanelActivity.class);
            //payment here
                //adding journey to user panel class
                //sending all information about ticket
                //intent.putExtra()
                startActivity(intent);
            }
        });
    }
}
