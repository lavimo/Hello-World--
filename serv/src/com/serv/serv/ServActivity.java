package com.serv.serv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServActivity extends Activity {
    /** Called when the activity is first created. */
    
	
	private boolean _isBound;
	public Serv fuck;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setTitle("HIT-43");
        initButtons();
        
		
			
		
		
        
}
	
	public void initButtons(){
		Button sB = (Button) findViewById(R.id.button1);
		final TextView view = (TextView) findViewById(R.id.textView);
		sB.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				view.setText("保护已启动！");
				startService();
			}
			
		}); 
		
		
	}
	
	private void startService(){
		Intent i = new Intent(this,Serv.class);
		this.startService(i);
	}
	
	
	
}