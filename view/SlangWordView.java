package view;
import model.SlangWordModel;

import java.awt.*;
import javax.swing.*;
public class SlangWordView extends JFrame{
    private SlangWordModel slangModel;
    private JPanel right;
    private JPanel left;
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
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Slang Words");

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
        searchResult.setEditable(false);
        resultContainer.add(searchTitle);
        resultContainer.add(searchResult);
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






        panel.setLayout(new FlowLayout());
        panel.add(left);
        panel.add(right);


        JLabel about = new JLabel("20127614 - Huỳnh Ngọc Sơn");
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(about, BorderLayout.PAGE_END);
        this.setVisible(true);

    }
}
