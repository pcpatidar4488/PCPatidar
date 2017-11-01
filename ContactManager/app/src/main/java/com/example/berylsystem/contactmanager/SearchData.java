package com.example.berylsystem.contactmanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText searchText;
    Button search;
    TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        databaseHelper =new DatabaseHelper(this);

        searchText = (EditText) findViewById(R.id.etsearch);

        search = (Button) findViewById(R.id.btsearch);

        name = (TextView) findViewById(R.id.tvname);

        email = (TextView) findViewById(R.id.tvemail);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor cursor = databaseHelper.getData(searchText.getText().toString());
                name.setText(" ");
                email.setText(" ");
                while(cursor.moveToNext()){
                    name.setText(cursor.getColumnName(1));
                    email.setText(cursor.getColumnName(3));
                }
            }
        });
    }
}
