package com.gretya.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Datos extends AppCompatActivity implements View.OnClickListener {


    TextView etiNombre, etiTelefono,  etiEmail, etiFecha, etiContacto;
    private Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        etiNombre = (TextView) findViewById( R.id.eti_layout_name);
        etiTelefono = (TextView) findViewById( R.id.eti_layout_phone );
        etiEmail = (TextView) findViewById( R.id.eti_layout_email);
        etiFecha = (TextView) findViewById( R.id.eti_layout_fecha);
        etiContacto = (TextView) findViewById( R.id.eti_layout_contacto );

        btnEditar = (Button) findViewById(R.id.btnEditar);

        Intent intentnew1=getIntent();
        Bundle extras =intentnew1.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre = (String) extras.get("nombre");//Obtengo el nombre
            String datoTelefono = (String) extras.get("telefono");//Obtengo la edad
            String datoEmail = (String) extras.get("email");
            String datoFecha = (String) extras.get("fecha");
            String datoContacto = (String) extras.get("contacto");


            etiNombre.setText(datoNombre);
            etiTelefono.setText(datoTelefono);
            etiEmail.setText(datoEmail);
            etiFecha.setText(datoFecha);
            etiContacto.setText(datoContacto);



        }

        btnEditar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        //iniciar el intent
        Intent intentnew1 = new Intent(Datos.this, MainActivity.class );

        String auxEdiNombre1= etiNombre.getText().toString();
        String auxEdiPhone1= etiTelefono.getText().toString();
        String auxEdiEmail1= etiEmail.getText().toString();
        String auxEdiContacto1= etiContacto.getText().toString();
        String auxEdiFecha1= etiFecha.getText().toString();


        intentnew1.putExtra("nombre1",auxEdiNombre1);
        intentnew1.putExtra("telefono1",auxEdiPhone1);
        intentnew1.putExtra("email1",auxEdiEmail1);
        intentnew1.putExtra("contacto1",auxEdiContacto1);
        intentnew1.putExtra("fecha1",auxEdiFecha1);



        //lo inicializamos pasandole la intencion, con todos sus parametros guardados
        startActivity(intentnew1);

    }
}
