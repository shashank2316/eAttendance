package com.example.eattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    databaseHelper mydb;
    private EditText email;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.emailId);
        password = (EditText)findViewById(R.id.passId);
        info = (TextView)findViewById(R.id.tvInfo);
        login = (Button) findViewById(R.id.btnLogin);

        info.setText("No. of attempts remaning:3");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(email.getText().toString(), password.getText().toString());
            }
        }
        );
        mydb = new databaseHelper(this);
    }

    private void validate(String username, String userpassword){
        if ((username.equals("admin")) && (userpassword.equals("admin"))){
            Intent intent =new Intent(MainActivity.this , insert.class);
            startActivity(intent);
        }
        else {
            counter--;
            info.setText("No. of attempts remaning:" + String.valueOf(counter));

            if (counter == 0)
                login.setEnabled(false);
        }
    }
}
