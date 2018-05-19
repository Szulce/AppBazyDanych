package com.example.szulce241d.appbazydanych;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class RegisterAcivity extends AppCompatActivity {

    private CardView registCardView;
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText nationalityEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText phoneEditText;
    private EditText birtdateEditText;
    private RadioButton femaleRadioButton;
    private RadioButton maleRadioButton;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText=(EditText)findViewById(R.id.surnameEditText);
        nationalityEditText = (EditText) findViewById(R.id.nationalityEditText);
        emailEditText =(EditText) findViewById(R.id.emailEditText);
        passwordEditText =(EditText)findViewById(R.id.passwordEditText);
        phoneEditText =(EditText)findViewById(R.id.phoneEditText);
        birtdateEditText =(EditText)findViewById(R.id.birthdateEditText);
        maleRadioButton = (RadioButton) findViewById(R.id.maleMadioButton);
        femaleRadioButton = (RadioButton) findViewById(R.id.femaleRdioButton);

        registCardView = (CardView) findViewById(R.id.RegistNow);
        registCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //validation form
            if(   !checkName() |
               !checkSurname() |
               !checkPassword()|
               !checkBirthdate()|
               !checkEmail()|
               !checkNationality()|
               !checkPhone()) {
                //alert empty places in form
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterAcivity.this);
                builder.setMessage("You must fill in a form first to register.");
                builder.setTitle("Empty");
                builder.setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
            else
            {
               // tu wysyłam dane do bazy
                //wysyłam maila
                sendMessage();
            }
            }
        });

        maleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male";
            }
        });

        femaleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";
            }
        });

    }
    boolean checkName()
    {
        if(nameEditText.getText().toString().trim().isEmpty())
        {
            nameEditText.setError("Please enter name");
            return false;
        }
        return true;
    }
    boolean checkSurname()
    {
        if(surnameEditText.getText().toString().trim().isEmpty())
        {
            surnameEditText.setError("Please enter surname");
            return false;
        }
        return true;
    }
    boolean checkNationality()
    {
        if(nationalityEditText.getText().toString().trim().isEmpty())
        {
            nationalityEditText.setError("Please enter nationality");
            return false;
        }
        return true;
    }
    boolean checkEmail()
    {
        if(emailEditText.getText().toString().trim().isEmpty())
        {
            emailEditText.setError("Please enter email");
            return false;
        }
        return true;
    }
    boolean checkPassword()
    {
        if(passwordEditText.getText().toString().trim().isEmpty())
        {
            passwordEditText.setError("Please enter password");
            return false;
        }
        else if(passwordEditText.getText().toString().trim().length()<7){
            passwordEditText.setError("min. length is 7");
        }
        return true;
    }
    boolean checkPhone()
    {
        if(phoneEditText.getText().toString().trim().isEmpty())
        {
            phoneEditText.setError("Please enter phone number");
            return false;
        }
        return true;
    }
    boolean checkBirthdate()
    {
        if(birtdateEditText.getText().toString().trim().isEmpty())
        {
            birtdateEditText.setError("Please enter birthdate");
            return false;
        }
        return true;
    }

    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(   RegisterAcivity.this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    //Genrate login
                    String login = "admin";
                    //prepare message
                    String input ="You have successfully created account in Magdalena Szulc Application\n"+
                            "This is your personal data \n"
                            +"Name:"+nameEditText.getText().toString()+"\n"+
                            "Surname:"+surnameEditText.getText().toString()+"\n"+
                            "Email:"+emailEditText.getText().toString()+"\n"+
                            "Password:"+passwordEditText.getText().toString()+"\n"+
                            "Nationality:"+nationalityEditText.getText().toString()+"\n"+
                            "Phone:"+ phoneEditText.getText().toString()+"\n"+
                            "Birthdate:"+birtdateEditText.getText().toString()+"\n"+
                            "Gender: "+gender+"\n \nYour login :"+login+"\n"+
                            "Thank you for creating account in my Application.\n";

                    //send mail
                    Gmail_Sender sender = new Gmail_Sender("szulcmagdalena241d@gmail.com", "onomatopeje");
                    sender.sendMail("Successful Registratin",
                            input,
                            "szulcmagdalena241d@gmail.com",
                            emailEditText.getText().toString());
                    dialog.dismiss();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }

}
