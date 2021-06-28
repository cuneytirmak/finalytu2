package com.example.finalytu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class urunRecyclerViewAdapter extends RecyclerView.Adapter<urunRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Urunler> urunler = new ArrayList<>();
    private Context context;
    private Button sil;


    public urunRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.urunler_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  urunRecyclerViewAdapter.ViewHolder holder, int position) {
        Urunler urun = urunler.get(position);
        holder.urunIsmi.setText(urunler.get(position).getName());
        holder.urunFiyati.setText(urunler.get(position).getPrice());
        holder.urunMiktari.setText(urunler.get(position).getAmount());
        holder.position = position;

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hello world");
            }
        });





    }

    @Override
    public int getItemCount() {
        return urunler.size();
    }

    public void setUrunler(ArrayList<Urunler> urunler) {
        this.urunler = urunler;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private EditText urunIsmi;
        private EditText urunFiyati;
        private EditText urunMiktari;
        private RelativeLayout parent;
        private Button sil;
        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            urunIsmi = itemView.findViewById(R.id.urunIsmi);
            urunFiyati=itemView.findViewById(R.id.urunFiyati);
            urunMiktari =itemView.findViewById(R.id.urunMiktari);
            sil=itemView.findViewById(R.id.silButon);


            parent=itemView.findViewById(R.id.parenturun);

            itemView.findViewById(R.id.silButon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(urunler.get(position));
                    urunler.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context,"Silindi",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }




}
