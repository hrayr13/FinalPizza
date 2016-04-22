package com.hrayr.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String string = intent.getStringExtra(Constants.KEY_TITLE);
        String stringDescription = intent.getStringExtra(Constants.KEY_DESCRIPTION);
        int imageId = intent.getIntExtra(Constants.KEY_IMAGE_ID, 0);
        // get from intent name by KEY_TITLE
        TextView textViewName = (TextView) findViewById(R.id.textName);
        textViewName.setText(string);

        TextView textViewDescription = (TextView) findViewById(R.id.textDescription);
        textViewDescription.setText(stringDescription);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(imageId);
    }
}
