package com.example.user.myproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class AddProjectActivity extends AppCompatActivity {

    ImageView ivPicture;
    DataGenerator generator = new DataGenerator();
    String picture = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddProjectActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        ivPicture = findViewById(R.id.ivPicture);
        loadImage();
        ivPicture.setOnClickListener(view -> loadImage());
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
            TextInputLayout tilName = findViewById(R.id.tilTheme);
            String theme = tilName.getEditText().getText().toString();
            EditText tillN = findViewById(R.id.etDescription);
            String Description = tillN.getText().toString();
            EditText till = findViewById(R.id.etActions);
            String Action = till.getText().toString();
            Project project = new Project(picture, theme, Description, Action);
            AppDatabase.getInstance(this).projectDao().insertProject(project);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage() {
        picture = generator.getPicture();
        Picasso.get().load(picture)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(ivPicture);
    }
}
