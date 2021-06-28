package com.example.finalytu;


import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class listeRecyclerViewAdapter extends RecyclerView.Adapter<listeRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Alisveris> alisveriss = new ArrayList<>();
    private Context context;


    public listeRecyclerViewAdapter(Context context) {
        this.context=context;

    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ListeName.setText(alisveriss.get(position).getName());
        holder.ListeMarket.setText(alisveriss.get(position).getMarket());
        holder.ListeTarih.setText(alisveriss.get(position).getTarih());



        holder.parent.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Ekle.class);
                    intent.putExtra("listeAdi", alisveriss.get(position).getName());
                    intent.putExtra("listeTarih", alisveriss.get(position).getTarih());
                    intent.putExtra("listeListe", alisveriss.get(position).getListe());
                    intent.putExtra("listeMarket", alisveriss.get(position).getMarket());
                    context.startActivity(intent);

                System.out.println(alisveriss.get(position).getName());


            }
        });

    }

    @Override
    public int getItemCount() {
        return alisveriss.size();
    }

    public void setAlisverisler(ArrayList<Alisveris> alisveriss) {
        this.alisveriss = alisveriss;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ListeName;
        private TextView ListeMarket;
        private TextView ListeTarih;
        private ListView ListeUrunler;



        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            ListeName = itemView.findViewById(R.id.listeName);
            ListeMarket = itemView.findViewById(R.id.listeMarket);
            ListeTarih = itemView.findViewById(R.id.listeTarih);
            ListeUrunler = (ListView) itemView.findViewById(R.id.listeUrunler);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
