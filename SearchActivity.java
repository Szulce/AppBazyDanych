package com.example.szulce241d.appbazydanych;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SearchActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private AutoCompleteTextView sourceAutoCompleteTextView;
    private AutoCompleteTextView destinationAutoCompleteTextView;
    private CardView calendarCardView;
    private CardView findCardView;
    private Spinner sortSpinner;

    ArrayList<String> airportsToChoose = new ArrayList<>();
    String []sortVia={"Price","Flight time","Plane Class"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sourceAutoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.sourceSearchView);
        destinationAutoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.destinationSearchView);

        //adding airports should be done automaticly from database
        airportsToChoose.add("Paris");
        airportsToChoose.add("London");
        airportsToChoose.add("Warszawa");
        airportsToChoose.add("Bydgoszcz");
        airportsToChoose.add("Poznań");
        airportsToChoose.add("Paris Center");
        airportsToChoose.add("Parie");
        airportsToChoose.add("Parama");
        airportsToChoose.add("Papaja");
        airportsToChoose.add("Portugese");

        ArrayAdapter<String> airportsAdapter = new ArrayAdapter<>(SearchActivity.this,android.R.layout.simple_spinner_dropdown_item,airportsToChoose);
        sourceAutoCompleteTextView.setAdapter(airportsAdapter);
        destinationAutoCompleteTextView.setAdapter(airportsAdapter);


        sortSpinner =(Spinner)findViewById(R.id.sortSpinner);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,sortVia);
        sortSpinner.setAdapter(arrayAdapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                       // record ="Price";
                        break;
                    case 1:
                        //record ="Flight time";
                        break;
                    case 2:
                       // record ="Plane Class";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                builder.setMessage("Choose priority");
                builder.setTitle("Option Empty");
                builder.setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        calendarCardView = (CardView) findViewById(R.id.calenderCardView);
        calendarCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dataPicker = new DataPickerFragment();
                dataPicker.show(getSupportFragmentManager(),"data picker");
            }
        });

        findCardView =(CardView) findViewById(R.id.SearCardView);
        findCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //walidacja
             if(checkSource() & checkDestination()) {
                 Intent intent = new Intent(SearchActivity.this,ResultsActivity.class);
                 //intent.putExtra("Source",sourceEditText.getText());
                 //intent.putExtra("Destination",destinatioEditText.getText());
                 startActivity(intent);
             }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

       //to powinno podledz walidacji i zostac wysłane do bazy by uzyskać odpowiedz
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        System.out.println(selectedDate);
    }

    boolean checkSource()
    {
       /* if(sourceEditText.getText().toString().trim().isEmpty())
        {
            sourceEditText.setError("Please enter start airport");
            return false;}*/
        return true;
    }

    boolean checkDestination()
    {
        /*
        if(destinatioEditText.getText().toString().trim().isEmpty())
        {
            destinatioEditText.setError("Please enter end airport");
            return false;
        }*/
        return true;
    }

}
