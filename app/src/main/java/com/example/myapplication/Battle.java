package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Battle extends AppCompatActivity {


    private Storage storage;
    private LinearLayout scrollView;

    private ArrayList<Unicorn> battle = new ArrayList<>();

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battlefield);

        storage = Storage.getInstance();

        scrollView = findViewById(R.id.viewunicorns);

        info = findViewById(R.id.info);

        for (Unicorn unicorn : storage.getUnicorns()) {

            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(unicorn.getUnicornName());
            cb.setTextSize(30);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        battle.add(unicorn);
                    } else {
                        battle.remove(unicorn);
                    }
                }
            });
            scrollView.addView(cb);
        }
    }

        public void battleUnicorn(View view){
            Unicorn fighter1 = battle.get(0);
            Unicorn fighter2 =  battle.get(1);
            String story = "";

            while (true) {
                story = story + fighter1.getUnicornName()+"("+fighter1.getunicornColour()+") att: "+ fighter1.getAttack()+"; def: "+fighter1.getDefence()+"; exp: "+fighter1.getExperience()+"; health: "+fighter1.getCurrent_life()+"/"+fighter1.getLife()+"\n";
                story = story + fighter2.getUnicornName()+"("+fighter2.getunicornColour()+") att: "+ fighter2.getAttack()+"; def: "+fighter2.getDefence()+"; exp: "+fighter2.getExperience()+"; health: "+fighter2.getCurrent_life()+"/"+fighter2.getLife()+"\n";

                if (fighter1.defence(fighter2.attack())){
                    story = story + fighter1.getUnicornName()+" kuoli\n";
                    fighter2.addExperience(1);
                    break;
                }

                story = story + fighter1.getUnicornName()+" onnistui väistämään kuoleman\n";

                Unicorn fighter3 = fighter1;
                fighter1 = fighter2;
                fighter2 = fighter3;
            }
            story = story + "Taistelu on ohitse.";
            info.setText(story);
            storage.saveUnicorns();

        }
    }
