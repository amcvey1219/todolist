package focusProject;

//imports for making the GUI
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class project implements ActionListener {

	//number of tasks counter
	private int count = 0;
	
	
	//other GUI
	JFrame frame;
	JLabel title;
	JButton addButton;
	JLabel taskLabel;
	JPanel panel;
	JLabel label2;
	JTextField textBox;
	JButton removeButton;
	
	//GUI creation
	public project(){
		//making the window
		frame = new JFrame();
		
		title = new JLabel("My To-Do List");
		
		addButton = new JButton("Add new task");
		addButton.addActionListener(this);
		
		taskLabel = new JLabel("You have no tasks.");
		
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		//adding elements
		panel.add(title);
		panel.add(taskLabel);
		panel.add(addButton);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("To-Do List");
		frame.pack();
		frame.setVisible(true);
	}

	//instantiates the project so it can run
	public static void main(String args[]){
		project proj = new project();
	}

   
	@Override
	// method to execute when buttons are pressed
	public void actionPerformed(ActionEvent e) {
	// when addButton (Add new task) is clicked
	 	if (e.getSource()==addButton)
	 	{
	 		//change the value of count by +1 (# of tasks)
	 		count++;
	 		taskLabel.setText("You have " + count + " tasks.");
	 		
	 		//added when addButton is clicked, adds new label2, new textBox and removeButton
	 		// (#., task field and x button)
			label2 = new JLabel(count + ". ");
			textBox = new JTextField();
			removeButton = new JButton("X");
			removeButton.addActionListener(this);
			
	 		panel.add(label2);
	 		panel.add(textBox);
	 		panel.add(removeButton);
	 	}
	 	//when removeButton (the x button) is clicked
	 	else if (e.getSource()==removeButton) {
	 		if (count==1) {
	 			//keeps count at 0 if there are no tasks (so count doesnt go into the negatives)
	 			taskLabel.setText("You have no tasks.");
	 			count = 0;
	 			panel.remove(label2);
	 			panel.remove(textBox);
	 			panel.remove(removeButton);
	 		} else {
	 			//lowers count -1, removes this label2, textBox, and removeButton
	 			count--;
	 			taskLabel.setText("You have " + count + " tasks.");
	 			panel.remove(label2);
	 			panel.remove(textBox);
	 			panel.remove(removeButton);
	 		}
	 	}
	}
}
