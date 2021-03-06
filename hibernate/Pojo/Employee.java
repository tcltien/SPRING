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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@SequenceGenerator(name = "S_EMPLOYEEID", sequenceName = "S_EMPLOYEEID")
public class Employee implements java.io.Serializable {

    private Integer employeeid;

    private Date timestamp;

    private String status;

    private String firstname;

    private String middleinitial;

    private String lastname;

    private String email;

    private String username;

    private String password;

    private Date created;

    private String createdby;

    private Date updated;

    private String updatedby;

    private Set<Jobrole> jobroles = new HashSet<Jobrole>(0);

    public Employee() {
    }

    @Id
    @Column(name = "EMPLOYEEID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_EMPLOYEEID")
    public Integer getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    @Version
    @Column(name = "TIMESTAMP", nullable = false)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "STATUS", nullable = false, length = 32)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "FIRSTNAME", nullable = false, length = 240)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "MIDDLEINITIAL", nullable = false, length = 240)
    public String getMiddleinitial() {
        return this.middleinitial;
    }

    public void setMiddleinitial(String middleinitial) {
        this.middleinitial = middleinitial;
    }

    @Column(name = "LASTNAME", nullable = false, length = 240)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "EMAIL", nullable = false, length = 320)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "USERNAME", unique = true, nullable = false, length = 240)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", nullable = false, length = 128)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEEJOBROLE", joinColumns = { @JoinColumn(name = "EMPLOYEEID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "JOBROLEID", nullable = false, updatable = false) })
    public Set<Jobrole> getJobroles() {
        return this.jobroles;
    }

    public void setJobroles(Set<Jobrole> jobroles) {
        this.jobroles = jobroles;
    }

}
