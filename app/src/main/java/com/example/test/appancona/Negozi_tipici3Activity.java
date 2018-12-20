package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Negozi_tipici3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.negozi_tipici3);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);

    }
}
