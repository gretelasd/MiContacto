package com.gretya.mycontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    private Button btnNext;
    private EditText ediNombre;
    private EditText ediTelefono;
    private EditText ediEmail;
    private EditText ediContacto;
    private TextView ediFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dateView = (TextView) findViewById(R.id.TextView2);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        //para el Activity Datos
        btnNext = (Button) findViewById(R.id.btnNext);
        ediNombre = (EditText) findViewById(R.id.input_name);
        ediTelefono = (EditText) findViewById(R.id.input_phone);
        ediEmail = (EditText) findViewById(R.id.input_email);
        ediContacto = (EditText) findViewById(R.id.input_contact_information) ;
        ediFecha = (TextView) findViewById(R.id.TextView2);


        btnNext.setOnClickListener(this);

        //para editar los datos al dar click en el boton Editar
        Intent intentnew=getIntent();
        Bundle extras =intentnew.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre1 = (String) extras.get("nombre1");//Obtengo el nombre
            String datoTelefono1 = (String) extras.get("telefono1");//Obtengo la edad
            String datoEmail1 = (String) extras.get("email1");
            String datoFecha1 = (String) extras.get("fecha1");
            String datoContacto1 = (String) extras.get("contacto1");

            ediNombre.setText(datoNombre1);
            ediTelefono.setText(datoTelefono1);
            ediEmail.setText(datoEmail1);
            ediFecha.setText(datoFecha1);
            ediContacto.setText(datoContacto1);


        }
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    //muestra la fecha en el TextView2
    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    //Para pasar del boton Siguiente a la próxima Actividad Datos
    public void Next(View view){

        Intent intent = new Intent(MainActivity.this, Datos.class );
        //iniciar el intent
        startActivity(intent);

        finish();

    }

    @Override
    public void onClick(View v) {

        Intent intentnew = new Intent(MainActivity.this, Datos.class );
        String auxEdiNombre= ediNombre.getText().toString();
        String auxEdiPhone= ediTelefono.getText().toString();
        String auxEdiEmail= ediEmail.getText().toString();
        String auxEdiContacto= ediContacto.getText().toString();
        String auxEdiFecha= ediFecha.getText().toString();

        intentnew.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        intentnew.putExtra("telefono",auxEdiPhone);
        intentnew.putExtra("email",auxEdiEmail);
        intentnew.putExtra("contacto",auxEdiContacto);
        intentnew.putExtra("fecha",auxEdiFecha);


        //lo inicializamos pasandole la intencion, con todos sus parametros guardados
        startActivity(intentnew);



    }
}
