package jp.hit.coffeebeans.bean;

/*
 * 注文情報を保持するクラス
 */

public class Order {
	
	// 注文ID
	private int id;
	
	// 商品ID
	private int itemId;
	
	// 氏名
	private String name;
	
	// 住所
	private String address;
	
	// 電話番号
	private String telNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	/*
	 * Getter / Setter
	 */
	
	
	

}
