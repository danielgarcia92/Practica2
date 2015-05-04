package com.danielgarcia.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText equiz = null;
    private EditText eexpo = null;
    private EditText elab = null;
    private EditText epf = null;
    private TextView enota = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equiz = (EditText) findViewById(R.id.equiz);
        eexpo = (EditText) findViewById(R.id.eexpo);
        elab  = (EditText) findViewById(R.id.elab);
        epf   = (EditText) findViewById(R.id.epf);
        enota = (TextView) findViewById(R.id.enota);

    }

    public void calcular (View v) {
        float op1 = Float.parseFloat(equiz.getText().toString());
        float op2 = Float.parseFloat(eexpo.getText().toString());
        float op3 = Float.parseFloat(elab.getText().toString());
        float op4 = Float.parseFloat(epf.getText().toString());
        double rw;

        if (op1 > 5)
            Toast.makeText(this, getResources().getString(R.string.quizm5), Toast.LENGTH_SHORT).show();

        if (op2 > 5)
            Toast.makeText(this, getResources().getString(R.string.expom5), Toast.LENGTH_SHORT).show();

        if (op3 > 5)
            Toast.makeText(this, getResources().getString(R.string.labm5), Toast.LENGTH_SHORT).show();

        if (op4 > 5)
            Toast.makeText(this, getResources().getString(R.string.pfm5), Toast.LENGTH_SHORT).show();

        if (op1<=5 && op2<=5 && op3<=5 && op4<=5) {
            rw = (op1 * 0.15) + (op2 * 0.1) + (op3 * 0.4) + (op4 * 0.35);
            String mytext = Double.toString(rw);
            enota.setText(mytext);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("ENOTA", enota.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        enota.setText(savedInstanceState.getString("ENOTA"));
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
