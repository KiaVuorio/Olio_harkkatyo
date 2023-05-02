package com.example.myapplication;

import java.io.Serializable;

public class Unicorn implements Serializable {

    protected String unicornname;
    protected String unicornColour;
    protected int attack;
    protected int defence;
    protected int life;

    protected int current_life;
    protected int experience;
    protected int photo;

    public Unicorn(String Unicornname, String unicornColour,  int attack, int defence, int life, int experience, int photo) {
        this.unicornname = Unicornname;
        this.unicornColour = unicornColour;
        this.attack = attack;
        this.defence = defence;
        this.life = life;
        current_life = life;
        this.experience = experience;
        this.photo = photo;

    }

    public void setUnicornname(String Unicornname) {this.unicornname = Unicornname;}
    public String getUnicornName() {return unicornname;}



    public void setunicornColour(String unicornColour) {
        this.unicornColour = unicornColour;
    }
    public String getunicornColour() {
        return unicornColour;
    }






    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getAttack() {
        return attack;
    }


    public void setDefence(int defence) {
        this.defence = defence;
    }
    public int getDefence() {
        return defence;
    }




    public void setLife(int life) {
        this.life = life;
    }
    public int getLife() {
        return life;
    }
    public int getCurrent_life(){return current_life;}

    public void heal(){
        current_life = life;
    }



    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }
    public void addExperience(int exp) {
        this.experience += exp;
        this.attack += exp;
    }



    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public int attack(){
        return attack;

    }

    public boolean defence(int attack){
        int damage = (attack-defence);
        if (damage > 0)
            current_life = current_life-damage;
        else
            current_life--;
        if (current_life < 0){
            current_life = 0;
        }
        return current_life <= 0;
    }




}
