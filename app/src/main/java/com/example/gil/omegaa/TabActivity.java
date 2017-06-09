package com.example.gil.omegaa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TabActivity extends AppCompatActivity {

    private TextView mTextMessage;
    long lastPressed;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("Friends");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Profile");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
