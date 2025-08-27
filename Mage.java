package codes;

import javax.swing.*;

class Mage extends GameCharacter {
	public Mage(String name) {
		super(name, 100, 20); // starting HP=100, attackDamage=20
	}

	@Override
	public int attack() {
		JOptionPane.showMessageDialog(null, name + " casts Fireball! (-20 HP)");
		return attackDamage;
	}

	@Override
	public int specialMove() {
		JOptionPane.showMessageDialog(null, name + " uses Ice Blast! (-25 HP)");
		return 25;
	}

	@Override
	public int secretPower() {
		JOptionPane.showMessageDialog(null, name + " unleashes Arcane Storm! (-35 HP)");
		return 35;
	}
}