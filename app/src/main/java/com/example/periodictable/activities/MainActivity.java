package com.example.periodictable.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;
import com.example.periodictable.utilities.AssetLoader;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Element> elements = AssetLoader.loadElementsList("elements.dat", getApplicationContext());
    }
}
