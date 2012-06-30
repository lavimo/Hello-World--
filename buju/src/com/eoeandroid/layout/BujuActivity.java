package com.eoeandroid.layout;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class BujuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        LinearLayout layoutmain = new LinearLayout(this);
        layoutmain.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(layoutmain);
        LayoutInflater inflate =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout layoutLeft = (RelativeLayout) inflate.inflate(
				R.layout.left, null);
		RelativeLayout layoutRight = (RelativeLayout) inflate.inflate(
				R.layout.right, null);

		RelativeLayout.LayoutParams relParam = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutmain.addView(layoutLeft, 100, 100);
		layoutmain.addView(layoutRight, relParam);
    }
}