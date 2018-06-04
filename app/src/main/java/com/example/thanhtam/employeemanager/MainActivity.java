package com.example.thanhtam.employeemanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Result;
    Button Add, Refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Result = (TextView) findViewById(R.id.tvShow);
        Add = (Button) findViewById(R.id.btnAdd);
        Refresh = (Button) findViewById(R.id.btnRefresh);
        final Intent intent = new Intent(   this, Add_employee.class);
        final employee employee = new employee(MainActivity.this);
        Cursor con_tro=employee.getAllSv();
        String chuoi="";
        while (con_tro.moveToNext()) {
            chuoi+=con_tro.getString(0)+"\t\t\t";
            chuoi+=con_tro.getString(1)+"\t\t\t";
            chuoi+=con_tro.getString(2)+"\t\t\t";
            chuoi+=con_tro.getString(3)+"\t\t\t";
            chuoi+=con_tro.getString(4)+"\t\t\t";
            chuoi+=con_tro.getString(5)+"\n";
        };

        Result.setText(chuoi);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor con_tro= employee.getAllSv();
                String chuoi="";
                if(con_tro.getCount()>=1){
                    con_tro.moveToFirst();
                    do {
                        chuoi+=con_tro.getString(0) + "\t\t\t";
                        chuoi+=con_tro.getString(1) + "\t\t\t";
                        chuoi+=con_tro.getString(2) + "\t\t\t";
                        chuoi+=con_tro.getString(3) + "\t\t\t";
                        chuoi+=con_tro.getString(4) + "\t\t\t";
                        chuoi+=con_tro.getString(5)+"\n";

                    }while (con_tro.moveToNext());
                    Result.setText(chuoi);
                }
            }
        });

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
