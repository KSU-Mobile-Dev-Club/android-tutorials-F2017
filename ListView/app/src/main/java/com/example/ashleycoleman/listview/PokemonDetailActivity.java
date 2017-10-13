package com.example.ashleycoleman.listview;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

public class PokemonDetailActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView pokemonImageView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        titleTextView = (TextView)findViewById(R.id.titleTextView);
        pokemonImageView = (ImageView)findViewById(R.id.pokemonImageView);
        descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);

        Pokemon pokemon = this.getIntent().getParcelableExtra("pokemon");

        titleTextView.setText(pokemon.name);

        Picasso.with(this)
                .load(pokemon.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(pokemonImageView);

        final Context context = this;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://pokeapi.co/api/v2/pokemon-species/" + Integer.toString(pokemon.id) + "/", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray arr = response.getJSONArray("flavor_text_entries");
                    for(int i = 0; i < arr.length(); i++) {
                        JSONObject jo = arr.getJSONObject(i);
                        if(jo.getJSONObject("language").getString("name").equals("en")) {
                            descriptionTextView.setText(jo.getString("flavor_text"));
                            return;
                        }
                    }
                }
                catch(JSONException e) {

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(context, "Something went wrong",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
