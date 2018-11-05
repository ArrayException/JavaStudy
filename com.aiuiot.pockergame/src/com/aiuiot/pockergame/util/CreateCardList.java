package com.aiuiot.pockergame.util;

import java.util.ArrayList;
import java.util.List;

import com.aiuiot.pockergame.model.Card;

/**
 * 初始创建扑克牌集合
 * @author aiuiot
 *
 */
public class CreateCardList {
	String[] PatternList = new String[] {"黑桃","红桃","梅花","方块"};
	String[] FigureList = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	/**
	 * 循环两个字符串数组内元素，创建新的扑克集合
	 */
	public List<Card> createCardList() {
		List<Card> cardList = new ArrayList<Card>();
		for(int i = 0; i < PatternList.length;i++) {
			for(int j = 0;j < FigureList.length;j++) {
				cardList.add(new Card(PatternList[i], FigureList[j]));
			}
		}
		return cardList;
	}
	
}
