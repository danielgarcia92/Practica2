package com.danielgarcia.punto4;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    char mcuadro = '0', mtriangulo = '0', mrectangulo = '0', mcirculo = '0';
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        // Identificar cuál RadioButton fue seleccionado
        switch (view.getId()) {
            case R.id.radio_cuadro:
                if (checked) {
                    mcuadro =     '1';
                    mtriangulo =  '0';
                    mrectangulo = '0';
                    mcirculo =    '0';
                }
                break;
            case R.id.radio_triangulo:
                if (checked) {
                    mcuadro =     '0';
                    mtriangulo =  '1';
                    mrectangulo = '0';
                    mcirculo =    '0';
                }
                break;
            case R.id.radio_rectangulo:
                if (checked) {
                    mcuadro =     '0';
                    mtriangulo =  '0';
                    mrectangulo = '1';
                    mcirculo =    '0';
                }
                break;
            case R.id.radio_circulo:
                if (checked) {
                    mcuadro =     '0';
                    mtriangulo =  '0';
                    mrectangulo = '0';
                    mcirculo =    '1';
                }
                break;
        }

    }

    public void calcular(View view) {
        final EditText elado = (EditText) findViewById(R.id.eladocu);
        final EditText ebase = (EditText) findViewById(R.id.ebase);
        final EditText ealtura = (EditText) findViewById(R.id.ealtura);
        final EditText eradio = (EditText) findViewById(R.id.eradio);
        final EditText tresultado = (EditText) findViewById(R.id.tresultado);

        if (mcuadro == '1') {
            if (elado.getText().toString().trim().length() == 0)
                Toast.makeText(this, getResources().getString(R.string.emptycuadro), Toast.LENGTH_SHORT).show();
            else {
                float op1 = Float.parseFloat(elado.getText().toString());
                float rw;
                rw = op1 * op1;
                String mytext = Float.toString(rw);
                tresultado.setText(mytext);
            }
        }

        if (mtriangulo == '1') {
            if (ebase.getText().toString().trim().length() == 0)
                Toast.makeText(this, getResources().getString(R.string.emptytriangulobase), Toast.LENGTH_SHORT).show();
            else
                if (ealtura.getText().toString().trim().length() == 0)
                    Toast.makeText(this, getResources().getString(R.string.emptytrianguloaltura), Toast.LENGTH_SHORT).show();
            else {
                float op1 = Float.parseFloat(ebase.getText().toString());
                float op2 = Float.parseFloat(ealtura.getText().toString());
                float rw;
                rw = op1*op2/2;
                String mytext=Float.toString(rw);
                tresultado.setText(mytext);
            }
        }

        if (mrectangulo == '1'){
            if (ebase.getText().toString().trim().length() == 0)
                Toast.makeText(this, getResources().getString(R.string.emptyrectangulobase), Toast.LENGTH_SHORT).show();
            else if (ealtura.getText().toString().trim().length() == 0)
                Toast.makeText(this, getResources().getString(R.string.emptyrectanguloaltura), Toast.LENGTH_SHORT).show();
            else {
                float op1 = Float.parseFloat(ebase.getText().toString());
                float op2 = Float.parseFloat(ealtura.getText().toString());
                float rw;
                rw = op1*op2;
                String mytext=Float.toString(rw);
                tresultado.setText(mytext);
            }
        }

        if (mcirculo == '1') {
            if (eradio.getText().toString().trim().length() == 0)
                Toast.makeText(this, getResources().getString(R.string.emptycirculo), Toast.LENGTH_SHORT).show();
            else {
                float op1 = Float.parseFloat(eradio.getText().toString());
                double rw;
                rw = (Math.PI)*Math.pow(op1,2);
                String mytext=Double.toString(rw);
                tresultado.setText(mytext);
            }
        }
    }


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
}
