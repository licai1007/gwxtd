package com.gwxtd.core.pojo;

import java.io.Serializable;

public class OrderGoods implements Serializable {
    /**
     * 订单明细表ID
     */
    private Integer ogid;

    /**
     * 订单号
     */
    private Integer oid;

    /**
     * 订购人ID
     */
    private Integer uid;

    /**
     * 商品ID
     */
    private Integer gid;

    /**
     * 商品数量
     */
    private Integer ogamount;

    /**
     * 商品总价
     */
    private Double ogtotalprice;
    //商品名称
    private String gname;

    public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	private static final long serialVersionUID = 1L;

    public Integer getOgid() {
        return ogid;
    }

    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getOgamount() {
        return ogamount;
    }

    public void setOgamount(Integer ogamount) {
        this.ogamount = ogamount;
    }

    public Double getOgtotalprice() {
        return ogtotalprice;
    }

    public void setOgtotalprice(Double ogtotalprice) {
        this.ogtotalprice = ogtotalprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ogid=").append(ogid);
        sb.append(", oid=").append(oid);
        sb.append(", uid=").append(uid);
        sb.append(", gid=").append(gid);
        sb.append(", ogamount=").append(ogamount);
        sb.append(", ogtotalprice=").append(ogtotalprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}