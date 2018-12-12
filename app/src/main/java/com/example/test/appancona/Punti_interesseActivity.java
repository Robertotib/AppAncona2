package com.example.test.appancona;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Punti_interesseActivity extends AppCompatActivity {

    private ListView lv=null;
    private SimpleCursorAdapter adapter=null;
    private DBManager db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse);

        lv=new ListView(this);
        setContentView(lv);

        db=new DBManager(this);
        adapter=new SimpleCursorAdapter(
                this,
                R.layout.row_tipi_punti_interesse,
                db.tipiPuntiinteresse(),
                new String[]{"immagine","_id"},
                new int[]{R.id.imagetipipuntint,R.id.nome},
                0
        );

        lv.setAdapter(adapter);
    }

    }


