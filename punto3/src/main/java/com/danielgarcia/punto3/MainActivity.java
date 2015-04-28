package com.danielgarcia.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText equiz = (EditText) findViewById(R.id.equiz);
        final EditText eexpo = (EditText) findViewById(R.id.eexpo);
        final EditText elab = (EditText) findViewById(R.id.elab);
        final EditText epf = (EditText) findViewById(R.id.epf);
        final TextView enota = (TextView) findViewById(R.id.enota);

        Button boton = (Button) findViewById(R.id.ebutton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float op1 = Float.parseFloat(equiz.getText().toString());
                float op2 = Float.parseFloat(eexpo.getText().toString());
                float op3 = Float.parseFloat(elab.getText().toString());
                float op4 = Float.parseFloat(epf.getText().toString());
                double rw;
                rw = (op1 * 0.15) + (op2 * 0.1) + (op3 * 0.4) + (op4 * 0.35);
                String mytext = Double.toString(rw);
                enota.setText(mytext);
            }
        });
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
