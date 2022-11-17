package controller;

import view.SlangWordView;

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
//            swv.handleChangeSearchDefView();
        }
        else if (src.equals("Random Slang")) {
            swv.handleChangeRandomSlangView();
        }
        else if (src.equals("Guess Meaning")) {
            swv.handleChangeRandomSlangQuizView();
        }
        else if(src.equals("Guess Slang")){
            swv.handleChangeRandomSlangDefView();
        }
        if(src.equals("Search Def")){
            swv.handleSearchSlang();
        }
        else if(src.equals("Search Slang")){
            swv.handleSearchDef();
        }
        else if(src.equals("History")){
            swv.handleLoadHistory();
        }
        else if(src.equals("Add New Slang")){
            swv.handleAddNewSlang();
        }

    }
}
