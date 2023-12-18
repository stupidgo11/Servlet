package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeUpdateServlet", value = "/office-update")
public class OfficeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("officeCode");
        OfficeRepository officeRepository = new OfficeRepository();
        if (officeRepository.isValidString(officeCode)) {
            Office findOff = officeRepository.find(officeCode);
            if (findOff != null) {
                request.setAttribute("office", findOff);
            }
        }
        officeRepository.close();
        request.getRequestDispatcher("/office-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        //for update office
        officeRepository.update(officeRepository.createOffice(request, response));
        officeRepository.close();

        response.sendRedirect(getServletContext().getContextPath() + "/office-list");
    }
}
 
