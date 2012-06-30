package my.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;;

public class Hello_WorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText(StringFromJNI());
        setContentView(tv);
    }
   public native String  StringFromJNI();
   public native String  unimplementedStringFromJNI();
    static {
        System.loadLibrary("hello-test");
   }
}