package com.gwxtd.core.pojo;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String upwd;

    /**
     * 用户e-mail
     */
    private String uemail;

    private static final long serialVersionUID = 1L;

    public User() {
		super();
	}

	public User(String uname, String upwd, String uemail) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.uemail = uemail;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", uname=").append(uname);
        sb.append(", upwd=").append(upwd);
        sb.append(", uemail=").append(uemail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}