package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Zohra on 10/01/2016.
 */
public class HWCfirebase extends Activity {

    private Firebase mRef;
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Button weekBut = (Button) findViewById(R.id.weekBut);
        Button allHomeworkBut = (Button) findViewById(R.id.allHomeworkBut);

        mRef = new Firebase("https://studysmart.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String newCondition = (String) dataSnapshot.getValue();
                sTextCondition.setText(newCondition);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        weekBut.setOnClickListener(new View.OnClickListener()){
            @Override
                    public void onClick(View v){
                mRef.setValues("AllWeeks");
            }
        });
        allHomeworkBut.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View v){
                mRef.setValues("AllHomeworks");
            }
        });





    }


}
