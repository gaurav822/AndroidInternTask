package com.example.contextmenuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String shops[]={"Store One", "Store two","XYZ Shop","ABC Store","Store A","Store B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,shops);
        listView.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.coupons){
            Toast.makeText(getApplicationContext(),"Coupons Selected",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.cashback){
            Toast.makeText(getApplicationContext(),"Cashback Selected", Toast.LENGTH_LONG).show();

        }
        else if(item.getItemId()==R.id.deals){
            Toast.makeText(getApplicationContext(),"Deals Selected",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}