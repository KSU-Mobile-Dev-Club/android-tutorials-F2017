package com.example.ashleycoleman.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.pokemon_list_view);

        final ArrayList<Pokemon> pokemonList = Pokemon.getPokemonFromFile("pokemon.json", this);

        PokemonAdapter adapter = new PokemonAdapter(this, pokemonList);
        listView.setAdapter(adapter);

        final Context context = this;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Pokemon pokemon = pokemonList.get(position);
                Toast.makeText(context, pokemon.name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
