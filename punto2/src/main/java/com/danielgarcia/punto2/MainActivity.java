package com.danielgarcia.punto2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView tresultado;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        final EditText edig1 = (EditText) findViewById(R.id.edig1);
        final EditText edig2 = (EditText) findViewById(R.id.edig2);
        tresultado = (TextView) findViewById(R.id.tresultado);
        Button boton = (Button) findViewById(R.id.ecalcul);
        String mytext = null;

        // Identificar cuál RadioButton fue seleccionado
        switch(view.getId()) {
            case R.id.radio_suma:
                if (checked){
                    float op1 = Float.parseFloat(edig1.getText().toString());
                    float op2 = Float.parseFloat(edig2.getText().toString());
                    float rw;
                    rw = op1 + op2;
                    mytext=Float.toString(rw);
                    //tresultado.setText(mytext);
                }
                break;
            case R.id.radio_resta:
                if (checked){
                    float op1 = Float.parseFloat(edig1.getText().toString());
                    float op2 = Float.parseFloat(edig2.getText().toString());
                    float rw;
                    rw = op1 - op2;
                    //System.out.println(rw);
                    mytext=Float.toString(rw);
                    //tresultado.setText(mytext);
                }
                break;
            case R.id.radio_multi:
                if (checked){
                    float op1 = Float.parseFloat(edig1.getText().toString());
                    float op2 = Float.parseFloat(edig2.getText().toString());
                    float rw;
                    rw = op1 * op2;
                    //System.out.println(rw);
                    mytext=Float.toString(rw);
                    //tresultado.setText(mytext);
                }
                break;
            case R.id.radio_divi:
                if (checked){
                    float op1 = Float.parseFloat(edig1.getText().toString());
                    float op2 = Float.parseFloat(edig2.getText().toString());
                    float rw;
                    rw = op1 / op2;
                    mytext=Float.toString(rw);
                    //tresultado.setText(mytext);
                }
                break;
        }
        final String finalMytext = mytext;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tresultado.setText(finalMytext);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("TRESULTADO", tresultado.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        tresultado.setText(savedInstanceState.getString("TRESULTADO"));
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
