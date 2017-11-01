package com.example.berylsystem.screenorientation;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    EditText et;
    String etString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=0;
        et= (EditText) findViewById(R.id.edit);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        etString = et.getText().toString();

        outState.putString("edittext",etString);
        outState.putInt("score",score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        et.setText(savedInstanceState.getString("edittext"));
        score = savedInstanceState.getInt("score");
    }

    public void performAction(View v){

        switch (v.getId()){
            case R.id.bincrement:
                score+=1;
                break;

            case R.id.bshow:
                Toast.makeText(MainActivity.this, "Your Score is : " + score, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}