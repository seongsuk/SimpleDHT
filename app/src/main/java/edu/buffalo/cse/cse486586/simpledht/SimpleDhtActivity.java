package edu.buffalo.cse.cse486586.simpledht;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SimpleDhtActivity extends Activity {

    private Uri mUri;
    private Uri buildUri(String scheme, String authority) {
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.authority(authority);
        uriBuilder.scheme(scheme);
        return uriBuilder.build();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_dht_main);
        mUri = buildUri("content", "edu.buffalo.cse.cse486586.simpledht.provider");
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setMovementMethod(new ScrollingMovementMethod());
        findViewById(R.id.button3).setOnClickListener(
                new OnTestClickListener(tv, getContentResolver()));
        findViewById(R.id.button1).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View arg0)
                    {
                        new Client().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
                        Log.v("button click","Local Dump called");
                    }

                });
        findViewById(R.id.button2).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View arg0)
                    {
                        new Clienttask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
                        Log.v("button click","Local Dump called");
                    }

                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_simple_dht_main, menu);
        return true;
    }
    public class Client extends AsyncTask<String, String, Void>
    {
        static final String REMOTE_PORT0 = "11108";
        String temp = null;
        @Override
        protected Void doInBackground(String... msgs)
        {
            String key = "@";

            Cursor resultCursor = getContentResolver().query(mUri, null,key, null, null);
            if (resultCursor == null)
            {
                Log.e("Ldump ", "Result null");
            }
            resultCursor.moveToFirst();
            while (resultCursor.isAfterLast() == false)
            {
                temp = resultCursor.getString(1);
                resultCursor.moveToNext();
                Log.v("Local dump", temp);
                publishProgress(temp);
            }
            return null;
        }
        protected void onProgressUpdate(String... strings ){
            TextView tv1 = (TextView) findViewById(R.id.textView1);
            if ( strings == null)
            {
                tv1.append("In L dump empty");
            }
            else
            {
                tv1.append("In L dump " + strings[0] + "\n ");
            }
        }
    }
    public class Clienttask extends AsyncTask<String, String, Void>
    {
        static final String REMOTE_PORT0 = "11108";
        String temp = null;
        @Override
        protected Void doInBackground(String... msgs)
        {
            String key = "*";

            Cursor resultCursor = getContentResolver().query(mUri, null,key, null, null);
            if (resultCursor == null)
            {
                Log.e("Ldump ", "Result null");
            }
            resultCursor.moveToFirst();
            while (resultCursor.isAfterLast() == false)
            {
                temp = resultCursor.getString(1);
                resultCursor.moveToNext();
                //Log.v("Local dump", temp);
                publishProgress(temp);
            }
            return null;
        }
        protected void onProgressUpdate(String... strings ){
            TextView tv1 = (TextView) findViewById(R.id.textView1);
            if ( strings[0] == null)
            {
                tv1.append("In L dump empty");
            }
            else
            {
                tv1.append("In L dump " + strings[0] + "\n ");
            }
        }
    }
}