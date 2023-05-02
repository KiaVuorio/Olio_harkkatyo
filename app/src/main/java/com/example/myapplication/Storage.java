package com.example.myapplication;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {
    private ArrayList<Unicorn> unicorns = new ArrayList<>();
    private ArrayList<Unicorn> home = new ArrayList<>();
    private ArrayList<Unicorn> battlefield = new ArrayList<>();
    private ArrayList<Unicorn> training = new ArrayList<>();

    private static Storage storage = null;

    private Storage(){
    }

    public static Storage getInstance() {
        if (storage == null){
            storage = (Storage) readObject("Storage.data");
            if (storage == null)
                storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Unicorn> getUnicorns() {
        return unicorns;
    }

    public ArrayList<Unicorn> getHome() {
        return home;
    }

    public ArrayList<Unicorn> getBattlefield() {
        return battlefield;
    }

    public ArrayList<Unicorn> getTraining() {
        return training;
    }

    public void addUnicorn(Unicorn unicorn) {
        unicorns.add(unicorn);
        home.add(unicorn);
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

    public void saveUnicorns() {
        saveObject(storage, "Storage.data");
    }

    public static void saveObject(Object object, String filename) {
        try {
            ObjectOutput output = new ObjectOutputStream(MainActivity.getAppContext().openFileOutput(filename, Context.MODE_PRIVATE));
            output.writeObject(object);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String filename) {
        Object object;
        try {
            ObjectInput input = new ObjectInputStream(MainActivity.getAppContext().openFileInput(filename));
            object = input.readObject();
            input.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;


    }

        public void moveUnicorns(String Place, Unicorn unicorn){
        home.remove(unicorn);
        battlefield.remove(unicorn);
        training.remove(unicorn);

            switch (Place) {
                case "home":
                default:
                    home.add(unicorn);
                    break;

                case "battlefield":
                    battlefield.add(unicorn);
                    break;

                case "training":
                    training.add(unicorn);
                    break;
            }
        }
}















