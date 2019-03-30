package com.gwxtd.core.pojo;

import java.io.Serializable;

public class GoodsWithBLOBs extends Goods implements Serializable {
    /**
     * 商品说明
     */
    private String gintro;

    /**
     * 商品简介
     */
    private String gbrief;

    private static final long serialVersionUID = 1L;

    public String getGintro() {
        return gintro;
    }

    public void setGintro(String gintro) {
        this.gintro = gintro == null ? null : gintro.trim();
    }

    public String getGbrief() {
        return gbrief;
    }

    public void setGbrief(String gbrief) {
        this.gbrief = gbrief == null ? null : gbrief.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gintro=").append(gintro);
        sb.append(", gbrief=").append(gbrief);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}