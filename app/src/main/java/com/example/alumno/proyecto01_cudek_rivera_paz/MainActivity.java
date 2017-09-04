package com.example.alumno.proyecto01_cudek_rivera_paz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alumno.proyecto01_cudek_rivera_paz.dto.DepositProductsDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.ProductDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.products.ListProductActivity;
import com.example.alumno.proyecto01_cudek_rivera_paz.scanner.IntentIntegrator;
import com.example.alumno.proyecto01_cudek_rivera_paz.scanner.ScannerActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {


    private String json = "{\n" +
            "  \"listProducts\": [\n" +
            "    {\n" +
            "      \"id\": \"0000000001\",\n" +
            "      \"label\": \"Caño de agua\",\n" +
            "      \"stock\": 4,\n" +
            "      \"idPhoto\": \"barcode01\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"0000000002\",\n" +
            "      \"label\": \"Caño de luz\",\n" +
            "      \"stock\": 4,\n" +
            "      \"idPhoto\": \"barcode02\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"0000000003\",\n" +
            "      \"label\": \"Caño de gas\",\n" +
            "      \"stock\": 4,\n" +
            "      \"idPhoto\": \"barcode03\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO Hacer andar el listado

        Gson g = new Gson();
        DepositProductsDTO listProduct = g.fromJson(json, DepositProductsDTO.class);

        for (ProductDTO product : listProduct.getProducts()) {
            System.out.println(product.getId());
        }*/

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
