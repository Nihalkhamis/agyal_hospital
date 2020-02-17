package com.agyal.hospital;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.agyal.hospital.ui.Contact.ContactFragment;
import com.agyal.hospital.ui.Director.DirectorFragment;
import com.agyal.hospital.ui.Home.HomeFragment;
import com.agyal.hospital.ui.Info.InfoFragment;
import com.agyal.hospital.ui.Photos.PhotosFragment;
import com.agyal.hospital.ui.Sections.SectionsFragment;
import com.agyal.hospital.ui.Services.ServicesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager manager;
    InfoFragment infoFragment;
    ServicesFragment servicesFragment;
    SectionsFragment sectionsFragment;
    DirectorFragment directorFragment;
    PhotosFragment photosFragment;
    ContactFragment contactFragment;
    HomeFragment homeFragment;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);



       infoFragment = new InfoFragment();
       servicesFragment = new ServicesFragment();
       sectionsFragment = new SectionsFragment();
       directorFragment = new DirectorFragment();
       photosFragment = new PhotosFragment();
       contactFragment = new ContactFragment();
        homeFragment = new HomeFragment();

        manager = getSupportFragmentManager();


        //set home page
       // if(savedInstanceState == null || savedInstanceState.isEmpty()) {
            setHomeScreen();
        //}


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    int id = menuItem.getItemId();
                    menuItem.setChecked(true);
                    drawer.closeDrawers();

                    switch (id) {
                        case R.id.nav_info:
                                setInfoScreen();
                            break;
                        case R.id.nav_services:
                            setServicesScreen();
                            break;
                        case R.id.nav_sections:
                            setSectionsScreen();
                            break;
                        case R.id.nav_director:
                            setDirectorScreen();
                            break;
                        case R.id.nav_photos:
                            setPhotosScreen();
                            break;
                        case R.id.nav_contact:
                            setContactScreen();
                            break;
                    }
                    return false;
                }
            });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0) {
            getSupportFragmentManager().popBackStack();
        }

        else{
            super.onBackPressed();
        }
    }

    public void setHomeScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, homeFragment , "").addToBackStack("").commit();
    }

    public void setInfoScreen() {

        manager.beginTransaction().replace(R.id.nav_host_fragment, infoFragment, "info").addToBackStack("").commit();
    }

    public void setServicesScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, servicesFragment, "service").addToBackStack("").commit();
    }

    public void setSectionsScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, sectionsFragment, "").addToBackStack("").commit();
    }

    public void setDirectorScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, directorFragment, "").addToBackStack("").commit();
    }

    public void setPhotosScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, photosFragment, "").addToBackStack("").commit();
    }

    public void setContactScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, contactFragment, "").addToBackStack("").commit();
    }


    public void menu() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            drawer.openDrawer(Gravity.RIGHT);
        }
    }
}
