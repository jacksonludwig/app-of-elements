package com.example.periodictable.utilities;

import android.content.Context;

import com.example.periodictable.model.Element;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public final class AssetLoader {
    private AssetLoader() {
        throw new IllegalStateException("Do not instantiate");
    }

    public static ArrayList<Element> loadElementsList(String fileName, Context context) {
        InputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.getAssets().open(fileName);
            ois = new ObjectInputStream(fis);
            return (ArrayList<Element>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
