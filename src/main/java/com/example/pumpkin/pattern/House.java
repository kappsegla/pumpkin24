package com.example.pumpkin.pattern;

public class House {
    boolean garage;
    int squareMeters;
    String roofColor;
    boolean pool;

    public House(boolean garage, int squareMeters, String roofColor, boolean pool) {
        this.garage = garage;
        this.squareMeters = squareMeters;
        this.roofColor = roofColor;
        this.pool = pool;
    }

    public static void main(String[] args) {

        House house = new HouseBuilder()
                .setPool(true)
                .setSquareMeters(100)
                .hasGarage()
                .hasIsolation()
                .setGarageSquareMeters(40)
                .houseBuilder()
                .setPool(true)
                .createHouse();

        var house2 = new HouseBuilder().withDefaultSettings().createHouse();


    }


}
