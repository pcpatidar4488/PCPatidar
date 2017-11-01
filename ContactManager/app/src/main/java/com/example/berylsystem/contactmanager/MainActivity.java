package com.example.berylsystem.contactmanager;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    Button insert;
    Button search;
    Button btviewAll;
    Button delete;
    Button update;
    Button newactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        insert = (Button) findViewById(R.id.add_contact);
        search = (Button) findViewById(R.id.search_contact);
        btviewAll = (Button) findViewById(R.id.viewall_contact);
        delete = (Button) findViewById(R.id.delete_contact);
        update = (Button) findViewById(R.id.update_contact);
        newactivity = (Button) findViewById(R.id.New_Activity);

        viewAll();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddNewContacts.class);
                startActivity(i);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SearchData.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DeleteData.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,UpdateData.class);
                startActivity(i);
            }
        });

        newactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NewActivity.class);
                startActivity(i);
            }
        });


    }

    public void viewAll() {
        btviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseHelper.getAllData();
                if (res.getCount() == 0) {
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("NAME :" + res.getString(1) + "\n");
                    buffer.append("MOBILE_NUMBER :" + res.getString(2) + "\n");
                    buffer.append("EMAIL ID :" + res.getString(3) + "\n");
                }
                //SHOW ALL DATA
                showMessage("Data",buffer.toString());
            }
        });
    }

    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}