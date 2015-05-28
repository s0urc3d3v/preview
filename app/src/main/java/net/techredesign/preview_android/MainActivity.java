package net.techredesign.preview_android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    int[] stack = new int[512];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void pop(View view){
        EditText pos = (EditText) findViewById(R.id.placeText);
        boolean isSucess = pop(Integer.valueOf(pos.getText().toString()))
                ;
        if (isSucess){
            Toast.makeText(getApplicationContext(), "SUCCESS ", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_LONG).show();
            Log.wtf("FAIL", "pop");
        }



    }
    public void add(View view){
        EditText t = (EditText) findViewById(R.id.valuetext);
        EditText t2 = (EditText) findViewById(R.id.placeText);
        int var = Integer.valueOf(t.getText().toString())
                ;
        int place = Integer.valueOf(t2.getText().toString())
                ;



        boolean isSucess = add_stack(place, var);
        if (isSucess){
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_LONG).
                    show();
            Log.wtf("FAIL", "In regards to stack add");


        }

    }
    public void mod(View view){

        /**
         * For future
         * stack modification that is more complex
         * There will also be a specific function for
         * customization for developers
         */


    }
    public boolean add_stack(int place, int value){
        stack[place] = value;
        if (value == stack[place]){
            return  true;
        }
        else{
            return false;
        }
    }


    public boolean pop(int pos){
        stack[pos] = 0;
        if (stack[pos] != 0){
            return false;
        }
        else {
            return true;

        }
    }
}
