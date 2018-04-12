package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * This page shows the description of a selected math course
 *
 * Created by Lantao & Haining on 2018-03-22.
 */
public class MathCoursesDescription extends AppCompatActivity {
    Button back;
    String courseName = "";
    TextView MATHdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_courses_description);
        MATHdescription = (TextView) findViewById(R.id.MATHdescription);
        back = (Button) findViewById(R.id.back);
        Intent course = getIntent();
        Bundle courseDetail = course.getExtras();
        if(courseDetail!=null){
            courseName = (String) courseDetail.get("name");
        }

        //retrieve course description from firebase
        DatabaseReference math = FirebaseDatabase.getInstance().getReference("subjects/math");
        math.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String name = snapshot.child("courseID").getValue().toString();
                    name += " "+snapshot.child("courseName").getValue().toString();
                    if(courseName.equals(name)){
                        String description = snapshot.child("courseDescription").getValue().toString();
                        MATHdescription.setText(description);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToCourses = new Intent(MathCoursesDescription.this,MathCourses.class);
                startActivity(backToCourses);
            }
        });
    }
}
