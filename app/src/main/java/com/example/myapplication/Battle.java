package com.example.myapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Battle extends AppCompatActivity {


    private Storage storage;
    private LinearLayout scrollView;

    private ArrayList<Unicorn> battle = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battlefield);

        storage = Storage.getInstance();

        scrollView = findViewById(R.id.viewunicorns);

        for (Unicorn unicorn : storage.getUnicorns()) {

            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(unicorn.getUnicornName());
            cb.setTextSize(30);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                }
            });
            scrollView.addView(cb);
        }

        public void BattleUnicorn(){


        }
    }
}