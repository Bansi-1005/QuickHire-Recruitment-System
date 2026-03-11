/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickhire.resources;

import EJB.CandidateEJBLocal;
import Entity.*;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.Collection;

/**
 *
 * @author tejan
 */
@Path("Candidate")
public class CandidateResource {
    @EJB CandidateEJBLocal ejb;
    
    // Login
    @GET
    @Path("candidateLogin")
    @Produces("application/json")
    public Tblusers candidateLogin(@QueryParam("email") String email, @QueryParam("password") String password, @QueryParam("roleId") int roleId) {
        try {
            return ejb.candidateLogin(email, password, roleId);
        } catch (Exception e) {
            return null;
        }   
    }

//    public void registerCandidate(Tblusers user, Tblcandidates candidate) {
//        try {
//            em.persist(user);
//            candidate.setUserId(user);
//            em.persist(candidate);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @GET
    @Produces("application/json")
    @Path("getCandidateProfile") 
    public Tblcandidates getCandidateProfile(@QueryParam("userId") int userId) { 
        try {
            return ejb.getCandidateProfile(userId);
        } catch (Exception e) {
            return null;
        }
    }

//    public void updateCandidateProfile(Tblcandidates candidate) {
//        try {
//            em.merge(candidate);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void uploadResume(int candidateId, String resumePath) {
//        try {
//            Tblcandidates c = em.find(Tblcandidates.class, candidateId);
//            c.setCandidateResume(resumePath);
//            em.merge(c);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getCandidateResume(int candidateId) {
//        try {
//            Tblcandidates c = em.find(Tblcandidates.class, candidateId);
//            return c.getCandidateResume();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public void addCandidateSkill(Tblcandidateskills skill) {
//        try {
//            em.persist(skill);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateCandidateSkill(Tblcandidateskills skill) {
//        try {
//            em.merge(skill);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteCandidateSkill(int candidateSkillId) {
//        try {
//            Tblcandidateskills s = em.find(Tblcandidateskills.class, candidateSkillId);
//            em.remove(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Collection<Tblcandidateskills> getCandidateSkills(int candidateId) {
//        try {
//            return em.createNamedQuery("Tblcandidateskills.findByCandidate", Tblcandidateskills.class)
//                    .setParameter("cid", candidateId)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Collection<Tbljob> getAllJobs() {
//        try {
//            return em.createNamedQuery("Tbljob.findAllOpen", Tbljob.class)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Collection<Tbljob> searchJobsByLocation(String location) {
//        try {
//            return em.createNamedQuery("Tbljob.findByLocation", Tbljob.class)
//                    .setParameter("loc", location)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Collection<Tbljob> searchJobsBySkill(String skill) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public void applyForJob(Tblapplication application) {
//        try {
//            em.persist(application);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Collection<Tblapplication> getCandidateApplications(int candidateId) {
//        try {
//            return em.createNamedQuery("Tblapplication.findByCandidate", Tblapplication.class)
//                    .setParameter("cid", candidateId)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Tblapplication getApplicationDetails(int applicationId) {
//        try {
//            return em.find(Tblapplication.class, applicationId);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public String getApplicationStatus(int applicationId) {
//        try {
//            Tblapplication a = em.find(Tblapplication.class, applicationId);
//            return a.getApplicationStatus();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Tblscreeningscore getScreeningScore(int applicationId) {
//        try {
//            return em.createNamedQuery("Tblscreeningscore.findByApplication", Tblscreeningscore.class)
//                    .setParameter("aid", applicationId)
//                    .getSingleResult();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Collection<Tblinterview> getCandidateInterviews(int applicationId) {
//        try {
//            return em.createNamedQuery("Tblinterview.findByApplication", Tblinterview.class)
//                    .setParameter("aid", applicationId)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public Collection<Tblnotification> getCandidateNotifications(int userId) {
//        try {
//            return em.createNamedQuery("Tblnotification.findByUser", Tblnotification.class)
//                    .setParameter("uid", userId)
//                    .getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//    }  
}
