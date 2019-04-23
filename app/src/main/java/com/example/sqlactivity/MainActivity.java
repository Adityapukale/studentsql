package com.example.sqlactivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etprn,etclass,etdiv,etyear,etname;
    Button btninsert,btnselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SQLClass sqlclass = new SQLClass(this);
        btninsert = findViewById(R.id.binsert);
        btnselect = findViewById(R.id.bselect);
        etprn = findViewById(R.id.etprn);
        etclass = findViewById(R.id.etclass);
        etdiv = findViewById(R.id.etdiv);
        etyear = findViewById(R.id.etyear);
        etname = findViewById(R.id.etname);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqldatabase = sqlclass.getWritableDatabase();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("stprn",Integer.parseInt(etprn.getText().toString()));
                contentvalues.put("stclass",etclass.getText().toString());
                contentvalues.put("stdiv",etdiv.getText().toString());
                contentvalues.put("styear",Integer.parseInt(etyear.getText().toString()));
                contentvalues.put("stname",etname.getText().toString());
                long row = sqldatabase.insert("student",null,contentvalues);
                Toast.makeText(getApplicationContext(),"Row count is "+row,Toast.LENGTH_LONG).show();
            }
        });

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SelectActivity.class));
            }
        });
    }
}
