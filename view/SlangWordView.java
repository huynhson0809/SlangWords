package view;
import model.SlangWordModel;

import java.awt.*;
import javax.swing.*;
public class SlangWordView extends JFrame{
    private SlangWordModel slangModel;
    private JPanel right;
    private JPanel left;
    private JScrollPane scroll;
    private JPanel panel;
    public SlangWordView(){
        this.slangModel = new SlangWordModel();
        this.init("Slang Words");
    }
    public void init(String title){
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle(title);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 40);

        //create panel
        panel = new JPanel();
        JLabel label = new JLabel("Slang Words", JLabel.CENTER);
        label.setFont(font);

        left = new JPanel();
        JButton findSlang = new JButton("Find By Slang");
        JButton findDef = new JButton("Find By Definition");
        JButton history = new JButton("History");
        JButton addSlang = new JButton("Add Slang");
        JButton editSlang = new JButton("Edit Slang");
        JButton deleteSlang = new JButton("Delete Slang");
        JButton resetSlang = new JButton("Reset Slang");
        JButton randomSlang = new JButton("Random Slang");
        JButton slangQuiz = new JButton("Guess Meaning");
        JButton defQuiz = new JButton("Guess Slang");
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
        left.setLayout(new GridLayout(10,1,10,10));

        panel.setLayout(new FlowLayout());
        panel.add(left);
        slangQuiz(panel, "Slang Quiz");
//        panel.remove(right);




        JLabel about = new JLabel("20127614 - Huỳnh Ngọc Sơn");
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.PAGE_START);
        this.add(panel, BorderLayout.CENTER);
        this.add(about, BorderLayout.PAGE_END);

        this.setVisible(true);

    }

    public void searchSLangView(JPanel panel){
        Font font = new Font("Arial", Font.BOLD, 40);
        //mặc định lúc mới vao nó sẽ ở chức năng tim kiếm theo slang
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        JTextField searchText = new JTextField();
        searchText.setColumns(40);
        JButton searchBtn = new JButton("Search");
        searchContainer.add(searchText);
        searchContainer.add(searchBtn);
        searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.X_AXIS));

        JPanel desContainer = new JPanel();
        JLabel des = new JLabel("No Slang");
        des.setFont(font);
        desContainer.add(des);
//        desContainer.add(about);
        desContainer.setLayout(new BoxLayout(desContainer, BoxLayout.Y_AXIS));

        right.setLayout(new BorderLayout());

        right.add(searchContainer, BorderLayout.PAGE_START);
        right.add(desContainer, BorderLayout.CENTER);

        panel.add(right);
    }
    public void searchDefView(JPanel panel){
        Font font = new Font("Arial", Font.BOLD, 40);
        //mặc định lúc mới vao nó sẽ ở chức năng tim kiếm theo slang
        right = new JPanel();

        //search Container
        JPanel searchContainer = new JPanel();
        JTextField searchText = new JTextField();
        searchText.setColumns(40);
        JButton searchBtn = new JButton("Search");
        searchContainer.add(searchText);
        searchContainer.add(searchBtn);
        searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.X_AXIS));

        //result container
        JPanel resultContainer = new JPanel();
        JLabel searchTitle = new JLabel("Search Result",JLabel.CENTER);
        JTextArea searchResult = new JTextArea(20,20);
        searchResult.setLineWrap(true);
        searchResult.setEditable(true);
        scroll = new JScrollPane(searchResult);
        resultContainer.add(searchTitle);
        resultContainer.add(scroll);
        resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));
//        resultContainer.setLocation(100,100);

        //des container
        JPanel desContainer = new JPanel();
        JLabel des = new JLabel("No Slang");
        des.setFont(font);
        desContainer.add(des);
//        desContainer.add(about);
        desContainer.setLayout(new BoxLayout(desContainer, BoxLayout.Y_AXIS));


//        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setLayout(new BorderLayout());

        right.add(searchContainer, BorderLayout.PAGE_START);
        right.add(resultContainer, BorderLayout.CENTER);
        right.add(desContainer, BorderLayout.PAGE_END);

        panel.add(right);
    }

    //history
    public void historyView(JPanel panel){
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JLabel historyTitle = new JLabel("History:");
        historyTitle.setFont(font);
        JTextArea hitoryList = new JTextArea(20,40);
        hitoryList.setLineWrap(true);
        hitoryList.setEditable(true);
        scroll = new JScrollPane(hitoryList);

        right.setLayout(new BorderLayout());
        right.add(historyTitle, BorderLayout.PAGE_START);
        right.add(scroll, BorderLayout.CENTER);

        panel.add(right);

    }

    public void addSlangWord(JPanel panel){
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();

        JLabel addSlangTitle = new JLabel("Add Slang Word");
        addSlangTitle.setFont(font);

        JLabel newSlang = new JLabel("Slang: ", JLabel.LEFT);
        newSlang.setFont(font);
        JTextField slangText = new JTextField(40);
//        newSlang.setLabelFor(slangText);
        JLabel newDef = new JLabel("Definition: ",JLabel.LEFT);
        newDef.setFont(font);
        JTextField defText = new JTextField(40);
//        slangArea.setLayout(new BoxLayout(slangArea, BoxLayout.Y_AXIS));


        JButton addSlangBtn = new JButton("Add");
//        addSlangBtn.setBounds(80,30,120,80);

        right.setLayout(new GridLayout(6,1,10,10));
        right.add(addSlangTitle);
        right.add(newSlang);
        right.add(slangText);
        right.add(newDef);
        right.add(defText);
        right.add(addSlangBtn);


        panel.add(right);
    }

    public void editSlangWord(JPanel panel){
        Font font = new Font("Arial", Font.BOLD, 20);
        right  = new JPanel();


        JLabel editTitle = new JLabel("Edit Slang Word");
        editTitle.setFont(font);


        JLabel enterEditSlang = new JLabel("Enter Slang: ");
        enterEditSlang.setFont(font);

        JTextField editText = new JTextField(30);
        JButton find = new JButton("Search");

        JPanel topEdit = new JPanel();
        topEdit.setLayout(new FlowLayout());
//        topEdit.add(enterEditSlang);
        topEdit.add(editText);
        topEdit.add(find);

        JLabel slang = new JLabel("Slang: ");
        slang.setFont(font);
        JTextField slangText = new JTextField(30);
        slangText.setEditable(false);

        JLabel def = new JLabel("Definition: ");
        def.setFont(font);
        JTextField defText = new JTextField(30);

//        right.setLayout(new BorderLayout());
        right.setLayout(new GridLayout(7,1));
        right.add(editTitle);
        right.add(enterEditSlang);
        right.add(topEdit);
        right.add(slang);
        right.add(slangText);
        right.add(def);
        right.add(defText);


        panel.add(right);
    }

    public void deleteSlangWord(JPanel panel){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right = new JPanel();
        JLabel deleteTitle = new JLabel("Delete Slang: ");
        deleteTitle.setFont(font2);

        JLabel slang = new JLabel("Enter Slang: ");
        slang.setFont(font);
        JTextField slangText = new JTextField(30);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(font);

        right.setLayout(new GridLayout(4,1,10,10));
        right.add(deleteTitle);
        right.add(slang);
        right.add(slangText);
        right.add(deleteBtn);

        panel.add(right);
    }

    public void randomSlangWord(JPanel panel){
        Font font2 = new Font("Arial", Font.BOLD, 30);
        Font font = new Font("Arial", Font.BOLD, 20);
        right =new JPanel();
        JLabel randomTitle = new JLabel("Random Slang");
        randomTitle.setFont(font2);
        JLabel slang = new JLabel("Hello ae");
        slang.setFont(font);

        right.setLayout(new GridLayout(2,1,10,10));
        right.add(randomTitle);
        right.add(slang);

        panel.add(right);
    }

    public void slangQuiz(JPanel panel, String title){
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

        panel.add(right);
    }
//    public void changeView()
}
