package com.codealpha1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WordCounter extends JFrame implements ActionListener{
	private JLabel titleLabel;
	private JLabel wordCountLabel;
	private JTextArea textArea;
	private JButton countButton;
	
	public WordCounter() {
		setTitle("Word Counter");
		setSize(400,300);
		
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			titleLabel=new JLabel("Enter your paragraph:");
			add(titleLabel,BorderLayout.NORTH);
			
			textArea=new JTextArea();
			JScrollPane scrollPane=new JScrollPane(textArea);
			add(scrollPane,BorderLayout.CENTER);
			
			wordCountLabel=new JLabel("Word count:0");
			add(wordCountLabel,BorderLayout.SOUTH);
			
			countButton=new JButton("Count Words");
			countButton.addActionListener(this);
			add(countButton,BorderLayout.EAST);
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==countButton) {
				String text=textArea.getText();
				int wordCount=countWords(text);
				wordCountLabel.setText("Word count:"+wordCount);
			}
		}
		
		private int countWords(String text) {
			if(text==null||text.isEmpty()) {
				return 0;
			}
			
			String[] words=text.split("\\s+");
			return words.length;
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(()->{
				WordCounter wordCounter=new WordCounter();
				wordCounter.setVisible(true);
			});
		}
	}