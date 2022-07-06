package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity implements MainActivity2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Display(this));
    }
    @Override
    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}