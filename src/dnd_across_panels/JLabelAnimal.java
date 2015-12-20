package dnd_across_panels;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class JLabelAnimal extends JLabel{
	private Animal animal;

	public JLabelAnimal(Animal a){
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            this.setBounds(new Rectangle(1, 5));
            this.animal = a;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
		this.setText(animal.getName());
	}

	public Animal getAnimal() {
		return animal;
	}
}