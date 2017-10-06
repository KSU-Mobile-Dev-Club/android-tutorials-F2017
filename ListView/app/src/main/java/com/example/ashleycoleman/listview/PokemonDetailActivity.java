package com.example.ashleycoleman.listview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PokemonDetailActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView pokemonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        titleTextView = (TextView)findViewById(R.id.titleTextView);
        pokemonImageView = (ImageView)findViewById(R.id.pokemonImageView);

        Pokemon pokemon = this.getIntent().getParcelableExtra("pokemon");

        titleTextView.setText(pokemon.name);

        Picasso.with(this)
                .load(pokemon.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(pokemonImageView);
    }
}
