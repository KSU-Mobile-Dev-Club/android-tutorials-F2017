package com.example.ashleycoleman.listview;

/**
 * Created by ashleycoleman on 9/21/17.
 */

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Pokemon {

    public String name;
    public int id;
    public String imageUrl;

    public static ArrayList<Pokemon> getPokemonFromFile(String filename, Context context){
        final ArrayList<Pokemon> pokemonList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray pokemon = json.getJSONArray("results");

            // Get Recipe objects from data
            for(int i = 0; i < pokemon.length(); i++){
                Pokemon p = new Pokemon();

                p.name = pokemon.getJSONObject(i).getString("name");
                p.imageUrl = pokemon.getJSONObject(i).getString("image_url");
                p.id = pokemon.getJSONObject(i).getInt("id");

                pokemonList.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
