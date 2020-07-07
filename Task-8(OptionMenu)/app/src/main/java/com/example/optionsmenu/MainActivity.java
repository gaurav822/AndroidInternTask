package com.example.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= (EditText) findViewById(R.id.message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.share:
                String toSend = et.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,toSend );
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;
            case R.id.dail:
                Uri u= Uri.parse("tel:9841517819");
                Intent i=new Intent(Intent.ACTION_DIAL,u);
                startActivity(i);
                break;
            case R.id.settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.Galley:
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                intent.setType("image/*");
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}