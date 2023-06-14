package mvcHotel;

import java.util.List;

public class hotels {
    private int hotel_id;
    private String name;
    private String address;
    private String city;
    private String country;
    private float rating;
    private String facilities;
    private List<rooms> roomsList;


    public hotels(int hotel_id, String name, String address, String city, String country, float rating, String facilities) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.rating = rating;
        this.facilities = facilities;
    }

    public hotels(String name, String address, String city, String country, float rating, String facilities) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.rating = rating;
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public float getRating() {
        return rating;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


    public void setRoomsList(List<rooms> roomsList) {
        this.roomsList = roomsList;
    }
    public List<rooms> getRoomsList() {
        return roomsList;
    }
}
