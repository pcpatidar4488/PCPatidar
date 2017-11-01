package com.example.berylsystem.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContacts extends AppCompatActivity {

    EditText name,mobile_number,email;
    Button save;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contacts);

        databaseHelper=new DatabaseHelper(this);

        name = (EditText) findViewById(R.id.name);

        mobile_number = (EditText) findViewById(R.id.mobile_no);

        email = (EditText) findViewById(R.id.email_id);

        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = databaseHelper.insertData(name.getText().toString(),Integer.parseInt(mobile_number.getText().toString()),email.getText().toString());
                    
                if(result)
                {
                    Toast.makeText(AddNewContacts.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    name.setText(" ");
                    mobile_number.setText(" ");
                    email.setText(" ");
                }
                else
                    Toast.makeText(AddNewContacts.this, "Data not Inserted...Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}