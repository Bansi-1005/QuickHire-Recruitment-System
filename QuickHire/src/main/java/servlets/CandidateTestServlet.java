/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import EJB.CandidateEJBLocal;
import Entity.Tblapplication;
import Entity.Tblcandidates;
import Entity.Tblcandidateskills;
import Entity.Tblinterview;
import Entity.Tbljob;
import Entity.Tblnotification;
import Entity.Tblscreeningscore;
import Entity.Tblusers;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 *
 * @author tejan
 */
@WebServlet(name = "CandidateTestServlet", urlPatterns = {"/CandidateTestServlet"})
public class CandidateTestServlet extends HttpServlet {

    @EJB CandidateEJBLocal ejb;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CandidateTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CandidateTestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        try {

            // LOGIN
            if (action.equals("login")) {

                Tblusers user = ejb.candidateLogin(
                        request.getParameter("email"),
                        request.getParameter("password"),
                        Integer.parseInt(request.getParameter("roleId"))
                );

                //out.println(user);
                out.println("User ID: " + user.getUserId() + "<br>");
                out.println("Name: " + user.getUserName() + "<br>");
                out.println("Email: " + user.getUserEmail() + "<br>");
                out.println("Status: " + user.getUserStatus() + "<br>");
            }

            // GET PROFILE
            if (action.equals("profile")) {

                Tblcandidates c = ejb.getCandidateProfile(
                        Integer.parseInt(request.getParameter("userId"))
                );

                out.println(c);
            }

            // GET ALL JOBS
            if (action.equals("jobs")) {

                Collection<Tbljob> jobs = ejb.getAllJobs();

                for (Tbljob j : jobs)
                    out.println(j + "<br>");
            }

            // SEARCH JOB BY LOCATION
            if (action.equals("search")) {

                Collection<Tbljob> jobs =
                        ejb.searchJobsByLocation(request.getParameter("location"));

                for (Tbljob j : jobs)
                    out.println(j + "<br>");
            }

            // GET SKILLS
            if (action.equals("skills")) {

                Collection<Tblcandidateskills> skills =
                        ejb.getCandidateSkills(
                                Integer.parseInt(request.getParameter("candidateId")));

                for (Tblcandidateskills s : skills)
                    out.println(s + "<br>");
            }

            // GET APPLICATIONS
            if (action.equals("applications")) {

                Collection<Tblapplication> apps;
                apps = ejb.getCandidateApplications(
                        Integer.parseInt(request.getParameter("candidateId")));

                for (Tblapplication a : apps)
                    out.println(a + "<br>");
            }

            // GET APPLICATION STATUS
            if (action.equals("status")) {

                String status =
                        ejb.getApplicationStatus(
                                Integer.parseInt(request.getParameter("applicationId")));

                out.println("Status : " + status);
            }

            // GET INTERVIEWS
            if (action.equals("interviews")) {

                Collection<Tblinterview> interviews =
                        ejb.getCandidateInterviews(
                                Integer.parseInt(request.getParameter("applicationId")));

                for (Tblinterview i : interviews)
                    out.println(i + "<br>");
            }

            // GET NOTIFICATIONS
            if (action.equals("notifications")) {

                Collection<Tblnotification> notes =
                        ejb.getCandidateNotifications(
                                Integer.parseInt(request.getParameter("userId")));

                for (Tblnotification n : notes)
                    out.println(n + "<br>");
            }

        } catch (Exception e) {
            out.println("Error : " + e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
