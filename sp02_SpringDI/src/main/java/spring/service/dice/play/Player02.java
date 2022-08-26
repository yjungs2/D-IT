package spring.service.dice.play;

import spring.service.dice.Dice;
/*
 *	FileName : Player02.java
 *	ㅇ Player01에서는 DiceA를 직접 가지고 있는 관계였다면(Tight한 Coupling)
 *	ㅇ DiceB, DiceC를 추가할 때마다 Plyaer01에서 수정되어져야 하는 코드가 기하급수적으로 늘어남으로써
 *    재사용성에 치명적인 결과를 야기한다.
 *  ㅇ 해결책으로 Dice라는 인터페이스를 추가
 *    Player02가 Dice를 가지는 관계를 작성...
 */
public class Player02 {
	
	///Field
	private Dice dice; // 인터페이스를 Hasing
	private int totalValue;
	
	///Constructor Method
	public Player02() { // 기본 생성자 필수
	}
	public Player02(Dice dice) {
		this.dice = dice;
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}
}//end of class