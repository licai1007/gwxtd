package com.gwxtd.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    /**
     * 订单号
     */
    private Integer oid;

    /**
     * 订单产生日期
     */
    private Date odate;

    /**
     * 订单处理人ID
     */
    private Integer aid;

    /**
     * 订单发送状态
     */
    private String ostate;

    /**
     * 订单接受者
     */
    private String orecname;

    /**
     * 订单接受者地址
     */
    private String orecadr;

    /**
     * 订单接受者电话
     */
    private String orectel;

    /**
     * 订购人ID
     */
    private Integer uid;

    /**
     * 订购总价
     */
    private Double ototalprice;

    private static final long serialVersionUID = 1L;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate == null ? null : ostate.trim();
    }

    public String getOrecname() {
        return orecname;
    }

    public void setOrecname(String orecname) {
        this.orecname = orecname == null ? null : orecname.trim();
    }

    public String getOrecadr() {
        return orecadr;
    }

    public void setOrecadr(String orecadr) {
        this.orecadr = orecadr == null ? null : orecadr.trim();
    }

    public String getOrectel() {
        return orectel;
    }

    public void setOrectel(String orectel) {
        this.orectel = orectel == null ? null : orectel.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getOtotalprice() {
        return ototalprice;
    }

    public void setOtotalprice(Double ototalprice) {
        this.ototalprice = ototalprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", odate=").append(odate);
        sb.append(", aid=").append(aid);
        sb.append(", ostate=").append(ostate);
        sb.append(", orecname=").append(orecname);
        sb.append(", orecadr=").append(orecadr);
        sb.append(", orectel=").append(orectel);
        sb.append(", uid=").append(uid);
        sb.append(", ototalprice=").append(ototalprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}