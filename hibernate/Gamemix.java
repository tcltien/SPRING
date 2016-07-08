package com.directv.mlb.pojo;

// Generated Dec 8, 2014 5:40:41 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Gamemix generated by hbm2java
 */
@Entity
@Table(name = "GAMEMIX")
@SequenceGenerator(name = "S_GAMEMIXID", sequenceName = "S_GAMEMIXID")
public class Gamemix implements java.io.Serializable {

    private Integer gamemixid;

    private Date timestamp;

    private Gamemixgroup gamemixgroup;

    private Short viewerchannel;

    private Date created;

    private String createdby;

    private Date updated;

    private String updatedby;

    private Set<Gamemixelement> gamemixelements = new HashSet<Gamemixelement>(0);

    public Gamemix() {
    }

    @Id
    @Column(name = "GAMEMIXID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_GAMEMIXID")
    public Integer getGamemixid() {
        return this.gamemixid;
    }

    public void setGamemixid(Integer gamemixid) {
        this.gamemixid = gamemixid;
    }

    @Version
    @Column(name = "TIMESTAMP", nullable = false)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAMEMIXGROUPID", nullable = false)
    public Gamemixgroup getGamemixgroup() {
        return this.gamemixgroup;
    }

    public void setGamemixgroup(Gamemixgroup gamemixgroup) {
        this.gamemixgroup = gamemixgroup;
    }

    @Column(name = "VIEWERCHANNEL", nullable = false)
    public Short getViewerchannel() {
        return this.viewerchannel;
    }

    public void setViewerchannel(Short viewerchannel) {
        this.viewerchannel = viewerchannel;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gamemix")
    public Set<Gamemixelement> getGamemixelements() {
        return this.gamemixelements;
    }

    public void setGamemixelements(Set<Gamemixelement> gamemixelements) {
        this.gamemixelements = gamemixelements;
    }

}
