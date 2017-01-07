package com.cice.spm.practica2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    float altura;
    int peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calcular = (Button) findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // validamos que se introduzcan valores y sean correctos
                boolean valido = validar();

                // calculamos
                if (valido) {
                    String mensaje = calculaIMC();
                    callResultado(mensaje);

                } else {
                    callResultado(getString(R.string.error));
                }
            }
        });
    }

    private void callResultado (final String mensaje) {
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        intent.putExtra("mensaje", mensaje);
        startActivity(intent);
    }

    public String calculaIMC() {
        String mensaje;
        float imc = peso / ((altura/100) * 2);

        if (imc <= 16) {
            mensaje = getString(R.string.desnutrido);
        } else if (imc < 18) {
            mensaje = getString(R.string.bajo);
        } else if (imc < 25) {
            mensaje = getString(R.string.normal);
        } else if (imc < 31) {
            mensaje = getString(R.string.sobrepeso);
        } else {
            mensaje = getString(R.string.obeso);
        }

        return mensaje;
    }

    private boolean validar() {
        boolean valido = true;

        // recuperamos los valores introducidos
        TextView tvAltura = (TextView) (findViewById(R.id.altura));
        TextView tvPeso = (TextView) (findViewById(R.id.peso));

        if (tvAltura.getText().length() == 0 || tvPeso.getText().length() == 0) {
            valido = false;
        } else {
            altura = Float.valueOf(String.valueOf(((TextView) findViewById(R.id.altura)).getText()));
            peso = Integer.valueOf(String.valueOf(((TextView) findViewById(R.id.peso)).getText()));

            if (altura <= 0 || peso <= 0) {
                valido = false;
            }
        }

        return valido;
    }
}
