package com.example.alumno.proyecto01_cudek_rivera_paz.dto;


import java.util.List;

public class DepositProductsDTO {

    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public DepositProductsDTO(List<ProductDTO> products) {

        this.products = products;
    }
}
