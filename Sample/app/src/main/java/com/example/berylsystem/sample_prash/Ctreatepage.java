package com.example.berylsystem.sample_prash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ctreatepage extends AppCompatActivity {

    EditText name,mobile_number,etclass,rollno;
    Button save;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctreatepage);

        databaseHelper=new DatabaseHelper(this);

        name = (EditText) findViewById(R.id.name);
        rollno = (EditText) findViewById(R.id.rollno);

        mobile_number = (EditText) findViewById(R.id.mobile_no);

        etclass = (EditText) findViewById(R.id.etclass);

        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = databaseHelper.insertData(name.getText().toString(),Integer.parseInt(rollno.getText().toString()),Integer.parseInt(mobile_number.getText().toString()),etclass.getText().toString());

                if(result)
                {
                    Toast.makeText(Ctreatepage.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    name.setText(" ");
                    mobile_number.setText(" ");
                    etclass.setText(" ");
                    rollno.setText(" ");
                }
                else
                    Toast.makeText(Ctreatepage.this, "Data not Inserted...Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
