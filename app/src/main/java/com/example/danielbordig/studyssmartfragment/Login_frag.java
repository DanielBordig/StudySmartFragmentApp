package com.example.danielbordig.studyssmartfragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Login_frag extends Fragment implements View.OnClickListener, Runnable {

    public static Database db;
    ImageView logoStudySmart;
    TextView header;
    EditText name, password;
    Button loginBut;
    StudentDAO stuDAO;
    Handler handler = new Handler();
    ProgressDialog progressDialog;

    public Login_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        logoStudySmart = (ImageView) root.findViewById(R.id.logoStudySmartLogin);
        header = (TextView) root.findViewById(R.id.headerLogin);
        name = (EditText) root.findViewById(R.id.nameText);
        password = (EditText) root.findViewById(R.id.passwordText);
        loginBut = (Button) root.findViewById(R.id.loginBut);

        name.setHint("Userame");
        password.setHint("Password");
        progressDialog = new ProgressDialog(getActivity());

        // gør vores login hugtigere, skal slettes senere
        name.setText("");
        password.setText("qwert14853");

        loginBut.setOnClickListener(this);
        loginBut.setBackgroundColor(Color.BLUE);
        loginBut.setTextColor(Color.WHITE);

        stuDAO = new StudentDAO();

        return root;
    }

    @Override
    public void onClick(View v) {

        final String nameString = name.getText().toString().trim();
        final String passwordString = password.getText().toString().trim();

        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loggin in");
        progressDialog.setMessage("Processing");
        progressDialog.show();

        Firebase LoginFirebase = new Firebase("https://studysmart.firebaseio.com/CBS/Logins/");
        LoginFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(nameString.isEmpty() || passwordString.isEmpty()){
                    Toast.makeText(getActivity(), "Fill out both fields", Toast.LENGTH_LONG).show();
                }
                else if((snapshot.child("Userid/" + nameString).getValue() == null)){
                    Toast.makeText(getActivity(), "User doesn't exist", Toast.LENGTH_LONG).show();
                }
                else if(!(snapshot.child("Password/" + nameString + "/Kodeord").getValue().equals(passwordString))){
                    Toast.makeText(getActivity(), "Wrong Password", Toast.LENGTH_LONG).show();
                }
                else if(snapshot.child("Userid/" + nameString + "/Active").getValue().equals("Yes") && snapshot.child("Password/" + nameString + "/Kodeord").getValue().equals(passwordString)) {
                    Singleton.userHWC = "CBS/Students/Information/"+nameString+"/HWC";
                    Singleton.userSGM = "CBS/Students/Information/"+nameString+"/SGM";
                    db = new Database();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getFragmentManager().beginTransaction().replace(R.id.mainFrame, new HWC_frag()).commit();
                            MainActivity.stayLoggedIn = true;
                            progressDialog.dismiss();
                        }
                    }, 2000);

                    }
                }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    @Override
    public void run() {

    }
}
