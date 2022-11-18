package view;
import controller.SlangWordListener;
import model.SlangWordModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
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
    private JButton searchDefBtn;

    //history
    private JTextArea historyList;
    private JButton resetHistory;

    //add slang
    private JTextField slangText;
    private JTextField defText;

    //edit slang
    private JButton findSlangEdit;
    private JLabel slangEdit;
    private JLabel defEdit;
    private JTextField editText;

    private JButton saveEditSlang;

    private JTextField slangTextEdit;
    private JTextField defTextEdit;

    //delete
    private JTextField slangDeleteText;
    private JButton deleteBtn;

    //reset
    private JButton resetBtn;
    //random Slang
    private JLabel slangRandom;

    //slang quiz
    private JButton[] anwerBtn;
    private JLabel slangQues;

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
        this.setSize(600, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 40);
        Font font2 = new Font("Arial", Font.BOLD, 20);

        //create panel
        panel = new JPanel();
        JLabel label = new JLabel("Slang Words", JLabel.CENTER);
        label.setFont(font);

        left = new JPanel();
        JButton findSlang = new JButton("Find By Slang");
        findSlang.setBackground(new Color(33, 151, 221));
        findSlang.setForeground(Color.WHITE);
        findSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon searchIcon = new ImageIcon("search-icon.png");
        findSlang.setIcon(searchIcon);
        findSlang.setFont(font2);
        findSlang.addActionListener(ac);
        JButton findDef = new JButton("Find By Definition");
        findDef.setBackground(new Color(33, 151, 221));
        findDef.setForeground(Color.WHITE);
        findDef.setCursor(new Cursor(Cursor.HAND_CURSOR));
        findDef.addActionListener(ac);
        findDef.setIcon(searchIcon);
        findDef.setFont(font2);
        JButton history = new JButton("History");
        history.setBackground(new Color(33, 151, 221));
        history.setForeground(Color.WHITE);
        history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon historyIcon = new ImageIcon("history.png");
        history.setFont(font2);
        history.setIcon(historyIcon);
        history.addActionListener(ac);
        JButton addSlang = new JButton("Add Slang");
        addSlang.setBackground(new Color(33, 151, 221));
        addSlang.setForeground(Color.WHITE);
        addSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon addIcon = new ImageIcon("add.png");
        addSlang.setIcon(addIcon);
        addSlang.setFont(font2);
        addSlang.addActionListener(ac);
        JButton editSlang = new JButton("Edit Slang");
        editSlang.setBackground(new Color(33, 151, 221));
        editSlang.setForeground(Color.WHITE);
        editSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon editIcon = new ImageIcon("edit.png");
        editSlang.setIcon(editIcon);
        editSlang.setFont(font2);
        editSlang.addActionListener(ac);
        JButton deleteSlang = new JButton("Delete Slang");
        deleteSlang.setBackground(new Color(33, 151, 221));
        deleteSlang.setForeground(Color.WHITE);
        deleteSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon deleteIcon = new ImageIcon("delete.png");
        deleteSlang.setIcon(deleteIcon);
        deleteSlang.setFont(font2);
        deleteSlang.addActionListener(ac);
        JButton resetSlang = new JButton("Reset Slang");
        resetSlang.setBackground(new Color(33, 151, 221));
        resetSlang.setForeground(Color.WHITE);
        resetSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon resetIcon = new ImageIcon("reset.png");
        resetSlang.setIcon(resetIcon);
        resetSlang.setFont(font2);
        resetSlang.addActionListener(ac);
        JButton randomSlang = new JButton("Random Slang");
        randomSlang.setBackground(new Color(33, 151, 221));
        randomSlang.setForeground(Color.WHITE);
        randomSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon randomIcon = new ImageIcon("random.png");
        randomSlang.setIcon(randomIcon);
        randomSlang.setFont(font2);
        randomSlang.addActionListener(ac);
        JButton slangQuiz = new JButton("Guess Meaning");
        slangQuiz.setBackground(new Color(33, 151, 221));
        slangQuiz.setForeground(Color.WHITE);
        slangQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon quizIcon = new ImageIcon("quiz.png");
        slangQuiz.setIcon(quizIcon);
        slangQuiz.setFont(font2);
        slangQuiz.addActionListener(ac);
        JButton defQuiz = new JButton("Guess Slang");
        defQuiz.setBackground(new Color(33, 151, 221));
        defQuiz.setForeground(Color.WHITE);
        defQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        defQuiz.setFont(font2);
        defQuiz.setIcon(quizIcon);
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
        left.setBorder(new EmptyBorder(20,10,20,10));

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
            right=slangQuiz(right,"Guess Meaning",ac,1);
        }
        if(flag==10){
            right=slangQuiz(right,"Guess Slang", ac,2);
        }
        right.setBorder(new EmptyBorder(10,10,20,10));
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
        Font font = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        //mặc định lúc mới vao nó sẽ ở chức năng tim kiếm theo slang
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        JLabel searchSlangTitle = new JLabel("Search Slang", JLabel.LEFT);
        searchSlangTitle.setFont(font);
        searchSlangTitle.setForeground(new Color(33, 151, 221));
        searchText = new JTextField();
        searchText.setFont(font2);
//        searchText.setBorder(new EmptyBorder(20,10,20,10));
        searchText.setColumns(40);
        searchText.addActionListener(ac);
        searchBtn = new JButton("Search");
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.setActionCommand("search definition");
        searchBtn.setFont(font2);
        //action listener
        searchBtn.addActionListener(ac);

        JPanel searchArea = new JPanel();
        searchArea.setLayout(new BoxLayout(searchArea, BoxLayout.X_AXIS));
        searchArea.add(searchText);
        searchArea.add(searchBtn);

        searchContainer.add(searchSlangTitle);
        searchContainer.add(searchArea);
        searchContainer.setLayout(new GridLayout(2,1));

        JPanel desContainer = new JPanel();
        desSearchSlang = new JLabel("Enter 1 slang word...");
        desSearchSlang.setForeground(new Color(33, 151, 221));
        desSearchSlang.setBorder(new EmptyBorder(15,0,0,0));
        desSearchSlang.setFont(font2);
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
        Font font4 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 18);
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        JLabel searchDefTitle = new JLabel("Search by definition");
        searchDefTitle.setFont(font4);
        searchDefTitle.setForeground(new Color(33, 151, 221));

        searchTextDef = new JTextField();
//        searchTextDef.setBorder(new EmptyBorder(20,10,20,10));
        searchTextDef.setColumns(40);
        searchTextDef.setFont(font2);
        searchDefBtn = new JButton("Search");
        searchDefBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchDefBtn.setFont(font2);
        searchDefBtn.setActionCommand("search def");
        searchDefBtn.addActionListener(ac);
        JPanel searchDefArea = new JPanel();
        searchDefArea.setLayout(new BoxLayout(searchDefArea, BoxLayout.X_AXIS));
        searchDefArea.add(searchTextDef);
        searchDefArea.add(searchDefBtn);

        searchContainer.add(searchDefTitle);
        searchContainer.add(searchDefArea);
        searchContainer.setLayout(new GridLayout(2,1));

        //result container
        JPanel resultContainer = new JPanel();
        JLabel searchTitle = new JLabel("Search Result",JLabel.LEFT);
        searchTitle.setForeground(new Color(33, 151, 221));
        searchTitle.setHorizontalTextPosition(JLabel.LEFT);
        searchTitle.setFont(font2);
        searchResult = new JTextArea(20,20);
        searchResult.setLineWrap(true);
        searchResult.setEditable(false);
        searchResult.setFont(font3);
        scroll = new JScrollPane(searchResult);
        resultContainer.add(searchTitle);
        resultContainer.add(scroll);
        resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));
        resultContainer.setBorder(new EmptyBorder(15,0,0,0));
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
        Font font2 = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JLabel historyTitle = new JLabel("History:");
        historyTitle.setForeground(new Color(33, 151, 221));
        historyTitle.setFont(font);
        historyList = new JTextArea(20,40);
        historyList.setLineWrap(true);
        historyList.setEditable(true);
        historyList.setEditable(false);
        historyList.setFont(font2);
        scroll = new JScrollPane(historyList);
        resetHistory = new JButton("Clear history");
        resetHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetHistory.addActionListener(ac);
        resetHistory.setFont(font2);

        right.setLayout(new BorderLayout());
        right.add(historyTitle, BorderLayout.PAGE_START);
        right.add(scroll, BorderLayout.CENTER);
        right.add(resetHistory, BorderLayout.PAGE_END);

        return right;
    }

    public JPanel addSlangWord(JPanel panel, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JLabel addSlangTitle = new JLabel("Add Slang Word");
        addSlangTitle.setForeground(new Color(33, 151, 221));
        addSlangTitle.setFont(font2);

        JPanel newSlangArea = new JPanel();
        JLabel newSlang = new JLabel("Slang: ", JLabel.LEFT);
        newSlang.setFont(font);
        slangText = new JTextField(30);
        slangText.setFont(font);
//        newSlang.setLabelFor(slangText);
        JLabel newDef = new JLabel("Definition: ",JLabel.LEFT);
        newDef.setFont(font);
        defText = new JTextField(30);
        defText.setFont(font);
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
        addSlangBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        editTitle.setForeground(new Color(33, 151, 221));
        editTitle.setFont(font2);

        editText= new JTextField(30);
//        editText.setBorder(new EmptyBorder(20,20,20,20));
        editText.setFont(font);

        findSlangEdit = new JButton("Search");
        findSlangEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        findSlangEdit.setActionCommand("search slang to edit");
        findSlangEdit.addActionListener(ac);
        findSlangEdit.setFont(font);

        JPanel topEdit = new JPanel();
        topEdit.setLayout(new BorderLayout());
        topEdit.add(editTitle, BorderLayout.PAGE_START);
        topEdit.add(editText, BorderLayout.CENTER);
        topEdit.add(findSlangEdit,BorderLayout.PAGE_END);

        JPanel editArea = new JPanel();
        editArea.setLayout(new GridLayout(5,1));
        slangEdit = new JLabel("Slang: ");
        slangEdit.setFont(font);
        slangTextEdit = new JTextField(20);
        slangTextEdit.setEditable(false);
        slangTextEdit.setFont(font);
        defEdit = new JLabel("Definition: ");
        defEdit.setFont(font);
        defTextEdit = new JTextField(20);
        saveEditSlang = new JButton("Save");
        saveEditSlang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveEditSlang.setActionCommand("save slang");
        saveEditSlang.addActionListener(ac);
        saveEditSlang.setFont(font);

        editArea.add(slangEdit);
        defTextEdit.setFont(font);
        editArea.add(slangTextEdit);
        editArea.add(defEdit);
        editArea.add(defTextEdit);
        editArea.add(saveEditSlang);

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
        deleteTitle.setForeground(new Color(33, 151, 221));
        deleteTitle.setFont(font);

        JPanel slangTextArea = new JPanel();
        JLabel slang = new JLabel("Enter Slang: ");
        slang.setFont(font);
        slangDeleteText = new JTextField(40);
        slangDeleteText.setFont(font4);
        slangDeleteText.setBorder(new EmptyBorder(20,20,20,20));
        slangTextArea.setLayout(new FlowLayout());
        slangTextArea.add(slang);
        slangTextArea.add(slangDeleteText);

        deleteBtn= new JButton("Delete");
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteBtn.setFont(font3);
        deleteBtn.addActionListener(ac);

        right.setLayout(new BorderLayout());
        right.add(deleteTitle, BorderLayout.PAGE_START);
        right.add(slangTextArea, BorderLayout.CENTER);
        right.add(deleteBtn,BorderLayout.PAGE_END);

        return right;
    }

    public JPanel resetSlangWord(JPanel right, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        right= new JPanel();
        resetBtn = new JButton("Reset Slang");
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.setActionCommand("reset slang btn");
        resetBtn.setFont(font2);
        resetBtn.addActionListener(ac);
        right.setLayout(new BorderLayout());
        right.add(resetBtn, BorderLayout.CENTER);
        return right;
    }

    public JPanel randomSlangWord(JPanel panel, ActionListener ac){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 30);
        right =new JPanel();
        JLabel randomTitle = new JLabel("Random Slang (`Slang` Definition)");
        randomTitle.setForeground(new Color(33, 151, 221));
        randomTitle.setFont(font2);
        slangRandom = new JLabel("", JLabel.CENTER);
        slangRandom.setFont(font);
        slangRandom.setForeground(Color.RED);

        right.setLayout(new BorderLayout());
        right.add(randomTitle, BorderLayout.PAGE_START);
        right.add(slangRandom, BorderLayout.CENTER);

        return right;
    }

    public JPanel slangQuiz(JPanel panel, String title, ActionListener ac,int check){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JPanel titleArea = new JPanel();
        JLabel slangQuizTitle = new JLabel("Slang Quiz ");
        slangQuizTitle.setForeground(new Color(33, 151, 221));
        slangQuizTitle.setFont(font2);

        JLabel slang = new JLabel(title);
        slang.setFont(font);
        slangQues = new JLabel("#1", JLabel.CENTER);
        slangQues.setFont(font2);
        slangQues.setForeground(Color.RED);
        titleArea.setLayout(new GridLayout(3,1,10,10));
        titleArea.add(slangQuizTitle);
        titleArea.add(slang);
        titleArea.add(slangQues);

        JPanel quizArea = new JPanel();
        anwerBtn = new JButton[4];
        anwerBtn[0] = new JButton("A.");
        anwerBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(check==1){
            anwerBtn[0].setActionCommand("A");
        }
        else {
            anwerBtn[0].setActionCommand("A2");
        }
        anwerBtn[0].addActionListener(ac);
        anwerBtn[1] = new JButton("B.");
        anwerBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(check==1){
            anwerBtn[1].setActionCommand("B");
        }
        else {
            anwerBtn[1].setActionCommand("B2");
        }
        anwerBtn[1].addActionListener(ac);
        anwerBtn[2] = new JButton("C.");
        anwerBtn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(check==1){
            anwerBtn[2].setActionCommand("C");
        }
        else {
            anwerBtn[2].setActionCommand("C2");
        }
        anwerBtn[2].addActionListener(ac);
        anwerBtn[3] = new JButton("D.");
        anwerBtn[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(check==1){
            anwerBtn[3].setActionCommand("D");
        }
        else {
            anwerBtn[3].setActionCommand("D2");
        }
        anwerBtn[3].addActionListener(ac);

        quizArea.setLayout(new GridLayout(2,2,10,10));
        quizArea.add(anwerBtn[0]);
        anwerBtn[0].setFont(font);
        quizArea.add( anwerBtn[1]);
        anwerBtn[1].setFont(font);
        quizArea.add(anwerBtn[2]);
        anwerBtn[2].setFont(font);
        quizArea.add(anwerBtn[3]);
        anwerBtn[3].setFont(font);

        right.setLayout(new BorderLayout());
        right.add(titleArea, BorderLayout.PAGE_START);
        right.add(quizArea, BorderLayout.CENTER);
        right.setPreferredSize(new Dimension(300,300));

        return right;
    }


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

    public void handleClearHistory(){
        int click = JOptionPane.showConfirmDialog(this,"Are you sure to clear all slang history searches?");
        if (click==JOptionPane.YES_OPTION) {
            this.slangModel.clearHistory();
            historyList.setText("");
            JOptionPane.showMessageDialog(null, "Clear Successfully");
        }
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
                slangText.setText("");
                defText.setText("");
            }
            else if(choice==1){
                this.slangModel.addSlangWord(slangList,slang,def,2);
                JOptionPane.showMessageDialog(this, "Done!");
                slangText.setText("");
                defText.setText("");
            }
        }
        else {
            if(slang.isEmpty()||def.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter slang or definition");
            }
            else {
                this.slangModel.addSlangWord(slangList,slang,def,3);
                JOptionPane.showMessageDialog(this, "A slang has been added!");
                slangText.setText("");
                defText.setText("");
            }
        }
    }

    public void handleEditSlang(){
        String slangSearch = editText.getText();
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        String res = this.slangModel.findSlangWordEdit(slangList,slangSearch);
//        System.out.println(res);
        if(res==""){
            res = "No Slang";
            JOptionPane.showMessageDialog(this, res);
        }
        else {
            String[] result = this.slangModel.splitSlangV2(res);
            slangTextEdit.setText(result[0]);
            defTextEdit.setText(result[1]);
        }
    }

    public void handleSaveSlangEdit(){
        String slangSearch = slangTextEdit.getText();
        System.out.println(slangSearch);
        String defUpdate = defTextEdit.getText();
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        if(!slangSearch.isEmpty() && !defUpdate.isEmpty()){
            this.slangModel.editSlang(slangList,slangSearch,defUpdate);
            JOptionPane.showMessageDialog(this, "Edit Successful");
            slangTextEdit.setText("");
            defTextEdit.setText("");
            editText.setText("");
            editText.requestFocusInWindow();
        }
    }
    public void handleDeleteSlang(){
        String slangSearch = slangDeleteText.getText();
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        String res = this.slangModel.findSlangWordEdit(slangList,slangSearch);
//        System.out.println(res);
        if(res==""){
            res = "No Slang";
            JOptionPane.showMessageDialog(this, res);
        }
        else {
            String[] result = this.slangModel.splitSlangV2(res);
            this.slangModel.deleteSlang(slangList,result[0]);
            JOptionPane.showMessageDialog(this, "Delete Successful");
            slangDeleteText.setText("");
            slangDeleteText.requestFocusInWindow();
        }
    }
    public void resetOriginSlang(){
        int click = JOptionPane.showConfirmDialog(this,"Are you sure to reset Slang Words");
        if (click==JOptionPane.YES_OPTION) {
            this.slangModel.resetSlang();
            JOptionPane.showMessageDialog(null, "Reset Successful");
        }
    }
    public void handleRandomSlang(){
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        String randomSlang = this.slangModel.randomSlangWord(slangList);
        slangRandom.setText(randomSlang);
    }
    public void handleSlangQuiz(int i, int check){
        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        this.slangModel.slangQuiz(slangList, answers,result,check);

        slangQues.setText(result.get(0));
        anwerBtn[0].setText(answers.get(0));
        anwerBtn[1].setText(answers.get(1));
        anwerBtn[2].setText(answers.get(2));
        anwerBtn[3].setText(answers.get(3));
        if(i!=-1){
            if(anwerBtn[i].getText()==result.get(1)){
                JOptionPane.showMessageDialog(this,
                        "Correct!",
                        "Correct answer",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Wrong!",
                        "Wrong answer",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//    public void handleSlangQuizDef(int i, int check){
//        HashMap<String, ArrayList<String>> slangList = this.slangModel.readFile("currentSlang.txt");
//        ArrayList<String> answers = new ArrayList<>();
//        ArrayList<String> result = new ArrayList<>();
//
//        this.slangModel.slangQuiz(slangList, answers,result,check);
//
//        slangQues.setText(result.get(0));
//        anwerBtn[0].setText(answers.get(0));
//        anwerBtn[1].setText(answers.get(1));
//        anwerBtn[2].setText(answers.get(2));
//        anwerBtn[3].setText(answers.get(3));
//        if(i!=-1){
//            if(anwerBtn[i].getText()==result.get(1)){
//                JOptionPane.showMessageDialog(this,
//                        "Correct!",
//                        "Correct answer",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//            else {
//                JOptionPane.showMessageDialog(this,
//                        "Wrong!",
//                        "Wrong answer",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }


}
