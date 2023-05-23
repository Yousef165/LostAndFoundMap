package com.application.lostandfound.model;

public class LostAndFound {

    private String _Id;
    private String _Name;
    private String _Phone;
    private String _Description;
    private String _Date;
    private String _Location;
    private String _Latitude;
    private String _Longitude;

    public LostAndFound(String _Id, String _Name, String _Phone, String _Description, String _Date, String _Location, String _Latitude, String _Longitude) {
        this._Id = _Id;
        this._Name = _Name;
        this._Phone = _Phone;
        this._Description = _Description;
        this._Date = _Date;
        this._Location = _Location;
        this._Latitude = _Latitude;
        this._Longitude = _Longitude;
    }

    public LostAndFound(String _Latitude, String _Longitude) {
        this._Latitude = _Latitude;
        this._Longitude = _Longitude;
    }

    public String get_Id() {
        return _Id;
    }

    public void set_Id(String _Id) {
        this._Id = _Id;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public String get_Phone() {
        return _Phone;
    }

    public void set_Phone(String _Phone) {
        this._Phone = _Phone;
    }

    public String get_Description() {
        return _Description;
    }

    public void set_Description(String _Description) {
        this._Description = _Description;
    }

    public String get_Date() {
        return _Date;
    }

    public void set_Date(String _Date) {
        this._Date = _Date;
    }

    public String get_Location() {
        return _Location;
    }

    public void set_Location(String _Location) {
        this._Location = _Location;
    }

    public String get_Latitude() {
        return _Latitude;
    }

    public void set_Latitude(String _Latitude) {
        this._Latitude = _Latitude;
    }

    public String get_Longitude() {
        return _Longitude;
    }

    public void set_Longitude(String _Longitude) {
        this._Longitude = _Longitude;
    }
}