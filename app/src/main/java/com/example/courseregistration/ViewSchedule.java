package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewSchedule extends AppCompatActivity{


    private ListView daysListView;
    ArrayAdapter daysadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewschedule);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");

        daysListView = (ListView) findViewById(R.id.lstView);
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        daysadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, days);
        daysListView.setAdapter(daysadapter);

        daysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedDay = (String) daysadapter.getItem(position);

                Intent intent = new Intent(ViewSchedule.this, ViewScheduleSingleDay.class);
                intent.putExtra("day", selectedDay);
                intent.putExtra("userID", userID);

                startActivity(intent);
            }
        });

    }
}
