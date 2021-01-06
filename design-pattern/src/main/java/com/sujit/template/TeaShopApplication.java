package com.sujit.template;

public class TeaShopApplication {

    public static void main(String[] args) {
        TeaMaker tea = new MilkTea();
        tea.makeTea();

        tea = new BlackTea();
        tea.makeTea();
    }
}
