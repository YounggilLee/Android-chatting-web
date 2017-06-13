package com.example.gil.omegaa;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

//import android.app.FragmentTransaction;

public class TabActivity extends AppCompatActivity {


    long lastPressed;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                     fragment = new HomeFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                     fragment = new FriendsFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                     fragment = new ProfileFragment();
                    switchFragment(fragment);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

       // FragmentManager fragmentManager = getFragmentManager();
         fragmentManager = getSupportFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();

        HomeFragment fragment = new HomeFragment();
        fragmentTransaction.add(R.id.content, fragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    public void switchFragment(Fragment fragment){
        // Create new fragment and transaction

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
        fragmentTransaction.replace(R.id.content, fragment);


// Commit the transaction
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() -lastPressed < 1500){
            finish();
        }else{
            Toast.makeText(this, "If you push the button, closeing the page", Toast.LENGTH_SHORT).show();
            lastPressed = System.currentTimeMillis();
        }

    }
}
