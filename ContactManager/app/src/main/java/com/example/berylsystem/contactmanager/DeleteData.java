package com.example.berylsystem.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {

    EditText Number;
    Button delete;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        Number = (EditText) findViewById(R.id.etNumber);
        delete = (Button) findViewById(R.id.btdelete);

        databaseHelper = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteData(Number.getText().toString());
                Toast.makeText(DeleteData.this, "Data is Deleted", Toast.LENGTH_SHORT).show();
                Number.setText(" ");
            }
        });
    }
}
