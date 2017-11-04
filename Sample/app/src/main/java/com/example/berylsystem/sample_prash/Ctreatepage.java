package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ctreatepage extends AppCompatActivity {

    boolean result;
    EditText name, mobile_number, etclass, rollno,mobile;
    Button save;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctreatepage);

        name = (EditText) findViewById(R.id.name);
        rollno = (EditText) findViewById(R.id.rollno);

        mobile_number = (EditText) findViewById(R.id.mobile_no);

        etclass = (EditText) findViewById(R.id.etclass);

        save = (Button) findViewById(R.id.save);

        //Value pass
        String name1=getIntent().getStringExtra("name");
        name.setText(name1);
        String rollno1=getIntent().getStringExtra("rollno");
        rollno.setText(rollno1);

        /*String mobile1=getIntent().getStringExtra("mobile");
        mobile.setText(mobile1);

        String etclass1=getIntent().getStringExtra("etclass");
        etclass.setText(etclass1);*/

        //end




        databaseHelper = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result = databaseHelper.insertData(name.getText().toString(),rollno.getText().toString(),mobile_number.getText().toString(),etclass.getText().toString());

                if(result)
                {
                    Toast.makeText(Ctreatepage.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Ctreatepage.this,DataListActivity.class);
                    startActivity(i);
                    name.setText(" ");
                    rollno.setText(" ");
                    mobile_number.setText(" ");
                    etclass.setText(" ");
                }
                else
                    Toast.makeText(Ctreatepage.this, "Data not Inserted...Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }


   /* public void viewContact(View view)
    {
        if(result)
        {
            *//*Intent i = new Intent(Ctreatepage.this,MainActivity.class);
            startActivity(i);*//*
        }
    }*/
}