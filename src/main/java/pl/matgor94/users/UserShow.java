package pl.matgor94.users;

import pl.matgor94.utils.User;
import pl.matgor94.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        User readOneUser = userDao.readOneUser(Integer.parseInt(id));
        request.setAttribute("user", readOneUser);
        getServletContext().getRequestDispatcher("/user/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
