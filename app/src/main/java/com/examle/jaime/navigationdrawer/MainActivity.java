package com.examle.jaime.navigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener,
        FragmentTwo.OnFragmentInteractionListener{
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_mcaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpNavigationView();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }


    private void setUpNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                int id = item.getItemId();
                Fragment fragment = null;
                Class fragmentClass = null;

                if (id == R.id.action_home) {
                    fragmentClass = FragmentOne.class;
                } else if (id == R.id.action_sector) {
                    fragmentClass = FragmentTwo.class;
                } else if (id == R.id.action_dependency) {
                    fragmentClass = FragmentOne.class;
                } else if (id == R.id.action_config) {
                    intent = new Intent(MainActivity.this, PreferenceActivity.class);
                    startActivity(intent);
                } else if (id == R.id.action_help) {
                    fragmentClass = FragmentOne.class;
                }

                if (intent == null) {
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_content, fragment).commit();
                }

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
                mDrawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
