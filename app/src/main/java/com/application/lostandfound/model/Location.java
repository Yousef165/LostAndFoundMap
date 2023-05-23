package com.application.lostandfound.model;

public class Location {

    private Double _Latitude;
    private Double _Longitude;

    public Location(Double _Latitude, Double _Longitude) {
        this._Latitude = _Latitude;
        this._Longitude = _Longitude;
    }

    public Double get_Latitude() {
        return _Latitude;
    }

    public void set_Latitude(Double _Latitude) {
        this._Latitude = _Latitude;
    }

    public Double get_Longitude() {
        return _Longitude;
    }

    public void set_Longitude(Double _Longitude) {
        this._Longitude = _Longitude;
    }
}
