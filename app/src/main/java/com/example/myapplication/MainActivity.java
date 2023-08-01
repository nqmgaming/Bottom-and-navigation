package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.MessengerFragment;
import com.example.myapplication.Fragment.ProfileFragment;
import com.example.myapplication.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentContainerView fragmentContainerView;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationView = findViewById(R.id.navigationView);
        HomeFragment homeFragment = new HomeFragment();
        SettingFragment settingFragment = new SettingFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        MessengerFragment messengerFragment = new MessengerFragment();
        replaceFragment(homeFragment);

        //set notification icon for chat
        bottomNavigationView.getOrCreateBadge(R.id.nav_messenger).setNumber(10);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_nav) {
                    drawerLayout.openDrawer(GravityCompat.START);
                } else if (id == R.id.nav_home) {
                    replaceFragment(homeFragment);
                } else if (id == R.id.nav_setting) {
                    replaceFragment(settingFragment);
                } else if (id == R.id.nav_messenger) {
                    replaceFragment(messengerFragment);
                } else if (id == R.id.nav_profile) {
                    replaceFragment(profileFragment);
                }
                return true;
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_help) {
                    Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_share) {
                    Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.nav_rate) {
                    Toast.makeText(MainActivity.this, "Rate", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.nav_about) {
                    Toast.makeText(MainActivity.this, "Info", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    //fragment container view funtion
    public void replaceFragment(Fragment fragment) {
        //replace fragmnet vào fragment container view
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();

    }
}