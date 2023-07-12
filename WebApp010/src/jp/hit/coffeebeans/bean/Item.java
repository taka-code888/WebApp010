package jp.hit.coffeebeans.bean;

/*
 * itemsテーブルのレコード毎の情報を保持するクラス
 */

public class Item {
	
	// 商品ID
	private int id;
	
	// 商品名
	private String name;
	
	// 原産地域
	private String area;
	
	// 原産国
	private String originalHome;
	
	/*
	 * Getter / Setter
	 */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOriginalHome() {
		return originalHome;
	}

	public void setOriginalHome(String originalHome) {
		this.originalHome = originalHome;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 価格
	private int price;
	
	

}
