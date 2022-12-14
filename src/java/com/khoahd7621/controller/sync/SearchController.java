package com.khoahd7621.controller.sync;

import java.io.IOException;
import java.util.List;
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
public class SearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            final int PAGE_SIZE = 12;
            
            HttpSession session = request.getSession();
            session.removeAttribute("destPage");
            
            String keyword = request.getParameter("keyword");
            String searchby = request.getParameter("searchby");
            
            String pagenumber = request.getParameter("pagenumber");
            int page = 1;
            if (pagenumber != null) {
                page = Integer.parseInt(pagenumber);
            }
            
            PlantDAO dao = new PlantDAO();
            List<Plant> listPlants = dao.getSearchPlantsWithPaging(keyword, searchby, page, PAGE_SIZE);
            
            if (listPlants.isEmpty()) {
                request.setAttribute("keyword", keyword);
                request.setAttribute("searchby", searchby);
                request.setAttribute("NO_RESULT", "No result");
                session.setAttribute("urlHistory", "SearchController?keyword=" + keyword + "&searchby=" + searchby);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            } else {
                int totalPlants = dao.getTotalPlantsFromSearchKeyword(keyword, searchby);
                int totalPage = totalPlants / PAGE_SIZE;
                if (totalPlants % PAGE_SIZE != 0) {
                    totalPage += 1;
                }
                request.setAttribute("page", page);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("keyword", keyword);
                request.setAttribute("searchby", searchby);
                request.setAttribute("totalPlants", totalPlants);
                request.setAttribute("listPlants", listPlants);
                session.setAttribute("urlHistory", "SearchController?keyword=" + keyword 
                                                 + "&searchby=" + searchby
                                                 + ((pagenumber != null) ? ("&pagenumber=" + pagenumber) : ""));
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }
        } catch (Exception e) {
            log("Error at SearchController: " + e);
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
