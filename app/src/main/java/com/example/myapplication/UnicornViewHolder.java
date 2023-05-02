package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

public class UnicornViewHolder extends RecyclerView.ViewHolder {
    ImageView photo;
    TextView namecolour, attack, defence, life, experience;

    Button remove;

    LinearLayoutCompat background;
    public UnicornViewHolder(@NonNull View itemView){
        super(itemView);
        photo = itemView.findViewById(R.id.photo);
        namecolour = itemView.findViewById(R.id.namecolour);
        defence = itemView.findViewById(R.id.defence);
        attack = itemView.findViewById(R.id.attack);
        life = itemView.findViewById(R.id.life);
        experience = itemView.findViewById(R.id.experience);
        background = itemView.findViewById(R.id.background);
        remove = itemView.findViewById(R.id.remove);
    }
}

