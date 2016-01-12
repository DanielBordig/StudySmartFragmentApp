package com.example.danielbordig.studyssmartfragment;

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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Login_frag extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    ImageView logoStudySmart;
    TextView header;
    EditText name, password;
    Button loginBut;
    StudentDAO stuDAO;
    Fragment fragment_hwc = new HWC_frag();
    Fragment fragment_welcome = new Welcome_frag();

    public Login_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FireBase
        Firebase myFirebaseRef;

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
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

        // gør vores login hugtigere, skal slettes senere
        name.setText("q");
        password.setText("q");

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
        String login = "";

        Firebase LoginFirebase = new Firebase("https://studysmart.firebaseio.com/CBS/Logins/");
        LoginFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(nameString.isEmpty() || passwordString.isEmpty()){
                    Toast.makeText(getActivity(), "Fill out all fields", Toast.LENGTH_LONG).show();
                }
                else if((snapshot.child("Userid/" + nameString).getValue() == null)){
                    Toast.makeText(getActivity(), "User doesn't exist", Toast.LENGTH_LONG).show();
                }
                else if(!(snapshot.child("Password/" + nameString + "/Kodeord").getValue().equals(passwordString))){
                    Toast.makeText(getActivity(), "Wrong Password", Toast.LENGTH_LONG).show();
                }
                else if(snapshot.child("Userid/" + nameString + "/Active").getValue().equals("Yes") && snapshot.child("Password/" + nameString + "/Kodeord").getValue().equals(passwordString)) {
                        getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_hwc).commit();
                    } else {
                        Toast.makeText(getActivity(), "Username and/or Password is wrong", Toast.LENGTH_LONG).show();
                    }
                }



            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        /*
        if(nameString.isEmpty() || passwordString.isEmpty()){
            Toast.makeText(getActivity(), "Fill out all fields", Toast.LENGTH_LONG).show();
        }
        else {
            login = stuDAO.Login(nameString, passwordString);
        }
        if(snapshot.child("Active").getValue().equals("Yes") && snapshot.child("Kodeord").getValue().equals(Kodeord)) {
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_hwc).commit();
        }
        else if(login.equals("trueName")){
            Toast.makeText(getActivity(), "Wrong password", Toast.LENGTH_LONG).show();
        }
        else if(login.equals("falseUser")){
            Toast.makeText(getActivity(), "Wrong username", Toast.LENGTH_LONG).show();
        }
        */
    }

}
