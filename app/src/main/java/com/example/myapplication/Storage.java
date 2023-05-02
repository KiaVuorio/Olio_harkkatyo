package com.example.myapplication;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Unicorn> unicorns = new ArrayList<>();

    private static Storage storage = null;

    private Storage(){
    }

    public static Storage getInstance() {
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Unicorn> getUnicorns() {
        return unicorns;
    }

    public void addUnicorn(Unicorn unicorn) {
        unicorns.add(unicorn);
    }


    public ArrayList<Unicorn> getListOfUnicorns() {
        return unicorns;
    }

    public Unicorn getUnicorn(String name){
        for (Unicorn unicorn : unicorns) {
            if (unicorn.getUnicornName().equals(name))
                return unicorn;
        }
        return null;
    }


}















