package com.example.jacosro.seminario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button get = findViewById(R.id.get);
        Button favourite = findViewById(R.id.favourite);
        Button settings = findViewById(R.id.settings);
        Button about = findViewById(R.id.about);

        get.setOnClickListener(this);
        favourite.setOnClickListener(this);
        settings.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.get:
                Intent intent4 = new Intent(this, QuotationActivity.class);
                startActivity(intent4);
                break;
            case R.id.favourite:
                Intent intent3 = new Intent(this, FavouriteActivity.class);
                startActivity(intent3);
                break;
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
