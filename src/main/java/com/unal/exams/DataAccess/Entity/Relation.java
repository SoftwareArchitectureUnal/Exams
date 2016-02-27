/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresGutierrez
 */
@Entity
@Table(name = "Relation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relation.findAll", query = "SELECT r FROM Relation r"),
    @NamedQuery(name = "Relation.findByRelationId", query = "SELECT r FROM Relation r WHERE r.relationId = :relationId"),
    @NamedQuery(name = "Relation.findByIdUser", query = "SELECT r FROM Relation r WHERE r.idUser = :idUser"),
    @NamedQuery(name = "Relation.findByIdExam", query = "SELECT r FROM Relation r WHERE r.idExam = :idExam"),
    @NamedQuery(name = "Relation.findByApproved", query = "SELECT r FROM Relation r WHERE r.approved = :approved"),
    @NamedQuery(name = "Relation.findByState", query = "SELECT r FROM Relation r WHERE r.state = :state")})
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relationId")
    private Integer relationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idUser")
    private String idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExam")
    private int idExam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private int approved;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state")
    private String state;

    public Relation() {
    }

    public Relation(Integer relationId) {
        this.relationId = relationId;
    }

    public Relation(Integer relationId, String idUser, int idExam, int approved, String state) {
        this.relationId = relationId;
        this.idUser = idUser;
        this.idExam = idExam;
        this.approved = approved;
        this.state = state;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationId != null ? relationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation)) {
            return false;
        }
        Relation other = (Relation) object;
        if ((this.relationId == null && other.relationId != null) || (this.relationId != null && !this.relationId.equals(other.relationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unal.exams.DataAccess.Entity.Relation[ relationId=" + relationId + " ]";
    }
    
}
