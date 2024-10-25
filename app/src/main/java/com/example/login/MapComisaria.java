package com.example.login;

import android.content.Context;
import android.os.Bundle;
//Librerias mapitas :3
import android.preference.PreferenceManager;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import androidx.appcompat.app.AppCompatActivity;

public class MapComisaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cargar el layout del mapa
        setContentView(R.layout.map_comisaria);
        // Cargar la configuración del mapa
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        MapView mapView = findViewById(R.id.mapaComisarias);
        mapView.setTileSource(TileSourceFactory.MAPNIK);// SELECCIÓN DE FUENTE DE MAPAS
        mapView.setBuiltInZoomControls(true);// CONTROL DE ZOOM DEL MAPA
        mapView.setMultiTouchControls(true);// Control Multitáctil para el mapa
        double dirPrederminadaLatitud = -33.4493141;// Coordenadas asignadas
        double dirPrederminadaLongitud = -70.6624069;// Coordenadas asignadas
        GeoPoint DirPredeterminadaPoint = new GeoPoint(dirPrederminadaLatitud, dirPrederminadaLongitud);// Creación de GeoPoint para las coordenadas definidas
        mapView.getController().setZoom(18.7);// Vista inicial del mapa centrada en la dirección predeterminada con zoom 15
        mapView.getController().setCenter(DirPredeterminadaPoint);// Centra el mapa en el punto Santiago
        Marker marcadorDirPredeterminada = new Marker(mapView);// Marcador para la dirección predeterminada
        marcadorDirPredeterminada.setPosition(DirPredeterminadaPoint);// Posición del marcador en el punto predeterminado
        marcadorDirPredeterminada.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);// Ancla del marcador
        marcadorDirPredeterminada.setTitle("Tu Dirección");// Título del marcador
        marcadorDirPredeterminada.setSnippet("Tú estás aquí"); // Descripción del marcador
        mapView.getOverlays().add(marcadorDirPredeterminada); // Marcadores en el mapa

        // Dirección comisarias cercanas I
        double dirComisariaLatitud1 = -33.4538828;
        double dirComisariaLongitud1 = -70.6676772;
        // Creación de GeoPoint para las coordenadas definidas
        GeoPoint DirComisariaPoint1 = new GeoPoint(dirComisariaLatitud1, dirComisariaLongitud1);
        Marker marcadorComisaria1 = new Marker(mapView);// Marcador comisaria
        marcadorComisaria1.setPosition(DirComisariaPoint1); // Posición del marcador en el punto comisaria 1
        marcadorComisaria1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);// // Ancla del marcador
        marcadorComisaria1.setTitle("Comisaria más Cercana");// Título del marcador
        marcadorComisaria1.setSnippet("2da Comisaria de Santiago");// Descripción del marcador
        marcadorComisaria1.setIcon(getResources().getDrawable(R.drawable.policepoint));// Icono marcador comisaria
        mapView.getOverlays().add(marcadorComisaria1); // Añadir marcador al mapa

        // Dirección comisarias cercanas II
        double dirComisariaLatitud2 = -33.4494009;
        double dirComisariaLongitud2 = -70.6671186;
        GeoPoint DirComisariaPoint2 = new GeoPoint(dirComisariaLatitud2, dirComisariaLongitud2);// Creación de GeoPoint para las coordenadas definidas
        Marker marcadorComisaria2 = new Marker(mapView);// Marcador comisaria
        marcadorComisaria2.setPosition(DirComisariaPoint2);// Posición del marcador en el punto comisaria 2
        marcadorComisaria2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM); // Ancla del marcador
        marcadorComisaria2.setTitle("Comisaria Cercana");// Título del marcador
        marcadorComisaria2.setSnippet("48ª Comisaría de Santiago");// Descripción del marcador
        marcadorComisaria2.setIcon(getResources().getDrawable(R.drawable.policepoint));// Icono marcador comisaria
        mapView.getOverlays().add(marcadorComisaria2);// Añadir marcador al mapa

        // Dirección comisarias cercanas III
        double dirComisariaLatitud3 = -33.451869;
        double dirComisariaLongitud3 = -70.6653711;

        // Creación de GeoPoint para las coordenadas definidas
        GeoPoint DirComisariaPoint3 = new GeoPoint(dirComisariaLatitud3, dirComisariaLongitud3);
        // Marcador comisaria
        Marker marcadorComisaria3 = new Marker(mapView);
        // Posición del marcador en el punto comisaria 3
        marcadorComisaria3.setPosition(DirComisariaPoint3);
        // Ancla del marcador
        marcadorComisaria3.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        // Título del marcador
        marcadorComisaria3.setTitle("Comisaria Cercana");
        // Descripción del marcador
        marcadorComisaria3.setSnippet("2a Comisaría Santiago Central");
        // Icono marcador comisaria
        marcadorComisaria3.setIcon(getResources().getDrawable(R.drawable.policepoint));

        // Añadir marcador al mapa
        mapView.getOverlays().add(marcadorComisaria3);

    }

}