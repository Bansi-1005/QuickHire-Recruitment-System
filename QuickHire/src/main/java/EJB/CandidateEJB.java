/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author tejan
 */
@Stateless
public class CandidateEJB implements CandidateEJBLocal {
    
    @PersistenceContext(unitName = "jpu")
    EntityManager em;

    @Override
    public Tblusers candidateLogin(String email, String password, int roleId) {
        try {
            return em.createNamedQuery("Tblusers.loginByRole", Tblusers.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .setParameter("roleId", roleId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }   
    }

    @Override
    public void registerCandidate(Tblusers user, Tblcandidates candidate) {
        try {
            em.persist(user);
            candidate.setUserId(user);
            em.persist(candidate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tblcandidates getCandidateProfile(int userId) {
         try {
            return em.createNamedQuery("Tblcandidates.findByUser", Tblcandidates.class)
                    .setParameter("uid", userId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateCandidateProfile(Tblcandidates candidate) {
        try {
            em.merge(candidate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadResume(int candidateId, String resumePath) {
        try {
            Tblcandidates c = em.find(Tblcandidates.class, candidateId);
            c.setCandidateResume(resumePath);
            em.merge(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCandidateResume(int candidateId) {
        try {
            Tblcandidates c = em.find(Tblcandidates.class, candidateId);
            return c.getCandidateResume();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addCandidateSkill(Tblcandidateskills skill) {
        try {
            em.persist(skill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCandidateSkill(Tblcandidateskills skill) {
        try {
            em.merge(skill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCandidateSkill(int candidateSkillId) {
        try {
            Tblcandidateskills s = em.find(Tblcandidateskills.class, candidateSkillId);
            em.remove(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Tblcandidateskills> getCandidateSkills(int candidateId) {
        try {
            return em.createNamedQuery("Tblcandidateskills.findByCandidate", Tblcandidateskills.class)
                    .setParameter("cid", candidateId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Tbljob> getAllJobs() {
        try {
            return em.createNamedQuery("Tbljob.findAllOpen", Tbljob.class)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Tbljob> searchJobsByLocation(String location) {
        try {
            return em.createNamedQuery("Tbljob.findByLocation", Tbljob.class)
                    .setParameter("loc", location)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Tbljob> searchJobsBySkill(String skill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void applyForJob(Tblapplication application) {
        try {
            em.persist(application);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Tblapplication> getCandidateApplications(int candidateId) {
        try {
            return em.createNamedQuery("Tblapplication.findByCandidate", Tblapplication.class)
                    .setParameter("cid", candidateId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Tblapplication getApplicationDetails(int applicationId) {
        try {
            return em.find(Tblapplication.class, applicationId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getApplicationStatus(int applicationId) {
        try {
            Tblapplication a = em.find(Tblapplication.class, applicationId);
            return a.getApplicationStatus();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Tblscreeningscore getScreeningScore(int applicationId) {
        try {
            return em.createNamedQuery("Tblscreeningscore.findByApplication", Tblscreeningscore.class)
                    .setParameter("aid", applicationId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Tblinterview> getCandidateInterviews(int applicationId) {
        try {
            return em.createNamedQuery("Tblinterview.findByApplication", Tblinterview.class)
                    .setParameter("aid", applicationId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Tblnotification> getCandidateNotifications(int userId) {
        try {
            return em.createNamedQuery("Tblnotification.findByUser", Tblnotification.class)
                    .setParameter("uid", userId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }  

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
