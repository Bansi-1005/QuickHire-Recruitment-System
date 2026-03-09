/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author tejan
 */
@Entity
@Table(name = "tblcandidateskills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcandidateskills.findAll", query = "SELECT t FROM Tblcandidateskills t"),
    @NamedQuery(name = "Tblcandidateskills.findByCandidateSkillId", query = "SELECT t FROM Tblcandidateskills t WHERE t.candidateSkillId = :candidateSkillId"),
    @NamedQuery(name = "Tblcandidateskills.findBySkillLevel", query = "SELECT t FROM Tblcandidateskills t WHERE t.skillLevel = :skillLevel")})
public class Tblcandidateskills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "candidateSkillId")
    private Integer candidateSkillId;
    @Size(max = 50)
    @Column(name = "skillLevel")
    private String skillLevel;
    @JoinColumn(name = "candidateId", referencedColumnName = "candidateId")
    @ManyToOne
    private Tblcandidates candidateId;
    @JoinColumn(name = "skillId", referencedColumnName = "skillId")
    @ManyToOne
    private Tblskills skillId;

    public Tblcandidateskills() {
    }

    public Tblcandidateskills(Integer candidateSkillId) {
        this.candidateSkillId = candidateSkillId;
    }

    public Integer getCandidateSkillId() {
        return candidateSkillId;
    }

    public void setCandidateSkillId(Integer candidateSkillId) {
        this.candidateSkillId = candidateSkillId;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Tblcandidates getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Tblcandidates candidateId) {
        this.candidateId = candidateId;
    }

    public Tblskills getSkillId() {
        return skillId;
    }

    public void setSkillId(Tblskills skillId) {
        this.skillId = skillId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateSkillId != null ? candidateSkillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcandidateskills)) {
            return false;
        }
        Tblcandidateskills other = (Tblcandidateskills) object;
        if ((this.candidateSkillId == null && other.candidateSkillId != null) || (this.candidateSkillId != null && !this.candidateSkillId.equals(other.candidateSkillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tblcandidateskills[ candidateSkillId=" + candidateSkillId + " ]";
    }
    
}
