package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_add_circle_outline_black_24dp);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        databaseHelper = new DatabaseHelper(this);
        //viewAll();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_id:
                //Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Ctreatepage.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}







// View All data in a Box

   /* public void viewAll() {
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
    }*/