package com.shop.controller.custom;

import com.shop.model.CustomDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IdCheck.do")
public class IdCheckCtrl extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomDAO dao = new CustomDAO();
        boolean pass = false;
        pass = dao.idCheck(id);

        JSONObject json = new JSONObject();
        json.put("result", pass);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
    }
}
