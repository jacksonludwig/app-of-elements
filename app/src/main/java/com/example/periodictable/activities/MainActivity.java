package com.example.periodictable.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;
import com.example.periodictable.utilities.JSONManipulator;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String ELEMENT_JSON_FILE = "PeriodicTableJSON.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private List<Element> generateElementsFromAssets() {
        try {
            return JSONManipulator.getListOfElements(openStreamFromAssets());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private InputStream openStreamFromAssets() throws IOException {
        return getAssets().open(ELEMENT_JSON_FILE);
    }

    public void openElementSearch(View view) {
        Intent intent = new Intent(getApplicationContext(), ElementSearchActivity.class);
        intent.putExtra("elements", (Serializable) generateElementsFromAssets());
        startActivity(intent);
    }
}
