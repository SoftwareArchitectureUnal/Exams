/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yeisondavid
 */
@Entity
@Table(name = "exams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exams.findAll", query = "SELECT e FROM Exams e"),
    @NamedQuery(name = "Exams.findByExamId", query = "SELECT e FROM Exams e WHERE e.examId = :examId"),
    @NamedQuery(name = "Exams.findByName", query = "SELECT e FROM Exams e WHERE e.name = :name"),
    @NamedQuery(name = "Exams.findByRealizationDate", query = "SELECT e FROM Exams e WHERE e.realizationDate = :realizationDate"),
    @NamedQuery(name = "Exams.findByExpeditionDate", query = "SELECT e FROM Exams e WHERE e.expeditionDate = :expeditionDate"),
    @NamedQuery(name = "Exams.findByDescription", query = "SELECT e FROM Exams e WHERE e.description = :description")})
public class Exams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "expeditionDate")
    @Temporal(TemporalType.DATE)
    private Date expeditionDate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExam")
    private Collection<Relation> relationCollection;

    public Exams() {
    }

    public Exams(Integer examId) {
        this.examId = examId;
    }

    public Exams(Integer examId, String name, Date realizationDate) {
        this.examId = examId;
        this.name = name;
        this.realizationDate = realizationDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Relation> getRelationCollection() {
        return relationCollection;
    }

    public void setRelationCollection(Collection<Relation> relationCollection) {
        this.relationCollection = relationCollection;
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
