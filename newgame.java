package codes;

import javax.swing.*;

public class newgame {

	public static String getHpBar(int hp) {
		int totalBars = 20; // length of the bar
		int filledBars = (hp * totalBars) / 100;
		String bar = "[" + "♥".repeat(filledBars) + "♡".repeat(totalBars - filledBars) + "]";
		return bar + " " + hp + " HP";
	}

	public static void main(String[] args) {
		// Ask player for names
		String mageName = JOptionPane.showInputDialog("Enter Mage's name:");
		String warriorName = JOptionPane.showInputDialog("Enter Warrior's name:");

		Mage mage = new Mage(mageName);
		Warrior warrior = new Warrior(warriorName);

		JOptionPane.showMessageDialog(null,
				"Game starts! " + mage.getName() + " vs " + warrior.getName() + "\nBoth have 100 HP.");

		// Turn-based battle loop
		while (mage.getHp() > 0 && warrior.getHp() > 0) {
			// Mage turn
			String mageChoice = JOptionPane.showInputDialog(mage.getName() + "'s Turn!\n\n" + mage.getName() + " "
					+ getHpBar(mage.getHp()) + "\n" + warrior.getName() + " " + getHpBar(warrior.getHp()) + "\n\n"
					+ "Choose move:\n1. Attack\n2. Special Move\n3. Secret Power");
			int mageDamage = 0;
			if (mageChoice.equals("1"))
				mageDamage = mage.attack();
			else if (mageChoice.equals("2"))
				mageDamage = mage.specialMove();
			else if (mageChoice.equals("3"))
				mageDamage = mage.secretPower();
			else
				JOptionPane.showMessageDialog(null, "Invalid choice! Skipping turn.");

			warrior.takeDamage(mageDamage);

			// Check if warrior is defeated
			if (warrior.getHp() <= 0) {
				JOptionPane.showMessageDialog(null, "🎉 " + mage.getName() + " wins the battle!");
				break;
			}

			// Warrior turn
			String warriorChoice = JOptionPane.showInputDialog(warrior.getName() + "'s Turn!\n\n" + mage.getName() + " "
					+ getHpBar(mage.getHp()) + "\n" + warrior.getName() + " " + getHpBar(warrior.getHp()) + "\n\n"
					+ "Choose move:\n1. Attack\n2. Special Move\n3. Secret Power");
			int warriorDamage = 0;
			if (warriorChoice.equals("1"))
				warriorDamage = warrior.attack();
			else if (warriorChoice.equals("2"))
				warriorDamage = warrior.specialMove();
			else if (warriorChoice.equals("3"))
				warriorDamage = warrior.secretPower();
			else
				JOptionPane.showMessageDialog(null, "Invalid choice! Skipping turn.");

			mage.takeDamage(warriorDamage);

			// Show HP status
			JOptionPane.showMessageDialog(null, "HP Status:\n" + mage.getName() + ": " + mage.getHp() + " HP\n"
					+ warrior.getName() + ": " + warrior.getHp() + " HP");

			// Check if mage is defeated
			if (mage.getHp() <= 0) {
				JOptionPane.showMessageDialog(null, "🎉 " + warrior.getName() + " wins the battle!");
				break;
			}
		}
	}
}