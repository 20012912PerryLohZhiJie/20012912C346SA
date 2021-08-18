package com.example.c346sa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView msg;
        Button btnlog;

        msg = findViewById(R.id.tvmsg);
        btnlog = findViewById(R.id.btlog);

        btnlog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                int x  =0;
                while (x != 0)
                {
                    msg.setText("You had launched app" + x + " times");
                }
                x++;

                if(x == 0)
                {
                    msg.setText("You had launched app 0 times");
                }


            }
        });


    }
}