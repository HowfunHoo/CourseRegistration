package com.example.courseregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Justin & Jasper on 2018-03-29.
 */
public class ViewScheduleSemester extends AppCompatActivity{


    private ListView semestersListView;
    private Button returnToUser;
    ArrayAdapter semesteradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewschedulesemester);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");

        returnToUser = (Button) findViewById(R.id.ReturnToUser);

        semestersListView = (ListView) findViewById(R.id.semesterListView);
        ArrayList<String> semesters = new ArrayList<String>();
        semesters.add("Fall");
        //semesters.add("Winter");
        semesters.add("Summer");
        semesteradapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, semesters);
        semestersListView.setAdapter(semesteradapter);

        semestersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedSemester = String.valueOf(parent.getItemAtPosition(position));

                Intent intent = new Intent(ViewScheduleSemester.this, ViewSchedule.class);
                intent.putExtra("semester", selectedSemester);
                intent.putExtra("userID", userID);

                startActivity(intent);
            }
        });

        returnToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToD = new Intent(ViewScheduleSemester.this, UserActivity.class);
                intentToD.putExtra("userID", userID);
                startActivity(intentToD);
            }


        });
    }
}