package com.example.sara.sw_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText email;
    EditText password;
    private  static Button b;
    public  void buttonlogin(View view)
    {
        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        HashMap<String, String> params = new HashMap<String, String>();
       // params.put("url","http://locationbased-locationbased.rhcloud.com/FCISquare/rest/login"); //not complete
        String e=email.getText().toString();
        String p=password.getText().toString();
        params.put("email", e);
        params.put("password", p);
        Log.i("info","sara");
        Connection conn = new Connection(params, new ConnectionPostListener() {
            @Override
            public void doSomething(String result) {
                try {
                    JSONObject reader = new JSONObject(result);
                    tv.setText(reader.getString("name"));
                    //Log.i("info", "lyla");
                } catch (JSONException e) {
                 //   Log.i("info", "sami");
                    e.printStackTrace();
                }

            }
        });
        Log.i("info", "123");
        conn.execute("http://locationbased-locationbased.rhcloud.com/FCISquare/rest/login");
        Log.i("info", "4579");


    }


    public void login() {
         b = (Button) findViewById(R.id.button);
        b.setOnClickListener(
              new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Log.i("info", "Taghreed");
                      Intent intent=new Intent("com.example.sara.sw_project.Home");
                      startActivity(intent);
                  }
              }
      );
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv=(TextView)findViewById(R.id.textView);
      //  buttonlogin(tv);
            login();


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
