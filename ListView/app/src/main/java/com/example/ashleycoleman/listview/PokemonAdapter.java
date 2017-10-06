package com.example.ashleycoleman.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ashleycoleman on 9/28/17.
 */

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Pokemon> dataSource;

    public PokemonAdapter(Context context, ArrayList<Pokemon> items) {
        this.context = context;
        this.dataSource = items;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = layoutInflater.inflate(R.layout.list_item_pokemon, viewGroup, false);

        Pokemon pokemon = (Pokemon)getItem(i);

        TextView title = (TextView)rowView.findViewById(R.id.titleTextView);
        title.setText(pokemon.name);

        ImageView imageView = (ImageView)rowView.findViewById(R.id.pokemonImageView);

        Picasso.with(context)
                .load(pokemon.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);

        return  rowView;

    }
}
