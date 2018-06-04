package com.example.thanhtam.employeemanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_employee extends AppCompatActivity {

    EditText id, name, dob, room, note;
    Button add, edit, delete, find, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        id = (EditText)findViewById(R.id.edID);
        name = (EditText)findViewById(R.id.edName);
        dob = (EditText)findViewById(R.id.edDOB);
        room = (EditText)findViewById(R.id.edRoom);
        note = (EditText)findViewById(R.id.edNote);
        add = (Button)findViewById(R.id.btnAdd);
        final Intent intent = new Intent(this,MainActivity.class);
        final employee qlemployee = new employee(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd = id.getText().toString();
                String fnstd = name.getText().toString();
                String dobstd = dob.getText().toString();
                String roomstd = room.getText().toString();
                String notestd = note.getText().toString();

                qlemployee.taosv(idstd, fnstd, dobstd, roomstd, notestd);
                startActivity(intent);
            }
        });
        edit = (Button)findViewById(R.id.btnEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd = id.getText().toString();
                String fnstd = name.getText().toString();
                String dobstd = dob.getText().toString();
                String roomstd = room.getText().toString();
                String notestd = note.getText().toString();

                qlemployee.suasv(idstd, fnstd, dobstd, roomstd, notestd);
                startActivity(intent);
            }
        });
        delete = (Button)findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd = id.getText().toString();

                qlemployee.xoasv(idstd);
                startActivity(intent);
            }
        });
        cancel = (Button)findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

}
