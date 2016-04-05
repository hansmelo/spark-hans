package br.com.hans;

public class Bus {

	private String code;
	private String lineDesc;
	private String lineName;
	private String latitude;
	private String longitude;
	
	public Bus(String code, String lineName, String lineDesc, String latitude, String longitude) {
		super();
		this.code = code;
		this.lineDesc = lineDesc;
		this.lineName = lineName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLineDesc() {
		return lineDesc;
	}

	public void setLineDesc(String lineDesc) {
		this.lineDesc = lineDesc;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
		
}
