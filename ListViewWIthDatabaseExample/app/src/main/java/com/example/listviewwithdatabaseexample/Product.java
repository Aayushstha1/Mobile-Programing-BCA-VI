package com.example.listviewwithdatabaseexample;

public class Product {
    private  int pCode;
    private  String name;
    private  int quantity;

    public Product(){
        pCode = 0;
        name = "";
        quantity = 0;

    }
    public Product(int pCode, String name, int quantity){
        this.pCode = pCode;
        this.name = name;
        this.quantity = quantity;

    }
    public void setpCode(int pCode) {
        this.pCode = pCode;
    }
    public int getpCode() {
        return pCode;
    }
public void setName(String name) {
    this.name = name;
}
public String getName() {
    return name;
}
public void setQuantity(int quantity) {
    this.quantity = quantity;
}
public int getQuantity() {
    return quantity;
}


}
