package com.example.periodictable.activities;

import android.content.Intent;
import android.os.Bundle;

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
    private static final String ELEMENTS_EXTRA_KEY = "elements";

    private List<Element> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elements = generateElementsFromAssets();
        waitToShowWelcomeScreenThenStart();
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

    private void waitToShowWelcomeScreenThenStart() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            openNewViewAndSendElementsList();
        });
        thread.start();
    }

    private InputStream openStreamFromAssets() throws IOException {
        return getAssets().open(ELEMENT_JSON_FILE);
    }

    private void openNewViewAndSendElementsList() {
        Intent intent = new Intent(getApplicationContext(), PeriodicTable.class);
        intent.putExtra(ELEMENTS_EXTRA_KEY, (Serializable) elements);
        startActivity(intent);
    }
}
