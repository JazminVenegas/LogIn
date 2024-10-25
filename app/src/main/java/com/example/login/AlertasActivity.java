package com.example.login;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

public class AlertasActivity extends AppCompatActivity implements SensorEventListener{

    //definición de variables para manipular la interfaz
    private View mainLayout;
    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertas);
        //Refenrencio cada variable con la interfaz
        mainLayout = findViewById(R.id.main_alertas);
        //Inicializo el sensor del dispositivo para interactuar
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Obtengo el tipo de sensor a utilizar
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void activarLuz(View view) {
        Snackbar.make(view, "Alerta Encendida", Snackbar.LENGTH_LONG)
                .setAction("Entendido", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Acción al presionar "Deshacer"
                    }
                }).show();
    }

    public void activarSonido(View view) {
        Snackbar.make(view, "Alerta Encendida", Snackbar.LENGTH_LONG)
                .setAction("Entendido", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Acción al presionar "Deshacer"
                    }
                }).show();
    }

    public void configAdicional(View view) {
        Intent intent = new Intent(this, CnfgAdicional.class);
        startActivity(intent);
    }


    @Override
    protected void onResume(){ //Metodo llamado cuando la actividad se reanude
        super.onResume();
        if (accelerometer != null){  //Verifico si el sensor esta disponible en el telefono
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL); //Registro un listener para recibir eventos
        }
    }

    @Override
    protected  void onPause(){  //Metodo llamado cuando la actividad se pause
        super.onPause();
        sensorManager.unregisterListener(this); //Se desregistra el listener para ahorrar bateria   //cuando la actividad no este activa
    }
    @Override
    public void onSensorChanged(SensorEvent event){//Metodo llamado cuando cambio los valores del sensor
        //Definimos un metodo cuando se registren los cambios del sensor
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];//Obtengo los valores del sensor
            float y = event.values[1];//Obtengo los valores del sensor
            float z = event.values[2];//Obtengo los valores del sensor

            if (Math.abs(x) > Math.abs(y) && Math.abs(x) > Math.abs(z)){ //Comparo la inclinacion del sensor
                if(x > 2){//Comparo la inclinacion del eje X
                    mainLayout.setBackgroundColor(Color.RED); //Incline el sensor a la derecha
                } else if (x < -2) {
                    mainLayout.setBackgroundColor(Color.BLUE); //Incline el sensor a la izquierda
                }
            } else if (Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z) ) {
                if (y > 2){  //Comparo la inclicacion del eje Y
                    mainLayout.setBackgroundColor(Color.GREEN); //Inclinacion es Arriba
                }else if(y < -2){
                    mainLayout.setBackgroundColor(Color.YELLOW);   //Inclinacion hacia abajo
                }

            }
        }
    }
    //Metodo llamado cuando cambie la precision del sensor (no lo utilizo)
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }
}

