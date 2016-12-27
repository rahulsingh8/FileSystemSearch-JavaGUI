package javaGui;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FinalProject extends JFrame {
    
    Container c;
    JPanel northP, innerNorthP1, innerNorthP2, southP, btnsouthP1, btnsouthP2, btnsouthP3;
    JLabel lblSearch;
    JTextField txtSearch;
    JTextArea displayResults;
    JButton btnReset, btnClose, btnSearch;
    JMenuBar menuBar;
    JMenuItem menuItem1, menuItem2, menuItem3;
    JMenu menu1;
    JRadioButtonMenuItem rbMenuItem;
    String file = "c:\\temp\\project.txt";
    String ex = "";
    int theme = 0;
    String read = "";
    
    String [] extensions = {"Documents", ".txt", ".exe",  ".doc", ".docx", ".pdf", ".rar", ".zip", ".java"};
    String [] extensions2 = {"Music/Videos", ".mp3", ".mp4", ".avi", ".mkv", ".flv", ".f4v", ".3gp", ".wmv", "wma", ".wav"};
    JComboBox cmbFiles,cmbFiles2;
    private JScrollBar scrollBar;
    
 /**
  * Class write a theme in the file Project.txt
  * 
  * @throws IOException
  */
    public void saveTheme() throws IOException {
        File f = new File(file);
        if(!f.exists()) f.createNewFile();
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        
        if(theme == 0)
            pw.println(""+0);
        else if(theme == 1)
            pw.println(""+1);
        else if(theme == 2)
            pw.println(""+2);
        pw.close();
        fw.close();
    }
    
    /**
     * Class to reading from the file and apply the theme
     * 
     */
    
    public void readTheme() throws IOException, NullPointerException {
        
        FileReader in = new FileReader(file);
        BufferedReader br = new BufferedReader(in);

        read = br.readLine();
        
        
        if (read != null) {
           
            System.out.println("from the file"+read);  
        }
        in.close();
    }
    
    /**
     * red theme class
     */
    
    public void redtheme() {
        innerNorthP1.setBackground(new Color(25, 80, 25));
        innerNorthP2.setBackground(new Color(25, 80, 25));
        
        cmbFiles.setBackground(new Color(25, 80, 25));
        cmbFiles2.setBackground(new Color(25, 80, 25));
        
        btnsouthP1.setBackground(new Color(25, 80, 25));
        btnsouthP2.setBackground(new Color(25, 80, 25));
        btnsouthP3.setBackground(new Color(25, 80, 25));
    }
    
    
    /**
     * green theme class
     */
    public void greentheme() {
        innerNorthP1.setBackground(new Color(200, 25, 25));
        innerNorthP2.setBackground(new Color(200, 25, 25));
        
        cmbFiles.setBackground(new Color(200, 25, 25));
        cmbFiles2.setBackground(new Color(200, 25, 25));
        
        btnsouthP1.setBackground(new Color(200, 25, 25));
        btnsouthP2.setBackground(new Color(200, 25, 25));
        btnsouthP3.setBackground(new Color(200, 25, 25));
    }
    
    
    /**
     * default constructor
     * @throws IOException 
     */
    
    public FinalProject() throws IOException {
        
        
        
        c = getContentPane();
        c.setLayout(new BorderLayout());
        
        //Menu
        menuBar = new JMenuBar();
        menuBar.setForeground(new Color(245, 255, 250));
        menuBar.setBackground(new Color(0, 0, 0));
        
        menu1 = new JMenu("A Menu");
        menu1.setBackground(new Color(105, 105, 105));
        menu1.setForeground(new Color(245, 255, 250));
        menu1.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu1);
        
        
        menuItem1 = new JMenuItem("Theme 1", KeyEvent.VK_T);
        
        menu1.add(menuItem1);

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   //green theme
                theme = 1;
                try {
                    saveTheme();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                innerNorthP1.setBackground(new Color(25, 80, 25));
                innerNorthP2.setBackground(new Color(25, 80, 25));
                
                cmbFiles.setBackground(new Color(25, 80, 25));
                cmbFiles2.setBackground(new Color(25, 80, 25));
                
                btnsouthP1.setBackground(new Color(25, 80, 25));
                btnsouthP2.setBackground(new Color(25, 80, 25));
                btnsouthP3.setBackground(new Color(25, 80, 25));
            }
        });
        
        
        menuItem2 = new JMenuItem("Theme 2", KeyEvent.VK_G);
        menu1.add(menuItem2);

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       //red theme
                theme = 2;
                try {
                    saveTheme();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                innerNorthP1.setBackground(new Color(200, 25, 25));
                innerNorthP2.setBackground(new Color(200, 25, 25));
                
                cmbFiles.setBackground(new Color(200, 25, 25));
                cmbFiles2.setBackground(new Color(200, 25, 25));
                
                btnsouthP1.setBackground(new Color(200, 25, 25));
                btnsouthP2.setBackground(new Color(200, 25, 25));
                btnsouthP3.setBackground(new Color(200, 25, 25));
            }
        });
        
        
        menuItem3 = new JMenuItem("Theme 3", KeyEvent.VK_H);
        menu1.add(menuItem3);

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       //blue theme
                innerNorthP1.setBackground(new Color(25, 25, 200));
                innerNorthP2.setBackground(new Color(25, 25, 200));
                
                cmbFiles.setBackground(new Color(25, 25, 200));
                cmbFiles2.setBackground(new Color(25, 25, 200));
                
                btnsouthP1.setBackground(new Color(25, 25, 200));
                btnsouthP2.setBackground(new Color(25, 25, 200));
                btnsouthP3.setBackground(new Color(25, 25, 200));
            }
        });
        
        
        northP = new JPanel();
        northP.setLayout(new GridLayout(3,1));
        northP.add(menuBar);
        
        innerNorthP1 = new JPanel();
        innerNorthP1.setForeground(new Color(255, 255, 255));         //black background of menubar
        
        innerNorthP1.setLayout(new FlowLayout());
        
        lblSearch = new JLabel("Search: ");
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSearch.setForeground(new Color(255, 255, 255));
        innerNorthP1.add(lblSearch);
        txtSearch = new JTextField(8);
        innerNorthP1.add(txtSearch);
        
        cmbFiles = new JComboBox(extensions);                    //1st dropbox
        cmbFiles.setForeground(new Color(255, 255, 255));
        
        cmbFiles2 = new JComboBox(extensions2);                    //2nd dropbox
        cmbFiles2.setForeground(new Color(255, 255, 255));
        
        
        innerNorthP2 = new JPanel();
        
        innerNorthP2.setLayout(new FlowLayout());
        innerNorthP2.add(cmbFiles);
        innerNorthP2.add(cmbFiles2);
        
        displayResults = new JTextArea(6, 10);                //textfield
        
        southP = new JPanel();
        southP.setLayout(new GridLayout(1,4));
        btnSearch = new JButton("Search");
        btnReset = new JButton("Reset");
        
        btnClose = new JButton("Close");
        btnsouthP1 = new JPanel();
        
        btnsouthP1.setLayout(new FlowLayout());
        btnsouthP1.add(btnReset);
        btnsouthP2 = new JPanel();
        
        btnsouthP2.setLayout(new FlowLayout());
        btnsouthP2.add(btnClose);
        btnsouthP3 = new JPanel();
        
        btnsouthP3.setLayout(new FlowLayout());
        btnsouthP3.add(btnSearch);
        southP.add(btnsouthP3);
        southP.add(btnsouthP1);
        southP.add(btnsouthP2);
        readTheme();
        
        
        if (read.equals("1"))
            redtheme();
        else if (read.equals("2"))
            greentheme();
        else {
            cmbFiles.setBackground(new Color(115, 115, 255));
            cmbFiles2.setBackground(new Color(115, 115, 255));
            
            innerNorthP2.setBackground(new Color(25, 25, 112));
            btnsouthP1.setBackground(new Color(25, 25, 112));
            btnsouthP2.setBackground(new Color(25, 25, 112));
            btnsouthP3.setBackground(new Color(25, 25, 112));
            innerNorthP1.setBackground(new Color(25, 25, 112));  
        }
        
        btnSearch.addActionListener(new ActionListener()
        {    
            private String fileNameToSearch;
              private List<String> result = new ArrayList<String>();
             
              public String getFileNameToSearch() {
                return fileNameToSearch;
              }
             
              public void setFileNameToSearch(String fileNameToSearch) {
                this.fileNameToSearch = fileNameToSearch;
              }
             
              public List<String> getResult() {   
                return result;
              }
              
              
            /**
             * Class to make file 
             */
              
              public void actionPerformed(ActionEvent e) {
                  
                  Experiments fileSearch = new Experiments();
                  String search = txtSearch.getText() + ex;
                  StringBuffer s = new StringBuffer();
                  
                fileSearch.searchDirectory(new File("C:\\Projects"), search); //adding C directory 
             
                int count = fileSearch.getResult().size();
                if(count ==0){
                    displayResults.setText("\nNo result found!");
                }else{
                    displayResults.setText("\nFound " + count + " result!\n");
                    for (String matched : fileSearch.getResult()){
                        s.append(matched  + "\n");
                    
                        displayResults.setText(s.toString());
                    }
                }
              }
             
              /**
               * Method to search and check for directory
               * @param directory
               * @param fileNameToSearch
               */
              
              public void searchDirectory(File directory, String fileNameToSearch) {
             
                setFileNameToSearch(fileNameToSearch);
             
                if (directory.isDirectory()) {
                    search(directory);
                } else {
                    displayResults.setText(directory.getAbsoluteFile() + " is not a directory!");
                }
             
              }
             
              
              /**
               * Method to search the directory
               */
              private void search(File file) {
             
                if (file.isDirectory()) {
                  displayResults.setText("Searching directory ... " + file.getAbsoluteFile());
             
                            
                    if (file.canRead()) {
                    for (File temp : file.listFiles()) {
                        if (temp.isDirectory()) {
                        search(temp);
                        } else {
                        if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {            
                            result.add(temp.getAbsoluteFile().toString());
                        }
             
                    }
                    }
             
                 } else {
                    displayResults.setText(file.getAbsoluteFile() + "Permission Denied");
                 }
                  }
              } 
            });
        
        
        btnReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             txtSearch.setText("");
             txtSearch.setEnabled(true);
             displayResults.setText("");
             cmbFiles.setEnabled(true);
             cmbFiles2.setEnabled(true);
            }        
        });
        
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int answer = JOptionPane.showConfirmDialog(null, "Exit");
                if(answer == JOptionPane.OK_OPTION) System.exit(0);
                
            }
        });
        
        cmbFiles.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                ex = cmbFiles.getSelectedItem().toString();
                if(!cmbFiles.getSelectedItem().toString().equalsIgnoreCase("Documents")) {
                    txtSearch.setEnabled(false);
                } else {
                    txtSearch.setEnabled(true);
                }
            }    
        });
        
        cmbFiles2.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                ex = cmbFiles2.getSelectedItem().toString();
                if(!cmbFiles2.getSelectedItem().toString().equalsIgnoreCase("Music/Videos")) {
                    txtSearch.setEnabled(false);
                } else {
                    txtSearch.setEnabled(true);
                }
            }    
        });        

        northP.add(innerNorthP1);
        northP.add(innerNorthP2);
        c.add(northP, BorderLayout.NORTH);
        c.add(displayResults, BorderLayout.CENTER);
        c.add(southP, BorderLayout.SOUTH);
        
        scrollBar = new JScrollBar();
        getContentPane().add(scrollBar, BorderLayout.EAST);    
    }
    
    StringBuffer s = new StringBuffer();
    
    
    
    class AddButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                File f = new File(file);
                if(!f.exists()) f.createNewFile();
                FileWriter fw = new FileWriter(f, true);
                PrintWriter pw = new PrintWriter(fw);
                
                if(theme == 0)
                    pw.println(""+0);
                else if(theme == 1)
                    pw.println(""+1);
                else if(theme == 2)
                    pw.println(""+2);
                pw.close();
                fw.close();
            } 
            catch (IOException ioe) {}
            
        }
        
    }
    
     /**
      * Main method
      * @param args
      * @throws IOException
      */
    public static void main(String[] args) throws IOException {
        FinalProject app = new FinalProject();
        app.setVisible(true);
        app.setSize(400, 400);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

}