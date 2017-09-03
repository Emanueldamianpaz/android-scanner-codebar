package com.example.alumno.proyecto01_cudek_rivera_paz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alumno.proyecto01_cudek_rivera_paz.products.ListProductActivity;
import com.example.alumno.proyecto01_cudek_rivera_paz.scanner.IntentIntegrator;
import com.example.alumno.proyecto01_cudek_rivera_paz.scanner.ScannerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanBtn = (Button) this.findViewById(R.id.btnScanner);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
                // myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button listProductsBtn = (Button) this.findViewById(R.id.btnListProduct);
        listProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ListProductActivity.class);
                // myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

    }

}
