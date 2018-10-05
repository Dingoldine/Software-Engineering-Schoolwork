
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

public class table extends JFrame implements ActionListener{
    private JSplitPane splitpane;
    private JSplitPane splitH;
    private final JPanel westpanel;
    private final JPanel eastpanel;
    private final JPanel toppanel;
    private final JLabel label;
    private JTable table;
    static String webpage = "http://www.nada.kth.se/~viggo";
    private JTextField textfield;
    private JEditorPane area;
    private String text;
    private Webreader web;
    private JScrollPane scroll;
    private JEditorPane ep1;
    private hyperLinks links;
    private Object[][] rader;
    private Object[] kolumner = { "WEBADRESS", "BENÄMNING"};
    
    table(String title){
        super("erik och philips webläsare");
        
        westpanel=new JPanel(new BorderLayout());
        eastpanel=new JPanel(new BorderLayout());
        toppanel=new JPanel(new BorderLayout());
        label=new JLabel (title);
        
    }

    private void initGUI() throws BadLocationException, UnsupportedEncodingException{
        setSize(1600,800);
        createWestpanel();
        createEaspanel(); //indata hur många rows
        splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, westpanel, eastpanel); 
        splitpane.setDividerLocation(900);
        splitpane.setDividerSize(4);
        splitH = new JSplitPane(JSplitPane.VERTICAL_SPLIT,toppanel,splitpane);
        getContentPane().add(splitH); //ta bort VERT_SPLIT samt ändra till splitpane
        splitH.setDividerSize(0);
        toppanel.add(textfield = new JTextField());
        textfield.addActionListener(this);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        setVisible(true);
    }
    
    private void createWestpanel() throws UnsupportedEncodingException{
        web = new Webreader(webpage);
        ep1 = web.getPane();
        scroll = new JScrollPane (ep1, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        westpanel.add(scroll, BorderLayout.CENTER); //ev ta bort BorderLayout här..

    }
    
    private void createEaspanel() throws BadLocationException, UnsupportedEncodingException{
        links = new hyperLinks(webpage);
        rader = links.getMatrix(links);
        table = new JTable();
        
        table.setModel(new DefaultTableModel(rader,kolumner));
        JScrollPane scrolltable = new JScrollPane (table, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        eastpanel.add(scrolltable);      
    }

    @Override
    public void actionPerformed(ActionEvent e) {  

        try {
            
            webpage = textfield.getText();
            links = new hyperLinks(webpage);
            rader = links.getMatrix(links);
            ep1.setPage(webpage);

            table.setModel( new DefaultTableModel(rader, kolumner));
        } catch (IOException | BadLocationException | NullPointerException ex) {
            Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(this, "NOT A WEBSITE");

        }
    }
    
    public static void main(String[] args) throws BadLocationException, UnsupportedEncodingException{
        table frame = new table(webpage);
        frame.initGUI();
            
            
    }
}
