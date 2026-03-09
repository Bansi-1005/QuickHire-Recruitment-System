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
 * @author tejan
 */
@Local
public interface CandidateEJBLocal {
    
    // ---------- Authentication ----------
    Tblusers candidateLogin(String email, String password, int roleId);
    void registerCandidate(Tblusers user, Tblcandidates candidate);

    // ---------- Candidate Profile ----------
    Tblcandidates getCandidateProfile(int userId);
    void updateCandidateProfile(Tblcandidates candidate);

    // ---------- Resume Management ----------
    void uploadResume(int candidateId, String resumePath);
    String getCandidateResume(int candidateId);

    // ---------- Candidate Skills ----------
    void addCandidateSkill(Tblcandidateskills skill);
    void updateCandidateSkill(Tblcandidateskills skill);
    void deleteCandidateSkill(int candidateSkillId);
    Collection<Tblcandidateskills> getCandidateSkills(int candidateId);

    // ---------- Job Search ----------
    Collection<Tbljob> getAllJobs();
    Collection<Tbljob> searchJobsByLocation(String location);
    Collection<Tbljob> searchJobsBySkill(String skill);

    // ---------- Job Application ----------
    void applyForJob(Tblapplication application);
    Collection<Tblapplication> getCandidateApplications(int candidateId);

    // ---------- Application Status ----------
    Tblapplication getApplicationDetails(int applicationId);
    String getApplicationStatus(int applicationId);

    // ---------- Screening Score ----------
    Tblscreeningscore getScreeningScore(int applicationId);

    // ---------- Interview ----------
    Collection<Tblinterview> getCandidateInterviews(int applicationId);

    // ---------- Notifications ----------
    Collection<Tblnotification> getCandidateNotifications(int userId);
}
