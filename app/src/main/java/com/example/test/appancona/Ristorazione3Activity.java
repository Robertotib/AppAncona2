package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Ristorazione3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ristorazione3);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);

    }
}
