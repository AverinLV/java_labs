package lab5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.*;

import lab2.Main_lab2;
import lab3.Mythread;
import lab4.Main_lab4;

public class Main extends JFrame implements ActionListener {

	private JTextArea text;
	private JTextField input;
	private static int one=-1, two=-1, three=-1;

    FlowLayout experimentLayout = new FlowLayout();
    
    public Main(String name) {
        super(name);
    }
    
   
    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton first = new JButton("Lab 1");
        first.setFont(new Font("Arial", Font.PLAIN, 30));
        first.setActionCommand("lab1");
        JButton second = new JButton("Lab 2");
        second.setFont(new Font("Arial", Font.PLAIN, 30));
        second.setActionCommand("lab2");
        JButton third = new JButton("Lab 3");
        third.setFont(new Font("Arial", Font.PLAIN, 30));
        third.setActionCommand("lab3");
        JButton forth = new JButton("Lab 4");
        forth.setFont(new Font("Arial", Font.PLAIN, 30));
        forth.setActionCommand("lab4");

        compsToExperiment.add(first);
        compsToExperiment.add(second);
        compsToExperiment.add(third);
        compsToExperiment.add(forth);

        first.addActionListener(this);
        second.addActionListener(this);
        third.addActionListener(this);
        forth.addActionListener(this);
        
        input = new JTextField(15);
        input.addActionListener(this);        
        text = new JTextArea(20, 40);
        text.setEditable(false);
        text.setFont(new Font("Courrier", Font.PLAIN, 20));
        JScrollPane scroll = new JScrollPane (text, 
        		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        PrintStream stream = new PrintStream(System.out) {
            public void print(String texts) { 
                text.append(texts + "\n");
                }
        };
        System.setOut(stream);

        //compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(scroll);
        pane.add(input, BorderLayout.SOUTH);
    }
    
	public void actionPerformed(ActionEvent arg0) {
		String ac = arg0.getActionCommand();
        String texts = input.getText();        
        
		if (ac == "lab1" || ac == "insert") {
			text.setText(null);

			if (three == -1) text.append("Insert 3 numbers" + "\n");
			else runClient(1);
		}
		else if (ac == "lab2") {
			text.setText(null);
			runClient(2);
		}
		else if (ac == "lab3") {
			text.setText(null);
			runClient(3);
		}
		else if (ac == "lab4") {
			text.setText(null);
			runClient(4);
		}
		else {
			try
			{
			Integer.parseInt(texts);
			if (two != -1) {
				three = Integer.parseInt(texts);
				runClient(1);
			}
			else if (one != -1) two = Integer.parseInt(texts);
	        else if (one == -1) one = Integer.parseInt(texts);

			//text.setText(null);
	        text.append(texts + "\n");
	        input.selectAll();
			}
			catch (NumberFormatException ex)
			{
				text.append("Insert numbers only" + "\n");
				input.selectAll();
			}
		}
		text.setCaretPosition(text.getDocument().getLength());
	}

    private static void runClient(int num) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                String[] args1={"12"};
                try {
                	if (num==1)	{
                		lab1.main(one, two, three);
                		one = -1;
                		two = -1;
                		three = -1;
                	}
                	else if (num == 2) Main_lab2.main(args1);
                	else if (num == 3) Mythread.main(args1);
                	else Main_lab4.main(args1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        });
    }
    
    private static void createAndShowGUI() {
        Main frame = new Main("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}