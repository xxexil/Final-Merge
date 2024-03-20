package com.example.visualgurubooker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.example.visualgurubooker.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    ActivityMainBinding binding;

    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Makes HomeFragment the main layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.frame_out, homeFragment);
        fragmentTransaction.commit();

        // Use view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        binding.NavImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //custom icon
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);

        //navigation side drawer
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                repFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.nav_msg) {
                repFragment(new MessagesFragment());
            }else if (item.getItemId() == R.id.nav_contacts) {
                repFragment(new ContactFragment());
            }
            drawerLayout.closeDrawer(GravityCompat.START); // Close drawer after selection
            return true;
        });

        //bottom
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                repFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.message) {
                repFragment(new MessagesFragment());
            }
            return true;
        });
    }

    public void openMainActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.googlemap) {
            Intent i = new Intent(this, googlemap.class);
            startActivity(i);
        } else if (view.getId() == R.id.spotify) {
            Intent i = new Intent(this, spotify.class);
            startActivity(i);
        } else if (view.getId() == R.id.twitter) {
            Intent i = new Intent(this, twitter.class);
            startActivity(i);
        }else if (view.getId() == R.id.facebook) {
            Intent i = new Intent(this, facebook.class);
            startActivity(i);
        }
    }
    private void repFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out,fragment);
        fragmentTransaction.commit();

    }

}