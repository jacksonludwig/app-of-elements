package com.example.periodictable.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;
import com.example.periodictable.utilities.JSONManipulator;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String ELEMENT_JSON_FILE = "PeriodicTableJSON.json";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Element> elements = generateElementsFromAssets();
        for (Element element : elements) {
            System.out.println(element.getName());
        }
    }

    private List<Element> generateElementsFromAssets() {
        try {
            return JSONManipulator.getListOfElements(getAssets().open(ELEMENT_JSON_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
