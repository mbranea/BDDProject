package adressManagement;

import java.util.HashMap;

public class AdressInfo {
	private String name;
	private int area_id;
	private int client_id;
	private int cityId;
	private int street_nr;
	private String adress_type;
	
	

public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public AdressInfo(String name, int area_id, int client_id, int street_nr, String adress_type,int cityId) {
		super();
		this.name = name;
		this.area_id = area_id;
		this.client_id = client_id;
		this.street_nr = street_nr;
		this.adress_type = adress_type;
		this.cityId=cityId;
	}
	public int getClient_id() {
		return client_id;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getStreet_nr() {
		return street_nr;
	}
	public void setStreet_nr(int street_nr) {
		this.street_nr = street_nr;
	}
	public String getAdress_type() {
		return adress_type;
	}
	public void setAdress_type(String adress_type) {
		this.adress_type = adress_type;
	}

}
