package com.example.alumno.proyecto01_cudek_rivera_paz.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.proyecto01_cudek_rivera_paz.R;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.DepositProductsDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.ProductDTO;
import com.google.gson.Gson;

import java.util.List;

public class ListProductActivity extends AppCompatActivity {


    private String json = "{\n" +
            "  \"listProducts\": [\n" +
            "    {\n" +
            "      \"id\": \"100000000\",\n" +
            "      \"label\": \"Caño de agua\",\n" +
            "      \"stock\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"200000000\",\n" +
            "      \"label\": \"Caño de luz\",\n" +
            "      \"stock\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"300000000\",\n" +
            "      \"label\": \"Caño de gas\",\n" +
            "      \"stock\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"400000000\",\n" +
            "      \"label\": \"Cable de 1 pulgada\",\n" +
            "      \"stock\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"500000000\",\n" +
            "      \"label\": \"Cable de 1 1/2 pulgada\",\n" +
            "      \"stock\": 4\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        Gson g = new Gson();

        DepositProductsDTO listProduct = g.fromJson(json, DepositProductsDTO.class);


        for (ProductDTO product : listProduct.getProducts()) {
            System.out.println(product.getId());
        }

    }
}
