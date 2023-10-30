
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import Board.Cell;

public class GUI implements ActionListener{

	Board board = new Board();
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JRadioButton simpleGame = new JRadioButton();
	JRadioButton generalGame = new JRadioButton();

	boolean sPlayer_turn;

	GUI(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("SOS GAME");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		// Set simple game and general game radio buttons
				simpleGame = new JRadioButton();
				simpleGame.setLayout(new BorderLayout());
				simpleGame.setText("Simple Game");
				simpleGame.addActionListener(this);
				simpleGame.setFocusable(false);
				
				title_panel.add(simpleGame);
				
				generalGame = new JRadioButton();
				generalGame.setLayout(new BorderLayout());
				generalGame.setText("General Game");
				generalGame.addActionListener(this);
				generalGame.setFocusable(false);
			
				title_panel.add(generalGame);
				
				ButtonGroup group = new ButtonGroup();
		
				group.add(simpleGame);
				group.add(generalGame);

		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	String option;
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=null;
		String o_turn = null;
		String s_turn = null;
		for(int i=0;i<9;i++) {
			
			if(e.getSource()==buttons[i]) {
				if(sPlayer_turn) {
				
					 temp = s_turn;
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("S");
						sPlayer_turn=false;
						textfield.setText("O turn");
					}
				}
				else {
					temp = o_turn;
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						sPlayer_turn=true;
						textfield.setText(" S player turn");
						if(board.simpleCheck(temp)) {
							JLabel label = new JLabel();
							label.setText(temp);
							frame.add(label);
						}
					}
				}
			} 
	
		}
		 if(e.getSource()==simpleGame) {
				System.out.println(simpleGame.getText() + " selected");
			}
			else if(e.getSource()==generalGame) {
				System.out.println(generalGame.getText() + " selected");			
			}
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			sPlayer_turn=true;
			textfield.setText("S turn");
	}	

	public static void main(String[] args) {
		GUI board = new GUI();
	}
}

