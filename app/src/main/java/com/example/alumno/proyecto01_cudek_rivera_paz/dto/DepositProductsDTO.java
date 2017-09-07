package com.example.alumno.proyecto01_cudek_rivera_paz.dto;


import java.util.List;

public class DepositProductsDTO {

    private List<ProductDTO> listProducts;

    public DepositProductsDTO(List<ProductDTO> listProducts) {
        this.listProducts = listProducts;
    }

    public List<ProductDTO> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ProductDTO> listProducts) {
        this.listProducts = listProducts;
    }
}
