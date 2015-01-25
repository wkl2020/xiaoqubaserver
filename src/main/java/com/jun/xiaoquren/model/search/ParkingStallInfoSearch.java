package com.jun.xiaoquren.model.search;

import java.math.BigDecimal;


public class ParkingStallInfoSearch {
	
	private Integer xiaoquId;
	
	private Integer rows = 10;
	private Integer page = 1;
	private String sidx = "create_date";
	private String sord = "desc";
	
	private Integer pageSize = 10;
	private Integer offset = 0;
	
	private String supplyDemandType;
    private String yourIdentity;
    private BigDecimal price;
    private BigDecimal areaMeasure;
    

	public Integer getPageSize() {
		pageSize = rows;
		return pageSize;
	}

	public Integer getOffset() {
		offset = rows * (page-1);
		return offset;
	}
    
	public Integer getXiaoquId() {
		return xiaoquId;
	}
	public void setXiaoquId(Integer xiaoquId) {
		this.xiaoquId = xiaoquId;
	}
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	public String getSupplyDemandType() {
		return supplyDemandType;
	}
	public void setSupplyDemandType(String supplyDemandType) {
		this.supplyDemandType = supplyDemandType;
	}
	
	public String getYourIdentity() {
		return yourIdentity;
	}
	
	public void setYourIdentity(String yourIdentity) {
		this.yourIdentity = yourIdentity;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getAreaMeasure() {
		return areaMeasure;
	}
	public void setAreaMeasure(BigDecimal areaMeasure) {
		this.areaMeasure = areaMeasure;
	}
	
}
