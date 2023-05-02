package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity{


    private Storage storage;
    private RecyclerView recyclerView;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();


    }

    public static Context getAppContext(){
        return MainActivity.context;
    }

    public void buttonAddUnicorn(View view){
        Intent intent = new Intent(this, AddUnicornActivity.class);
        startActivity(intent);
    }

    public void buttonListUnicorn(View view){
        Intent intent = new Intent(this, ListUnicornActivity.class);
        startActivity(intent);
    }

    public void buttonMoveUnicorns(View view){
        Intent intent = new Intent(this, MoveUnicorns.class);
        startActivity(intent);
    }

    public void buttonBattleUnicorns(View view){
        Intent intent = new Intent(this, Battle.class);
        startActivity(intent);
    }

    public void buttonTrainUnicorns(View view){
        Intent intent = new Intent(this, Training.class);
        startActivity(intent);
    }

    public void buttonHome(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

}

