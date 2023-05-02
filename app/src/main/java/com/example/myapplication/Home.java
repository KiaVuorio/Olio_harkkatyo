package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home extends AppCompatActivity {


    private Storage storage;
    private LinearLayout scrollView;

    private ArrayList<Unicorn> home = new ArrayList<>();

    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        storage = Storage.getInstance();

        scrollView = findViewById(R.id.viewunicorns);

        info = findViewById(R.id.info);

        for (Unicorn unicorn : storage.getHome()) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(unicorn.getUnicornName());
            cb.setTextSize(30);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        home.add(unicorn);
                    } else {
                        home.remove(unicorn);
                    }
                }
            });
            scrollView.addView(cb);
        }
    }


    public void restUnicorn(View view) {
        String text = "";

        for (Unicorn unicorn : home) {
            unicorn.heal();
            text = text + unicorn.getUnicornName() + "(" + unicorn.getunicornColour() + ") att: " + unicorn.getAttack() + "; def: " + unicorn.getDefence() + "; exp: " + unicorn.getExperience() + "; health: " + unicorn.getCurrent_life() + "/" + unicorn.getLife() + "\n";
        }
        info.setText(text);
        storage.saveUnicorns();
    }
}