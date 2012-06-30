package com.serv.serv;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Service;
import android.content.*;
import android.util.*;
import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Serv extends Service{

	private static final String TAG = "hit-43";
	private java.lang.Process process;
	
	@Override
	public IBinder onBind(Intent i) {
		// TODO Auto-generated method stub
		Log.e(TAG, "================>onBind");
		return null;
	}
	
	public class LocalBinder extends Binder{
		Serv getService(){
			return Serv.this;
		}
	}
	
	public boolean onUnbind(Intent i){
		Log.e(TAG, "=================>onUnbind");
		return false;
	}
	
	public void onRebind(Intent i){
		Log.e(TAG, "=================>reBind");
	}
	
	public void onCreate(){
		Log.e(TAG, "=================>onCreate");
		//在这儿还是别的地方开始加东西。
		Toast.makeText(this,"我看到了！", Toast.LENGTH_SHORT).show();
		obj.postDelayed(mTasks, 156000);
		
		//
	}
	
	public void onStart(Intent intent,int startId){
		Log.e(TAG, "=================>onStart");
		
	}
	
	public void onDestroy(){
		Log.e(TAG, "=================>onDestroy");
	}
	
	private Handler obj = new Handler();
	
	private int count = 0;
	
	private Runnable mTasks = new Runnable(){
		public void run(){
			getlog();
			Log.i(TAG, "==============>new thread started")	;
			obj.postDelayed(mTasks, 156000);
		}
	};
	
	
	
	public void getlog(){
		try{
			ArrayList<String> cmdLine = new ArrayList<String>();
			cmdLine.add("logcat");
			cmdLine.add("-d");
			
			
			ArrayList<String> clearLog=new ArrayList<String>();  //设置命令  logcat -c 清除日志
            clearLog.add("logcat");
            clearLog.add("-c");
            
            Process process=Runtime.getRuntime().exec(cmdLine.toArray(new String[cmdLine.size()]));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream())); 
            String str=null;
            while((str=bufferedReader.readLine())!=null)    //开始读取日志，每次读取一行
            {
                Runtime.getRuntime().exec(clearLog.toArray(new String[clearLog.size()]));  //清理日志....这里至关重要，不清理的话，任何操作都将产生新的日志，代码进入死循环，直到bufferreader满
                System.out.println(str);    //输出，在logcat中查看效果，也可以是其他操作，比如发送给服务器..
                
                //在这里是添加将 ｓｔｒ（也就是ｌｏｇ中的一条） 加到了 ａｒ（数组） 里面
                //问题就是打出来的我不会看
                Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
            }
            if(str==null)
            {
                System.out.println("--   is null   --");
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
