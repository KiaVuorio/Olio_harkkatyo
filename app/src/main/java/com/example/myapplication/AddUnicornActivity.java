package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Unicorns.BlackUnicorn;
import com.example.myapplication.Unicorns.GreenUnicorn;
import com.example.myapplication.Unicorns.OrangeUnicorn;
import com.example.myapplication.Unicorns.PinkUnicorn;
import com.example.myapplication.Unicorns.WhiteUnicorn;


public class AddUnicornActivity extends AppCompatActivity {
        protected EditText inputUnicornName;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.addunicorn);
        }

        public void addUnicorn(View view) {

            inputUnicornName = findViewById(R.id.Unicornname);


            String Unicornname = inputUnicornName.getText().toString();
            String unicornColour = "";

            RadioGroup rgUnicornType = findViewById(R.id.radioGroup);
            Unicorn newUnicorn;
            switch (rgUnicornType.getCheckedRadioButtonId()) {
                case R.id.rb1:
                default:
                    newUnicorn = new WhiteUnicorn(Unicornname);
                    break;

                case R.id.rb2:
                    newUnicorn = new GreenUnicorn(Unicornname);
                    break;

                case R.id.rb3:
                    newUnicorn = new PinkUnicorn(Unicornname);
                    break;

                case R.id.rb4:
                    newUnicorn = new OrangeUnicorn(Unicornname);
                    break;

                case R.id.rb5:
                    newUnicorn = new BlackUnicorn(Unicornname);
                    break;
            }

            Storage.getInstance().addUnicorn(newUnicorn);
        }
    }


