package com.example.jacosro.seminario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity implements View.OnClickListener{
    TextView author ,quote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);
        ImageButton refresh =  findViewById(R.id.refresh);
        author = findViewById(R.id.textView_author);
        quote = findViewById(R.id.textView_quote);
        refresh.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        author.setText("sample author");
        quote.setText("sample quote");
    }
}
