    package mvcHotel;


    import com.oracle.wls.shaded.org.apache.bcel.generic.ARETURN;

    import javax.sql.DataSource;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    public class hotelsDbUtil {
        private DataSource dataSource;

        public hotelsDbUtil(DataSource theDataSource) {
            dataSource = theDataSource;
        }

        public List<hotels> getHotels() throws Exception {
            List<hotels> hotels = new ArrayList<>();

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");

                myConn = DriverManager.getConnection(url, username, password);

                String sql = "select * from hotels order by name";

                myStmt = myConn.createStatement();

                myRs = myStmt.executeQuery(sql);

                while (myRs.next()) {
                    int hotel_id = myRs.getInt("hotel_id");
                    String name = myRs.getString("name");
                    String address = myRs.getString("address");
                    String city = myRs.getString("city");
                    String country = myRs.getString("country");
                    float rating = myRs.getFloat("rating");
                    String facilities = myRs.getString("facilities");

                    hotels tempHotel = new hotels(hotel_id, name, address, city, country, rating, facilities);

                    hotels.add(tempHotel);
                }
                return hotels;
            } finally {
                close(myConn, myStmt, myRs);
            }
        }

        public List<rooms> getRoomsByHotelId(int hotelId) throws Exception {
            List<rooms> rooms = new ArrayList<>();

            Connection myConn = null;
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                myConn = DriverManager.getConnection(url, username, password);

                String sql = "SELECT r.room_id, r.room_type, r.price, r.availability, r.detail " +
                        "FROM rooms r " +
                        "INNER JOIN hotels h ON r.hotel_id = h.hotel_id " +
                        "WHERE h.hotel_id = ?";

                myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1, hotelId);

                myRs = myStmt.executeQuery();

                while (myRs.next()) {
                    int room_id = myRs.getInt("room_id");
                    String room_type = myRs.getString("room_type");
                    double price = myRs.getDouble("price");
                    boolean availability = myRs.getBoolean("availability");
                    String detail = myRs.getString("detail");

                    rooms tempRoom = new rooms(room_id,hotelId, room_type, price, availability, detail);
                    rooms.add(tempRoom);
                }
                return rooms;
            }finally {
                close(myConn, myStmt, myRs);
            }
        }

        private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
            try {
                if (myRs != null) {
                    myRs.close();
                }

                if (myStmt != null) {
                    myStmt.close();
                }

                if (myConn != null) {
                    myConn.close();
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

        public void addHotel(hotels theHotel) throws Exception {
            Connection myConn = null;
            PreparedStatement myStmt = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");

                myConn = DriverManager.getConnection(url, username, password);

                String sql = "insert into hotels" + "(name, address, city, country, rating, facilities)" + "values (?, ?, ?, ?, ?, ?)";

                myStmt = myConn.prepareStatement(sql);

                myStmt.setString(1, theHotel.getName());
                myStmt.setString(2, theHotel.getAddress());
                myStmt.setString(3, theHotel.getCity());
                myStmt.setString(4, theHotel.getCountry());
                myStmt.setFloat(5, theHotel.getRating());
                myStmt.setString(6, theHotel.getFacilities());

                myStmt.execute();
            } finally {
                close(myConn, myStmt, null);
            }
        }

        public hotels getHotel(String theHotelId) throws Exception {
            hotels theHotel = null;

            Connection myConn = null;
            PreparedStatement myStmt = null;
            ResultSet myRs = null;
            int hotelId;

            try {
                hotelId = Integer.parseInt(theHotelId);

                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                myConn = DriverManager.getConnection(url, username, password);

                String sql = "select * from hotels where hotel_id=?";

                myStmt = myConn.prepareStatement(sql);

                myStmt.setInt(1, hotelId);

                myRs = myStmt.executeQuery();

                hotels tempHotel = null;
                if (myRs.next()) {
                    String name = myRs.getString("name");
                    String address = myRs.getString("address");
                    String city = myRs.getString("city");
                    String country = myRs.getString("country");
                    float rating = myRs.getFloat("rating");
                    String facilities = myRs.getString("facilities");

                    tempHotel = new hotels(hotelId, name, address, city, country, rating, facilities);
                } else {
                    throw new Exception("Could not find student id: " + hotelId);
                }
                return tempHotel;
            } finally {
                close(myConn, myStmt, myRs);
            }
        }

        public void updateHotel(hotels theHotel) throws Exception {
            Connection myConn = null;
            PreparedStatement myStmt = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                myConn = DriverManager.getConnection(url, username, password);

                String sql = "update hotels set name=?, address=?, city=?, country=?, rating=?, facilities=? where hotel_id=?";
                myStmt = myConn.prepareStatement(sql);

                myStmt.setString(1, theHotel.getName());
                myStmt.setString(2, theHotel.getAddress());
                myStmt.setString(3, theHotel.getCity());
                myStmt.setString(4, theHotel.getCountry());
                myStmt.setFloat(5, theHotel.getRating());
                myStmt.setString(6, theHotel.getFacilities());
                myStmt.setInt(7, theHotel.getHotel_id());

                myStmt.execute();
            } finally {
                close(myConn, myStmt, null);
            }

        }

        public void deleteHotel(String theHotelId) throws Exception {
            Connection myConn = null;
            PreparedStatement myStmt = null;

            try {
                int hotelId = Integer.parseInt(theHotelId);

                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                myConn = DriverManager.getConnection(url, username, password);

                String sql = "delete from hotels where hotel_id=?";

                myStmt = myConn.prepareStatement(sql);

                myStmt.setInt(1, hotelId);

                myStmt.execute();
            } finally {
                close(myConn, myStmt, null);
            }
        }

        public List<hotels> searchHotels(String keyword) throws Exception {
            List<hotels> hotels = new ArrayList<>();

            Connection myConn = null;
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");

                myConn = DriverManager.getConnection(url, username, password);

                String sql = "SELECT * FROM hotels WHERE name LIKE ?";

                myStmt = myConn.prepareStatement(sql);
                String searchKeyword = "%" + keyword + "%";
                myStmt.setString(1, searchKeyword);

                myRs = myStmt.executeQuery();

                while (myRs.next()) {
                    int hotel_id = myRs.getInt("hotel_id");
                    String name = myRs.getString("name");
                    String address = myRs.getString("address");
                    String city = myRs.getString("city");
                    String country = myRs.getString("country");
                    float rating = myRs.getFloat("rating");
                    String facilities = myRs.getString("facilities");

                    hotels tempHotel = new hotels(hotel_id, name, address, city, country, rating, facilities);

                    hotels.add(tempHotel);
                }

                return hotels;
            } finally {
                close(myConn, myStmt, myRs);
            }
        }

        public hotels hotelsDetails(int hotelId) throws Exception {
            hotels theHotel = null;

            Connection myConn = null;
            PreparedStatement hotelStmt = null;
            PreparedStatement roomsStmt = null;
            ResultSet hotelRs = null;
            ResultSet roomsRs = null;

            try {
                String url = "jdbc:mysql://localhost:3306/web_hotels_tracker";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                myConn = DriverManager.getConnection(url, username, password);

                // Lấy thông tin khách sạn từ bảng hotels
                String hotelSql = "SELECT * FROM hotels WHERE hotel_id = ?";
                hotelStmt = myConn.prepareStatement(hotelSql);
                hotelStmt.setInt(1, hotelId);
                hotelRs = hotelStmt.executeQuery();

                if (hotelRs.next()) {
                    int hotel_id = hotelRs.getInt("hotel_id");
                    String name = hotelRs.getString("name");
                    String address = hotelRs.getString("address");
                    String city = hotelRs.getString("city");
                    String country = hotelRs.getString("country");
                    float rating = hotelRs.getFloat("rating");
                    String facilities = hotelRs.getString("facilities");

                    theHotel = new hotels(hotel_id, name, address, city, country, rating, facilities);
                } else {
                    throw new Exception("Could not find hotel with id: " + hotelId);
                }

                // Lấy danh sách phòng từ bảng rooms dựa trên hotel_id
                String roomsSql = "SELECT * FROM rooms WHERE hotel_id = ?";
                roomsStmt = myConn.prepareStatement(roomsSql);
                roomsStmt.setInt(1, hotelId);
                roomsRs = roomsStmt.executeQuery();

                List<rooms> roomsList = new ArrayList<>();
                while (roomsRs.next()) {
                    int room_id = roomsRs.getInt("room_id");
                    String room_type = roomsRs.getString("room_type");
                    double price = roomsRs.getDouble("price");
                    boolean availability = roomsRs.getBoolean("availability");
                    String detail = roomsRs.getString("detail");

                    rooms room = new rooms(room_id, hotelId, room_type, price, availability, detail);
                    roomsList.add(room);
                }

                theHotel.setRoomsList(roomsList);

                return theHotel;
            } finally {
                close(myConn, hotelStmt, hotelRs);
                close(null, roomsStmt, roomsRs);
            }
        }

    }
