package com.aiuiot.pockergame.model;
/**
 * 玩家类
 * 属性：id，姓名，手牌（handCard）
 * @author aiuiot
 *
 */

import java.util.List;

public class Player {
	private int Id;
	private String Name;
	private List<Card> handCard;
	public Player() {
		
	}
	public Player(int id, String name, List<Card> handCard) {
		super();
		Id = id;
		Name = name;
		this.handCard = handCard;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Card> getHandCard() {
		return handCard;
	}
	public void setHandCard(List<Card> handCard) {
		this.handCard = handCard;
	}
	
	
	

}
