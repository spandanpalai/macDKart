package com.macd.dto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Order_DTO {
	private Integer orderID;
	private Menu orderList;
	
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Menu getOrderList() {
		return orderList;
	}
	public void setOrderList(Menu orderList) {
		this.orderList = orderList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order_DTO other = (Order_DTO) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderList=" + orderList + "]";
	}

	
	
}
