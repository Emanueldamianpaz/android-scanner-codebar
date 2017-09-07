package com.example.alumno.proyecto01_cudek_rivera_paz.scanner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno.proyecto01_cudek_rivera_paz.dto.DepositProductsDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.ProductDTO;
import com.example.alumno.proyecto01_cudek_rivera_paz.interpreterScanner.IntentIntegrator;
import com.example.alumno.proyecto01_cudek_rivera_paz.interpreterScanner.IntentResult;
import com.example.alumno.proyecto01_cudek_rivera_paz.MainActivity;
import com.example.alumno.proyecto01_cudek_rivera_paz.R;
import com.google.gson.Gson;


public class ScannerActivity extends AppCompatActivity {

    private TextView scan_formatLbl, lblTitle, lblStock;
    private ImageView imgProduct;
    private Button btnVolver;
    private DepositProductsDTO listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        scan_formatLbl = (TextView) this.findViewById(R.id.scan_format);
        lblTitle = (TextView) this.findViewById(R.id.lblTitle);
        lblStock = (TextView) this.findViewById(R.id.lblStock);
        imgProduct = (ImageView) this.findViewById(R.id.imgProduct);

        Gson g = new Gson();
        listProduct = g.fromJson(getIntent().getExtras().get("listProducts").toString(), DepositProductsDTO.class);

        IntentIntegrator scanIntegrator = new IntentIntegrator(this);
        scanIntegrator.initiateScan();

        btnVolver = (Button) this.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ScannerActivity.this, MainActivity.class);
                ScannerActivity.this.startActivity(myIntent);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            for (ProductDTO product : listProduct.getListProducts()) {
                if (scanContent.equals(product.getId())) {
                    lblTitle.setText(product.getLabel());
                    lblStock.setText("Stock: " + String.valueOf(product.getStock()) + " unidades");

                    int imageResource = getResources().getIdentifier("@drawable/" + product.getIdPhoto(), null, getPackageName());
                    Drawable res = getResources().getDrawable(imageResource);
                    imgProduct.setImageDrawable(res);


                }
            }
            scan_formatLbl.setText("Formato: " + scanFormat);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void setViewToResults(ProductDTO product) {

    }
}

