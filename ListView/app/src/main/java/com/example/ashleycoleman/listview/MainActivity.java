package com.example.ashleycoleman.listview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.pokemon_list_view);

        //final ArrayList<Pokemon> pokemonList = Pokemon.getPokemonFromFile("pokemon.json", this);

        //PokemonAdapter adapter = new PokemonAdapter(this, pokemonList);
        //listView.setAdapter(adapter);

        final Context context = this;

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://people.cs.ksu.edu/~ashley78/pokemon.json", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                final ArrayList<Pokemon> pokemonList = Pokemon.getPokemonFromJSON(response);
                PokemonAdapter adapter = new PokemonAdapter(context, pokemonList);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Pokemon pokemon = pokemonList.get(position);

                        Intent detailIntent = new Intent(context, PokemonDetailActivity.class);
                        detailIntent.putExtra("pokemon", pokemon);

                        startActivity(detailIntent);
                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getApplicationContext(), "Something went wrong",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
