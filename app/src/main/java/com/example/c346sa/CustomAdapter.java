package com.example.c346sa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter
{
    Context partent_context;
    int layout_id;
    ArrayList<RatLog> versionList;


    public CustomAdapter(Context context, int resource, ArrayList<RatLog> objects)
    {
        super(context, resource, objects);

        partent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                partent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);
        // Obtain the UI components and do the necessary binding

        ImageView ivNew = rowView.findViewById(R.id.high);

        EditText value = rowView.findViewById(R.id.etvalue);
        EditText place = rowView.findViewById(R.id.etplace);

        RatLog currentVersion = versionList.get(position);

        value.setText(currentVersion.getNumber());
        place.setText(currentVersion.getPlace());


        if(currentVersion.getNumber() >=3)
        {
            ivNew.setImageResource(R.drawable.high);
        }
        else
        {
            ivNew.setImageResource(View.INVISIBLE);
        }

        return rowView;
    }
}
