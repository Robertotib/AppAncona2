package com.example.test.appancona.Servizi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.test.appancona.*;

public class Servizi4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi4);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);

    }
}
