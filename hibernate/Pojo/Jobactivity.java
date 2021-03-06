package com.directv.mlb.pojo;

// Generated Dec 16, 2014 5:06:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Jobactivity generated by hbm2java
 */
@Entity
@Table(name = "JOBACTIVITY", uniqueConstraints = { @UniqueConstraint(columnNames = "JOBACTIVITY"),
        @UniqueConstraint(columnNames = "JOBACTIVITYCODE") })
@SequenceGenerator(name = "S_JOBACTIVITYID", sequenceName = "S_JOBACTIVITYID")
public class Jobactivity implements java.io.Serializable {

    private Integer jobactivityid;

    private Date timestamp;

    private String jobactivity;

    private String jobactivitycode;

    private String description;

    private Date created;

    private String createdby;

    private Date updated;

    private String updatedby;

    private Set<Jobrole> jobroles = new HashSet<Jobrole>(0);

    public Jobactivity() {
    }

    @Id
    @Column(name = "JOBACTIVITYID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_JOBACTIVITYID")
    public Integer getJobactivityid() {
        return this.jobactivityid;
    }

    public void setJobactivityid(Integer jobactivityid) {
        this.jobactivityid = jobactivityid;
    }

    @Version
    @Column(name = "TIMESTAMP", nullable = false)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "JOBACTIVITY", unique = true, nullable = false, length = 240)
    public String getJobactivity() {
        return this.jobactivity;
    }

    public void setJobactivity(String jobactivity) {
        this.jobactivity = jobactivity;
    }

    @Column(name = "JOBACTIVITYCODE", unique = true, nullable = false, length = 80)
    public String getJobactivitycode() {
        return this.jobactivitycode;
    }

    public void setJobactivitycode(String jobactivitycode) {
        this.jobactivitycode = jobactivitycode;
    }

    @Column(name = "DESCRIPTION", nullable = false, length = 1020)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED", nullable = false, length = 7)
    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "CREATEDBY", nullable = false, length = 240)
    public String getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED", nullable = false, length = 7)
    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Column(name = "UPDATEDBY", nullable = false, length = 240)
    public String getUpdatedby() {
        return this.updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "jobactivities")
    public Set<Jobrole> getJobroles() {
        return this.jobroles;
    }

    public void setJobroles(Set<Jobrole> jobroles) {
        this.jobroles = jobroles;
    }

}
