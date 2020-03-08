package com.example.periodictable.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.periodictable.R;
import com.example.periodictable.model.Element;

import java.util.List;

public class PeriodicTable extends AppCompatActivity {
    private static final String ELEMENTS_EXTRA_KEY = "elements";
    private static final int DEFAULT_X_POS = -300;
    private static final int DEFAULT_Y_POS = -300;

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
        return new PopupWindow(view,
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                false);
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

}
