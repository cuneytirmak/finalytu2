package com.example.finalytu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;

public class Ekle extends AppCompatActivity  {

    Button urunEkle;
    private RecyclerView urunRecView;
    EditText urunIsmi;
    EditText urunFiyati;
    EditText urunMiktari;
    Button kaydet;
    EditText listeId;
    EditText marketId;
    EditText tarih;
    String currentListe;
    String currentTarih;
    String currentMarket;
    ArrayList currentUrun;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
        urunEkle = findViewById(R.id.urunEkle);
        kaydet = findViewById(R.id.kaydet);
        urunIsmi = findViewById(R.id.urunIsmi);
        urunFiyati = findViewById(R.id.urunFiyati);
        urunMiktari = findViewById(R.id.urunMiktari);
        urunRecView = findViewById(R.id.urunlerRecView);
        listeId = findViewById(R.id.listeId);
        marketId = findViewById(R.id.marketId);
        tarih=findViewById(R.id.tarih);

        currentListe =getIntent().getStringExtra("listeAdi");
        currentTarih =getIntent().getStringExtra("listeTarih");
        currentMarket =getIntent().getStringExtra("listeMarket");
        currentUrun =getIntent().getStringArrayListExtra("listeListe");
        System.out.println(currentUrun);

        listeId.setText(currentListe);
        marketId.setText(currentMarket);
        tarih.setText(currentTarih);



        ArrayList<Urunler> urunler = new ArrayList<>();

        if (currentUrun!=null) {
            for (Object i : currentUrun) {
                System.out.println(i.getClass());
                Urunler a = (Urunler) i;
                urunler.add(a);

            }
        }

        ArrayList<Alisveris> alisverisler = new ArrayList<>();




        urunRecyclerViewAdapter adapter = new urunRecyclerViewAdapter(this);
        adapter.setUrunler(urunler);
        urunRecView.setAdapter(adapter);
        urunRecView.setLayoutManager(new LinearLayoutManager(this));

        urunEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urunler.add(new Urunler(urunIsmi.getText().toString(),urunMiktari.getText().toString(),urunFiyati.getText().toString()));

                System.out.println(urunler);
                adapter.notifyDataSetChanged();


            }


        });



        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Ekle.super.getFilesDir(),listeId.getText().toString());
                
                alisverisler.add(new Alisveris(listeId.getText().toString(),marketId.getText().toString(),tarih.getText().toString(),urunler,false));
                Alisveris alisverisz = (new Alisveris(listeId.getText().toString(),marketId.getText().toString(),tarih.getText().toString(),urunler,false));
                try {

                    FileOutputStream fileOut = new FileOutputStream(file);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(alisverisz);
                    objectOut.close();
                    Toast.makeText(v.getContext(),"Başarıyla Kaydedildi",Toast.LENGTH_SHORT).show();
                    System.out.println("The Object  was succesfully written to a file");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


                adapter.notifyDataSetChanged();
                Intent intent;
                    intent= new Intent(v.getContext(),Listeler.class);
                    startActivity(intent);



            }
        });






    }


}