package com.example.periodictable.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FileInputStream fis = new FileInputStream(new File("D:\\app-of-elements\\app\\src\\main\\assets\\elements.dat"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<?> stuff = (ArrayList<?>) ois.readObject();
            System.out.println(stuff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
