package com.example.jacosro.seminario;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FavouriteActivity extends AppCompatActivity implements View.OnClickListener{

    static private final String URL = "http://en.wikipedia.org/wiki/Special:Search?search=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        Button author_info = findViewById(R.id.button_autor_info);
        author_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(URL + "Albert Einstein"));
        startActivity(intent);
    }
}
