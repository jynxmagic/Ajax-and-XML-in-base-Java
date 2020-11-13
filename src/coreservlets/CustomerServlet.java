package coreservlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Customer[] customers = CustomerUtils.getTwoRichestCustomers();

        request.setAttribute("customers", customers);

        response.setContentType("text/xml");

        String outputPage = "/WEB-INF/results/customers-xml.jsp";

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(outputPage);
        dispatcher.include(request, response);
    }
}
