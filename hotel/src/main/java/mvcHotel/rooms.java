package mvcHotel;

public class rooms {
    private int room_id;
    private int hotel_id;
    private String room_type;
    private double price;
    private boolean availability;
    private String detail;

    public rooms(int room_id, int hotel_id, String room_type, double price, boolean availability, String detail) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.room_type = room_type;
        this.price = price;
        this.availability = availability;
        this.detail = detail;
    }
    public rooms( int hotel_id, String room_type, double price, boolean availability, String detail) {
        this.hotel_id = hotel_id;
        this.room_type = room_type;
        this.price = price;
        this.availability = availability;
        this.detail = detail;
    }
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isAvailability() {
        return availability;
    }

}

