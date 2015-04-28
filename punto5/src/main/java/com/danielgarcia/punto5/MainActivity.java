package com.danielgarcia.punto5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    char sex, check;
    Spinner spinner;
    TextView mytext;
    String ge;

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Identificar cuál RadioButton fue seleccionado
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

    public void setDate(View view) {
        PickerDialogs pickerDialogs = new PickerDialogs();
        pickerDialogs.show(getFragmentManager(), "date_picker");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, getResources().getString(R.string.tonCreate), Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tsex = (TextView) findViewById(R.id.tsex);
        final TextView tcity = (TextView) findViewById(R.id.tcity);
        final TextView tdeporte = (TextView) findViewById(R.id.tdeporte);


        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());
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
