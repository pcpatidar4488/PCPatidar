package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    ImageButton imageButton;
    Button btViewAll;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        btViewAll = (Button) findViewById(R.id.btview);
        imageButton = (ImageButton) findViewById(R.id.imagebutton);

        viewAll();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,Ctreatepage.class);
                startActivity(i);
            }
        });

       /* ListView listview =(ListView) findViewById(R.id.listView);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = databaseHelper.getAllData();

        if(data.getCount()==0)
        {
            Toast.makeText(MainActivity.this, "The Database was empty", Toast.LENGTH_LONG).show();
        }
        else
        {
            while (data.moveToNext()){
                theList.add(data.getString(0));
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

            }
        }*/


    }

    public void viewAll() {
        btViewAll.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("NAME :" + res.getString(0) + "\n");
                    buffer.append("ROLL NO :" + res.getString(1) + "\n");
                    buffer.append("MOBILE_NUMBER :" + res.getString(2) + "\n");
                    buffer.append("CLASS :" + res.getString(3) + "\n");
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