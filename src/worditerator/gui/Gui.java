package worditerator.gui;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import worditerator.algorithm.Algorithm;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	
	public Gui() {
		setSize(400, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		TextField textField = new TextField(40);
		List list = new List(23);
		add(textField);
		add(list);
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				String word = e.getActionCommand();
				String[] words = Algorithm.iterate(word);
				for (String s : words) {
					list.add(s);
				}
			}
		});
	}
}
