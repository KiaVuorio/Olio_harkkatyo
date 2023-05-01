package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



    public class ListUnicornActivity extends AppCompatActivity {

        private Storage storage;
        private RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.unicornview);

            storage = Storage.getInstance();

            recyclerView = findViewById(R.id.recycleunicorn);

            System.out.println("Unicorns: " + Storage.getInstance().getListOfUnicorns().size());

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(new UnicornListAdapter(getApplicationContext(), Storage.getInstance().getListOfUnicorns()));



        }
}
