
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import javax.swing.*;


public final class Webreader extends JEditorPane {
    private JEditorPane editorpane;
    private String webpage;
    private String HTMLtext;
//    private JTextPane textpane;
    
    Webreader(String site){
        initWeb(site);
        
    }
    
    private void initWeb(String site) {  
        webpage=site; 
        try{
            URL helpURL = new URL(webpage);
            editorpane = new JEditorPane(helpURL);
            editorpane.setEditable(false);
            editorpane.setContentType("text/html; charset=iso-8859-1");

        }catch(IOException e){
        }
    }
    
    public JEditorPane getPane(){
    return editorpane;
    }
    

    
    /*public static void main(String[] args){
        Webreader run = new Webreader();
        
    }*/
}
