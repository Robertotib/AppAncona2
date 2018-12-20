package com.example.test.appancona.Pernottamento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.test.appancona.*;

public class Pernottamento3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pernottamento3);
        String t =getIntent().getStringExtra("nome");
        setTitle(t);

    }
}
