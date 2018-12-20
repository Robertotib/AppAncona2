package com.example.test.appancona.Punti_interesse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.test.appancona.*;

public class Punti_interesse4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse4);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);
    }
}
