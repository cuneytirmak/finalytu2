package com.example.finalytu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button liste, market;

    @Override
    public File getFilesDir() {
        return super.getFilesDir();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = (Button) findViewById(R.id.liste);
        market = (Button) findViewById(R.id.market);

        liste.setOnClickListener(this);
        market.setOnClickListener(this);
        File dir = getFilesDir();


    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.liste:
                intent = new Intent(v.getContext(), Listeler.class);
                startActivity(intent);
                break;
            case R.id.market:
                intent = new Intent(v.getContext(), Marketler.class);
                startActivity(intent);
                break;
        }

    }

}