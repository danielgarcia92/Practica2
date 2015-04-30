package com.danielgarcia.punto5;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    char sex, check;
    Spinner spinner;
    TextView mytext;
    String ge;
    DateFormat formate=DateFormat.getDateInstance();
    Calendar calendar= Calendar.getInstance();

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // RadioButton
        switch (view.getId()) {
            case R.id.radio_masculino:
                if (checked) {
                    sex = '1';
                }
                break;
            case R.id.radio_femenino:
                if (checked) {
                    sex = '2';
                }
                break;
        }

    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    check = '1';
                break;
            case R.id.checkBox2:
                if (checked)
                    check = '2';
                break;
            case R.id.checkBox3:
                if (checked)
                    check = '3';
                break;
            case R.id.checkBox4:
                if (checked)
                    check = '4';
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView fecha     = (TextView) findViewById(R.id.tfecha);
        final EditText eNombre   = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo   = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tName     = (TextView) findViewById(R.id.tNombre);
        final TextView tMail     = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel      = (TextView) findViewById(R.id.tTel);
        final TextView tsex      = (TextView) findViewById(R.id.tsex);
        final TextView tcity     = (TextView) findViewById(R.id.tcity);
        final TextView tdeporte  = (TextView) findViewById(R.id.tdeporte);

        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());
                fecha.setText(formate.format(calendar.getTime()));
                ge=spinner.getSelectedItem().toString();
                tcity.setText(ge);
                if (sex=='1')
                    tsex.setText("Masculino");
                if(sex=='2')
                    tsex.setText("Femenino");
                if(check=='1')
                    tdeporte.setText("Fútbol");
                if(check=='2')
                    tdeporte.setText("Voleibol");
                if(check=='3')
                    tdeporte.setText("Natación");
                if(check=='4')
                    tdeporte.setText("Basketball");

            }
        });

        spinner = (Spinner) findViewById(R.id.spinnerf);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        }
    };

    public void setDate (View v){
        new DatePickerDialog(MainActivity.this,d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mytext = (TextView) view;
        ge= String.valueOf((TextView) view);
        Toast.makeText(this, "Seleccionaste " + mytext.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}