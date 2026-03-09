/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package EJB;

import Entity.*;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author RINKAL
 */
@Local
public interface AdminEJBLocal {
     // ---------- Authentication ----------
//     Tblusers adminLogin(String email, String password);

        // ---------- Role Management ----------
    void addRole(Tblrolemaster role);
    void updateRole(Tblrolemaster role);
    void deleteRole(int roleId);
    Collection<Tblrolemaster> getAllRoles();

    // ---------- User Management ----------
    Collection<Tblusers> getAllUsers();
    Tblusers getUserById(int userId);
    void updateUserStatus(int userId, String status);
    void deleteUser(int userId);

    // ---------- Company Management ----------
    void addCompany(Tblcompany company);
    void updateCompany(Tblcompany company);
    void deleteCompany(int companyId);
    Collection<Tblcompany> getAllCompanies();

    // ---------- Job Monitoring ----------
    Collection<Tbljob> getAllJobs();
    Tbljob getJobById(int jobId);
    void updateJobStatus(int jobId, String status);

    // ---------- Application Monitoring ----------
    Collection<Tblapplication> getAllApplications();
    Tblapplication getApplicationById(int applicationId);

    // ---------- Notification ----------
    void sendNotification(Tblnotification notification);
    Collection<Tblnotification> getUserNotifications(int userId);

    // ---------- Analytics ----------
    int getTotalUsers();
    int getTotalJobs();
    int getTotalApplications();
    int getTotalCandidates();
}
