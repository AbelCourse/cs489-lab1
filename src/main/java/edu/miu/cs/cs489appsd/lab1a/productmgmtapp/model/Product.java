package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Comparable<Product>{

    private long productId;
    private String name;
    private Date dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Product() {}

    public Product(long productId, String name, String dateSupplied, double unitPrice, int quantityInStock) throws ParseException {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = sdf.parse(dateSupplied);
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public Product(String name, double unitPrice, int quantityInStock) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}
