package com.example.szulce241d.appbazydanych;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

public class CheckInActivity extends AppCompatActivity {

    private CardView confirmCheckInCardView;
    private EditText userDocumentInput;
    private EditText userNameInput;
    private EditText userSurnameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        userNameInput = (EditText) findViewById(R.id.confirmUserNameeditText);
        userSurnameInput = (EditText) findViewById(R.id.confirmUserSurnameEditText);
        userDocumentInput = (EditText) findViewById(R.id.userDocEditText);
        confirmCheckInCardView = (CardView) findViewById(R.id.confirmCheckInButton);
        confirmCheckInCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking the inputed data
                String document = userDocumentInput.getText().toString();
                //some checking usig name and surname
                //saving data of documents in user
                User user = new User();
                user.setDocument(document);
                //changng boolean checked_in into true
                //change text on ticket instead of check in
                //change activity
                Intent intent = new Intent(CheckInActivity.this,UserPanelActivity.class);
                startActivity(intent);
            }
        });
    }
}
