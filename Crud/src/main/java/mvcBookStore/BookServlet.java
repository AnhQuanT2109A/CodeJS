package mvcBookStore;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcCrud.Product;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private List<Book> bookList;
    @Override
    public void init() throws ServletException {
        super.init();
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Dế mèn phiêu lưu kí", "Tô Hoài",48000, 20 ));
        bookList.add(new Book(2, "Làng", "Kim Lân",23000, 21 ));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createBook(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bookList", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        dispatcher.forward(request, response);
    }
    private void createBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameBook = request.getParameter("nameBook");
        String nameAuthor = request.getParameter("nameAuthor");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int id = bookList.size() + 1;

        Book newBook = new Book(id, nameBook, nameAuthor, price, quantity);
        bookList.add(newBook);

        response.sendRedirect("books");


    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = getBookById(id);

        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        dispatcher.forward(request, response);
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameBook = request.getParameter("nameBook");
        String nameAuthor = request.getParameter("nameAuthor");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Book book = getBookById(id);
        book.setNameBook(nameBook);
        book.setNameAuthor(nameAuthor);
        book.setPrice(price);
        book.setQuantity(quantity);

        response.sendRedirect("books");
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = getBookById(id);
        bookList.remove(book);
        response.sendRedirect("books");
    }
    private Book getBookById(int id) {
        for (Book book : bookList) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }


}
