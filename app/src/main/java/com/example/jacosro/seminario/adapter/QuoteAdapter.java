package com.example.jacosro.seminario.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jacosro.seminario.R;
import com.example.jacosro.seminario.quote.Quotation;

import java.util.List;

/**
 * Created by kallileo on 07/02/2018.
 */

public class QuoteAdapter extends ArrayAdapter<Quotation> {
    List<Quotation> list ;
    Context context;

    public QuoteAdapter(@NonNull Context context, int resource, List<Quotation> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.quotation_list_row,null);
        }

        Quotation item = list.get(posicion);
        TextView quote = convertView.findViewById(R.id.quote);
        quote.setText(item.getText());
        TextView author = convertView.findViewById(R.id.author);
        author.setText(item.getAuthor());

        return convertView;
    }
}
