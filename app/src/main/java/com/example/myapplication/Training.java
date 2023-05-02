package com.example.myapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Training extends AppCompatActivity {


    private Storage storage;
    private LinearLayout scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_area);

        storage = Storage.getInstance();

        scrollView = findViewById(R.id.viewunicorns);

        for (Unicorn unicorn : storage.getUnicorns()) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(unicorn.getUnicornName());
            cb.setTextSize(30);
            scrollView.addView(cb);
        }

    }

