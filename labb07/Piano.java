import java.awt.*;                                   
import javax.swing.*;
import java.awt.event.*;
public class Piano extends JFrame {
    Box oktav = Box.createHorizontalBox();
    
    public Piano() {
        getContentPane().setLayout(new FlowLayout());
    	oktav.add(bredbox());
    	oktav.add(svartbox());
    	oktav.add(smalbox());
    	oktav.add(svartbox());
    	oktav.add(bredbox());
    	oktav.add(svartbox());
    	oktav.add(smalbox());
    	oktav.add(svartbox());
    	oktav.add(smalbox());
    	oktav.add(svartbox());
    	oktav.add(bredbox());
        oktav.setBackground(Color.white);
	   getContentPane().add(oktav);
        setSize(330,240);
	//	getContentPane().setBackground(Color.blue);
        //setBackground(Color.white);
        setVisible(true);
    }
    public Box bredbox() {
        Box box=Box.createHorizontalBox();
        box.add(bredvit());
        box.add(Box.createHorizontalStrut(2));
        box.add(bredvit());
        return box;
    }
    public Box smalbox() {
        Box box=Box.createHorizontalBox();
        box.add(smalvit());
        return box;
    }
    public JPanel bredvit() {
        JPanel bred=new JPanel();
        bred.setBackground(Color.white);
        bred.setPreferredSize(new Dimension(23,200));
        return bred;
    }
    public JPanel smalvit() {
        JPanel smal=new JPanel();
        smal.setBackground(Color.white);
        smal.setPreferredSize(new Dimension(11,200));
        return smal;
    }
    public Box svartbox() {
	Box box=Box.createVerticalBox();
        box.add(svarttangent());
	box.add(vithalvor());
        return box;
    }
    public Box vithalvor() {
	Box box=Box.createHorizontalBox();
        box.add(vithalva());
	box.add(Box.createHorizontalStrut(2));
        box.add(vithalva());
        return box;
    }
    public JPanel vithalva() {
        JPanel halva=new JPanel();
        halva.setBackground(Color.white);
        halva.setPreferredSize(new Dimension(14,80));
        return halva;
    }
    public JPanel svarttangent() {
        JPanel tang=new JPanel();
        tang.setBackground(Color.black);
        tang.setPreferredSize(new Dimension(30,120));
        return tang;
    }

}
