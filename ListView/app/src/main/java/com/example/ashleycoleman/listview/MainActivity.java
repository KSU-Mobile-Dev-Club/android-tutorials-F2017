package com.example.ashleycoleman.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.pokemon_list_view);

        final ArrayList<Pokemon> pokemonList = Pokemon.getPokemonFromFile("pokemon.json", this);
        String[] items = new String[pokemonList.size()];

        for(int i = 0; i < pokemonList.size(); i++) {
            Pokemon p = pokemonList.get(i);

            items[i] = p.name;
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

    }
}
