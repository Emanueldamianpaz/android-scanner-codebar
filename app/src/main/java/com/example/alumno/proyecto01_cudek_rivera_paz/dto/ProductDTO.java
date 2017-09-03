package com.example.alumno.proyecto01_cudek_rivera_paz.dto;


public class ProductDTO {

    private String id;
    private String label;
    private int stock;

    public ProductDTO(String id, String label, int stock) {
        this.id = id;
        this.label = label;
        this.stock = stock;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
