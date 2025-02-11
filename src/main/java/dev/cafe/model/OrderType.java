package dev.cafe.model;

public enum OrderType {
	
	//for_here, to_go
	// 한번에 개수 합산해서 * 500해서 빼주기
	
	FOR_HERE("매장 이용",0), TO_GO("포장",500);
	
	OrderType(String description,int discount) {
		this.description = description;
		this.discount = discount;
	}
	private String description;
	private int discount;
}
