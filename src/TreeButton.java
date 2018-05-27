import javax.swing.JButton;
import javax.swing.JPanel;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TreeButton extends JButton{

	private Node btnNode;
	private boolean wasClicked;
	public TreeButton(){
		super();
		btnNode = new Node(0);
		setText(btnNode.toString());
		addActionListener(new Handler());
		wasClicked = false;
	}

	public TreeButton(Node n){
		super();
		btnNode = n;
		setText(btnNode.toString());	
		addActionListener(new Handler());
		wasClicked = false;
	}

	private class Handler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(wasClicked==false){
				JPanel p = (JPanel)(((TreeButton)event.getSource()).getParent());
				btnNode.generateChildren(0);
				Node[] children = btnNode.getChildren();
				for(int i=0;i<children.length;i++){
					TreeButton b = new TreeButton(children[i]);
					p.add(b);
				}
			}

			wasClicked = true;

			
		}	
	}
}
	
