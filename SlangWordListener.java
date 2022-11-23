
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlangWordListener implements ActionListener {
    private SlangWordView swv;
    public SlangWordListener(SlangWordView swv){
        this.swv = swv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println("Ban da nhan nut: "+ src);
        if(src.equals("Find By Slang")){
            swv.handleChangeSearchView();
        } else if (src.equals("Find By Definition")) {
            swv.handleChangeSearchDefView();
        }
        else if (src.equals("History")) {
            swv.handleChangeHistoryView();
        }
        else if (src.equals("Add Slang")) {
            swv.handleChangeAddView();
        }
        else if (src.equals("Edit Slang")) {
            swv.handleChangeEditView();
        }
        else if (src.equals("Delete Slang")) {
            swv.handleChangeDeleteView();
        }
        else if (src.equals("Reset Slang")) {
            swv.handleResetSlangView();
        }
        else if (src.equals("Random Slang")) {
            swv.handleChangeRandomSlangView();
            swv.handleRandomSlang();
        }
        else if (src.equals("Guess Meaning")) {
            swv.handleChangeRandomSlangQuizView();
            swv.handleSlangQuiz(-1,1);
        }
        else if(src.equals("Guess Slang")){
            swv.handleChangeRandomSlangDefView();
            swv.handleSlangQuiz(-1,2);
        }
        if(src.equals("search definition")){
            swv.handleSearchSlang();
        }

        else if(src.equals("search def")){
            swv.handleSearchDef();
        }
        else if(src.equals("History")){
            swv.handleLoadHistory();
        }
        else if(src.equals("Clear history")){
            swv.handleClearHistory();
        }
        else if(src.equals("Add New Slang")){
            swv.handleAddNewSlang();
        }
        else if(src.equals("search slang to edit")){
            swv.handleEditSlang();
        }
        else if(src.equals("save slang")){
            swv.handleSaveSlangEdit();
        }
        else if(src.equals("Delete")){
            swv.handleDeleteSlang();
        }
        else if(src.equals("reset slang btn")){
            swv.resetOriginSlang();
        }
        else if(src.equals("A")){
            swv.handleSlangQuiz(0,1);
        }
        else if(src.equals("B")){
            swv.handleSlangQuiz(1,1);
        }
        else if(src.equals("C")){
            swv.handleSlangQuiz(2,1);
        }
        else if(src.equals("D")){
            swv.handleSlangQuiz(3,1);
        }
        else if(src.equals("A2")){
            swv.handleSlangQuiz(0,2);
        }
        else if(src.equals("B2")){
            swv.handleSlangQuiz(1,2);
        }
        else if(src.equals("C2")){
            swv.handleSlangQuiz(2,2);
        }
        else if(src.equals("D2")){
            swv.handleSlangQuiz(3,2);
        }


    }
}

