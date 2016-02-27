/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.DataAccess.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresGutierrez
 */
@Entity
@Table(name = "Exams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exams.findAll", query = "SELECT e FROM Exams e"),
    @NamedQuery(name = "Exams.findByExamId", query = "SELECT e FROM Exams e WHERE e.examId = :examId"),
    @NamedQuery(name = "Exams.findByName", query = "SELECT e FROM Exams e WHERE e.name = :name"),
    @NamedQuery(name = "Exams.findByRealizationDate", query = "SELECT e FROM Exams e WHERE e.realizationDate = :realizationDate"),
    @NamedQuery(name = "Exams.findByExpeditionDate", query = "SELECT e FROM Exams e WHERE e.expeditionDate = :expeditionDate"),
    @NamedQuery(name = "Exams.findByCertificationDate", query = "SELECT e FROM Exams e WHERE e.certificationDate = :certificationDate"),
    @NamedQuery(name = "Exams.findByDescription", query = "SELECT e FROM Exams e WHERE e.description = :description")})
public class Exams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examId")
    private Integer examId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "realizationDate")
    @Temporal(TemporalType.DATE)
    private Date realizationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expeditionDate")
    @Temporal(TemporalType.DATE)
    private Date expeditionDate;
    @Column(name = "certificationDate")
    @Temporal(TemporalType.DATE)
    private Date certificationDate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    public Exams() {
    }

    public Exams(Integer examId) {
        this.examId = examId;
    }

    public Exams(Integer examId, String name, Date realizationDate, Date expeditionDate) {
        this.examId = examId;
        this.name = name;
        this.realizationDate = realizationDate;
        this.expeditionDate = expeditionDate;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }

    public Date getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public Date getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(Date certificationDate) {
        this.certificationDate = certificationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examId != null ? examId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exams)) {
            return false;
        }
        Exams other = (Exams) object;
        if ((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unal.exams.DataAccess.Entity.Exams[ examId=" + examId + " ]";
    }
    
}
