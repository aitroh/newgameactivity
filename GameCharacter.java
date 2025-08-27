package codes;

import javax.swing.*;

//Abstract Class (Parent)
abstract class GameCharacter {
	String name;
	int hp;
	int attackDamage;

	public GameCharacter(String name, int hp, int attackDamage) {
		this.name = name;
		this.hp = hp;
		this.attackDamage = attackDamage;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void takeDamage(int damage) {
		hp -= damage;
		if (hp < 0) {
			hp = 0;
		}
	}

	// Abstract methods (forces Mage & Warrior to implement)
	public abstract int attack();

	public abstract int specialMove();

	public abstract int secretPower();
}