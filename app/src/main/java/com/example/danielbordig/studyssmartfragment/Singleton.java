package com.example.danielbordig.studyssmartfragment;

import android.app.Application;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Nicklas Jensen on 08-01-2016.
 */
public class Singleton extends Application{
    public boolean visDrawer = false;
    DrawerIF drawer;
    public static Singleton st;
    public static String user = "";
    public static String userHWC = "";
    public static String userSGM = "";

    //FireBase
    Firebase myFirebaseRef;

    @Override
    public void onCreate() {
        super.onCreate();
        st = this;
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://studysmart.firebaseio.com/CBS/Students/Information/144869/HWC");
                myFirebaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });
    }
        //setter
        public void setMessage(String message) {
            myFirebaseRef.child("message").setValue(message);
        }


         // public ArrayList getlist() {return ;}
         void startDrawer(){
    drawer.setDrawer();
}



}
