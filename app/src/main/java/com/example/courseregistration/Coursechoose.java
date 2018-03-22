package com.example.courseregistration;
import com.example.courseregistration.DBHelper.FirebaseHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
  
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Courses;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class Coursechoose extends AppCompatActivity {

    public ArrayList<CourseInfo> courseList = new ArrayList<CourseInfo>();



    //FirebaseHelper firebasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursechoose);

        final Button button = (Button) findViewById(R.id.button3);

        final CheckBox checkbox11 = (CheckBox) findViewById(R.id.checkBox11);
        final CheckBox checkbox12 = (CheckBox) findViewById(R.id.checkBox12);
        final CheckBox checkbox13 = (CheckBox) findViewById(R.id.checkBox13);
        final CheckBox checkbox14 = (CheckBox) findViewById(R.id.checkBox14);

        final TextView c1wctextView = (TextView) findViewById(R.id.c1wctextView);
        final TextView c1wntextView = (TextView) findViewById(R.id.c1wntextView);
        final TextView c1maxtextView = (TextView) findViewById(R.id.c1maxtextView);
        final TextView c1curtextView = (TextView) findViewById(R.id.c1curtextView);
        final TextView c2wctextView = (TextView) findViewById(R.id.c2wctextView);
        final TextView c2wntextView = (TextView) findViewById(R.id.c2wntextView);
        final TextView c2maxtextView = (TextView) findViewById(R.id.c2maxtextView);
        final TextView c2curtextView = (TextView) findViewById(R.id.c2curtextView);
        final TextView c3wctextView = (TextView) findViewById(R.id.c3wctextView);
        final TextView c3wntextView = (TextView) findViewById(R.id.c3wntextView);
        final TextView c3maxtextView = (TextView) findViewById(R.id.c3maxtextView);
        final TextView c3curtextView = (TextView) findViewById(R.id.c3curtextView);
        final TextView c4wctextView = (TextView) findViewById(R.id.c4wctextView);
        final TextView c4wntextView = (TextView) findViewById(R.id.c4wntextView);
        final TextView c4maxtextView = (TextView) findViewById(R.id.c4maxtextView);
        final TextView c4curtextView = (TextView) findViewById(R.id.c4curtextView);


        Intent intent = getIntent();
        final String message = intent.getStringExtra("data");
        final String userID = intent.getStringExtra("userID");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {

                String course1 = dataSnapshot.child("subjects").child(message).child("course 1").child("courseID").getValue(String.class);
                String course2 = dataSnapshot.child("subjects").child(message).child("course 2").child("courseID").getValue(String.class);
                String course3 = dataSnapshot.child("subjects").child(message).child("course 3").child("courseID").getValue(String.class);
                String course4 = dataSnapshot.child("subjects").child(message).child("course 4").child("courseID").getValue(String.class);


                if (message.equals("computer science")) {
                    checkbox11.setText(course1);
                    String wcnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistcapacity").getValue().toString();
                    String wnnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();
                    String maxnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                    String curnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                    c1wctextView.setText(wcnum1);
                    c1wntextView.setText(wnnum1);
                    c1maxtextView.setText(maxnum1);
                    c1curtextView.setText(curnum1);
                    checkbox12.setText(course2);
                    String wcnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistcapacity").getValue().toString();
                    String wnnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistnum").getValue().toString();
                    String maxnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("capacity").getValue().toString();
                    String curnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("numberOfStudents").getValue().toString();
                    c2wctextView.setText(wcnum2);
                    c2wntextView.setText(wnnum2);
                    c2maxtextView.setText(maxnum2);
                    c2curtextView.setText(curnum2);
                    checkbox13.setText(course3);
                    String wcnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistcapacity").getValue().toString();
                    String wnnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistnum").getValue().toString();
                    String maxnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("capacity").getValue().toString();
                    String curnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("numberOfStudents").getValue().toString();
                    c3wctextView.setText(wcnum3);
                    c3wntextView.setText(wnnum3);
                    c3maxtextView.setText(maxnum3);
                    c3curtextView.setText(curnum3);
                    checkbox14.setText(course4);
                    String wcnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistcapacity").getValue().toString();
                    String wnnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistnum").getValue().toString();
                    String maxnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                    String curnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                    c4wctextView.setText(wcnum4);
                    c4wntextView.setText(wnnum4);
                    c4maxtextView.setText(maxnum4);
                    c4curtextView.setText(curnum4);
                }
                if (message.equals("math")) {
                    checkbox11.setText(course1);
                    String wcnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistcapacity").getValue().toString();
                    String wnnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();
                    String maxnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                    String curnum1 = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                    c1wctextView.setText(wcnum1);
                    c1wntextView.setText(wnnum1);
                    c1maxtextView.setText(maxnum1);
                    c1curtextView.setText(curnum1);
                    checkbox12.setText(course2);
                    String wcnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistcapacity").getValue().toString();
                    String wnnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistnum").getValue().toString();
                    String maxnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("capacity").getValue().toString();
                    String curnum2 = dataSnapshot.child("subjects").child(message).child("course 2").child("numberOfStudents").getValue().toString();
                    c2wctextView.setText(wcnum2);
                    c2wntextView.setText(wnnum2);
                    c2maxtextView.setText(maxnum2);
                    c2curtextView.setText(curnum2);
                    checkbox13.setText(course3);
                    String wcnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistcapacity").getValue().toString();
                    String wnnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistnum").getValue().toString();
                    String maxnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("capacity").getValue().toString();
                    String curnum3 = dataSnapshot.child("subjects").child(message).child("course 3").child("numberOfStudents").getValue().toString();
                    c3wctextView.setText(wcnum3);
                    c3wntextView.setText(wnnum3);
                    c3maxtextView.setText(maxnum3);
                    c3curtextView.setText(curnum3);
                    checkbox14.setText(course4);
                    String wcnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistcapacity").getValue().toString();
                    String wnnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistnum").getValue().toString();
                    String maxnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("capacity").getValue().toString();
                    String curnum4 = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                    c4wctextView.setText(wcnum4);
                    c4wntextView.setText(wnnum4);
                    c4maxtextView.setText(maxnum4);
                    c4curtextView.setText(curnum4);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override


                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        String message1 = "";
                        //DatabaseReference checktime=myRef.child("user").child(userID).child("registered courses");

                                /*for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                                    String userKey = snapshot.getKey();
                                    String user = snapshot.child("registered courses").getValue(String.class);
                                    CourseInfo course = snapshot.getValue(CourseInfo.class);
                                    courseList.add(course);
                                }*/
                        if (checkbox11.isChecked()) {
                            message1 = checkbox11.getText().toString();

                            String id = myRef.child(userID).push().getKey();
                            String courseID=dataSnapshot.child("subjects").child(message).child("course 1").child("courseID").getValue().toString();
                            String subject=message;
                            String starttime = dataSnapshot.child("subjects").child(message).child("course 1").child("time").child("start").getValue().toString();
                            String endtime=dataSnapshot.child("subjects").child(message).child("course 1").child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child("course 1").child("time").child("days").getValue().toString();

                            Courses r=new Courses(id,courseID,subject,starttime,endtime,days);
                            myRef.child("users").child(userID).child("registered courses").child(id).setValue(r);
                                    /*int checkcounter = 0; //confilict buged
                                    for(int i = 0; i<timeList.size(); i++){
                                        if(timeList.get(i).equals(checktime)) {
                                            checkcounter = 1;
                                        }
                                    }
                                    if(checkcounter == 0) {*/
                                   /* }
                                    else{
                                        Toast.makeText(Coursechoose.this, "You have a confilict courses.", Toast.LENGTH_SHORT).show();
                                    }*/
                            String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();

                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap == numint) {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child("course 1").child("waitlistnum").setValue(numintwaitnum1);
                                checkbox11.setChecked(false);
                            } else {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(numint1);
                                checkbox11.setChecked(false);
                            }
                        }

                        if (checkbox12.isChecked()) {
                            message1 = checkbox12.getText().toString();
                            String id = myRef.child(userID).push().getKey();
                            String courseID=dataSnapshot.child("subjects").child(message).child("course 2").child("courseID").getValue().toString();
                            String subject=message;
                            String starttime = dataSnapshot.child("subjects").child(message).child("course 2").child("time").child("start").getValue().toString();
                            String endtime=dataSnapshot.child("subjects").child(message).child("course 2").child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child("course 2").child("time").child("days").getValue().toString();

                            Courses r=new Courses(id,courseID,subject,starttime,endtime,days);
                            myRef.child("users").child(userID).child("registered courses").child(id).setValue(r);
                                    /*int checkcounter = 0;
                                    for(int i = 0; i<timeList.size(); i++){  //confilict buged
                                        if(timeList.get(i).equals(checktime)) {
                                            checkcounter = 1;
                                        }
                                    }
                                    if(checkcounter == 0) {*/

                                   /* }
                                    else{
                                        Toast.makeText(Coursechoose.this, "You have a confilict courses.", Toast.LENGTH_SHORT).show();
                                    }*/
                            String num = dataSnapshot.child("subjects").child(message).child("course 2").child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child("course 2").child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);

                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child("course 2").child("numberOfStudents").setValue(numint1);
                                checkbox11.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child("course 2").child("waitlistnum").setValue(numintwaitnum1);
                                checkbox11.setChecked(false);
                            }
                        }
                        if (checkbox13.isChecked()) {
                            message1 = checkbox13.getText().toString();
                            String id = myRef.child(userID).push().getKey();
                            String courseID=dataSnapshot.child("subjects").child(message).child("course 3").child("courseID").getValue().toString();
                            String subject=message;
                            String starttime = dataSnapshot.child("subjects").child(message).child("course 3").child("time").child("start").getValue().toString();
                            String endtime=dataSnapshot.child("subjects").child(message).child("course 3").child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child("course 3").child("time").child("days").getValue().toString();

                            Courses r=new Courses(id,courseID,subject,starttime,endtime,days);
                            myRef.child("users").child(userID).child("registered courses").child(id).setValue(r);
                                    /*int checkcounter = 0;   //confilict buged
                                    for(int i = 0; i<timeList.size(); i++){
                                        if(timeList.get(i).equals(checktime)) {
                                            checkcounter = 1;
                                        }
                                    }
                                    if(checkcounter == 0) {*/
                                   /* }
                                    else{
                                        Toast.makeText(Coursechoose.this, "You have a confilict courses.", Toast.LENGTH_SHORT).show();
                                    }*/
                            String num = dataSnapshot.child("subjects").child(message).child("course 3").child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child("course 3").child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child("course 3").child("numberOfStudents").setValue(numint1);
                                checkbox11.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child("course 3").child("waitlistnum").setValue(numintwaitnum1);
                                checkbox11.setChecked(false);
                            }
                        }

                        if (checkbox14.isChecked()) {
                            message1 = checkbox14.getText().toString();
                            String id = myRef.child(userID).push().getKey();
                            String courseID=dataSnapshot.child("subjects").child(message).child("course 4").child("courseID").getValue().toString();
                            String subject=message;
                            String starttime = dataSnapshot.child("subjects").child(message).child("course 4").child("time").child("start").getValue().toString();
                            String endtime=dataSnapshot.child("subjects").child(message).child("course 4").child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child("course 4").child("time").child("days").getValue().toString();

                            Courses r=new Courses(id,courseID,subject,starttime,endtime,days);
                            myRef.child("users").child(userID).child("registered courses").child(id).setValue(r);
                                   /* int checkcounter = 0; //confilict buged
                                    Log.d("test","test debug !!!!!!!!!!!!!!!!!");
                                    for(int i = 0; i<timeList.size(); i++){
                                        Log.d("test1","test debug++++++++++++++++++");
                                        if(timeList.get(i).equals(checktime)) {
                                            Log.d("test2","test debug______________________" + timeList.get(i) + checktime);
                                            checkcounter = 1;
                                        }
                                    }
                                    if(checkcounter == 0) {*/
                                    /*}
                                    else{
                                        Toast.makeText(Coursechoose.this, "You have a confilict courses.", Toast.LENGTH_SHORT).show();
                                    }*/
                            String num = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child("course 4").child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child("course 4").child("numberOfStudents").setValue(numint1);
                                checkbox11.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child("course 4").child("waitlistnum").setValue(numintwaitnum1);
                                checkbox11.setChecked(false);
                            }

                                Toast.makeText(Coursechoose.this, "This courses need a special pre courses", Toast.LENGTH_SHORT).show();
                        }

                        // String check = dataSnapshot.child("users").child(userID).child("learned courses").getValue().toString();
                        //if (check.contains("CSCI 1100")) {

                        //}
                        checkbox11.setChecked(false);
                        checkbox12.setChecked(false);
                        checkbox13.setChecked(false);
                        checkbox14.setChecked(false);
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                Intent intent = new Intent();
                intent.setClass(Coursechoose.this, Adddroptable.class);
                intent.putExtra("userID", userID);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });
    }
}



