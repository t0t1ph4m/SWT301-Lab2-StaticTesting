package com.khoahd7621.controller.sync;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KhoaHD7621
 */
@SuppressWarnings("SameReturnValue")
public class CartController extends HttpServlet {

// --Commented out by Inspection START (10/23/2022 9:01 PM):
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        response.setContentType("text/html;charset=UTF-8");
//        try {
//            HttpSession session = request.getSession();
//            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
//            if (carts == null) {
//                carts = new LinkedHashMap<>();
//            }
//
//            // Tinh tong tien
//            int totalMoney = 0;
//            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
//                Integer pid = entry.getKey();
//                Cart cart = entry.getValue();
//
//                totalMoney += cart.getQuantity() * cart.getPlant().getPrice();
//            }
//            request.setAttribute("totalMoney", totalMoney);
//            request.setAttribute("carts", carts);
//            session.setAttribute("destPage", "cart");
//        } catch (Exception e) {
//            log("Error at CartController: " + e);
//        } finally {
//            request.getRequestDispatcher("carts.jsp").forward(request, response);
//        }
//    }
// --Commented out by Inspection STOP (10/23/2022 9:01 PM)

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
// --Commented out by Inspection START (10/23/2022 9:00 PM):
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
// --Commented out by Inspection START (10/23/2022 9:00 PM):
////            throws ServletException, IOException {
////        processRequest(request, response);
////    }
//// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
