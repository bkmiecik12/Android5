package com.example.bkmiecik.android5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView t1;
    TextView t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        b1 = (Button) findViewById(R.id.button);

        final Intent intent = new Intent(this,SecActivity.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        registerForContextMenu(t1);
        registerForContextMenu(t2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater;
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.t1){
            menu.add(0,11,0,"Małe");
            menu.add(0,12,1,"Normalne");
            menu.add(0,13,2,"Wielkie");
        }
        else if(v.getId()==R.id.t2){
            menu.add(1,21,0,"Małe");
            menu.add(1,22,1,"Normalne");
            menu.add(1,23,2,"Wielkie");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 11:
                t1.setAllCaps(false);
                t1.setText("hello world!");
                return true;
            case 12:
                t1.setAllCaps(false);
                t1.setText("Hello World!");
                return true;
            case 13:
                t1.setAllCaps(true);
                return true;
            case 21:
                t2.setAllCaps(false);
                t2.setText("bye bye world!");
                return true;
            case 22:
                t2.setAllCaps(false);
                t2.setText("Bye Bye World!");
                return true;
            case 23:
                t2.setAllCaps(true);
                return true;
            default:
                super.onContextItemSelected(item);
                return true;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.pozycja1:
                t1.setTextSize(30);
                t2.setTextSize(30);
                return true;
            case R.id.pozycja2:
                t1.setTextSize(20);
                t2.setTextSize(20);
                return true;
            case R.id.pozycja3:
                t1.setTextSize(10);
                t2.setTextSize(10);
                return true;
            case R.id.pozycja21:
                t1.setTextColor(getResources().getColor(R.color.red));
                t2.setTextColor(getResources().getColor(R.color.red));
                return true;
            case R.id.pozycja22:
                t1.setTextColor(getResources().getColor(R.color.green));
                t2.setTextColor(getResources().getColor(R.color.green));
                return true;
            case R.id.pozycja23:
                t1.setTextColor(getResources().getColor(R.color.blue));
                t2.setTextColor(getResources().getColor(R.color.blue));
                return true;
            default:
                super.onOptionsItemSelected(item);
                return true;

        }
    }
}
