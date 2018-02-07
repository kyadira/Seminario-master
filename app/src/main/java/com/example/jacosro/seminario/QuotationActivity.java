package com.example.jacosro.seminario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        author = findViewById(R.id.textView_author);
        quote = findViewById(R.id.textView_quote);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quotation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_add:
                break;
            case R.id.menu_refresh:
                onClick(null);
                break;
            default:
               return false;
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        author.setText("sample author");
        quote.setText("sample quote");
    }
}
