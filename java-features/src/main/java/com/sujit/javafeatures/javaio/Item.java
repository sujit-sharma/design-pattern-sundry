package com.sujit.javafeatures.javaio;

public class Item {
    private String name;
    private String quantity;
    private Double price;
    private static final String CSV_LINEBREAK = "\n";
    private static final String CSV_SEPARATOR = ",";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String convertToCSV(){
        return name + CSV_SEPARATOR + quantity + CSV_SEPARATOR + price + CSV_LINEBREAK;
    }
    static public String getCSVHeader(){
        return "Name" + CSV_SEPARATOR + "Quantity" + CSV_SEPARATOR + "Price" + CSV_LINEBREAK;
    }
}
