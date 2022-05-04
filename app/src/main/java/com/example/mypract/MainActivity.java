package com.example.mypract;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, WeatherAppActivity.class);
                startActivity(a);
                //Toast.makeText(MainActivity.this, "Okay now", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btnLogin:
//                //Intent a = new Intent(this, LoginActivity.class);
//                //startActivity(a);
//                Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.loginMenuItem:
                intent = new Intent(this, LoginActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }
}