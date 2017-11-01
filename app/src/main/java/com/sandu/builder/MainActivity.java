package com.sandu.builder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onShowClick(View view){
        new CommonPopupWindow.Builder(this).
                setView(R.layout.popup_item)
                .setWindowAlpha(1.0F)
                .setOutsideTouchable(true)
                .setAnimationStyle(R.style.AnimDown)
                .setWidthAndHeight(500, 500)
                .create()
                .showAsDropDown(view);
    }
}
