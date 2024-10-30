package com.example.pumpkin.pattern;

public class HouseBuilder implements Garage{
    private boolean garage;
    private int squareMeters;
    private String roofColor;
    private boolean pool;
    private int garageSquareMeters;
    private boolean garageIsolated;

    public Garage hasGarage() {
        this.garage = true;
        return this;
    }

    public HouseBuilder withDefaultSettings(){
       return this.hasGarage()
               .hasIsolation()
               .setGarageSquareMeters(20)
               .houseBuilder()
               .setRoofColor("RED");
    }

    public HouseBuilder setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
        return this;
    }

    @Override
    public Garage setGarageSquareMeters(int squareMeters) {
        this.garageSquareMeters = squareMeters;
        return this;
    }

    @Override
    public Garage hasIsolation() {
        this.garageIsolated = true;
        return this;
    }

    @Override
    public HouseBuilder houseBuilder() {
        return this;
    }

    public HouseBuilder setRoofColor(String roofColor) {
        this.roofColor = roofColor;
        return this;
    }

    public HouseBuilder setPool(boolean pool) {
        this.pool = pool;
        return this;
    }

    public House createHouse() {
        return new House(garage, squareMeters, roofColor, pool);
    }
}

interface Garage {
    Garage setGarageSquareMeters(int squareMeters);
    Garage hasIsolation();
    HouseBuilder houseBuilder();
}
