package view;
import controller.SlangWordListener;
import model.SlangWordModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SlangWordView extends JFrame{
    private SlangWordModel slangModel;
    private JPanel right;
    private JPanel left;
    private JScrollPane scroll;
    private JPanel panel;

    //searchSlang
    private JTextField searchText;
    private JButton searchBtn;
    private JLabel desSearchSlang;
    private int flag=0;

    //search def
    private JTextField searchTextDef;
    private JTextArea searchResult;
    private JLabel des;

    //history
    private JTextArea historyList;

    //add slang
    private JTextField slangText;
    private JTextField defText;


    private ActionListener ac;
    public SlangWordView(){
        this.slangModel = new SlangWordModel();
        this.init("Slang Words",1 );
    }

//    public void setPanel(JPanel panel){
//        this.panel = panel;
//    }
//
//    public JPanel getPanel(){
//        return this.panel;
//    }
    public void setRight(JPanel right){
        this.right = right;
    }

    public JPanel getRight(){
        return this.right;
    }

    public void init(String title, int flag){
        ac = new SlangWordListener(this);
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle(title);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 40);

        //create panel
        panel = new JPanel();
        JLabel label = new JLabel("Slang Words", JLabel.CENTER);
        label.setFont(font);

        left = new JPanel();
        JButton findSlang = new JButton("Find By Slang");
        findSlang.addActionListener(ac);
        JButton findDef = new JButton("Find By Definition");
        findDef.addActionListener(ac);
        JButton history = new JButton("History");
        history.addActionListener(ac);
        JButton addSlang = new JButton("Add Slang");
        addSlang.addActionListener(ac);
        JButton editSlang = new JButton("Edit Slang");
        editSlang.addActionListener(ac);
        JButton deleteSlang = new JButton("Delete Slang");
        deleteSlang.addActionListener(ac);
        JButton resetSlang = new JButton("Reset Slang");
        resetSlang.addActionListener(ac);
        JButton randomSlang = new JButton("Random Slang");
        randomSlang.addActionListener(ac);
        JButton slangQuiz = new JButton("Guess Meaning");
        slangQuiz.addActionListener(ac);
        JButton defQuiz = new JButton("Guess Slang");
        defQuiz.addActionListener(ac);
        left.add(findSlang);
        left.add(findDef);
        left.add(history);
        left.add(addSlang);
        left.add(editSlang);
        left.add(deleteSlang);
        left.add(resetSlang);
        left.add(randomSlang);
        left.add(slangQuiz);
        left.add(defQuiz);
        left.setLayout(new GridLayout(5,2,10,10));

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(left);
        if(flag==1){
            right = searchSLangView(right, ac);

        }
        if(flag==2){
            right=searchDefView(right,ac);
        }
        if(flag==3){
            right=historyView(right,ac);
        }
        if(flag==4){
            right=addSlangWord(right,ac);
        }
        if(flag==5){
            right=editSlangWord(right,ac);
        }
        if(flag==6){
            right=deleteSlangWord(right,ac);
        }
        if(flag==7){
            right=resetSlangWord(right, ac);
        }
        if(flag==8){
            right=randomSlangWord(right,ac);
        }
        if(flag==9){
            right=slangQuiz(right,"Guess Meaning",ac);
        }
        if(flag==10){
            right=slangQuiz(right,"Guess Slang", ac);
        }

        panel.add(right);




//        JLabel about = new JLabel("20127614 - Huỳnh Ngọc Sơn");
        this.setLayout(new BorderLayout());
        if(label==null){
            this.add(label, BorderLayout.PAGE_START);
        }
        this.add(panel, BorderLayout.CENTER);
//        this.add(about, BorderLayout.PAGE_END);

        this.setVisible(true);

    }

    public JPanel searchSLangView(JPanel right, ActionListener ac){
        Font font = new Font("Arial", Font.BOLD, 20);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        //mặc định lúc mới vao nó sẽ ở chức năng tim kiếm theo slang
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        searchText = new JTextField();
        searchText.setFont(font2);
        searchText.setBorder(new EmptyBorder(20,10,20,10));
        searchText.setColumns(40);
        searchText.addActionListener(ac);
        searchBtn = new JButton("Search Def");
        searchBtn.setFont(font2);
        //action listener
        searchBtn.addActionListener(ac);
        searchContainer.add(searchText);
        searchContainer.add(searchBtn);
        searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.X_AXIS));

        JPanel desContainer = new JPanel();
        desSearchSlang = new JLabel("Enter 1 slang word...");
        desSearchSlang.setFont(font);
        desContainer.add(desSearchSlang);
//        desContainer.add(about);
        desContainer.setLayout(new BoxLayout(desContainer, BoxLayout.Y_AXIS));

        right.setLayout(new BorderLayout());

        right.add(searchContainer, BorderLayout.PAGE_START);
        right.add(desContainer, BorderLayout.CENTER);

        return right;
    }
    public JPanel searchDefView(JPanel right, ActionListener ac){
        Font font = new Font("Arial", Font.BOLD, 40);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 18);
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        searchTextDef = new JTextField();
        searchTextDef.setBorder(new EmptyBorder(20,10,20,10));
        searchTextDef.setColumns(40);
        searchTextDef.setFont(font2);
        JButton searchBtn = new JButton("Search Slang");
        searchBtn.setFont(font2);
        searchBtn.addActionListener(ac);
        searchContainer.add(searchTextDef);
        searchContainer.add(searchBtn);
        searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.X_AXIS));

        //result container
        JPanel resultContainer = new JPanel();
        JLabel searchTitle = new JLabel("Search Result",JLabel.CENTER);
        searchTitle.setFont(font2);
        searchResult = new JTextArea(20,20);
        searchResult.setLineWrap(true);
        searchResult.setEditable(false);
        searchResult.setFont(font3);
        scroll = new JScrollPane(searchResult);
        resultContainer.add(searchTitle);
        resultContainer.add(scroll);
        resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));
//        resultContainer.setLocation(100,100);

        //des container
        JPanel desContainer = new JPanel();
        des = new JLabel("");
        des.setFont(font);
        desContainer.add(des);
//        desContainer.add(about);
        desContainer.setLayout(new BoxLayout(desContainer, BoxLayout.Y_AXIS));


//        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setLayout(new BorderLayout());

        right.add(searchContainer, BorderLayout.PAGE_START);
        right.add(resultContainer, BorderLayout.CENTER);
        right.add(desContainer, BorderLayout.PAGE_END);

        return right;
    }

    //history
    public JPanel historyView(JPanel panel, ActionListener ac){
        Font font = new Font("Arial", Font.BOLD, 30);
        right = new JPanel();

        JLabel historyTitle = new JLabel("History:");
        historyTitle.setFont(font);
        historyList = new JTextArea(20,40);
        historyList.setLineWrap(true);
        historyList.setEditable(true);
        scroll = new JScrollPane(historyList);

        right.setLayout(new BorderLayout());
        right.add(historyTitle, BorderLayout.PAGE_START);
        right.add(scroll, BorderLayout.CENTER);

        return right;
    }

    public JPanel addSlangWord(JPanel panel, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        Font font4 = new Font("Arial", Font.BOLD, 15);
        right = new JPanel();

        JLabel addSlangTitle = new JLabel("Add Slang Word");
        addSlangTitle.setFont(font2);

        JPanel newSlangArea = new JPanel();
        JLabel newSlang = new JLabel("Slang: ", JLabel.LEFT);
        newSlang.setFont(font);
        slangText = new JTextField(30);
        slangText.setFont(font4);
//        newSlang.setLabelFor(slangText);
        JLabel newDef = new JLabel("Definition: ",JLabel.LEFT);
        newDef.setFont(font);
        defText = new JTextField(30);
        defText.setFont(font4);
        newSlangArea.setLayout(new BoxLayout(newSlangArea, BoxLayout.Y_AXIS));
        JPanel text = new JPanel();
        text.setLayout(new FlowLayout());
        text.add(newSlang);
        text.add(slangText);

        JPanel def = new JPanel();
        def.setLayout(new FlowLayout());
        def.add(newDef);
        def.add(defText);
        newSlangArea.add(text);
        newSlangArea.add(def);


        JButton addSlangBtn = new JButton("Add New Slang");
        addSlangBtn.addActionListener(ac);
        addSlangBtn.setFont(font);

        right.setLayout(new BorderLayout());
        right.add(addSlangTitle, BorderLayout.PAGE_START);

        right.add(newSlangArea, BorderLayout.CENTER);

        right.add(addSlangBtn, BorderLayout.PAGE_END);


        return right;
    }

    public JPanel editSlangWord(JPanel panel, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right  = new JPanel();


        JLabel editTitle = new JLabel("Edit Slang Word");
        editTitle.setFont(font2);

        JTextField editText = new JTextField(30);
        editText.setBorder(new EmptyBorder(20,20,20,20));
        editText.setFont(font);
        JButton find = new JButton("Search");
        find.setFont(font);

        JPanel topEdit = new JPanel();
        topEdit.setLayout(new BorderLayout());
        topEdit.add(editTitle, BorderLayout.PAGE_START);
        topEdit.add(editText, BorderLayout.CENTER);
        topEdit.add(find,BorderLayout.PAGE_END);

        JPanel editArea = new JPanel();
        editArea.setLayout(new GridLayout(4,1));
        JLabel slang = new JLabel("Slang: ");
        slang.setFont(font);
        JTextField slangText = new JTextField(20);
        slangText.setEditable(false);
        JLabel def = new JLabel("Definition: ");
        def.setFont(font);
        JTextField defText = new JTextField(20);
        editArea.add(slang);
        editArea.add(slangText);
        editArea.add(def);
        editArea.add(defText);

//        right.setLayout(new BorderLayout());
        right.setLayout(new BorderLayout());
//        right.add(editTitle, BorderLayout.PAGE_START);
        right.add(topEdit, BorderLayout.PAGE_START);
        right.add(editArea, BorderLayout.CENTER);


        return right;
    }

    public JPanel deleteSlangWord(JPanel panel, ActionListener ac){
        Font font = new Font("Arial", Font.BOLD, 30);
        Font font3 = new Font("Arial", Font.BOLD, 20);
        Font font4 = new Font("Arial", Font.BOLD, 15);
        right = new JPanel();
        JLabel deleteTitle = new JLabel("Delete Slang");
        deleteTitle.setFont(font);

        JPanel slangTextArea = new JPanel();
        JLabel slang = new JLabel("Enter Slang: ");
        slang.setFont(font);
        JTextField slangText = new JTextField(40);
        slangText.setFont(font4);
        slangText.setBorder(new EmptyBorder(20,20,20,20));
        slangTextArea.setLayout(new FlowLayout());
        slangTextArea.add(slang);
        slangTextArea.add(slangText);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(font3);

        right.setLayout(new BorderLayout());
        right.add(deleteTitle, BorderLayout.PAGE_START);
        right.add(slangTextArea, BorderLayout.CENTER);
        right.add(deleteBtn,BorderLayout.PAGE_END);

        return right;
    }

    public JPanel resetSlangWord(JPanel right, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        right= new JPanel();
        JLabel l = new JLabel("Reset Slang");
        l.setFont(font2);
        right.setLayout(new BorderLayout());
        right.add(l, BorderLayout.CENTER);
        return right;
    }

    public JPanel randomSlangWord(JPanel panel, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 40);
        right =new JPanel();
        JLabel randomTitle = new JLabel("Random Slang (Slang Definition)");
        randomTitle.setFont(font2);
        JLabel slang = new JLabel("", JLabel.CENTER);
        slang.setFont(font);

        right.setLayout(new BorderLayout());
        right.add(randomTitle, BorderLayout.PAGE_START);
        right.add(slang, BorderLayout.CENTER);

        return right;
    }

    public JPanel slangQuiz(JPanel panel, String title, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JPanel titleArea = new JPanel();
        JLabel slangQuizTitle = new JLabel("Slang Quiz ");
        slangQuizTitle.setFont(font2);
        JLabel slang = new JLabel(title);
        slang.setFont(font);
        titleArea.setLayout(new GridLayout(2,1,10,10));
        titleArea.add(slangQuizTitle);
        titleArea.add(slang);




        JPanel quizArea = new JPanel();
        JButton a = new JButton("A.");
        JButton b = new JButton("B.");
        JButton c = new JButton("C.");
        JButton d = new JButton("D.");
        quizArea.setLayout(new GridLayout(2,2,10,10));
        quizArea.add(a);
        a.setFont(font);
        quizArea.add(b);
        b.setFont(font);
        quizArea.add(c);
        c.setFont(font);
        quizArea.add(d);
        d.setFont(font);

        right.setLayout(new BorderLayout());
        right.add(titleArea, BorderLayout.PAGE_START);
        right.add(quizArea, BorderLayout.CENTER);
        right.setPreferredSize(new Dimension(300,300));

        return right;
    }
//    public void changeView(JPanel panel, JPanel oldRight, JPanel newRight){
//        panel.remove(oldRight);
//        panel.add(newRight);
//    }

    public void handleChangeSearchView(){
        this.remove(panel);
        this.init("Slang Word", 1);
    }

    public void handleChangeSearchDefView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 2);
    }
    public void handleChangeHistoryView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 3);
    }
    public void handleChangeAddView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 4);
    }
    public void handleChangeEditView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 5);
    }
    public void handleChangeDeleteView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 6);
    }

    public void handleResetSlangView(){
        this.remove(panel);
        this.init("Slang Word",7);
    }
    public void handleChangeRandomSlangView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 8);
    }
    public void handleChangeRandomSlangQuizView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 9);
    }
    public void handleChangeRandomSlangDefView(){
//        this.flag = 2;
        this.remove(panel);
        this.init("Slang Word", 10);
    }
    public void handleSearchSlang(){
        String slangWord = searchText.getText();
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        String res = this.slangModel.findSlangWord(slangList,slangWord);
        if(res==""){
            res = "No Slang";
        }
        desSearchSlang.setText(res);
//        this.slangModel.getHistory().add(slangWord);
//        this.slangModel.writeFileHistory(slangWord);
    }
    public void handleSearchDef(){
        String def = searchTextDef.getText();
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        ArrayList<String> res = this.slangModel.findDefinition(slangList,def);
        if(res.isEmpty()) {
            des.setText("No Slang");
            searchResult.setText("");
        }else {
            String r = "";
            for(String i: res){
                r=r+i+'\n';
            }
            searchResult.setText(r);
            des.setText("");
//            searchTextDef.setText("");
            searchTextDef.requestFocusInWindow();
        }
    }

    public void handleLoadHistory(){
        ArrayList<String> history = this.slangModel.readFileHistory("history.txt");
        String r = "";
        for(String i: history){
            r=r+i+'\n';
        }
        historyList.setText(r);
    }
    public void handleAddNewSlang(){
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        String slang = slangText.getText();
        String def = defText.getText();
        int check =-1;
        if(slangList.containsKey(slang)){
            String[] options = {"Overwrite it", "Only add meaning", "Cancel"};
            int choice = JOptionPane.showOptionDialog(this, "Slang is already existed!",
                    "Slang existed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[2]);
            if(choice==0){
                this.slangModel.addSlangWord(slangList,slang,def,1);
                JOptionPane.showMessageDialog(this, "Done!");
            }
            else if(choice==1){
                this.slangModel.addSlangWord(slangList,slang,def,2);
                JOptionPane.showMessageDialog(this, "Done!");
            }
        }
        else {
            this.slangModel.addSlangWord(slangList,slang,def,3);
            JOptionPane.showMessageDialog(this, "A slang has been added!");
        }
    }
}
