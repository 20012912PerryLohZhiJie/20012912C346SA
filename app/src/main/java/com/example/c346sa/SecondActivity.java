package com.example.c346sa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<RatLog> rats;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnlog;
        ListView lv;
        TextView ans;
        btnlog = findViewById(R.id.btnrecordrat);
        lv = findViewById(R.id.lv);
        ans = findViewById(R.id.tvaverage);


        Intent i = getIntent();
        rats = new ArrayList<RatLog>();
        RatLog rat1 = new RatLog(2, "ABC Shop");
        RatLog rat2 = new RatLog(3, "DEF Eatery");

        rats.add(rat1);
        rats.add(rat2);

        int ratsum1 =0;
        int ratsum2 =0;
        for(int x = 0; x<rats.size();x++)
        {
            ratsum1 = rats.get(x).getNumber();
            ratsum2 = rats.get(x+1).getNumber();
        }

        double average = (ratsum1 + ratsum2)/rats.size();
        ans.setText("Average rats spotted: " + average);


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);

                builder.setTitle("Add Log");
                builder.setCancelable(false);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                            {

                                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                                {
                                    Toast.makeText(SecondActivity.this, " " + rats.get(position), Toast.LENGTH_LONG).show();
                                    String colour = lv.getSelectedItem().toString();

                                }
                            }
                        });
                    }
                });

                builder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = builder.create();
                myDialog.show();

            }
        });

    }




}