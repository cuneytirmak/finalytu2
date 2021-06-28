package com.example.finalytu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Listeler extends AppCompatActivity implements View.OnClickListener {
    private Button ekle;
    private RecyclerView listeRecView;
    ArrayList<Alisveris> alisveriss = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Urunler> liste = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeler);
        listeRecyclerViewAdapter adapter = new listeRecyclerViewAdapter(this);


        ekle = (Button) findViewById(R.id.ekle);
        listeRecView = findViewById(R.id.listeRecView);

        ekle.setOnClickListener(this);

        listeRecView.setAdapter(adapter);
        listeRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAlisverisler(alisveriss);



        String li;
        File directory = new File(String.valueOf(super.getFilesDir()));
        File file;
        File[] files = directory.listFiles();
        for (File value : files) {
            li = value.getName();
            file = new File(super.getFilesDir(), li);
            Alisveris st = (Alisveris) ObjectIO.ReadObjectFromFile(file);
            alisveriss.add(st);

        }




    }
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.ekle:
                intent = new Intent(v.getContext(), Ekle.class);
                startActivity(intent);
                break;
        }
    }
}
