package com.mmt.model.bean;
import java.io.Serializable;
public class HotelRoom implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelChangedId;
	private int hotelRoomNo;
	private String hotelRoomType;
	private double hotelRoomPrice;
	private String hotelRoomStatus;
	public HotelRoom(String hotelChangedId,int hotelRoomNo, String hotelRoomType, double hotelRoomPrice, String hotelRoomStatus) {
		super();
		this.hotelChangedId=hotelChangedId;
		this.hotelRoomNo = hotelRoomNo;
		this.hotelRoomType = hotelRoomType;
		this.hotelRoomPrice = hotelRoomPrice;
		this.hotelRoomStatus = hotelRoomStatus;
	}
	
	public String getHotelChangedId() {
		return hotelChangedId;
	}

	public void setHotelChangedId(String hotelChangedId) {
		this.hotelChangedId = hotelChangedId;
	}

	public HotelRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHotelRoomNo() {
		return hotelRoomNo;
	}
	public void setHotelRoomNo(int hotelRoomNo) {
		this.hotelRoomNo = hotelRoomNo;
	}
	public String getHotelRoomType() {
		return hotelRoomType;
	}
	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}
	public double getHotelRoomPrice() {
		return hotelRoomPrice;
	}
	public void setHotelRoomPrice(double hotelRoomPrice) {
		this.hotelRoomPrice = hotelRoomPrice;
	}
	public String getHotelRoomStatus() {
		return hotelRoomStatus;
	}
	public void setHotelRoomStatus(String hotelRoomStatus) {
		this.hotelRoomStatus = hotelRoomStatus;
	}

	@Override
	public String toString() {
		return "HotelRoom [hotelChangedId=" + hotelChangedId + ", hotelRoomNo=" + hotelRoomNo + ", hotelRoomType="
				+ hotelRoomType + ", hotelRoomPrice=" + hotelRoomPrice + ", hotelRoomStatus=" + hotelRoomStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelChangedId == null) ? 0 : hotelChangedId.hashCode());
		result = prime * result + hotelRoomNo;
		long temp;
		temp = Double.doubleToLongBits(hotelRoomPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hotelRoomStatus == null) ? 0 : hotelRoomStatus.hashCode());
		result = prime * result + ((hotelRoomType == null) ? 0 : hotelRoomType.hashCode());
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
		HotelRoom other = (HotelRoom) obj;
		if (hotelChangedId == null) {
			if (other.hotelChangedId != null)
				return false;
		} else if (!hotelChangedId.equals(other.hotelChangedId))
			return false;
		if (hotelRoomNo != other.hotelRoomNo)
			return false;
		if (Double.doubleToLongBits(hotelRoomPrice) != Double.doubleToLongBits(other.hotelRoomPrice))
			return false;
		if (hotelRoomStatus == null) {
			if (other.hotelRoomStatus != null)
				return false;
		} else if (!hotelRoomStatus.equals(other.hotelRoomStatus))
			return false;
		if (hotelRoomType == null) {
			if (other.hotelRoomType != null)
				return false;
		} else if (!hotelRoomType.equals(other.hotelRoomType))
			return false;
		return true;
	}
	
	
	
}
