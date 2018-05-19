package com.example.szulce241d.appbazydanych;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {

    private CardView backTicketButtonCardView;

    private TextView ticketSourceTextView;
    private TextView ticketDestiantionTextView;
    private TextView ticketDepartureTextView;
    private TextView ticketTermianalTextView;
    private TextView arrivalTicketTextView;
    private TextView luggageOptionTextView;
    private TextView additionalLuggageTextView;
    private TextView firstOnBoardTextView;
    private TextView seatNumberTextView;
    private TextView window_middleTextView;

    private TextView ticketOwnerName;
    private TextView ticketOwnerSurname;
    private TextView ticketOwnerNationality;
    private TextView ticketOwnerBirthdate;
    private TextView ticketOwnerDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        //get ticket ale jeszce nie wiem jak wiec prepare
        Ticket ticket = new Ticket();

        Connections LONDON_PARIS = new Connections();
        LONDON_PARIS .setDestination("Paris");
        LONDON_PARIS.setSource("London");
        LONDON_PARIS.setMoreInf("more info paris london");
        LONDON_PARIS.setTime("2 h");
        LONDON_PARIS.setPrice(26);
        LONDON_PARIS.setDate("27.04.2018");
        LONDON_PARIS.setClasa("economic");
        ticket.setConnectionTicket(LONDON_PARIS);

        User user = new User();
        user.setLogin("Magda9455");
        user.setSurname("Szulc");
        user.setName("Magda");
        user.setEmail("szulcmagdalena241d@gmail.com");
        user.setNationality("Polish");
        user.setDocument("none");
        user.setBirthdate("14.04.1997");
        ticket.setOwner(user);


        //connection to layout
        ticketSourceTextView = (TextView) findViewById(R.id.ticketSourceTextView);
        ticketDepartureTextView = (TextView) findViewById(R.id.ticketDepartureTextView);
        ticketDestiantionTextView = (TextView) findViewById(R.id.ticketDestinationTextView);
        ticketTermianalTextView = (TextView) findViewById(R.id.ticketTerminalTextView);
        arrivalTicketTextView = (TextView) findViewById(R.id.ticketArrivalextView);
        luggageOptionTextView = (TextView) findViewById(R.id.ticketLoggageOptionTextView);
        additionalLuggageTextView = (TextView) findViewById(R.id.ticketAdditionalLuggage);
        firstOnBoardTextView = (TextView) findViewById(R.id.ticketFirstOnBoard);
        seatNumberTextView = (TextView) findViewById(R.id.ticketSeatNumber);
        window_middleTextView = (TextView) findViewById(R.id.ticketWindowMiddle);

        ticketOwnerName = (TextView) findViewById(R.id.ticketOwnerName);
        ticketOwnerSurname = (TextView) findViewById(R.id.ticketOwnerSurname);
        ticketOwnerBirthdate = (TextView) findViewById(R.id.ticketOwnerBirthdate);
        ticketOwnerNationality = (TextView) findViewById(R.id.ticketOwnerNationality);
        ticketOwnerDocument = (TextView) findViewById(R.id.ticketOwnerDocument);

        //setting all fields
        ticketSourceTextView.setText(ticket.getConnectionTicket().getSource());
        ticketDepartureTextView.setText(ticket.getConnectionTicket().getDate()+" "+ticket.getConnectionTicket().getTime());
        ticketTermianalTextView.setText("to dodaj");
        ticketDestiantionTextView.setText(ticket.getConnectionTicket().getDestination());
        arrivalTicketTextView.setText(ticket.getConnectionTicket().getDate()+"do tego dodja czas");
        luggageOptionTextView.setText("tododaj");
        additionalLuggageTextView.setText("to tez");
        firstOnBoardTextView.setText("totez");
        seatNumberTextView.setText("i to");
        window_middleTextView.setText("no i to");

        ticketOwnerName.setText(ticket.getOwner().getName());
        ticketOwnerSurname.setText(ticket.getOwner().getSurname());
        ticketOwnerNationality.setText(ticket.getOwner().getNationality());
        ticketOwnerBirthdate.setText(ticket.getOwner().getBirthdate());
        ticketOwnerDocument.setText(ticket.getOwner().getDocument());


        backTicketButtonCardView = (CardView) findViewById(R.id.backbuttonticketCardView);
        backTicketButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this,UserPanelActivity.class);
                startActivity(intent);
            }
        });
    }
}
