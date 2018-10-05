import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

class Program extends JFrame implements ActionListener{
  private JPanel panel;
  private JLabel authors;
  private JPanel pnlButton;
  private MyButton button1;
  private MyButton button2;

  // constructor
  public Program(String title){

  super(title);                      // invoke the JFrame constructor
    setSize(800, 600);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout(new FlowLayout());
    setVisible(true);             // ask it to become visible
    
    //JPanel
    panel = new JPanel();
    panel.setBackground(Color.cyan);
    setContentPane(panel);
    panel.setLayout(new BorderLayout());

    //Button 1 
    button1 = new MyButton(Color.green, Color.red, "Run", "Stop");
    button1.setBounds(60, 400, 220, 30);
    panel.add(button1);
    button1.addActionListener(this);

    //Button 2 
    button2 = new MyButton(Color.white, Color.black, "On", "Off");
    button2.setBounds(100, 500, 300, 50);
    panel.add(button2);
    button2.addActionListener(this);
    
    //JLabel
    authors = new JLabel("Philip Rumman y Erik Lundsten!");  // construct a JLabel
    authors.revalidate();
    panel.add(authors);                        // add the label to the JFrame
    


    }

    public void actionPerformed(ActionEvent e){
      button1.toggleState();


    }

    public static void main(String[] args){
      Program frame = new Program("Nigguh");
      
      
      
  }
}