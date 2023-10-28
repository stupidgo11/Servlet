package sit.int202.sitspacemanagement.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.sitspacemanagement.models.AllStudent;

import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/Add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double score = Double.parseDouble(request.getParameter("score")) ;
        HttpSession session =request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("AllStudent");
        if(allStudent != null){
            allStudent.addStudent(id,name,score);
        }else {
            allStudent = new AllStudent();
            allStudent.addStudent(id,name,score);
            session.setAttribute("AllStudent",allStudent);
        }
        session.setAttribute("findAll", allStudent.findAll());
        request.setAttribute("message", "Add Successful");
        getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response);
    }
}