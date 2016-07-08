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
 * Game generated by hbm2java
 */
@Entity
@Table(name = "GAME")
@SequenceGenerator(name = "S_GAMEID", sequenceName = "S_GAMEID")
public class Game implements java.io.Serializable {

    private Integer gameid;

    private Date timestamp;

    private Team teamByHometeamid;

    private Team teamByAwayteamid;

    private Channel channelByHdchannelid;

    private Channel channelBySdchannelid;

    private Routersource routersourceBySdroutersourceid;

    private Routersource routersourceByHdroutersourceid;

    private Date startdate;

    private String league;

    private String videostate;

    private String interactivemode;

    private Boolean incommercial;

    private String bonuscamstatus;

    private String datastatus;

    private String calendarhighlight;

    private Date created;

    private String createdby;

    private Date updated;

    private String updatedby;

    private Set<Gamedetail> gamedetails = new HashSet<Gamedetail>(0);

    private Set<Gamemixelement> gamemixelements = new HashSet<Gamemixelement>(0);

    public Game() {
    }

    @Id
    @Column(name = "GAMEID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_GAMEID")
    public Integer getGameid() {
        return this.gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    @Version
    @Column(name = "TIMESTAMP", nullable = false)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOMETEAMID", nullable = false)
    public Team getTeamByHometeamid() {
        return this.teamByHometeamid;
    }

    public void setTeamByHometeamid(Team teamByHometeamid) {
        this.teamByHometeamid = teamByHometeamid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AWAYTEAMID", nullable = false)
    public Team getTeamByAwayteamid() {
        return this.teamByAwayteamid;
    }

    public void setTeamByAwayteamid(Team teamByAwayteamid) {
        this.teamByAwayteamid = teamByAwayteamid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HDCHANNELID")
    public Channel getChannelByHdchannelid() {
        return this.channelByHdchannelid;
    }

    public void setChannelByHdchannelid(Channel channelByHdchannelid) {
        this.channelByHdchannelid = channelByHdchannelid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SDCHANNELID")
    public Channel getChannelBySdchannelid() {
        return this.channelBySdchannelid;
    }

    public void setChannelBySdchannelid(Channel channelBySdchannelid) {
        this.channelBySdchannelid = channelBySdchannelid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SDROUTERSOURCEID")
    public Routersource getRoutersourceBySdroutersourceid() {
        return this.routersourceBySdroutersourceid;
    }

    public void setRoutersourceBySdroutersourceid(Routersource routersourceBySdroutersourceid) {
        this.routersourceBySdroutersourceid = routersourceBySdroutersourceid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HDROUTERSOURCEID")
    public Routersource getRoutersourceByHdroutersourceid() {
        return this.routersourceByHdroutersourceid;
    }

    public void setRoutersourceByHdroutersourceid(Routersource routersourceByHdroutersourceid) {
        this.routersourceByHdroutersourceid = routersourceByHdroutersourceid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE", nullable = false, length = 7)
    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Column(name = "LEAGUE", nullable = false, length = 8)
    public String getLeague() {
        return this.league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Column(name = "VIDEOSTATE", nullable = false, length = 240)
    public String getVideostate() {
        return this.videostate;
    }

    public void setVideostate(String videostate) {
        this.videostate = videostate;
    }

    @Column(name = "INTERACTIVEMODE", nullable = false, length = 36)
    public String getInteractivemode() {
        return this.interactivemode;
    }

    public void setInteractivemode(String interactivemode) {
        this.interactivemode = interactivemode;
    }

    @Column(name = "INCOMMERCIAL", nullable = false)
    public Boolean getIncommercial() {
        return this.incommercial;
    }

    public void setIncommercial(Boolean incommercial) {
        this.incommercial = incommercial;
    }

    @Column(name = "BONUSCAMSTATUS", nullable = false, length = 32)
    public String getBonuscamstatus() {
        return this.bonuscamstatus;
    }

    public void setBonuscamstatus(String bonuscamstatus) {
        this.bonuscamstatus = bonuscamstatus;
    }

    @Column(name = "DATASTATUS", nullable = false, length = 32)
    public String getDatastatus() {
        return this.datastatus;
    }

    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus;
    }

    @Column(name = "CALENDARHIGHLIGHT", nullable = false, length = 32)
    public String getCalendarhighlight() {
        return this.calendarhighlight;
    }

    public void setCalendarhighlight(String calendarhighlight) {
        this.calendarhighlight = calendarhighlight;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    public Set<Gamedetail> getGamedetails() {
        return this.gamedetails;
    }

    public void setGamedetails(Set<Gamedetail> gamedetails) {
        this.gamedetails = gamedetails;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    public Set<Gamemixelement> getGamemixelements() {
        return this.gamemixelements;
    }

    public void setGamemixelements(Set<Gamemixelement> gamemixelements) {
        this.gamemixelements = gamemixelements;
    }

}
