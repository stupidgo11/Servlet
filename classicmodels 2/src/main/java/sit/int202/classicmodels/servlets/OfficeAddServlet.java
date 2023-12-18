package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeAddServlet", value = "/office-add")
public class OfficeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/office-add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();

        officeRepository.insert(officeRepository.createOffice(request,response));
        officeRepository.close();
        //redirect to office list
        response.sendRedirect(getServletContext().getContextPath() + "/office-list");
    }
}
 
