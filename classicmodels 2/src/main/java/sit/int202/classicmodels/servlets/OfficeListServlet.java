package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        String search = request.getParameter("search");
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }

        if (officeRepository.isValidString(search)) {
            request.setAttribute("search",search);
            request.setAttribute("offices", officeRepository.findByCityOrCountry(search));
        }

        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OfficeRepository officeRepository = new OfficeRepository();
        //delete office
        String delete = request.getParameter("delete");
        officeRepository.delete(delete);
        officeRepository.close();
        doGet(request,response);
    }
}
 
