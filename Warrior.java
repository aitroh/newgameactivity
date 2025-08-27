package codes;

import javax.swing.*;

class Warrior extends GameCharacter {
	public Warrior(String name) {
		super(name, 100, 15); // starting HP=100, attackDamage=15
	}

	@Override
	public int attack() {
		JOptionPane.showMessageDialog(null, name + " slashes with Sword! (-15 HP)");
		return attackDamage;
	}

	@Override
	public int specialMove() {
		JOptionPane.showMessageDialog(null, name + " uses Power Strike! (-20 HP)");
		return 20;
	}

	@Override
	public int secretPower() {
		JOptionPane.showMessageDialog(null, name + " unleashes Berserk Rage! (-30 HP)");
		return 30;
	}
}