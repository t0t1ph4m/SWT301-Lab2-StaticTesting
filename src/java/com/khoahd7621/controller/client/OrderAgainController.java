package com.khoahd7621.controller.client;

import com.khoahd7621.util.SendMailUtils;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
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
public class OrderAgainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String orderId = request.getParameter("orderId");
            List<OrderDetail> listOrdersDetail = new OrderDetailDAO().getListOrdersDetail(Integer.parseInt(orderId));
            Map<Integer, Cart> subCarts = new LinkedHashMap<>();
            PlantDAO plantDAO = new PlantDAO();
            for (OrderDetail orderDetail : listOrdersDetail) {
                subCarts.put(orderDetail.getPlantId(), new Cart(plantDAO.getPlant(orderDetail.getPlantId()), orderDetail.getQuantity()));
            }
            
            session.setAttribute("subCarts", subCarts);
            response.sendRedirect("orderAgain.jsp");
        } catch (Exception e) {
            log("Error at OrderAgainController: " + e);
        }
    }

// --Commented out by Inspection START (10/23/2022 9:00 PM):
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
// --Commented out by Inspection START (10/23/2022 9:00 PM):
////            throws ServletException, IOException {
////        processRequest(request, response);
////    }
//// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        try {
//            HttpSession session = request.getSession();
//
//            String name = request.getParameter("name");
//            String phone = request.getParameter("phone");
//            String address = request.getParameter("address");
//            String note = request.getParameter("note").trim();
//            if (note == null || note.isEmpty()) {
//                note = "No notes";
//            }
//
//            Account account = (Account) session.getAttribute("LOGIN_USER");
//
//            // Save all to database
//            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("subCarts");
//            if (carts != null && !carts.isEmpty()) { // Cart is not empty
//                if (account != null) { // User had login
//                    boolean result = new OrderDAO().insertOrder(account.getAccId(), carts, name, phone, address, note);
//                    if (result) {
//                        session.removeAttribute("subCarts");
//                        try {
//                            String subject = "Your order has been processing";
//                            String message = "<!DOCTYPE html>\n"
//                                    + "<html lang=\"en\">\n"
//                                    + "\n"
//                                    + "<head>\n"
//                                    + "</head>\n"
//                                    + "\n"
//                                    + "<body>\n"
//                                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
//                                    + "\n"
//                                    + "</body>\n"
//                                    + "\n"
//                                    + "</html>";
//                            SendMailUtils.send(account.getEmail(), subject, message);
//                        } catch (Exception e) {
//                            log("Error occur when send mail to user after place order sucessfully!");
//                        }
//                        request.setAttribute("MSG_SUCCESS", "Your reorder successfully!");
//                        request.getRequestDispatcher("UserViewOrderController").forward(request, response);
//                    } else {
//                        request.setAttribute("MSG_ERROR", "These products are out of stock!");
//                        request.getRequestDispatcher("UserViewOrderController").forward(request, response);
//                    }
//                } else {
//                    response.sendRedirect("HomeController");
//                }
//            } else {
//                response.sendRedirect("HomeController");
// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
            }
        } catch (Exception e) {
            log("Error at CheckoutController: " + e);
        }
    }

}
