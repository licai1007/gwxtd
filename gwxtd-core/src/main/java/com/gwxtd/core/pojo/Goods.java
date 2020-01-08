package com.gwxtd.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    /**
     * 商品ID
     */
    private Integer gid;

    /**
     * 商品名称
     */
    private String gname;

    /**
     * 商品价格
     */
    private Double gprice;

    /**
     * 商品类别
     */
    private String gclass;

    /**
     * 商品数量
     */
    private Integer gamount;

    /**
     * 上架日期
     */
    private Date gdate;

    /**
     * 图片url
     */
    private String gimgurl;

    /**
     * 商品浏览量
     */
    private Integer glook;
    /**
     * 商品说明
     */
    private String gintro;
    /**
     * 商品简介
     */
    private String gbrief;
    //购买数量
    private Integer buynum;
    
    private int favcomRate;//好评率
    
    private String imgUrls;//多张图片
    
    private int ifSaleOneself;//是否自营
    
    private String typeList;//版本
    
    private long recomProductId;//推荐商品id
    
    private String recomProduct;//推荐商品标题
    
    private Integer sid;
    private String storeName;
    
    public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}

	public int getIfSaleOneself() {
		return ifSaleOneself;
	}

	public void setIfSaleOneself(int ifSaleOneself) {
		this.ifSaleOneself = ifSaleOneself;
	}

	public String getTypeList() {
		return typeList;
	}

	public void setTypeList(String typeList) {
		this.typeList = typeList;
	}

	public long getRecomProductId() {
		return recomProductId;
	}

	public void setRecomProductId(long recomProductId) {
		this.recomProductId = recomProductId;
	}

	public String getRecomProduct() {
		return recomProduct;
	}

	public void setRecomProduct(String recomProduct) {
		this.recomProduct = recomProduct;
	}

	public void setGbrief(String gbrief) {
		this.gbrief = gbrief;
	}

	public int getFavcomRate() {
		return favcomRate;
	}

	public void setFavcomRate(int favcomRate) {
		this.favcomRate = favcomRate;
	}

	public Integer getBuynum() {
		return buynum;
	}

	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}

	private static final long serialVersionUID = 1L;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGclass() {
        return gclass;
    }

    public void setGclass(String gclass) {
        this.gclass = gclass == null ? null : gclass.trim();
    }

    public Integer getGamount() {
        return gamount;
    }

    public void setGamount(Integer gamount) {
        this.gamount = gamount;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    public String getGimgurl() {
        return gimgurl;
    }

    public void setGimgurl(String gimgurl) {
        this.gimgurl = gimgurl == null ? null : gimgurl.trim();
    }

    public Integer getGlook() {
        return glook;
    }

    public void setGlook(Integer glook) {
        this.glook = glook;
    }
    
    public String getGintro()
	{//得到商品的信息说明
		String info = "";
		String[] msg = gintro.split("\\|");
		for(String temp:msg)
		{
			info = info+temp+"   ";
		}
		return info;
	}
    
    public void setGintro(String gintro){
    	this.gintro = gintro;
    }
    
    public String getGbrief(){
    	return gbrief;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gid=").append(gid);
        sb.append(", gname=").append(gname);
        sb.append(", gprice=").append(gprice);
        sb.append(", gclass=").append(gclass);
        sb.append(", gamount=").append(gamount);
        sb.append(", gdate=").append(gdate);
        sb.append(", gimgurl=").append(gimgurl);
        sb.append(", glook=").append(glook);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}