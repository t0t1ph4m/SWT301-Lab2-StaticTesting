package com.khoahd7621.controller.admin;

import com.khoahd7621.util.SecurityUtils;
import java.io.IOException;
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
public class AdminInfoController extends HttpServlet {
    
    private static final String ADMIN_PAGE = "admininfo.jsp";

// --Commented out by Inspection START (10/23/2022 9:00 PM):
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        try {
//            response.sendRedirect(ADMIN_PAGE);
// --Commented out by Inspection START (10/23/2022 9:00 PM):
////        } catch (Exception e) {
////            log("Error at AdminInfo: " + e);
////        }
////    }
//// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        try {
//            HttpSession session = request.getSession();
//            Account acc = (Account) session.getAttribute("LOGIN_USER");
//            AccountDAO accDAO = new AccountDAO();
//            if (acc != null) {
//                String action = request.getParameter("action");
//                if (action != null) {
//                    switch (action) {
//                        case "updateInfo":
//                            String name = request.getParameter("name");
//                            String phone = request.getParameter("phone");
//                            boolean check = accDAO.changeAccount(acc.getEmail(), name, phone);
//                            if (check) {
//                                acc = accDAO.getAccountInfoByEmail(acc.getEmail());
//                                session.setAttribute("LOGIN_USER", acc);
//                                request.setAttribute("MSG_SUCCESS", "Update profile information successfully!");
//                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
//                            } else {
//                                request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
//                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
//                            }
//                            break;
//                        case "changePassword":
//                            String oldPassword = SecurityUtils.hashMd5(request.getParameter("oldPassword"));
//                            boolean checkOldPsw = accDAO.checkOldPassword(acc.getAccId(), oldPassword);
//                            if (checkOldPsw) {
//                                String newPasword = SecurityUtils.hashMd5(request.getParameter("newPassword"));
//                                boolean checkNewPsw = accDAO.updateAccountPassword(acc.getAccId(), newPasword);
//                                if (checkNewPsw) {
//                                    request.setAttribute("MSG_SUCCESS", "Change password successfully!");
//                                    request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
//                                } else {
//                                    request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
//                                    request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
//                                }
//                            } else {
//                                request.setAttribute("MSG_ERROR", "You entered the wrong old password! Please try again!");
//                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
//                            }
//                            break;
//                    }
//                } else {
//                    request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
//                    request.getRequestDispatcher("invalid.jsp").forward(request, response);
// --Commented out by Inspection STOP (10/23/2022 9:00 PM)
                }
            }
        } catch (Exception e) {
            log("Error at AdminInfoController: " + e);
        }
    }

}
