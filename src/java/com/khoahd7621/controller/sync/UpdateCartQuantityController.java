package com.khoahd7621.controller.sync;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KhoaHD7621
 */
public class UpdateCartQuantityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int pid = Integer.parseInt(request.getParameter("pid"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) {
                return;
            }
            HttpSession session = request.getSession();
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }
            if (carts.containsKey(pid)) {
                carts.get(pid).setQuantity(quantity);
            }
            session.setAttribute("carts", carts);

            // Save cookie contain list cart to client
            Cookie[] cookies = request.getCookies();
            // Remove old cookie "cart" from client if it existed
            Cookie cartCookie = null;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("cart")) {
                    cartCookie = cooky;
                    cartCookie.setMaxAge(0);
                    response.addCookie(cartCookie);
                }
                if (cartCookie != null) {
                    break;
                }
            }
            // Convert carts to string for save it to cookie
            StringBuilder cart = new StringBuilder();
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                int plantId = entry.getKey();
                Cart cartEl = entry.getValue();
                if (cart.toString().equals("")) {
                    cart = new StringBuilder(plantId + ":" + cartEl.getQuantity());
                } else {
                    cart.append("-").append(plantId).append(":").append(cartEl.getQuantity());
                }
            }
            Cookie cookieCart = new Cookie("cart", cart.toString());
            cookieCart.setMaxAge(60 * 60 * 24);
            response.addCookie(cookieCart);
        } catch (Exception e) {
            log("Error at UpdateCartQuantityController: " + e);
        } finally {
            response.sendRedirect("CartController");
        }
    }

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
