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
    //I aktivitet/frag Singleton st = Singleton.st;

    public void l(String object){
        Log.d("Test", object);
    }

    //FireBase

    Firebase myFirebaseRef;

    @Override
    public void onCreate() {
        super.onCreate();
        st = this;
        l("singleton oncreate");
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://studysmart.firebaseio.com/CBS/Students/Information/144869/HWC/Date");

        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
            //System.out.println("singleton 1: " + snapshot.getKey());
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
