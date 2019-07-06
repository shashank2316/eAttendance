package com.example.eattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class insert extends AppCompatActivity {
    private EditText name;
    private EditText roll_no;
    private EditText mobile_no;
    private EditText status;
    private Button save;
    private TextView result;
    databaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mydb = new databaseHelper(this);
        name=(EditText)findViewById(R.id.name_id);
        roll_no=(EditText)findViewById(R.id.rollno_id);
        mobile_no=(EditText)findViewById(R.id.mobile_id);
        status=(EditText)findViewById(R.id.status_id);
        result=(TextView)findViewById(R.id.result);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        save=(Button)findViewById(R.id.insert_id);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View view) {
                mydb.insertData("Shivam",1,"9239732932","scds");
                Cursor res=mydb.getAllData();
                String out="";
                if(res.getCount()!=0){
                    out=res.getColumnNames()[0]+" "+res.getColumnNames()[1]+" "+res.getColumnNames()[2]+" "+res.getColumnNames()[3];
                    Log.d("message","this: "+out);
                }
                else
                    out="nothing stored";
                result.setText(out);
            }
        }
        );
    }


}
