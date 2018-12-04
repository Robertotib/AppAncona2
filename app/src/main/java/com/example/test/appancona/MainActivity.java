package com.example.test.appancona;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.addListenerOnButton1();
        this.addListenerOnButton2();
        this.addListenerOnButton3();
        this.addListenerOnButton4();
        this.addListenerOnButton5();
        this.addListenerOnButton6();





    }
    public void addListenerOnButton1(){
        ImageButton a;
        a  =  findViewById(R.id.icona1);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Punti_interesse1Activity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton2(){
        ImageButton a;
        a  =  findViewById(R.id.icona2);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Ristorazione1Activity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton3(){
        ImageButton a;
        a  =  findViewById(R.id.icona3);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Pernottamento1Activity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton4(){
        ImageButton a;
        a  =  findViewById(R.id.icona4);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Percorsi1Activity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton5(){
        ImageButton a;
        a  =  findViewById(R.id.icona5);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Servizi1Activity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton6(){
        ImageButton a;
        a  =  findViewById(R.id.icona6);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Citta1Activity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.MENU_1:
                Intent i;
                i = new Intent(MainActivity.this,Ricerca1Activity.class);
                startActivity(i);
                break;

            case R.id.MENU_2:
        }
        return true;
    }


}
