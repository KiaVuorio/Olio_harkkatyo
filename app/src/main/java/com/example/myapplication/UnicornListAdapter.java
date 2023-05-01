package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Unicorns.BlackUnicorn;
import com.example.myapplication.Unicorns.GreenUnicorn;
import com.example.myapplication.Unicorns.OrangeUnicorn;
import com.example.myapplication.Unicorns.PinkUnicorn;
import com.example.myapplication.Unicorns.WhiteUnicorn;

import java.util.ArrayList;



public class UnicornListAdapter extends RecyclerView.Adapter<UnicornViewHolder> {

private Context context;
    private ArrayList<Unicorn> unicorns;

    public UnicornListAdapter(Context context, ArrayList<Unicorn> unicorns) {
        this.context = context;
        this.unicorns = unicorns;
    }

    @NonNull
    @Override
    public UnicornViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UnicornViewHolder(LayoutInflater.from(context).inflate(R.layout.listunicorns, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull UnicornViewHolder holder, int position) {
        holder.namecolour.setText(unicorns.get(position).getUnicornName() + " (" + unicorns.get(position).getunicornColour()+")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(unicorns.get(position).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(unicorns.get(position).getDefence()));
        holder.life.setText("Elämät: " + String.valueOf(unicorns.get(position).getLife()));
        holder.experience.setText("Kokemus: " + String.valueOf(unicorns.get(position).getExperience()));
        holder.photo.setImageResource(unicorns.get(position).getPhoto());
        switch (unicorns.get(position).getunicornColour()) {
            case "White":
            default:
                holder.background.setBackgroundColor(Color.parseColor("#C7CAB8"));
                break;

            case "Green":
                holder.background.setBackgroundColor(Color.parseColor("#4CAF50"));
                break;

            case "Pink":
                holder.background.setBackgroundColor(Color.parseColor("#A84A90"));
                break;

            case "Orange":
                holder.background.setBackgroundColor(Color.parseColor("#FF9800"));
                break;

            case "Black":
                holder.background.setBackgroundColor(Color.parseColor("#504F4D"));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return unicorns.size();
    }
}

