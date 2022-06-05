package controller.task;

import model.category.Category;
import model.task.Task;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/task/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date limit = Date.valueOf(req.getParameter("limit"));
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        User user = (User) req.getSession().getAttribute("currentUser");
        Integer userId = user.getId();

        Task task = new Task(
                null,
                name,
                description,
                limit,
                false,
                null,
                null,
                categoryId,
                userId
        );

        task.insert();

        resp.sendRedirect("/user/login");
    }
}
