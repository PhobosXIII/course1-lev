package com.example.user.myproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class AddProjectActivity extends AppCompatActivity {

    DataGenerator generator = new DataGenerator();
    String picture = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddProjectActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        ImageView ivPicture = findViewById(R.id.ivPicture);
        loadImage(ivPicture);
        ivPicture.setOnClickListener(view -> loadImage(ivPicture));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_project, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            // TODO: 16.11.2018 save project
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage(ImageView view) {
        picture = generator.getPicture();
        Picasso.get().load(picture)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(view);
    }
}
