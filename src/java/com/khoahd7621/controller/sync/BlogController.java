package com.khoahd7621.controller.sync;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KhoaHD7621
 */
@SuppressWarnings("SameReturnValue")
public class BlogController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Map<Integer, String> listBlogCategories = new BlogCategoryDAO().getRandomNBlogCategories(10);
            Map<Integer, String> listBlogTags = new TagsDAO().getRandomNTags(10);
            List<Blog> listBlogs = new BlogDAO().getRandomNBlogs(3);
            List<Plant> listPlants = new PlantDAO().getRandomNPlants(4);
            
            request.setAttribute("listBlogs", listBlogs);
            request.setAttribute("listPlants", listPlants);
            request.getSession().setAttribute("listBlogCategories", listBlogCategories);
            request.getSession().setAttribute("listBlogTags", listBlogTags);
            request.getSession().setAttribute("destPage", "blog");
            request.getRequestDispatcher("blog.jsp").forward(request, response);
        } catch (Exception e) {
            log("Error at BlogController");
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
