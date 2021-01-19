package com.macd.dto;

public class Customer_DTO {
	private String customerName;
	private Integer PhoneNumber;
	private Order_DTO order;
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Order_DTO getOrder() {
		return order;
	}
	public void setOrder(Order_DTO order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", PhoneNumber=" + PhoneNumber
				+ ", order=" + order + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
		Customer_DTO other = (Customer_DTO) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}
	
	
	
}
