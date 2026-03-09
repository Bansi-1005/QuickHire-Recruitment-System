/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author RINKAL
 */
@Stateless
public class AdminEJB implements AdminEJBLocal {
    @PersistenceContext(unitName="jpu")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

//    @Override
//    public Tblusers adminLogin(String email, String password) {
//         try {
//            return em.createNamedQuery("Tblusers.adminLogin", Tblusers.class)
//                    .setParameter("email", email)
//                    .setParameter("password", password)
//                    .getSingleResult();
//        } catch(Exception e){
//            return null;
//        }
//    }

    @Override
    public void addRole(Tblrolemaster role) {
        try {
            em.persist(role);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(Tblrolemaster role) {
        try {
            em.merge(role);
        } catch(Exception e){
            e.printStackTrace();
        }    
    }

    @Override
    public void deleteRole(int roleId) {
       try {
            Tblrolemaster r = em.find(Tblrolemaster.class, roleId);
            if(r != null){
                em.remove(r);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Tblrolemaster> getAllRoles() {
        try {
            return em.createNamedQuery("Tblrolemaster.findAll", Tblrolemaster.class)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
        // ---------- Users ----------

    @Override
    public Collection<Tblusers> getAllUsers() {
        try {
            return em.createNamedQuery("Tblusers.findAll", Tblusers.class)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tblusers getUserById(int userId) {
        try {
            return em.createNamedQuery("Tblusers.findByUserId", Tblusers.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUserStatus(int userId, String status) {
        try {
            Tblusers u = em.find(Tblusers.class, userId);
            if(u != null){
                u.setUserStatus(status);
                em.merge(u);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            Tblusers u = em.find(Tblusers.class, userId);
            if(u != null){
                em.remove(u);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // ---------- Company ----------

    @Override
    public void addCompany(Tblcompany company) {
         try {
            em.persist(company);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(Tblcompany company) {
        try {
            em.merge(company);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(int companyId) {
        try {
            Tblcompany c = em.find(Tblcompany.class, companyId);
            if(c != null){
                em.remove(c);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Tblcompany> getAllCompanies() {
        try {
            return em.createNamedQuery("Tblcompany.findAll", Tblcompany.class)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
        // ---------- Jobs ----------

    @Override
    public Collection<Tbljob> getAllJobs() {
        try {
            return em.createNamedQuery("Tbljob.findAll", Tbljob.class)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tbljob getJobById(int jobId) {
        try {
            return em.createNamedQuery("Tbljob.findByJobId", Tbljob.class)
                    .setParameter("jobId", jobId)
                    .getSingleResult();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateJobStatus(int jobId, String status) {
         try {
            Tbljob j = em.find(Tbljob.class, jobId);
            if(j != null){
                j.setJobStatus(status);
                em.merge(j);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

        // ---------- Applications ----------

    @Override
    public Collection<Tblapplication> getAllApplications() {
        try {
            return em.createNamedQuery("Tblapplication.findAll", Tblapplication.class)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tblapplication getApplicationById(int applicationId) {
        try {
            return em.createNamedQuery("Tblapplication.findById", Tblapplication.class)
                    .setParameter("applicationId", applicationId)
                    .getSingleResult();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

        // ---------- Notification ----------
    @Override
    public void sendNotification(Tblnotification notification) {
         try {
            em.persist(notification);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Tblnotification> getUserNotifications(int userId) {
         try {
            return em.createNamedQuery("Tblnotification.findByUser", Tblnotification.class)
                    .setParameter("uid", userId)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

        // ---------- Analytics ----------
    @Override
    public int getTotalUsers() {
        try {
            Long count = em.createNamedQuery("Tblusers.countUsers", Long.class)
                    .getSingleResult();
            return count.intValue();
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getTotalJobs() {
        try {
            Long count = em.createNamedQuery("Tbljob.countJobs", Long.class)
                    .getSingleResult();
            return count.intValue();
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getTotalApplications() {
        try {
            Long count = em.createNamedQuery("Tblapplication.countApplications", Long.class)
                    .getSingleResult();
            return count.intValue();
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getTotalCandidates() {
         try {
            Long count = em.createNamedQuery("Tblcandidates.countCandidates", Long.class)
                    .getSingleResult();
            return count.intValue();
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
}
