package com.example.alumno.proyecto01_cudek_rivera_paz.products;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumno.proyecto01_cudek_rivera_paz.R;
import com.example.alumno.proyecto01_cudek_rivera_paz.dto.ProductDTO;

public class ProductInflater {

    private Context context;
    private ProductDTO product;

    public ProductInflater(Context context, ProductDTO product) {
        this.context = context;
        this.product = product;

    }

    public View createProductItem() {
        View productItem = LayoutInflater.from(context).inflate(R.layout.product_item, null, false);
        ImageView imgDetail = (ImageView) productItem.findViewById(R.id.imgProductDetail);
        TextView titleDetail = (TextView) productItem.findViewById(R.id.txtTitleDetail);
        TextView stockDetail = (TextView) productItem.findViewById(R.id.txtStockDetail);

        titleDetail.setText(product.getLabel());
        stockDetail.setText("Stock: " + String.valueOf(product.getStock()) + " unidades");
        int imageResource = context.getResources().getIdentifier("@drawable/" + product.getIdPhoto(), null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource);
        imgDetail.setImageDrawable(res);

        return productItem;
    }
}
