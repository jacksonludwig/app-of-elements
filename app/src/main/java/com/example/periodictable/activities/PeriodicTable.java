package com.example.periodictable.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;

import java.util.List;

public class PeriodicTable extends AppCompatActivity {
    private static final String ELEMENTS_EXTRA_KEY = "elements";
    private static final int DEFAULT_X_POS = -300;
    private static final int DEFAULT_Y_POS = -300;

    private int height = 400;
    private int width = 1100;

    private List<Element> elements;

    private PopupWindow popupWindow;
    private int popUpPosX;
    private int popUpPosY;
    private boolean isPopupOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forceLandscapeMode();
        setContentView(R.layout.activity_periodic_table);

        elements = getElementsFromMain();
        isPopupOpen = false;
        setScreenSize();
    }

    private void setScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = (int) (displayMetrics.widthPixels * .7);
        height = (int) (displayMetrics.heightPixels * .4);
    }

    @SuppressLint("SourceLockedOrientationActivity")
    private void forceLandscapeMode() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    private List<Element> getElementsFromMain() {
        Intent intent = getIntent();
        return (List<Element>) intent.getSerializableExtra(ELEMENTS_EXTRA_KEY);
    }

    private PopupWindow createPopupWindow(View view) {
        PopupWindow popupWindow = new PopupWindow(view,
                width,
                height,
                false);

        return popupWindow;
    }

    public void openInfoMenu(View view) {
        if (!isPopupOpen) {
            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View customView = inflater.inflate(R.layout.popup_layout, null);

            popupWindow = createPopupWindow(customView);

            popUpPosX = DEFAULT_X_POS;
            popUpPosY = DEFAULT_Y_POS;
            ImageButton closeButton = customView.findViewById(R.id.close_popup_button);
            popupWindow.showAtLocation(view, Gravity.CENTER, popUpPosX, popUpPosY);
            isPopupOpen = true;
            setCloseable(closeButton, popupWindow);
            setDraggable(customView);
            setAttributes(view, customView);
        }
    }

    private void setCloseable(ImageButton closeButton, PopupWindow popupWindow) {
        closeButton.setOnClickListener(onClick -> {
            popupWindow.dismiss();
            isPopupOpen = false;
        });
    }

    private void setDraggable(View customView) {
        customView.setOnTouchListener(new View.OnTouchListener() {
            int dx = 0;
            int dy = 0;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = (int) event.getX();
                        dy = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        popUpPosX = (int) event.getRawX();
                        popUpPosY = (int) event.getRawY();
                        int sides = (popUpPosX - dx);
                        int topBot = (popUpPosY - dy);
                        popupWindow.update(sides, topBot, -1, -1, true);
                        break;
                }
                return true;
            }
        });
    }

    private void setAttributes(View clickedView, View popupView) {
        setElementSymbolText(clickedView, popupView);
        setElementSymbolBackground(clickedView, popupView);
        setElementStats(clickedView, popupView);
    }

    private void setElementSymbolText(View clickedView, View popupView) {
        TextView clickedText = findViewById(clickedView.getId());
        TextView popupText = popupView.findViewById(R.id.popup_element_text);
        popupText.setText(clickedText.getText());
    }

    private void setElementSymbolBackground(View clickedView, View popupView) {
        TextView clickedText = findViewById(clickedView.getId());
        TextView popupText = popupView.findViewById(R.id.popup_element_text);
        popupText.setBackground(clickedText.getBackground());
    }

    private void setElementStats(View clickedView, View popupView) {
        TextView clickedText = findViewById(clickedView.getId());
        String elementNumber = ((String) clickedText.getText()).replaceAll("\\D+", "");
        Element element = elements.get(Integer.parseInt(elementNumber) - 1);

        TextView elementName = popupView.findViewById(R.id.popup_element_name);
        elementName.setText(element.getName());
        TextView elementMass = popupView.findViewById(R.id.popup_element_mass);
        elementMass.setText(String.valueOf(element.getAtomicMass()));
        TextView elementCategory = popupView.findViewById(R.id.popup_element_category);
        elementCategory.setText(element.getCategory());
        TextView elementColumn = popupView.findViewById(R.id.popup_element_column);
        elementColumn.setText(String.valueOf(element.getXpos()));
        TextView elementProtons = popupView.findViewById(R.id.popup_element_protons);
        elementProtons.setText(String.valueOf(element.getNumber()));
    }

}
