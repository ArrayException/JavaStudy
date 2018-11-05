package com.aiuiot.pockergame.model;
/**
 * 扑克牌类
 * 属性：
 *  1、花色 Pattern
 *  2、点数 Figure
 * @author aiuiot
 *
 */
public class Card {
	private String Pattern;
	private String Figure;
	public Card() {
		
	}
	public Card(String pattern, String figure) {
		super();
		Pattern = pattern;
		Figure = figure;
	}
	public String getPattern() {
		return Pattern;
	}
	public void setPattern(String pattern) {
		Pattern = pattern;
	}
	public String getFigure() {
		return Figure;
	}
	public void setFigure(String figure) {
		Figure = figure;
	}
	
	

}
