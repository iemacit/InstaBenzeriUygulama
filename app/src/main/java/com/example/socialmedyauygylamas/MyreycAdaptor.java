package com.example.socialmedyauygylamas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyreycAdaptor extends RecyclerView.Adapter<MyreycAdaptor.Myholder> {
    private ArrayList<GonderiDetay> detay;

    public MyreycAdaptor(ArrayList<GonderiDetay> paylasim) {
        this.detay=paylasim;
    }

    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.paylasan_item,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.txtPaylasan.setText(detay.get(position).getPaylasan());
        holder.gonderi.setImageResource(detay.get(position).getLogo());
    }

    @Override
    public int getItemCount() {

        return detay.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView txtPaylasan;
        ImageView gonderi;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            txtPaylasan=itemView.findViewById(R.id.paylasan);
            gonderi=itemView.findViewById(R.id.gonderi);
        }
    }
}
