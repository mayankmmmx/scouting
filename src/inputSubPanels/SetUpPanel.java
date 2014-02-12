package inputSubPanels;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SetUpPanel extends JPanel {
    
    private JComboBox num;
    private JComboBox name;
    private JTextField matchNum;
    private JTextField scoutName;
    private ArrayList<Integer> teamNums;
    private ArrayList<String> teamNames;
    
    @SuppressWarnings("unchecked")
	public SetUpPanel(ArrayList<Integer> teamNums,ArrayList<String> teamNames){

    	this.teamNums = new ArrayList(teamNums);
    	this.teamNames = new ArrayList(teamNames);
    	
        num = new JComboBox(teamNums.toArray());
        
        name = new JComboBox(teamNames.toArray());
        
        num.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                name.setSelectedIndex(num.getSelectedIndex());
            }
        });
        
        name.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                num.setSelectedIndex(name.getSelectedIndex());
            }
        });
        matchNum = new JTextField("Match Number",3);
        Methods.clearAndResetText(matchNum,matchNum.getText());
        scoutName = new JTextField("Scout Name");
        Methods.clearAndResetText(scoutName,scoutName.getText());
        add(num);
        add(name);
        add(matchNum);
        add(scoutName);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    public int getTeamNumber(){
    	return (Integer)num.getSelectedItem();
    }
    public String getTeamName(){
    	return (String)name.getSelectedItem();
    }
    public int getMatchNumber(){
    	return Integer.parseInt(matchNum.getText());
    }
    public String getScoutName(){
    	return scoutName.getText();
    }
    public void setMatchNumber(int matchNumber){
    	matchNum.setText(Integer.toString(matchNumber));
    }
    public void setScoutName(String scoutName){
    	this.scoutName.setText(scoutName);
    }
    public void setTeamNumber(int teamNumber){
    	for( int i = 0; i < teamNums.size(); i++ )
    		if( teamNumber == teamNums.get(i) )
    			num.setSelectedIndex(i);
    	return;
    }
    public void setTeamName(String teamName){
    	for( int i = 0; i < teamNums.size(); i++ )
    		if( teamName.equals(teamNames.get(i)) )
    			num.setSelectedIndex(i);
    	return;
    }
}