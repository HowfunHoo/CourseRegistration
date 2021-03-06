package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * Created by Justin & Jasper on 2018-03-25.
 */
public class ViewScheduleSingleDay extends AppCompatActivity {
    /**Refactoring Comment**/
    /**Displaying user's course schedule after registration. Retrieved courses start and end time from database
     * Using listview for display Study schedule instead of using TableRow **/
    ListView classesListView;
    ArrayList<String> classTime = new ArrayList<String>();
    String time;
    private Button returnToUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewscheduleday);

        Intent intent = getIntent();
        final String selectedDay = intent.getStringExtra("day");
        final String userID = intent.getStringExtra("userID");
        final String selectedSemester = intent.getStringExtra("semester");

        // The code of the selected day. Mon = M, Tues = T, Wed = W, Thurs = R, Fri = F
        final String selectedDayCode = getDayCode(selectedDay);

        returnToUser = (Button) findViewById(R.id.ReturnToUser);

        TextView dayTextView = (TextView) findViewById(R.id.dayTextView);
        dayTextView.setText(selectedSemester+" - "+selectedDay+"'s Classes");

        classesListView = (ListView) findViewById(R.id.classesListView);
        String directory = "users/"+userID+"/registered courses";
        DatabaseReference db = FirebaseDatabase.getInstance().getReference(directory);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    // makes sure class is in selected term
                    // 1 = summer, 2 = fall, 3 = winter
                    if (Integer.parseInt(snapshot.child("term").getValue().toString()) == getTermCode(selectedSemester)) {
                        // makes sure class is on selected day
                        if (snapshot.child("days").getValue().toString().contains(selectedDayCode)) {
                            time = snapshot.child("courseID").getValue().toString();
                            time += "\n" + snapshot.child("starttime").getValue().toString();
                            time += " - " + snapshot.child("endtime").getValue().toString();

                            classTime.add(time);
                        }
                    }
                }



                ListAdapter adapter = new ArrayAdapter<String>(ViewScheduleSingleDay.this,android.R.layout.simple_list_item_1,classTime);
                classesListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        returnToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToD = new Intent(ViewScheduleSingleDay.this, ViewSchedule.class);
                intentToD.putExtra("userID", userID);
                startActivity(intentToD);
            }


        });

    }

    /**
     * Takes in the day, returns the single character code for that day
     *
     * @param day
     * @return
     */
    public static String getDayCode(String day) {
        String returncode = "Z";
        switch(day.toLowerCase()) {
            case "monday":
                returncode = "M";
                break;
            case "tuesday":
                returncode = "T";
                break;
            case "wednesday":
                returncode = "W";
                break;
            case "thursday":
                returncode = "R";
                break;
            case "friday":
                returncode = "F";
                break;
            default:
        }
        return returncode;
    }

    public static int getTermCode(String term) {
        int returncode = -1;
        switch (term.toLowerCase()) {
            case "summer":
                returncode = 1;
                break;
            case "fall":
                returncode = 2;
                break;
            /*
            case "winter":
                returncode = 3;
                break;
             */
            default:
        }
        return returncode;
    }
}