package com.danielgarcia.punto5;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniel on 28/04/2015.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener {
    Context context;

    public DateSettings(Context context) {

        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context, "Fecha seleccionada: " + monthOfYear + " / " + dayOfMonth + "/" + year, Toast.LENGTH_LONG).show();
        TextView tfecha;
    }
}