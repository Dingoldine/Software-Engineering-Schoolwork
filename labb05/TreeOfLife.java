
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;

public class TreeOfLife extends TreeFrame  {
    DefaultMutableTreeNode currentChild;
    String namn;
    String sentence;
    int counter;
    String kappa;
    String text;
    static ArrayList<ArrayList<String>> listOList = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> taggar = new ArrayList<>();
    private String pathString;
   TreeOfLife(){
   OpenFile whatwhat = new OpenFile();
   text = whatwhat.getText();
   }

    private void matching(){ //Sorterar filen i en lista [Child, text] or [/(text)]

    String a = text;
        try (Scanner scanner = new Scanner(a)) {
            sentence = "";
            while(scanner.hasNext()){
                String word = scanner.next();
                //System.out.println("" + word);
                String temp = LetterAtIndex(0, word);
                if("<".equals(temp)){
                    if (sentence.length() >0){
                        list.add(sentence);
                        sentence = "";
                        listOList.add(list);
                        list = new ArrayList<>();
                    }
                    word = word.replaceAll("<", "");
                    if(Character.isLetter(word.charAt(0)) ){ // Ã¤ndra till Character.isLetter(word.charAt(0))
                        taggar.add(word);
                        String kappaNamn = scanner.next();
                        kappaNamn = kappaNamn.replaceAll("namn=\"", "");
                        while(">".equals(Character.toString(kappaNamn.charAt(kappaNamn.length() - 1))) == false){
                            kappaNamn += " " + scanner.next();
                        }
                        if(">".equals(Character.toString(kappaNamn.charAt(kappaNamn.length()-1)))){
                            kappaNamn = kappaNamn.replaceAll("\">", "");
                            list.add(kappaNamn);  
                        }else{
                            System.out.println("fel på sluttagg");
                        }
            
                    }
                    
                }else if("<".equals(temp) == false && "".equals(sentence)){
                    
                    System.out.println("fel pÃ¥ starttagg vid " + word);
                }
                if("/".equals(Character.toString(word.charAt(0)))) {
                    word = word.replace(">", "");
                    list.add(word);
                    listOList.add((ArrayList<String>) list);
                    list = new ArrayList<>();
                    String sluttagg = word.replace("/","");
                    String starttagg = taggar.remove(taggar.size()-1);
                    if(!starttagg.equals(sluttagg)){
                        System.out.println("faaaail");
                    }
                }else{
                    sentence += word + " ";
                    
                    
                }
            }
//            System.out.println(listOList);
        }
    
    
    
    }
    String LetterAtIndex(int i, String str){
        char z = str.charAt(i);
        String temp = Character.toString(z);
        return temp;
    }
    

    @Override
    void initTree(){
        
        if(listOList.size() >0){
        setVisible(false);
        kappa = listOList.get(0).get(0);
        }else{
        kappa = "";
        }
        root = new DefaultMutableTreeNode(kappa);
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        tree.setBackground(Color.GREEN);

        buildTree(root);

    }
    
    private void buildTree(DefaultMutableTreeNode parent){ 

        counter = 0;
        for(int i = 1; i < listOList.size(); i++){    
            String word = listOList.get(i).get(0);
            if(LetterAtIndex(0, word).equals("/")){
                counter += 1;
            }else{
                if (counter > 0){
                    parent = parentMethod(parent, counter);
                    counter =0;
                }

            DefaultMutableTreeNode child4 = new DefaultMutableTreeNode(word);
            
            parent.add(child4);
            parent = child4;


            }      
        }

    }
    private DefaultMutableTreeNode parentMethod(DefaultMutableTreeNode Child, int iterations){
        for(int i = 0; i < iterations; i++){
            Child = (DefaultMutableTreeNode) Child.getParent();  
        }
        return Child;
    }
    
    @Override
    void showDetails(TreePath p){
        if (p == null)
	    return;
	String info = p.getLastPathComponent().toString();
//        System.out.println(getStringPath(info));
        currentChild = root;
        while(currentChild.getNextNode()!=null && !root.toString().equals(info)){
            currentChild = currentChild.getNextNode();
            if(currentChild.toString().equals(info)){
                break;
            }
        }
        
	JOptionPane.showMessageDialog(this, getAttribute(info)+  "\n" + getStringPath(currentChild));
            
    }
    private String getStringPath(DefaultMutableTreeNode Child){
        
        if(Child.isRoot()){
            pathString = "THIS IS WHY WE LIVE";
        }else{
        pathString = "allt som är " + Child.toString();
        
        System.out.println(root.toString() + " ");
        
        while(!Child.getParent().toString().equals(root.toString())){
            DefaultMutableTreeNode prnt = (DefaultMutableTreeNode) Child.getParent();
            pathString += " är " + prnt.toString();
            Child = prnt;
        }
        if(Child.getParent().equals(root)){
        pathString += " är " + Child.getParent().toString();
        }
        }
        return pathString;
        
    }
    private String getAttribute(String information){
        String info = "";
        for(int i = 0; i < listOList.size(); i++){
            if ( listOList.get(i).get(0).equals(information) ){
                info = listOList.get(i).get(1);
                String[] arr = info.split(" ", 2);
                info = arr[1];
                info = info.replaceAll(".*>", "");

            }
        }
    return info;
    }
    public void rekt (){
    dispose();
    }
    @Override
    public void setBackground(Color bg){
        
    }

    public static void main(String[] args){
        TreeOfLife kappa = new TreeOfLife();
        
        if(listOList.isEmpty()){
            kappa.rekt(); //bugfix, Ã¶ppnar tvÃ¥ fÃ¶nster, dno why
        }
        kappa.matching();
        
        TreeOfLife treeOfLife = new TreeOfLife();
        
        
    }
    }


