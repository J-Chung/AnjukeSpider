package spider.anjuke.model;

public class AnjukeHouseInfo {

	private String id;
	private String province;// 省
	private String city;// 市
	private String region;// 区
	private String floor_area;// 小区
	private String houseInfo;// 房屋信息
	private String housePrice;// 价格
	private String type;// 0 新房 1二手房

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(String housePrice) {
		this.housePrice = housePrice;
	}

	public AnjukeHouseInfo() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFloor_area() {
		return floor_area;
	}

	public void setFloor_area(String floor_area) {
		this.floor_area = floor_area;
	}

	public AnjukeHouseInfo(String id, String province, String city,
			String region, String floor_area, String houseInfo,
			String housePrice, String type) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.region = region;
		this.floor_area = floor_area;
		this.houseInfo = houseInfo;
		this.housePrice = housePrice;
		this.type = type;
	}

	@Override
	public String toString() {
		return "AnjukeHouseInfo [id=" + id + ", province=" + province
				+ ", city=" + city + ", region=" + region + ", floor_area="
				+ floor_area + ", houseInfo=" + houseInfo + ", housePrice="
				+ housePrice + ", type=" + type + "]";
	}

}
