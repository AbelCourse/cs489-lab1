package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.text.ParseException;
import java.util.Arrays;

public class ProductMgmtApp {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        // Create an array of Products using company data
        Product[] products = {
                new Product(3128874119L, "Banana", "2023-01-24", 0.55, 124),
                new Product(2927458265L, "Apple", "2022-12-09",1.09, 18),
                new Product(9189927460L, "Carrot", "2023-03-31", 2.99, 89)
        };

        // Sort products array by product name
        Arrays.sort(products);

        // Print products in JSON format
        System.out.println("JSON format:");
        printProductsJSON(products);

        // Print products in XML format
        System.out.println("\nXML format:");
        printProductsXML(products);

        // Print products in CSV format
        System.out.println("\nCSV format:");
        printProductsCSV(products);
    }

    public static void printProductsJSON(Product[] products) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        for (Product product : products) {
            System.out.println(ow.writeValueAsString(product));
        }
    }

    public static void printProductsXML(Product[] products) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        System.out.println("<?xml version=\"1.0\"?>");
        ObjectWriter writer = xmlMapper.writer().withRootName("products");
        for (Product product: products)
            System.out.println(writer.writeValueAsString(product));
        System.out.println();
    }

    public static void printProductsCSV(Product[] products) {
        System.out.println("productId,productName,price,quantity");
        for (Product product : products) {
            System.out.println(product.getProductId() + "," + product.getName() + "," +
                    product.getUnitPrice() + "," + product.getQuantityInStock());
        }
    }
}

