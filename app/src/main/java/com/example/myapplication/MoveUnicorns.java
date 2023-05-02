package com.example.myapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MoveUnicorns extends AppCompatActivity {


    private Storage storage;
    private LinearLayout scrollView;
    private ArrayList<Unicorn> move = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moveunicorns);

        storage = Storage.getInstance();


        scrollView = findViewById(R.id.viewunicorns);

        for (Unicorn unicorn : storage.getUnicorns()) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(unicorn.getUnicornName());
            cb.setTextSize(30);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        move.add(unicorn);
                    } else {
                        move.remove(unicorn);
                    }
                }
            });
            scrollView.addView(cb);

        }


    }





}









