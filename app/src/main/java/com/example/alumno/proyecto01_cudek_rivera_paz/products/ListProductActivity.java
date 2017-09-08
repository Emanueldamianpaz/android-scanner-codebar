package com.example.alumno.proyecto01_cudek_rivera_paz.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.alumno.proyecto01_cudek_rivera_paz.MainActivity;
import com.example.alumno.proyecto01_cudek_rivera_paz.R;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.DepositProductsDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.ProductDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.scanner.ScannerActivity;
import com.google.gson.Gson;

import java.util.List;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        Gson g = new Gson();
        DepositProductsDTO listProduct = g.fromJson(getIntent().getExtras().get("listProducts").toString(), DepositProductsDTO.class);

        LinearLayout containerItem = (LinearLayout) this.findViewById(R.id.listProductsContainer);

        for (ProductDTO product : listProduct.getListProducts()) {
            View viewItem = new ProductInflater(getBaseContext(), product).createProductItem();
            containerItem.addView(viewItem);
        }


        Button btnVolver = (Button) this.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListProductActivity.this, MainActivity.class);
                ListProductActivity.this.startActivity(myIntent);
            }
        });

    }
}
