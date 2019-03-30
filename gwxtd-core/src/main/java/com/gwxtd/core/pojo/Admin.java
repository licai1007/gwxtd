package com.gwxtd.core.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    /**
     * 管理员ID
     */
    private Integer aid;

    /**
     * 管理员名
     */
    private String aname;

    /**
     * 管理员密码
     */
    private String apwd;

    /**
     * 管理员级别
     */
    private String alevel;

    private static final long serialVersionUID = 1L;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd == null ? null : apwd.trim();
    }

    public String getAlevel() {
        return alevel;
    }

    public void setAlevel(String alevel) {
        this.alevel = alevel == null ? null : alevel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", aname=").append(aname);
        sb.append(", apwd=").append(apwd);
        sb.append(", alevel=").append(alevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}