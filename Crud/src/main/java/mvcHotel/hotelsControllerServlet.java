package mvcHotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thidk.codelean.jdbc.Student;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/hotelsControllerServlet")
public class hotelsControllerServlet extends HttpServlet {
    private static final long serialVersionUID =  1L;

    private hotelsDbUtil hotelsDbUtil;

    @Resource(name="jdbc/web_hotels_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            hotelsDbUtil = new hotelsDbUtil(dataSource);
        }catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if(theCommand == null) {
                theCommand = "list";
            }else if (theCommand.equals("SEARCH")) {
                String keyword = request.getParameter("keyword");
                try {
                    List<hotels> hotelList = hotelsDbUtil.searchHotels(keyword);
                    request.setAttribute("HOTEL_LIST", hotelList);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/list-hotel.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
            }
            switch (theCommand) {
                case "ADD":
                    addHotel(request, response);
                    break;
                case "LOAD":
                    loadHotel(request, response);
                    break;
                case "UPDATE":
                    updateHotel(request, response);
                    break;
                case "DELETE":
                    deleteHotel(request, response);
                    break;
                case "SEARCH":
                    searchHotel(request, response);
                    break;
                case "ROOMS":
                    listRooms(request, response);
                    break;
                case "LOGIN":
                    login(request, response);
                    break;
                default:
                    listHotel(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<hotels> hotels = hotelsDbUtil.getHotels();

        request.setAttribute("HOTEL_LIST", hotels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-hotel.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theHotelId = request.getParameter("hotelId");

        hotelsDbUtil.deleteHotel(theHotelId);

        listHotel(request, response);
    }

    public void updateHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int hotel_id = Integer.parseInt(request.getParameter("hotelId"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        float rating = Float.parseFloat(request.getParameter("rating"));
        String facilities = request.getParameter("facilities");

        hotels theHotel = new hotels(hotel_id, name, address, city, country, rating, facilities);

        hotelsDbUtil.updateHotel(theHotel);
        listHotel(request, response);
    }

    public void loadHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theHotelId = request.getParameter("hotelId");

        hotels theHotel = hotelsDbUtil.getHotel(theHotelId);

        request.setAttribute("THE_HOTEL", theHotel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-hotel-form.jsp");
        dispatcher.forward(request, response);
    }

    public void addHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        float rating = Float.parseFloat(request.getParameter("rating"));
        String facilities = request.getParameter("facilities");

        hotels theHotel = new hotels(name, address, city, country, rating, facilities);

        hotelsDbUtil.addHotel(theHotel);

        listHotel(request, response);
    }

    private void searchHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<hotels> hotels = hotelsDbUtil.searchHotels(keyword);

        request.setAttribute("HOTEL_LIST", hotels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-hotel.jsp");
        dispatcher.forward(request, response);
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        List<rooms> rooms = hotelsDbUtil.getRoomsByHotelId(hotelId);

        request.setAttribute("ROOM_LIST", rooms);
        request.setAttribute("HOTEL_ID", hotelId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-room.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập từ cơ sở dữ liệu
        int userId = hotelsDbUtil.authenticateUser(username, password);

        if (userId != -1) {
            // Lưu user_id vào session
            HttpSession session = request.getSession();
            session.setAttribute("userId", String.valueOf(userId));

            out.println("userID : " + userId);


            // Tiến hành các hành động tiếp theo
            response.sendRedirect(request.getContextPath() + "/hotelsControllerServlet");
        } else {
            out.println("bú");

        }
    }

}
