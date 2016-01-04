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

        loginBut.setOnClickListener(this);
        loginBut.setBackgroundColor(Color.BLUE);
        loginBut.setTextColor(Color.WHITE);

        stuDAO = new StudentDAO();

        return root;
    }

    @Override
    public void onClick(View v) {
        String nameString = name.getText().toString().trim();
        String passwordString = password.getText().toString().trim();
        String login = "";
        if(nameString.isEmpty() || passwordString.isEmpty()){
            Toast.makeText(getActivity(), "Fill out all fields", Toast.LENGTH_LONG).show();
        }
        else {
            login = stuDAO.Login(nameString, passwordString);
        }
        if (login.equals("true")) {
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_hwc).commit();
        }
        else if(login.equals("trueName")){
            Toast.makeText(getActivity(), "Wrong password", Toast.LENGTH_LONG).show();
        }
        else if(login.equals("falseUser")){
            Toast.makeText(getActivity(), "Wrong username", Toast.LENGTH_LONG).show();
        }
    }

}
