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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author tejan
 */
@Entity
@Table(name = "tbljobskills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbljobskills.findAll", query = "SELECT t FROM Tbljobskills t"),
    @NamedQuery(name = "Tbljobskills.findByJobSkillId", query = "SELECT t FROM Tbljobskills t WHERE t.jobSkillId = :jobSkillId"),
    @NamedQuery(name = "Tbljobskills.findByJobSkillWeightage", query = "SELECT t FROM Tbljobskills t WHERE t.jobSkillWeightage = :jobSkillWeightage")})
public class Tbljobskills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobSkillId")
    private Integer jobSkillId;
    @Column(name = "jobSkillWeightage")
    private Integer jobSkillWeightage;
    @JoinColumn(name = "jobId", referencedColumnName = "jobId")
    @ManyToOne
    private Tbljob jobId;
    @JoinColumn(name = "skillId", referencedColumnName = "skillId")
    @ManyToOne
    private Tblskills skillId;

    public Tbljobskills() {
    }

    public Tbljobskills(Integer jobSkillId) {
        this.jobSkillId = jobSkillId;
    }

    public Integer getJobSkillId() {
        return jobSkillId;
    }

    public void setJobSkillId(Integer jobSkillId) {
        this.jobSkillId = jobSkillId;
    }

    public Integer getJobSkillWeightage() {
        return jobSkillWeightage;
    }

    public void setJobSkillWeightage(Integer jobSkillWeightage) {
        this.jobSkillWeightage = jobSkillWeightage;
    }

    public Tbljob getJobId() {
        return jobId;
    }

    public void setJobId(Tbljob jobId) {
        this.jobId = jobId;
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
        hash += (jobSkillId != null ? jobSkillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbljobskills)) {
            return false;
        }
        Tbljobskills other = (Tbljobskills) object;
        if ((this.jobSkillId == null && other.jobSkillId != null) || (this.jobSkillId != null && !this.jobSkillId.equals(other.jobSkillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tbljobskills[ jobSkillId=" + jobSkillId + " ]";
    }
    
}
