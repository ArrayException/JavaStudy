package com.aiuiot.pockergame.util;
/**
 * 洗牌类：
 * 1、输入集合cardList
 * 2、通过更改下标打乱顺序后输出新的数列
 * @author aiuiot
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.aiuiot.pockergame.model.Card;

public class Shuffle {
	public List<Card> shufferCardList(List<Card> cardList){
		//获取cardList扑克牌数量
		int cardListLen = cardList.size();
		//创建一个整数包装类型
		List<Integer> ranList = new ArrayList<Integer>();
		//存放随机数
		Integer ranNum;
		//创建循环为集合ranList赋值
		for(int i = 0; i< cardListLen; i++) {
			//生成一个0～cardList-1范围内不重复的随机数
			do {
				Random randon = new Random();
				ranNum = randon.nextInt(cardListLen);
			}while(ranList.contains(ranNum));
			ranList.add(ranNum);
		}
		//创建更改完顺序的新集合并返回
		List<Card> newCardList = new ArrayList<Card>();
		//更具生成的随机数集合内的数组，改变原扑克牌的下标，从而打乱顺序
		for(int k= 0;k < cardListLen;k++ ) {
			newCardList.add(k, cardList.get(ranList.get(k).intValue()));
		}
		//返回newCardList
		return newCardList;
	}

}
