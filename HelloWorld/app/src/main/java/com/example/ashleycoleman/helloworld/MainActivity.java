package com.example.ashleycoleman.helloworld;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf = (TextView) findViewById(R.id.message);
        tf.setText("My name is bob");

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tf.setText("You clicked me");

                Toast.makeText(getApplicationContext(), "I am a toast", Toast.LENGTH_LONG).show();

            }
        });
    }
}
