package Phone;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/phoneControllerServlet")
public class phoneControllerServlet extends HttpServlet {
    private static final long serialVersionUID =  1L;

    private phoneDbUtil phoneDbUtil;

    @Resource(name="jdbc/web_phone_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            phoneDbUtil = new phoneDbUtil(dataSource);
        }catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if(theCommand == null) {
                theCommand = "list";
            }
            switch (theCommand) {
                case "ADD":
                    addPhone(request, response);
                    break;
                default:
                    listPhone(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<phone> phone = phoneDbUtil.getPhones();

        request.setAttribute("PHONE_LIST", phone);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-phone.jsp");
        dispatcher.forward(request, response);
    }


    public void addPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        phone thePhone = new phone(name, brand, description, price);

        phoneDbUtil.addPhone(thePhone);

        listPhone(request, response);
    }

}
