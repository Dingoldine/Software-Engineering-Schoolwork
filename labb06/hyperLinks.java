
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class hyperLinks {
    private String webpage;
    private String htmlString;
    private URL url;
    private HTMLEditorKit kit;
    private HTMLDocument doc;
    private InputStreamReader reader;
    private BufferedReader reading;
    private StringWriter writer;
    private Object[][] matrix = new Object[50][2];
    private Object[] list = new Object[2];

    hyperLinks(String link) throws BadLocationException{

    
        try{

            webpage= link;
            String result = java.net.URLDecoder.decode(webpage, "iso-8859-1");
            url = new URL(result);      
            kit = new HTMLEditorKit();
            doc = (HTMLDocument) kit.createDefaultDocument();
            reader = new InputStreamReader((InputStream) url.getContent(), "iso-8859-1");
            doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
            kit.read(reader, doc, 0);

        }catch(IOException e){
            System.out.println("something wrong with the interwebspage");
        }
    }
    
    private String docToString() throws BadLocationException, UnsupportedEncodingException{
        try{
            writer = new StringWriter();
            kit.write(writer, doc, 0, doc.getLength());
            htmlString = writer.toString();
        }catch(IOException e){   
        }

        
  
        return htmlString;
    }
    
    private void getStartOffSet() throws BadLocationException, UnsupportedEncodingException{
        Pattern p = Pattern.compile("<a href=\"([^\"]*)\">", Pattern.DOTALL); //([^\"]*)</a>  
        Pattern findhttp = Pattern.compile("http://");
        Matcher m = p.matcher(docToString());
        int index = 0;
        while (m.find()) {
            if (index == 50){
                break;
            }
            // Get all groups for this match
            for (int i=0; i<=m.groupCount(); i++) {     
                String groupStr = m.group(i);
                if(i == 1){
                    if(findhttp.matcher(groupStr).find()){
                    }else{
                        groupStr = webpage + "/" + groupStr;
                    }
                    
                    list[0] = groupStr;
                    matrix[index] = list;
                    
                    list = new String[2];
                    index += 1;
                }
            }
        }
    

    }

   private void getEndOffSet() throws BadLocationException, UnsupportedEncodingException{
        Pattern findName = Pattern.compile(">([^\"]*)\\s*</a>");
        Matcher z = findName.matcher(docToString());
        int counter = 0;
        while (z.find()) {
            if(counter == 50){
                break;
            }
         // Get all groups for this match
         for (int i=0; i<=z.groupCount(); i++) {
             String groupStr = z.group(i);
             if(findName.matcher(groupStr).find()){        
             }else{
                 String str = java.net.URLDecoder.decode(groupStr, "UTF-8");
                 matrix[counter][1] = str;
                 //System.out.println(Arrays.toString(matrix[counter]) + " här");
                 counter += 1;

             }
         }
     }
   }
   public Object[][] getMatrix(hyperLinks lol) throws BadLocationException, UnsupportedEncodingException{
       lol.getStartOffSet();
       lol.getEndOffSet();
       //System.out.println(Arrays.toString(matrix[19]) + " här");
       return matrix;
   }
   /*public static void main(String[] args) throws BadLocationException, UnsupportedEncodingException{
   hyperLinks lol = new hyperLinks("http://www.nada.kth.se/~henrik");
   //System.out.println(lol.docToString());
   lol.getStartOffSet();
   lol.getEndOffSet();
   lol.getMatrix(lol);
   //System.out.println(lol.getMatrix());
    
   }*/
}
