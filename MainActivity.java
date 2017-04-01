package com.example.anik1.projectno2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ////////////////////////////////////////////////1-1
    private static final long TIME_INTERVAL_UPDATES = 1000;
    private static final long DISTANCE_FOR_UPDATES = 1;
    protected LocationManager gpsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gpsManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
            return;
        }
        gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, TIME_INTERVAL_UPDATES, DISTANCE_FOR_UPDATES, new MyGPSListner());
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
                    return;
                }
                Location location = gpsManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location !=null){
                    String gpsData = String.format("Last Known GPS\nLongitude: %1$s\nLatitude: %2$s\nAltitude: %3$s",location.getLongitude(),location.getLatitude(),location.getAltitude());
                    TextView tv2 = (TextView) findViewById(R.id.txt4);
                    tv2.setText(gpsData.toString());
                    //Toast.makeText(MainActivity.this,gpsData,Toast.LENGTH_LONG).show();
                }


            }
        });

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
                    return;
                }
                Location location = gpsManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location !=null){
                    String gpsData = String.format("Last Known GPS\nLongitude: %1$s\nLatitude: %2$s\nAltitude: %3$s",location.getLongitude(),location.getLatitude(),location.getAltitude());


                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("Anik",gpsData);
                    startActivity(intent);
                }
            }
        });
        /////////////////////////////////////////////End2-1
        /////////////////////////////////////////////////2-1
        Button bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
                    return;
                }
                Location location = gpsManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location !=null){
                    String gpsData = String.format("Last Known GPS\nLongitude: %1$s\nLatitude: %2$s\nAltitude: %3$s",location.getLongitude(),location.getLatitude(),location.getAltitude());
                    Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                    intent.putExtra("Anik",gpsData);
                    startActivity(intent);
                }
            }
        });
        /////////////////////////////////////////////End2-1
        /////////////////////////////////////////////2nd Key AES PAGE
        Button bt4 = (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
                    return;
                }
                Location location = gpsManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location !=null){
                    String gpsData = String.format("Last Known GPS\nLongitude: %1$s\nLatitude: %2$s\nAltitude: %3$s",location.getLongitude(),location.getLatitude(),location.getAltitude());
                    EditText edt = (EditText) findViewById(R.id.editText);
                    String passKey = edt.getText().toString();
                    Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                    intent.putExtra("Anik",gpsData);
                    intent.putExtra("Mykey",passKey);
                    startActivity(intent);
                }


            }
        });

        Button bt5 = (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
                    return;
                }
                Location location = gpsManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location !=null){
                    String gpsData = String.format("Last Known GPS\nLongitude: %1$s\nLatitude: %2$s\nAltitude: %3$s",location.getLongitude(),location.getLatitude(),location.getAltitude());
                    EditText edt = (EditText) findViewById(R.id.editText);
                    String passKey = edt.getText().toString();
                    Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                    intent.putExtra("Anik",gpsData);
                    intent.putExtra("Mykey",passKey);
                    startActivity(intent);
                }


            }
        });
        /////////////////////////////////////////////End 2nd Key XOR PAGE

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    /////////////////////////////////////////////////1-3
    private class MyGPSListner implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            String gpsData = String.format("New GPS\nLongitude: %1$s\nLatitude: %2%s\nAltitude: %3$s",location.getLatitude(),location.getLatitude(),location.getAltitude());
            Toast.makeText(MainActivity.this,gpsData,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            Toast.makeText(MainActivity.this,"GPS Status Changed",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String s) {
            Toast.makeText(MainActivity.this,"GPS is Enabled",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String s) {
            Toast.makeText(MainActivity.this,"GPS is Disabled",Toast.LENGTH_LONG).show();
        }
    }
    /////////////////////////////////////////////////End1-3

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
