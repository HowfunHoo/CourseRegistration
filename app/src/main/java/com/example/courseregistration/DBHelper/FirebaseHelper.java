package com.example.courseregistration.DBHelper;

import com.example.courseregistration.interfaces.CourseCallbacks;
import com.example.courseregistration.interfaces.MajorCallbacks;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-02-24.
 */

public class FirebaseHelper{

    private DatabaseReference db;
    private ArrayList<Major> majors = new ArrayList<>();
    private ArrayList<CourseInfo> courseInfos = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //Save the Major info. into db
    public Boolean saveMajor(Major major)
    {
        Boolean saved = null;
        if(major==null)
        {
            saved =false;
        }else
        {
            try
            {
                db.child("subjects").push().setValue(major);
                saved =true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved =false;
            }
        }

        return saved;
    }




    public ArrayList<Major> retrieveMajor(final MajorCallbacks majorCallbacks){

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Major major = ds.getValue(Major.class);
                    majors.add(major);
                }

                majorCallbacks.onMajorCallback(majors);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

//                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Major major = ds.getValue(Major.class);
                    majors.add(major);
                }
                majorCallbacks.onMajorCallback(majors);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        db.addChildEventListener(childEventListener);

        if (!majors.isEmpty()){
            db.removeEventListener(childEventListener);
        }

//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//                    majors.add(major);
//                }
//
//                majorCallbacks.onMajorCallback(majors);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        return majors;

    }



    public ArrayList<CourseInfo> retrieveCourse(String majorID, final CourseCallbacks courseCallbacks){

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    CourseInfo courseInfo = ds.getValue(CourseInfo.class);
                    courseInfos.add(courseInfo);
                }

                courseCallbacks.onCourseCallback(courseInfos);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

//                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    CourseInfo courseInfo = ds.getValue(CourseInfo.class);
                    courseInfos.add(courseInfo);
                }

                courseCallbacks.onCourseCallback(courseInfos);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        db.orderByChild("major_id").equalTo(majorID).addChildEventListener(childEventListener);

        if (!courseInfos.isEmpty()){
            db.removeEventListener(childEventListener);
        }


        return courseInfos;

    }


}