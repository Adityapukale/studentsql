package com.example.sqlactivity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {
    Button byyear,byname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        final SQLClass sqlclass = new SQLClass(this);
        byyear = findViewById(R.id.bbyyear);
        byname = findViewById(R.id.bbyname);

        byyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cs=sqlclass.getByPercentage();
                if(cs.getCount()==0){
                    showalldata("DATA","DATA NOT FOUND");
                } else {
                    cs.moveToFirst();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cs.moveToNext()) {
                        stringBuffer.append("PRN Number : " + cs.getString(0) + "\n");
                        stringBuffer.append("Class : " + cs.getString(1) + "\n");
                        stringBuffer.append("Div : " + cs.getString(2) + "\n");
                        stringBuffer.append("Admission Year : " + cs.getString(3) + "\n");
                        stringBuffer.append("Name : " + cs.getString(4) + "\n\n");
                    }
                    showalldata("DATA",stringBuffer.toString());
                }
            }
        });

        byname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cs=sqlclass.getByCategory();
                if(cs.getCount()==0){
                    showalldata("DATA","DATA NOT FOUND");
                }else{
                    cs.moveToFirst();
                    StringBuffer stringBuffer=new StringBuffer();
                    while(cs.moveToNext()){
                        stringBuffer.append("PRN Number :"+cs.getString(0)+"\n");
                        stringBuffer.append("Class :"+cs.getString(1)+"\n");
                        stringBuffer.append("Div :"+cs.getString(2)+"\n");
                        stringBuffer.append("Admission Year : :"+cs.getString(3)+"\n");
                        stringBuffer.append("Name : " + cs.getString(4) + "\n\n");
                    }
                    showalldata("DATA",stringBuffer.toString());
                }
            }
        });
    }

    public  void showalldata(String title,String mesg){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(mesg);
        builder.show();
    }
}
