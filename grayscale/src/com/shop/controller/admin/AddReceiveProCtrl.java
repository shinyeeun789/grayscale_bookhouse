package com.shop.controller.admin;

import com.shop.dto.Receive;
import com.shop.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AddReceivePro.do")
public class AddReceiveProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        String home = application.getContextPath();

        Receive rec = new Receive();
        rec.setPno(Integer.parseInt(request.getParameter("pno")));
        rec.setAmount(Integer.parseInt(request.getParameter("amount")));
        rec.setRprice(Integer.parseInt(request.getParameter("rprice")));

        ProductDAO dao = new ProductDAO();
        int cnt = dao.addReceive(rec);
        if (cnt > 0) {
            response.sendRedirect(home + "/AdminProList.do");
        } else {
            response.sendRedirect(home + "/AddReceive.do");
        }
    }
}
