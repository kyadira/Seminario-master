package com.example.jacosro.seminario;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jacosro.seminario.adapter.QuoteAdapter;
import com.example.jacosro.seminario.quote.Quotation;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity implements View.OnClickListener{

    List<Quotation> quotations;
    QuoteAdapter adapter;

    static private final String URL = "http://en.wikipedia.org/wiki/Special:Search?search=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        //Button author_info = findViewById(R.id.button_autor_info);
        //author_info.setOnClickListener(this);

        quotations = getMockQuotations();
        adapter = new QuoteAdapter(this, R.layout.quotation_list_row, quotations);

        final ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Quotation quotation = (Quotation) parent.getItemAtPosition(position);

                if (quotation.getAuthor() == null) {
                    Toast.makeText(FavouriteActivity.this, "No es posible obtener la información", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(URL + quotation.getAuthor()));
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FavouriteActivity.this);
                builder.setTitle(R.string.dialog_title);
                builder.setMessage(R.string.dialog_message);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Quotation item = (Quotation) parent.getItemAtPosition(position);
                        quotations.remove(item);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favourite_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_clear:
                AlertDialog.Builder builder = new AlertDialog.Builder(FavouriteActivity.this);
                builder.setTitle(R.string.dialog_title);
                builder.setMessage(R.string.dialog_message_clear);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.clear();
                    }
                });
                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                break;
            default:
                return false;
        }

        return true;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(URL + "Albert Einstein"));
        startActivity(intent);
    }

    public List<Quotation> getMockQuotations() {
        List<Quotation> res = new ArrayList<>(10);

        for(int i = 0, j = 10; i < 10 ; i++, j++) {
            Quotation quotation = new Quotation(String.valueOf(j), String.valueOf(i));
            res.add(quotation);
        }

        return res;
    }
}
