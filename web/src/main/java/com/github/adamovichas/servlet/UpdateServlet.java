package com.github.adamovichas.servlet;


import com.github.adamovichas.DAO.impl.IDAOUser;
import com.github.adamovichas.DAO.DAOUser;
import com.github.adamovichas.dto.AuthUser;
import com.github.adamovichas.user.User;
import com.github.adamovichas.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UpdateServlet.class);
    private final IDAOUser daoUser = DAOUser.DAO_USER;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String>userFieldsForUpdate = new HashMap<>();
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        String password = req.getParameter("password");
        userFieldsForUpdate.put("password",password);
        userFieldsForUpdate.put("firstName",req.getParameter("firstName"));
        userFieldsForUpdate.put("lastName",req.getParameter("lastName"));
        userFieldsForUpdate.put("phone",req.getParameter("phone"));
        userFieldsForUpdate.put("email",req.getParameter("email"));
        userFieldsForUpdate.put("country",req.getParameter("country"));
        Utils.UTILS.removeEmptyValue(userFieldsForUpdate);
        if(!userFieldsForUpdate.isEmpty()){
            daoUser.updateUserInfo(authUser.getLogin(),userFieldsForUpdate);
            if(password !=null) {
                resp.addCookie(new Cookie("login", authUser.getLogin() + "/" + password));
            }
            User user = daoUser.getUserByLogin(authUser.getLogin());
            req.setAttribute("user",user);
            req.setAttribute("message","Update is done! ");
            log.info("Updated user {}", user);
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }else {
            req.setAttribute("message","Update is failed! ");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        User user = daoUser.getUserByLogin(authUser.getLogin());
        req.setAttribute("user",user);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
