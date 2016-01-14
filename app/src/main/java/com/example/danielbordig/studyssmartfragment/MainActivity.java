package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DrawerIF{

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private android.widget.ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Singleton st;
    static Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("StudySmart");
        getFragmentManager().beginTransaction().add(R.id.mainFrame, new Main_frag()).commit();
        db = new Database();
        st = Singleton.st;
        st.drawer = this;
    }
    @Override
    public void setDrawer () {
        //We're initiating the components here
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
        //Each item are being added to the slidinglist
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_hwc, "HWC"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_sgm, "SGM"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_done, "Done"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_rl, "ReadLater"));
        adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Display icon to open/ close sliding list
       // if (st.visDrawer) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //this sets the title
        setTitle(listSliding.get(0).getTitle());
        //the item selected
        listViewSliding.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Handling on item click

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position).getTitle());
                //item selected
                listViewSliding.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
                actionBarDrawerToggle.syncState();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                actionBarDrawerToggle.syncState();
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    //Create method replace fragment

    private void replaceFragment(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new HWC_frag_testing();
                break;
            case 1:
                //fragment = new Groups_Fragment(); // this will make the app crash because, Gezienna is not finished yet with the Groups activity
                break;
            case 2:
               fragment = new Done_frag();
                break;
            case 3:
                fragment = new ReadLater_frag();
                break;
        }

        if(null!=fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.mainFrame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}

