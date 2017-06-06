package com.example.gil.omegaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin;

        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(in);
            }
        });
    }


/*    public void onClick(View v){
        Intent intent=null;
        switch(v.getId()){
            case R.id.btnLogin:
                intent = new Intent(this, ChatActivity.class);
                break;
        }
        startActivity(intent);
    }*/
}
