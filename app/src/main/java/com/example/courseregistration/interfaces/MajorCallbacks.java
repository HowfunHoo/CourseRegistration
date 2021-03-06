package com.example.courseregistration.interfaces;

import com.example.courseregistration.models.Major;

import java.util.ArrayList;

/**
 * An interface callbacks the results returned by Firebase db
 *
 * @author Haofan & Qunzhi
 */
public interface MajorCallbacks {
    void onMajorCallback(ArrayList<Major> majors);
}
