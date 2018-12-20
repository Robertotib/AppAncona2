package com.example.test.appancona.Ristorazione;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.test.appancona.*;

public class Ristorazione3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ristorazione3);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);

    }
}
