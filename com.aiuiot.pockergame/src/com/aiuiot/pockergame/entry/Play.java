package com.aiuiot.pockergame.entry;

import java.util.ArrayList;
import java.util.List;

import com.aiuiot.pockergame.model.Card;
import com.aiuiot.pockergame.util.CreateCardList;
import com.aiuiot.pockergame.util.Shuffle;

public class Play {
	/**
	 * 创建扑克牌
	 * @param args
	 */
	public List<Card> testCreateCard() {
		System.out.println("----------创建扑克牌----------");
		//创建扑克牌集合
		CreateCardList ccl = new CreateCardList();
		List<Card> cardList = new ArrayList<Card>();
		cardList = ccl.createCardList();
		
		//输出扑克牌集合
		for (Card card : cardList) {
			System.out.println("扑克牌："+card.getPattern()+""+card.getFigure());
		}
		return cardList;
	}
	
	/**
	 * 洗牌
	 * @param args
	 */
	public void testshuffleCard() {
		CreateCardList ccl = new CreateCardList();
		List<Card> cardList = new ArrayList<Card>();
		cardList = ccl.createCardList();
		System.out.println("----------洗牌----------");
		//List<Card> cardList = new ArrayList<Card>();
		//开始洗牌
		Shuffle shuffleCard = new Shuffle();
		List<Card> newCardList = new ArrayList<Card>();
		newCardList = shuffleCard.shufferCardList(cardList);
		//测试打印洗牌后的顺序
		for (Card card : newCardList) {
			System.out.println("洗牌后："+card.getPattern()+""+card.getFigure());
		}
		System.out.println("----------洗牌结束----------");
	}
	

	
	public static void main(String[] args) {
		Play p = new Play();
		p.testCreateCard();
		p.testshuffleCard();
		

	}

}
