package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.berylsystem.DataProvider;

public class DataListActivity extends ActionBarActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.activity_main);
        listView.setAdapter(listDataAdapter);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.getAllData();

        //Click On List Item
        listView.setOnItemClickListener(new ItemList());

        if(cursor.moveToFirst())
        {
            do{
                String name,rollno,id,mob,etclass;
                id=cursor.getString(0);
                name=cursor.getString(1);
                rollno=cursor.getString(2);
               mob=cursor.getString(3);
              etclass=cursor.getString(4);
                DataProvider dataProvider = new DataProvider(name,rollno);
                listDataAdapter.add(dataProvider);
            }while (cursor.moveToNext());
        }
    }

    class ItemList implements AdapterView.OnItemClickListener
    {
        Cursor cursor;
        Ctreatepage ctreatepage;
        EditText name,rollno,mobileno,etclass;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewGroup=(ViewGroup)view;
            TextView textView =(TextView)viewGroup.findViewById(R.id.text_name);
            TextView textView1 = (TextView)viewGroup.findViewById(R.id.text_rollno);

            Intent i = new Intent(DataListActivity.this,Ctreatepage.class);
            i.putExtra("name",textView.getText().toString());
            i.putExtra("rollno",textView.getText().toString());
           /* i.putExtra("mobile",textView.getText().toString());
            i.putExtra("etclass",textView.getText().toString());*/
            startActivity(i);
        }

        public void updatefun(String name,String rollno,String mobileno,String etclass)
        {



        }

    }
}
