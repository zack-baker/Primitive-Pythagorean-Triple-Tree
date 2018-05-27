/**
*	This class runs the Primitive Pythagorean Tree program.
*/


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PPT{
	
	private static JFrame frame;

	private static JPanel panel;

	public static void main(String[] args) {

		frame = new JFrame("Primitive Pythagorean Tree Shower");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		TreeButton b = new TreeButton();

		panel.add(b);

		frame.add(panel);
		frame.pack();
		
		frame.setVisible(true);
	}


	// 	String num = JOptionPane.showInputDialog("Enter the depth of the tree");

	// 	int depth = Integer.parseInt(num);
	// 	Node n = new Node(depth);//create the first node
	// 	System.out.println("Root node: " + n);

	// 	n.printTree(1);
	// 	System.out.println("\n");

	// }
}