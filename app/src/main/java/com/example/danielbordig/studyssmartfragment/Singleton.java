package com.example.danielbordig.studyssmartfragment;

import android.app.Application;
import android.util.Log;

import com.firebase.client.Firebase;

import java.util.ArrayList;

/**
 * Created by Nicklas Jensen on 08-01-2016.
 */
public class Singleton extends Application{
    public boolean visDrawer =false;
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
            myFirebaseRef = new Firebase("https://studysmart.firebaseio.com/");
            setMessage("hej");
            // other setup code
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
