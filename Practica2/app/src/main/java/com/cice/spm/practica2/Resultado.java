package com.cice.spm.practica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // asignamos el valor de resultado
        TextView resultado = (TextView) findViewById(R.id.resultado);
        Intent intent = getIntent();
        resultado.setText(intent.getStringExtra("mensaje"));
    }
}
