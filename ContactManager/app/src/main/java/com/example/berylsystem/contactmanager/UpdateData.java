package com.example.berylsystem.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    EditText mobile,name,email;
    Button update;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        mobile = (EditText) findViewById(R.id.mobile_no1);
        name = (EditText) findViewById(R.id.name1);
        email = (EditText) findViewById(R.id.email_id1);
        update = (Button) findViewById(R.id.save1);

        databaseHelper = new DatabaseHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.updateData(mobile.getText().toString(),name.getText().toString(),email.getText().toString());
                Toast.makeText(UpdateData.this, "Data is Update", Toast.LENGTH_SHORT).show();
               /* name.setText(" ");
                mobile.setText(" ");
                email.setText(" ");*/
            }
        });
    }
}