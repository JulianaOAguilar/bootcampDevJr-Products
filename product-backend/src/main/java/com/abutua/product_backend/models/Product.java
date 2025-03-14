package com.abutua.product_backend.models;

//aqui é onde criamos nosso object Product, especificando seus atributos
public class Product {
   
    //Atributos
    private int id;
    private String name;
    private String description;
    private int idCategory;
    private double price;
    private boolean promotion;
    private boolean newProduct;

    public int getId() {
        return id;
    }

    //métodos construturores

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public Product(int id, String name, String description, int idCategory, double price, boolean promotion, boolean newProduct){
        this.id = id;
        this.name = name;
        this.description = description;
        this.idCategory = idCategory;
        this.price = price;
        this.promotion = promotion;
        this.newProduct = newProduct;

    }


    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Product(){
        
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isnewProduct() {
        return newProduct;
    }

    public void setnewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    //getters e setters, pois essa classe é privada
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
