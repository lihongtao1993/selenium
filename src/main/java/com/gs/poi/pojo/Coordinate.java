package com.gs.poi.pojo;

public class Coordinate {

    private String coordinateType;
    private double latitude;
    private double longitude;
    public void setCoordinateType(String coordinateType) {
        this.coordinateType = coordinateType;
    }
    public String getCoordinateType() {
        return coordinateType;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLongitude() {
        return longitude;
    }

}