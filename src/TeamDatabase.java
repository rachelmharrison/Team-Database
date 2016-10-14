/**
 * @(#)TeamDatabase.java
 *
 * TeamDatabase application
 *
 * @author 
 * @version 1.00 2016/4/12
 */
 
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class TeamDatabase implements MouseListener 
{
    
    public static void main(String[] args) 
    {
    	new TeamDatabase();
    }
  
    JPanel displayPanel=new JPanel();
    JFrame helpFrame=new JFrame("Help");
    JFrame mainFrame=new JFrame("Team Database"); //main window
    CardLayout cardLayout=new CardLayout();  
    boolean tracing=true;
    JPanel clearPanel=new JPanel();
    boolean edit=true;
    boolean editTeamActive=false;
    boolean editStudentActive=false;
    boolean viewTeamActive=false;
    boolean viewStudentActive=false;
    
    //view/edit panel objects
	JPanel viewEditPanel=new JPanel();
	JButton editButton=new JButton("Edit");
	JButton viewButton=new JButton("View");
	JButton helpButton=new JButton("Help");
	
	//view team panel objects
	JPanel viewTeamPanel=new JPanel();
	JPanel viewTeamOverviewPanel= new JPanel();
	JPanel viewTeamBudgetPanel=new JPanel();
	JPanel viewTeamListPanel=new JPanel();
	JPanel viewTeamBottomPanel=new JPanel();
	JLabel teamNameLabelv=new JLabel();
	JLabel teamGenderLabelv=new JLabel();
	JLabel teamSeasonLabelv=new JLabel();
	JLabel teamLevelLabelv=new JLabel();
	JLabel teamMvp1Labelv=new JLabel();
	JLabel teamMvp2Labelv=new JLabel();
	JLabel teamCaptainLabelv=new JLabel();
	JLabel teamTeacherLabelv=new JLabel();
	JButton viewMembersButton=new JButton("View Members");
	JButton viewBudgetButton=new JButton("View Budget");
	
	//view team budget panel objects
	JPanel budgetItemColumn=new JPanel();
	JPanel budgetExpenseColumn=new JPanel();
	LinkedList <String> budgetItems=new LinkedList();
	LinkedList <String> budgetExpense=new LinkedList();
	JPanel empty=new JPanel();
	
	//view team list panel objects
	JPanel listNameColumn=new JPanel();
	JPanel listJerseyColumn=new JPanel();
	JPanel listAthleticFeeColumn=new JPanel();
	JPanel listAllergiesColumn=new JPanel();
	JPanel listGradeColumn=new JPanel();
	JPanel listEligibleColumn=new JPanel();
	LinkedList <StudentLabel> listNames=new LinkedList();
	LinkedList <String> listJerseys=new LinkedList();
	LinkedList <String> listAthleticFees=new LinkedList();
	LinkedList <String> listAllergies=new LinkedList();
	LinkedList <String> listGrades=new LinkedList();
	LinkedList <String> listEligibles=new LinkedList();
	JLabel listNameLabel=new JLabel("<HTML><U>Name</HTML></U>");
    JLabel listJerseyLabel=new JLabel("<HTML><U>Jersey Deposit?</HTML></U>");
    JLabel listAthleticFeeLabel=new JLabel("<HTML><U>Athletic Fee?</HTML></U>");
    JLabel listAllergiesLabel=new JLabel("<HTML><U>Allergies?</HTML></U>");
    JLabel listGradeLabel=new JLabel("<HTML><U>Grade</HTML></U>");
    JLabel listEligibleLabel=new JLabel("<HTML><U>Eligible</HTML></U>");
	
	//side menu 2 objects
	JButton viewStudent=new JButton("View Student");
	JButton viewTeam=new JButton("View Team");
	JPanel sideMenu2=new JPanel();
		
	//side menu 1 objects
	JButton makeStudent=new JButton("Make Student");
	JButton makeTeam=new JButton("Make Team");
	JButton editStudent=new JButton("Edit Student");
	JButton editTeam=new JButton("Edit Team");
	JPanel sideMenu1=new JPanel();
	CardLayout sideMenuCardLayout=new CardLayout();
	JPanel sideMenuPanel=new JPanel();
	
	
	//view student panel object
	JPanel viewStudentPanel=new JPanel();
	JLabel nameLabelv=new JLabel();
	JLabel genderLabelv=new JLabel();
	JLabel gradeLabelv=new JLabel();
	JLabel averageLabelv=new JLabel();
	JLabel fallSportLabelv=new JLabel();
	JLabel winterSportLabelv=new JLabel();
	JLabel springSportLabelv=new JLabel();
	JLabel yearSportLabelv=new JLabel();
	JLabel allergiesLabelv=new JLabel();
		    
    //student and team linked lists and objects and counters
    JFrame teamListFrame=new JFrame("Team List");
    JPanel teamListPanel=new JPanel();
    CardLayout cl=new CardLayout();
    LinkedList <Student> students= new LinkedList();
    LinkedList <Team> teams=new LinkedList();
    LinkedList <Student> teamList=new LinkedList();
    LinkedList <StudentLabel> teamListLabels=new LinkedList();
    LinkedList <StudentCheckBox> teamCheckBoxes=new LinkedList();
    JButton saveJerseyButton=new JButton("Save Changes");
    JButton saveAthleticFeeButton=new JButton("Save Changes");
    JPanel studentSelectPanel=new JPanel();
    JPanel teamSelectPanel=new JPanel();
    LinkedList <StudentLabel> studentLabels=new LinkedList();
    LinkedList <TeamLabel> teamLabels=new LinkedList();
    JScrollPane studentScrollPane=new JScrollPane();
    int currentStudent=0;
    int currentTeam=0;
    int currentAction=1;
    int studentCounter=0;
    int teamCounter=0;
    
    //make team screen objects
    JPanel makeTeamPanel=new JPanel();
    String[] sports={"-----","Badminton","Baseball","Basketball","Dragonboat","Soccer", "Softball","Swimming"};
    String[] genders={"-----","Girl's", "Boy's", "Co-ed"};
    String[] levels={"------", "Junior", "Senior", "Both"};
    String[] seasons={"-----","Fall", "Winter", "Spring", "All Year"};
    JComboBox sportList=new JComboBox(sports);
    JComboBox genderList=new JComboBox(genders);
    JComboBox seasonList=new JComboBox(seasons);
    JComboBox levelList= new JComboBox(levels);
    JButton okayButton3=new JButton("Okay");
    
    //make student screen objects
    JPanel makeStudentPanel= new JPanel();
    JTextField firstNameField=new JTextField();
    JTextField lastNameField=new JTextField();
    String[] sexes= {"-----","Female", "Male"};
    String[] grades= {"-","9", "10", "11", "12", "5th Year"}; 
    JComboBox sexList= new JComboBox(sexes);
    JComboBox gradeList= new JComboBox(grades);
    JButton okayButton=new JButton("Okay");
    JLabel allergiesLabel=new JLabel("Allergies or health conditions? ");
    String[] yesNo={"--","Yes","No"};
    JComboBox yesNoList=new JComboBox(yesNo);
    JLabel allergiesLabel2=new JLabel("Please provide details: ");
    JTextArea allergiesArea=new JTextArea();
    JButton okayButton2=new JButton("Okay");
    JLabel averageLabel=new JLabel("Academic Average: ");
    JTextField averageField =new JTextField();
    
    //edit student screen objects
    JPanel editStudentPanel= new JPanel();
   	JTextField firstNameF=new JTextField();
   	JTextField lastNameF=new JTextField();   
   	JTextField averageF=new JTextField();
   	JComboBox sexCb=new JComboBox(sexes);
   	JComboBox gradeCb=new JComboBox(grades); 
   	JTextArea allergiesA=new JTextArea();
   	JButton saveButton=new JButton("Save Changes");
   	JButton deleteButton1=new JButton("Delete Student");
   	
   	//edit team screen objects
   	JButton deleteButton2=new JButton("Delete Team");
   	JPanel editTeamPanel=new JPanel();
	JLabel sportHeader=new JLabel("Sport Example");
	JLabel genderHeader=new JLabel("Gender Example");
	JLabel levelHeader=new JLabel("Level Example");
	JLabel seasonHeader=new JLabel("Season Example");
	JButton addStudentButton=new JButton("Add Student");
	JButton deleteStudentButton=new JButton("Delete Student");
	JButton addExpenseButton=new JButton("Add Expense");
	JButton addIncomeButton=new JButton("Add Income");
	JButton mvpButton1=new JButton("MVP 1");
	JButton mvpButton2=new JButton("MVP 2");
	JButton captainButton=new JButton("Captain");
	JButton teacherButton=new JButton("Teacher");
	JButton jerseyButton=new JButton("Jersey Deposit");
	JButton athleticFeeButton=new JButton("Athletic Fee");
	JLabel addStudentLabel1=new JLabel("First Name: ");
	JLabel addStudentLabel2=new JLabel("Last Name: ");
	JTextField addStudentField1=new JTextField();
	JTextField addStudentField2=new JTextField();
	JButton searchButton1=new JButton("Search");
	JButton doneButton1=new JButton("Okay");
	JLabel incomeLabel2=new JLabel("Source:");
	JTextField incomeField1=new JTextField();
	JTextField incomeField2=new JTextField();
	JLabel expenseLabel2=new JLabel("Source: ");
	JTextField expenseField1=new JTextField();
	JTextField expenseField2=new JTextField();
	JButton doneButton3=new JButton("Okay");
	JButton doneButton4=new JButton("Okay");
   
    TeamDatabase()
    {
    	teamListFrame.setVisible(false);
    	mainFrame.setLayout(null);
    	mainFrame.setSize(1000, 600);
    	
    	//create view/edit panel and add to main frame
    	viewEditPanel.setLayout(null);
    	viewEditPanel.setSize(280,40);
    	viewEditPanel.add(editButton);
    	editButton.setBounds(0,10,80,20);
    	viewEditPanel.add(viewButton);
    	viewButton.setBounds(85,10,80,20);
    	viewEditPanel.add(helpButton);
    	helpButton.setBounds(170,10,80,20);
    	helpButton.addMouseListener(this);
    	mainFrame.add(viewEditPanel);
    	viewEditPanel.setBounds(720,0,280,40);
    	viewButton.addMouseListener(this);
    	editButton.addMouseListener(this);
    	JPanel helpPanel=new JPanel();
    	JTextArea helpText=new JTextArea();
    	helpText.setWrapStyleWord(true);
    	helpText.setSize(450,700);
    	helpText.setLineWrap(true);
    	helpText.setText("Help\n\nGeneral: On the top right corner, there are 2 buttons, along with the help button, View and Edit.\n\nView: Provides the option to view students or teams.\n\nEdit: Provides options to edit or create students or teams.\n\nAt any time, when editing or viewing, click on one of these to switch modes with the same element, ie if you are editing Senna Daymond, and click view, the view pane will show for Senna Daymond.\n\nCreate a Student: Enter the information as prompted, and click on buttons to proceed. Ensure the average is within range 0-100. Click directly on the allergy response to proceed. (Click on the word)\n\nCreate a Team: Make sure to enter all information. You will be prompted if any information is missing or duplicate\n\nEdit Student: Click on the student that you wish to edit, and after changing any information, click ‘Save Changes’ Click on delete to delete the student.\n\nEdit Team: Here, you can add, delete students by clicking on the appropriate button and following the prompts. A maximum of 20 students can be added to a team. Add incomes and expenses the same way, making sure not to enter a negative value, and to provide a source of income and expense. To set MVPs, and captain, a list of team members will be presented to select from. Enter the name of a teacher to set that. To keep track of who has paid the jersey deposit and athletic fee, a check box list where you can select students is provided. Click on delete team to delete team.\n\nView Student: click on the student on the list provided when this button is pressed.\n\nView Team: The information will be displayed, along with buttons linking to a member list and outline of the budget.");
    	helpText.setEditable(false);
    	helpPanel.add(helpText);
    	helpFrame.add(helpPanel);
    	helpFrame.setSize(480,630);
    	helpFrame.setResizable(false);
    	helpFrame.setVisible(false);
    	
    	
    	//create student view panel
    	GridBagConstraints gbc=new GridBagConstraints();
    	gbc.insets=new Insets(4,4,4,4);
    	JLabel fallSportLabel=new JLabel("<HTML><U>Fall Sport</U><HTML>");
    	JLabel winterSportLabel=new JLabel("<HTML><U>Winter Sport</U><HTML>");
    	JLabel springSportLabel=new JLabel("<HTML><U>Spring Sport</U><HTML>");
    	JLabel yearSportLabel=new JLabel("<HTML><U>All Year Sport</U><HTML>");
    	viewStudentPanel.setLayout(new GridBagLayout());
    	JPanel basicInfo=new JPanel();
    	basicInfo.setLayout(new GridLayout(5,1));
    	JPanel sports=new JPanel();
    	sports.setLayout(new GridLayout(2,4));
    	basicInfo.add(nameLabelv);
    	basicInfo.add(genderLabelv);
    	basicInfo.add(gradeLabelv);
    	basicInfo.add(averageLabelv);
    	basicInfo.add(allergiesLabelv);
    	sports.add(fallSportLabel);
    	sports.add(winterSportLabel);
    	sports.add(springSportLabel);
    	sports.add(yearSportLabel);	
    	sports.add(fallSportLabelv);
    	sports.add(winterSportLabelv);
    	sports.add(springSportLabelv);
    	sports.add(yearSportLabelv);
    
    	empty.setSize(800,260);
    	gbc.gridx=0;
    	gbc.gridy=0;
    	viewStudentPanel.add(basicInfo, gbc);
    	gbc.gridy=100;
    	viewStudentPanel.add(sports, gbc);
    	gbc.gridy=200;
    	
    	viewStudentPanel.setSize(800,300);
    	
    	//view team panel
    	viewTeamPanel.setLayout(new GridBagLayout());
    	viewTeamOverviewPanel.setLayout(new GridBagLayout());
    	viewTeamBottomPanel.setLayout(cl);
    	viewMembersButton.addMouseListener(this);
    	viewBudgetButton.addMouseListener(this);
    	
    	viewTeamBudgetPanel.setLayout(new GridBagLayout());
    	budgetItemColumn.setLayout(new GridLayout(21,1));
    	budgetExpenseColumn.setLayout(new GridLayout(21,1));
    	gbc.gridx=0;
    	gbc.gridy=0;
    	viewTeamBudgetPanel.add(budgetItemColumn, gbc);
    	gbc.gridx=100;
    	viewTeamBudgetPanel.add(budgetExpenseColumn, gbc);
    	
    	viewTeamListPanel.setLayout(new GridBagLayout());
    	listNameColumn.setLayout(new GridLayout(21,1));
    	listJerseyColumn.setLayout(new GridLayout(21,1));
    	listAthleticFeeColumn.setLayout(new GridLayout(21,1));
    	listGradeColumn.setLayout(new GridLayout(21,1));
    	listEligibleColumn.setLayout(new GridLayout(21,1));
    	gbc.gridy=0;
    	
    	gbc.gridx=400;
    	viewTeamListPanel.add(listGradeLabel, gbc);
    	gbc.gridx=500;
    	viewTeamListPanel.add(listEligibleLabel, gbc);
    	gbc.gridx=0;
    	gbc.gridy=10;
    	viewTeamListPanel.add(listNameColumn, gbc);
    	gbc.gridx=100;
    	viewTeamListPanel.add(listJerseyColumn, gbc);
    	gbc.gridx=200;
    	viewTeamListPanel.add(listAthleticFeeColumn, gbc);
    	gbc.gridx=300;
    	viewTeamListPanel.add(listAllergiesColumn, gbc);
    	gbc.gridx=400;
    	viewTeamListPanel.add(listGradeColumn, gbc);
    	gbc.gridx=500;
    	viewTeamListPanel.add(listEligibleColumn, gbc);
    	
    	
    	viewTeamBottomPanel.add(viewTeamBudgetPanel, "teamBudget");
    	viewTeamBottomPanel.add(viewTeamListPanel, "teamList");
    	viewTeamBottomPanel.add(empty, "clear");
    	
    	gbc.gridx=0;
    	gbc.gridy=0;
    	viewTeamOverviewPanel.add(teamNameLabelv, gbc);
    	gbc.gridy=100;
    	viewTeamOverviewPanel.add(teamCaptainLabelv, gbc);
    	gbc.gridy=200;
    	viewTeamOverviewPanel.add(teamMvp1Labelv, gbc);
    	gbc.gridy=300;
    	viewTeamOverviewPanel.add(viewMembersButton, gbc);
    	gbc.gridx=100;
    	gbc.gridy=0;
    	viewTeamOverviewPanel.add(teamSeasonLabelv, gbc);
    	gbc.gridy=100;
    	viewTeamOverviewPanel.add(teamTeacherLabelv, gbc);
    	gbc.gridy=200;
    	viewTeamOverviewPanel.add(teamMvp2Labelv, gbc);
    	gbc.gridy=300;
    	viewTeamOverviewPanel.add(viewBudgetButton, gbc);
    	
    	gbc.gridx=0;
    	gbc.gridy=0;
    	viewTeamPanel.add(viewTeamOverviewPanel, gbc);
    	gbc.gridy=100;
    	viewTeamPanel.add(viewTeamBottomPanel, gbc);
    	
    
    	//create menu panels and add to main frame
    	viewStudent.addMouseListener(this);
    	viewTeam.addMouseListener(this);
    	makeStudent.addMouseListener(this);
    	makeTeam.addMouseListener(this);
    	editStudent.addMouseListener(this);
    	editTeam.addMouseListener(this);
    	sideMenu1.setLayout(new GridLayout(4,1));
    	sideMenu2.setLayout(new GridLayout(2,1));
    	sideMenu1.add(makeStudent);
    	sideMenu1.add(makeTeam);
    	sideMenu1.add(editStudent);
    	sideMenu1.add(editTeam);
    	sideMenu2.add(viewStudent);
    	sideMenu2.add(viewTeam);
    	sideMenuPanel.setLayout(sideMenuCardLayout);
    	sideMenuPanel.add(sideMenu1, "sm1");
    	sideMenuPanel.add(sideMenu2, "sm2");
    	sideMenuCardLayout.show(sideMenuPanel,"sm1");
    	mainFrame.add(sideMenuPanel);
    	sideMenuPanel.setBounds(0,0,200,580);
    	
    	//create display panel and add to main frame
    	mainFrame.add(displayPanel);
    	displayPanel.setLayout(cardLayout);
    	displayPanel.setBounds(200,40,800,560);
    	
    	//make student select panel
    //	studentScrollPane.add(studentSelectPanel);
    	studentSelectPanel.setLayout(new GridLayout(20,4));
    	studentSelectPanel.setSize(800,560);
    	studentSelectPanel.addMouseListener(this);
    	teamSelectPanel.setLayout(new GridLayout(20,3));
    	teamSelectPanel.setSize(800,560);
    	
    	//create make team panel
    	makeTeamPanel.setSize(800,560);
    	makeTeamPanel.setLayout(new GridBagLayout());
    	sportList.addMouseListener(this);    	
    	genderList.addMouseListener(this);    	
    	seasonList.addMouseListener(this);    	
    	levelList.addMouseListener(this);
    	JLabel sportLabel= new JLabel("Sport");
    	JLabel genderLabel= new JLabel("Gender");
    	JLabel levelLabel= new JLabel("Level");
    	JLabel seasonLabel= new JLabel("Season");
    	okayButton3.addMouseListener(this);
    	
    	gbc.gridx=100;
    	gbc.gridy=100;
    	makeTeamPanel.add(sportLabel, gbc);
    	gbc.gridy=200;
    	makeTeamPanel.add(sportList, gbc);
    	gbc.gridx=300;
    	gbc.gridy=100;
    	makeTeamPanel.add(genderLabel, gbc);
    	gbc.gridy=200;
    	makeTeamPanel.add(genderList, gbc);
    	gbc.gridx=500;
    	gbc.gridy=100;
    	makeTeamPanel.add(levelLabel, gbc);
    	gbc.gridy=200;
    	makeTeamPanel.add(levelList, gbc);
    	gbc.gridx=700;
    	gbc.gridy=100;
    	makeTeamPanel.add(seasonLabel, gbc);
    	gbc.gridy=200;
    	makeTeamPanel.add(seasonList, gbc);
    	gbc.gridx=900;
    	gbc.gridy=200;
    	makeTeamPanel.add(okayButton3, gbc);
    	
    	//create make student panel
    	makeStudentPanel.setLayout(new GridBagLayout());
    	makeStudentPanel.setSize(800,560);
    	JLabel firstNameLabel=new JLabel("First name: ");
    	JLabel lastNameLabel=new JLabel("Last name: ");
    	JLabel sexLabel=new JLabel("Gender: ");
    	JLabel gradeLabel= new JLabel("Grade: ");   	
    	firstNameField.setColumns(15);    	
    	lastNameField.setColumns(15);   	
    	sexList.addMouseListener(this);   	
    	gradeList.addMouseListener(this);   	
    	okayButton.addMouseListener(this);
    	yesNoList.addMouseListener(this);
    	
    	gbc.gridx=100;
    	gbc.gridy=100;
    	makeStudentPanel.add(firstNameLabel, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(firstNameField, gbc);
    	gbc.gridx=100;
    	gbc.gridy=200;
    	makeStudentPanel.add(lastNameLabel, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(lastNameField, gbc);
    	gbc.gridx=100;
    	gbc.gridy=300;
    	makeStudentPanel.add(sexLabel, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(sexList, gbc);
    	gbc.gridx=100;
    	gbc.gridy=500;
    	makeStudentPanel.add(gradeLabel, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(gradeList, gbc);
    	gbc.gridy=600;
    	makeStudentPanel.add(okayButton, gbc);
    	
    	//eventually set as invisible
    	allergiesArea.setColumns(20);
    	allergiesArea.setRows(10);
    	allergiesArea.setWrapStyleWord(true);
    	averageField.setColumns(15);
    	okayButton2.addMouseListener(this);
    	
    	gbc.gridx=200;
    	gbc.gridy=700;
    	makeStudentPanel.add(averageField, gbc);
    	gbc.gridx=100;
    	makeStudentPanel.add(averageLabel, gbc);
    	gbc.gridy=800;
    	makeStudentPanel.add(allergiesLabel, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(yesNoList, gbc);
    	gbc.gridx=100;
    	gbc.gridy=900;
    	makeStudentPanel.add(allergiesLabel2, gbc);
    	gbc.gridx=200;
    	makeStudentPanel.add(allergiesArea, gbc);
    	gbc.gridy=1000;
    	makeStudentPanel.add(okayButton2, gbc);
    	
    	//create edit student panel	 
    	editStudentPanel.setLayout(new GridBagLayout());
    	editStudentPanel.setSize(800, 560);
    	JLabel firstNameL=new JLabel("First Name: ");
    	JLabel lastNameL=new JLabel("Last Name: ");   
    	JLabel averageL=new JLabel("Academic Average: ");	
    	JLabel genderL=new JLabel("Gender: ");
    	JLabel gradeL=new JLabel("Grade: ");
    	JLabel allergiesL=new JLabel("Allergies and health conditions: ");
    	firstNameF.setColumns(15);
    	lastNameF.setColumns(15);
    	averageF.setColumns(5);
    	allergiesA.setColumns(15);
		allergiesA.setRows(5);
		allergiesA.setWrapStyleWord(true);
		saveButton.addMouseListener(this);
		sexCb.addMouseListener(this);
		gradeCb.addMouseListener(this);
		deleteButton1.addMouseListener(this);
		gbc.gridx=300;
		gbc.gridy=0;
		editStudentPanel.add(deleteButton1, gbc);
		gbc.gridx=100;
		gbc.gridy=100; 
		editStudentPanel.add(firstNameL, gbc);
		gbc.gridx=200;
		editStudentPanel.add(firstNameF, gbc);
		gbc.gridy=200;
		editStudentPanel.add(lastNameF, gbc);
		gbc.gridx=100;
		editStudentPanel.add(lastNameL, gbc);
		gbc.gridy=300;
		editStudentPanel.add(genderL, gbc);
		gbc.gridx=200;
		editStudentPanel.add(sexCb, gbc);
		gbc.gridy=400;
		editStudentPanel.add(gradeCb, gbc);
		gbc.gridx=100;
		editStudentPanel.add(gradeL, gbc);
		gbc.gridy=500;
		editStudentPanel.add(averageL, gbc);
		gbc.gridx=200;
		editStudentPanel.add(averageF, gbc);
		gbc.gridy=600;
		editStudentPanel.add(allergiesA, gbc);
		gbc.gridx=100;
		editStudentPanel.add(allergiesL, gbc);
		gbc.gridx=200;
		gbc.gridy=700;
		editStudentPanel.add(saveButton, gbc);
		
		//create edit team panel
		JLabel set1=new JLabel("Set: ");
		JLabel set2=new JLabel("Set: ");
		JLabel set3=new JLabel("Set: ");
		addStudentField1.setColumns(10);
		addStudentField2.setColumns(10);
		incomeField1.setColumns(5);
		incomeField1.setText("$");
		incomeField2.setColumns(10);
		expenseField1.setColumns(5);
		expenseField1.setText("$");
		expenseField2.setColumns(10);
		searchButton1.addMouseListener(this);
		doneButton1.addMouseListener(this);
		doneButton3.addMouseListener(this);
		doneButton4.addMouseListener(this);
    	addStudentButton.addMouseListener(this);
    	deleteStudentButton.addMouseListener(this);
    	addExpenseButton.addMouseListener(this);
    	addIncomeButton.addMouseListener(this);
    	mvpButton1.addMouseListener(this);
    	mvpButton2.addMouseListener(this);
    	captainButton.addMouseListener(this);
    	teacherButton.addMouseListener(this);
    	jerseyButton.addMouseListener(this);
    	athleticFeeButton.addMouseListener(this);
    	editTeamPanel.setSize(800,560);
    	editTeamPanel.setLayout(new GridBagLayout());
    	deleteButton2.addMouseListener(this);
    	
    	gbc.gridx=140;
    	gbc.gridy=0;
    	editTeamPanel.add(deleteButton2, gbc);
    	gbc.gridx=100;
    	gbc.gridy=100;
    	editTeamPanel.add(sportHeader, gbc);
    	gbc.gridy=200;
    	editTeamPanel.add(genderHeader, gbc);
    	gbc.gridy=300;
    	editTeamPanel.add(levelHeader, gbc);
    	gbc.gridy=400;
    	editTeamPanel.add(addStudentButton, gbc);
    	gbc.gridy=450;
    	editTeamPanel.add(deleteStudentButton, gbc);
    	gbc.gridy=500;
    	editTeamPanel.add(addIncomeButton, gbc);
    	gbc.gridy=600;
    	editTeamPanel.add(addExpenseButton, gbc);
    	gbc.gridy=700;
    	editTeamPanel.add(set1, gbc);
    	gbc.gridy=800;
    	editTeamPanel.add(set2, gbc);
    	gbc.gridy=900;
    	editTeamPanel.add(set3, gbc);
    	gbc.gridy=1000;
    	editTeamPanel.add(jerseyButton, gbc);
    	gbc.gridy=1110;
    	editTeamPanel.add(athleticFeeButton, gbc);
    	gbc.gridx=130;
    	gbc.gridy=100;
    	editTeamPanel.add(seasonHeader, gbc);
    	gbc.gridx=120;
    	gbc.gridy=700;
    	editTeamPanel.add(mvpButton1, gbc);
    	gbc.gridy=800;
    	editTeamPanel.add(captainButton, gbc);
    	gbc.gridy=900;
    	editTeamPanel.add(teacherButton, gbc);
    	gbc.gridy=700;
    	gbc.gridx=130;
    	editTeamPanel.add(mvpButton2, gbc);    	
    	gbc.gridx=120;
    	gbc.gridy=400;
    	editTeamPanel.add(addStudentLabel1, gbc);
    	gbc.gridx=130;
    	editTeamPanel.add(addStudentField1, gbc);
    	gbc.gridx=140;
    	editTeamPanel.add(addStudentLabel2, gbc);
    	gbc.gridx=150;
    	editTeamPanel.add(addStudentField2, gbc);
    	gbc.gridx=160;
    	editTeamPanel.add(doneButton1, gbc);
    	gbc.gridx=170;
    	gbc.gridy=500;
    	gbc.gridx=120;
    	editTeamPanel.add(incomeField1, gbc);
    	gbc.gridx=130;
    	editTeamPanel.add(incomeLabel2, gbc);
    	gbc.gridx=140;
    	editTeamPanel.add(incomeField2, gbc);
    	gbc.gridx=150;
    	editTeamPanel.add(doneButton3, gbc);
    	gbc.gridy=600;
    	editTeamPanel.add(doneButton4, gbc);
    	gbc.gridx=140;
    	editTeamPanel.add(expenseField2, gbc);
    	gbc.gridx=130;
    	editTeamPanel.add(expenseLabel2, gbc);
    	gbc.gridx=120;
    	editTeamPanel.add(expenseField1, gbc);
    	
    	ImageIcon sportsBackground=new ImageIcon("sportImage.png");
    	JLabel backgroundLabel=new JLabel(sportsBackground);
    	backgroundLabel.setSize(560,560);
    	clearPanel.add(backgroundLabel);
    	
    	displayPanel.add(editTeamPanel, "editTeam");
    	displayPanel.add(editStudentPanel, "editStudent");
    	displayPanel.add(makeTeamPanel, "makeTeam");
    	displayPanel.add(makeStudentPanel, "makeStudent");
    	displayPanel.add(clearPanel, "clear");
    	displayPanel.add(studentSelectPanel, "selectStudent");
    	displayPanel.add(teamSelectPanel, "selectTeam");
    	displayPanel.add(viewTeamPanel, "viewTeam");
    	displayPanel.add(viewStudentPanel, "viewStudent");
    	cardLayout.show(displayPanel, "clear");
    	viewStudentActive=false;
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
		
		teamListPanel.setSize(200,400);
		teamListFrame.setSize(200,400);
		teamListPanel.setLayout(new GridLayout(25,1));
		teamListFrame.setContentPane(teamListPanel);
		teamListFrame.setVisible(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
    	mainFrame.setVisible(true);
    	
    	mainFrame.addWindowListener(new java.awt.event.WindowAdapter()
    	{
	    	public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    	{
	    		//add code to save to files
		        {
		            System.exit(0);
		        }
	    	}
		});
    }
    
    public void mouseClicked(MouseEvent e)
	{
		if(tracing)System.out.println(e.getSource());
		
		if(e.getSource()==makeStudent)
		{
			displayMakeStudent1();
		}
		
		if(e.getSource()==makeTeam)
		{
			displayMakeTeam();
		}
			
		if(e.getSource()==editStudent)
		{
			displaySelectStudentToEdit();
			edit=true;
		}
			
		if(e.getSource()==editTeam)
		{
			displaySelectTeamToEdit();
			edit=true;
		}
			
		if(e.getSource()==okayButton)
		{
			if(tracing)System.out.println("okay button pressed");
			checkIfStudentExists();
		}
		
		if(e.getSource()==yesNoList)
		{
			if(tracing)System.out.println("yesNoList selected");
			JComboBox cb=(JComboBox)e.getSource();
			if(cb.getSelectedItem().equals("Yes"))
				displayMakeStudent3();
			else if (cb.getSelectedItem().equals("No"))
				displayMakeStudent4();
		}
		
		if(e.getSource()==okayButton2)
			saveNewStudent();
		
		//end of make student if statements
		//start of make team if statements
		
		if(e.getSource()==okayButton3)
			checkIfTeamExists();

		//end of make team is statements
		//start of edit student if statements
		if(e.getSource()==saveButton)
			updateStudent();
		if(e.getSource()==deleteButton1)
			deleteStudentFromSystem(students.get(currentStudent));
		//end of edit student if statements
		//start of edit team if statements
		if(e.getSource()==deleteButton2)
			deleteTeamFromSystem(teams.get(currentTeam));
		if(e.getSource()==addStudentButton)
			displayAddStudentOptions();
		if(e.getSource()==doneButton1)
			addStudent();
		if(e.getSource()==searchButton1)
			displaySelectStudentToAdd();
		if(e.getSource()==deleteStudentButton)
			displaySelectStudentToDelete();
		if(e.getSource()==addIncomeButton)
			addIncome();
		if(e.getSource()==doneButton3)
			saveNewIncome();
		if(e.getSource()==addExpenseButton)
			addExpense();
		if(e.getSource()==doneButton4)
			saveNewExpense();
		if(e.getSource()==mvpButton1&&teams.get(currentTeam).getMvp1()==null)
			selectMvp1();
		else if(e.getSource()==mvpButton1&&teams.get(currentTeam).getMvp1()!=null)
			askToReplaceMvp1();
		if(e.getSource()==mvpButton2&&teams.get(currentTeam).getMvp2()==null)
			selectMvp2();
		else if(e.getSource()==mvpButton2&&teams.get(currentTeam).getMvp2()!=null)
			askToReplaceMvp2();	
		if(e.getSource()==captainButton&&teams.get(currentTeam).getCaptain()==null)
			selectCaptain();
		else if(e.getSource()==captainButton&&teams.get(currentTeam).getCaptain()!=null)
			askToReplaceCaptain();
		if(e.getSource()==teacherButton&&teams.get(currentTeam).getTeacher()==null)
			saveTeacher();
		else if(e.getSource()==teacherButton&&teams.get(currentTeam).getTeacher()!=null)
			askToReplaceTeacher();
		if(e.getSource()==jerseyButton)
			displayJerseyList();
		if(e.getSource()==athleticFeeButton)
			displayAthleticFeeList();	
		
		for(int x=0; x<studentCounter; x++)
		{
			if(tracing)System.out.println("for loop running (mouseEvent)");
			if(e.getSource()==studentLabels.get(x)&&edit==true)
			{
				displayEditStudent(studentLabels.get(x).getStudent());
				if(tracing)System.out.println("edit panel should display");
				currentStudent=x;
			}
			else if(e.getSource()==studentLabels.get(x)&&edit==false)
			{
				displayViewStudent(studentLabels.get(x).getStudent());
				currentStudent=x;
			}
		}
		
		try
		{
			for(int x=0; x<teamCounter; x++)
			{
				if(e.getSource()==teamLabels.get(x)&&edit==true)
				{
					displayEditTeam(teamLabels.get(x).getTeam());
					currentTeam=x;
					if(tracing)System.out.println("current team: "+currentTeam);
				}
				else if(e.getSource()==teamLabels.get(x)&&edit==false)
				{
					displayViewTeam(teamLabels.get(x).getTeam());
					currentTeam=x;
				}
			}
		}
		catch(IndexOutOfBoundsException ex)
		{
			
		}
		
		try
		{
			for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
			{
				if(tracing)System.out.println("try section");
				if(e.getSource()==teamListLabels.get(x))
				{
					if(currentAction==1)
					{
						teams.get(currentTeam).removeStudent((teams.get(currentTeam).getStudentAt(x)));
							if(teams.get(currentTeam).getSeason().equals("Fall"))
								teamListLabels.get(x).getStudent().setFallSport(null);
							else if(teams.get(currentTeam).getSeason().equals("Winter"))
								teamListLabels.get(x).getStudent().setWinterSport(null);
							else if(teams.get(currentTeam).getSeason().equals("Spring"))
								teamListLabels.get(x).getStudent().setSpringSport(null);
							else if(teams.get(currentTeam).getSeason().equals("All Year"))
								teamListLabels.get(x).getStudent().setYearSport(null);
					}
					else if(currentAction==2)
					{
						if(teams.get(currentTeam).getStudentAt(x).equals(teams.get(currentTeam).getMvp2()))
							JOptionPane.showMessageDialog(null, "That student is already MVP!", "Error", JOptionPane.ERROR_MESSAGE);
						else
							teams.get(currentTeam).setMvp1(teams.get(currentTeam).getStudentAt(x));		
					}
					else if(currentAction==3)
					{
						if(teams.get(currentTeam).getStudentAt(x).equals(teams.get(currentTeam).getMvp1()))
							JOptionPane.showMessageDialog(null, "That student is already MVP!", "Error", JOptionPane.ERROR_MESSAGE);
						else
							teams.get(currentTeam).setMvp2(teams.get(currentTeam).getStudentAt(x));		
					}
					else if(currentAction==4)
						teams.get(currentTeam).setCaptain(teams.get(currentTeam).getStudentAt(x));					
					teamListFrame.setVisible(false);
				}
			}
		}
		catch(IndexOutOfBoundsException ex)
		{
			
		}
		
		if(e.getSource().equals(saveJerseyButton))
		{
			for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
			{
				if(teamCheckBoxes.get(x).isSelected()==true)
					teams.get(currentTeam).setJerseyAt(x, true);
				else
					teams.get(currentTeam).setJerseyAt(x, false);
			}
			//exit select window, repeat for athletic fee, sort before adding (lines up)
		}
		
		if(e.getSource().equals(saveAthleticFeeButton))
		{
			for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
			{
				if(teamCheckBoxes.get(x).isSelected()==true)
					teams.get(currentTeam).setAthleticFeeAt(x, true);
				else
					teams.get(currentTeam).setAthleticFeeAt(x, false);
			}
			//exit select window, repeat for athletic fee, sort before adding (lines up)
		}
		
		//view mode if statements
		if(e.getSource().equals(viewStudent))
		{
			displaySelectStudentToEdit();
			edit=false;
		}
		
		if(e.getSource().equals(viewTeam))
		{
			displaySelectTeamToEdit();
			edit=false;
		}
		
		if(e.getSource().equals(viewMembersButton))
			displayViewTeamMembers(teams.get(currentTeam));
			
		if(e.getSource().equals(viewBudgetButton))
			displayViewTeamBudget(teams.get(currentTeam));
			
		//viewButton and edit button
		if(e.getSource()==helpButton)
			helpFrame.setVisible(true);
		if(e.getSource()==viewButton&&edit==true)
		{
			switchToViewMode();
			if(tracing)System.out.println("view button pressed");
			if(editStudentActive==true)
			{
				viewStudentActive=false;
			if(tracing)System.out.println("viewStudentActive(mouseClicked): "+viewStudentActive);
			viewTeamActive=false;
			editStudentActive=false;
			editTeamActive=false;
				try
					{
						displayViewStudent(students.get(currentStudent));
					}
					catch(IndexOutOfBoundsException ex)
					{
						
					}	
			}			
			else if(editTeamActive==true)
			{
				viewStudentActive=false;
			if(tracing)System.out.println("viewStudentActive(mouseClicked): "+viewStudentActive);
			viewTeamActive=false;
			editStudentActive=false;
			editTeamActive=false;
				try
				{
					displayViewTeam(teams.get(currentTeam));	
				}
				catch(IndexOutOfBoundsException ex)
				{
					
				}
			}								
			edit=false;
			
		}
		if(e.getSource()==editButton&&edit==false)
		{
			switchToEditMode();
			if(tracing)System.out.println("viewStudentActive: "+viewStudentActive);
			if(viewStudentActive==true)
			{
				viewStudentActive=false;
			if(tracing)System.out.println("viewStudentActive(mouseClicked): "+viewStudentActive);
			viewTeamActive=false;
			editStudentActive=false;
			editTeamActive=false;
				try
				{
					displayEditStudent(students.get(currentStudent));
				}
				catch(IndexOutOfBoundsException ex)
				{
					
				}
			}								
			else if(viewTeamActive==true)
			{
				viewStudentActive=false;
			if(tracing)System.out.println("viewStudentActive(mouseClicked): "+viewStudentActive);
			viewTeamActive=false;
			editStudentActive=false;
			editTeamActive=false;
				try
				{
					displayEditTeam(teams.get(currentStudent));	
				}
				catch(IndexOutOfBoundsException ex)
				{
					
				}
			}								
			edit=true;
		}		
	}
	
	public void deleteStudentFromSystem(Student student)
	{
		for(int x=0; x<teamCounter; x++)
		{
			for(int y=0; y<teams.get(x).getTeamSize(); y++)
			{
				if(teams.get(x).getStudentAt(y).equals(student))
					teams.get(x).removeStudent(student);
			}
		}
		students.remove(student);
		studentCounter--;
		displayClearScreen();
	}
	
	public void deleteTeamFromSystem(Team team)
	{
		for(int x=(team.getTeamSize()-1); x>=0; x--)
		{
			if(teams.get(currentTeam).getSeason().equals("Fall"))
				team.getStudentAt(x).setFallSport(null);
			else if(teams.get(currentTeam).getSeason().equals("Winter"))
				team.getStudentAt(x).setWinterSport(null);
			else if(teams.get(currentTeam).getSeason().equals("Spring"))
				team.getStudentAt(x).setSpringSport(null);
			else if(teams.get(currentTeam).getSeason().equals("All Year"))
				team.getStudentAt(x).setYearSport(null);
		}
		teams.remove(team);
		teamCounter--;
		displayClearScreen();
	}
	
	public void switchToEditMode()
	{
		cardLayout.show(displayPanel, "clear");
		sideMenuCardLayout.show(sideMenuPanel, "sm1");
	}
	
	public void switchToViewMode()
	{
		if(tracing)System.out.println("menu should switch");
		cardLayout.show(displayPanel, "clear");
		sideMenuCardLayout.show(sideMenuPanel, "sm2");
	}
	
	public void displayViewTeamBudget(Team team)
	{
		budgetItems.clear();
		budgetExpense.clear();
		budgetItemColumn.removeAll();
		budgetExpenseColumn.removeAll();
		budgetExpenseColumn.add(new JLabel("Expense"));
		budgetItemColumn.add(new JLabel("Source"));
		for(int x=0; x<team.getCosts().size(); x++)
		{
			budgetExpenseColumn.add(new JLabel("$"+team.getCostAt(x)));
			budgetItemColumn.add(new JLabel(team.getItemAt(x)));
		}
		budgetItemColumn.add(new JLabel("Total: "));
		budgetExpenseColumn.add(new JLabel("$"+team.getBudget()));
		cl.show(viewTeamBottomPanel, "teamBudget");
	}
	
	public void displayViewTeamMembers(Team team)
	{
		listNames.clear();
		listJerseys.clear();
		listAthleticFees.clear();
		listAllergies.clear();
		listGrades.clear();
		listEligibles.clear();
		listNameColumn.removeAll();
		listJerseyColumn.removeAll();
		listAthleticFeeColumn.removeAll();
		listGradeColumn.removeAll();
		listEligibleColumn.removeAll();
		listNameColumn.add(listNameLabel);
		listJerseyColumn.add(listJerseyLabel);
		listAthleticFeeColumn.add(listAthleticFeeLabel);
		listGradeColumn.add(listGradeLabel);
		listEligibleColumn.add(listEligibleLabel);
		
		for(int x=0; x<team.getTeamSize(); x++)
		{
			listNames.add(new StudentLabel(team.getStudentAt(x)));
			listJerseys.add(team.getJerseyAt(x));
			listAthleticFees.add(team.getAthleticFeeAt(x));
			listGrades.add(""+team.getStudentAt(x).getGrade());
			if(team.getStudentAt(x).getAverage()<65)
				listEligibles.add("N");
			else
				listEligibles.add("Y");
		}
		
		for(int x=0; x<team.getTeamSize(); x++)
		{
			listNameColumn.add(listNames.get(x));
			listJerseyColumn.add(new JLabel(listJerseys.get(x)));
			listAthleticFeeColumn.add(new JLabel(listAthleticFees.get(x)));
			listGradeColumn.add(new JLabel(listGrades.get(x)));
			listEligibleColumn.add(new JLabel(listEligibles.get(x)));
		}
		
		cl.show(viewTeamBottomPanel, "teamList");
	}
	
	public void displayViewTeam(Team team)
	{
		teamNameLabelv.setText(team.getAges()+" "+team.getGender()+" "+team.getSport());
		teamSeasonLabelv.setText("Season: "+team.getSeason());
		if(team.getCaptain()!=null)
			teamCaptainLabelv.setText("Captain: "+team.getCaptain().getFirstName()+" "+team.getCaptain().getLastName());
		else
			teamCaptainLabelv.setText("Captain: ");
		if(team.getTeacher()!=null)
			teamTeacherLabelv.setText("Teacher: "+team.getTeacher().getFirstName()+" "+team.getTeacher().getLastName());
		else
			teamTeacherLabelv.setText("Teacher: ");
		if(team.getMvp1()!=null)
			teamMvp1Labelv.setText("MVP1: "+team.getMvp1().getFirstName()+" "+team.getMvp1().getLastName());
		else
			teamMvp1Labelv.setText("MVP1: ");
		if(team.getMvp2()!=null)
			teamMvp2Labelv.setText("MVP2: "+team.getMvp2().getFirstName()+" "+team.getMvp2().getLastName());
		else
			teamMvp2Labelv.setText("MVP2: ");
		cardLayout.show(displayPanel, "viewTeam");
		viewStudentActive=false;
		if(tracing)System.out.println("viewStudentActive(displayViewTeam): "+viewStudentActive);
		viewTeamActive=true;
		editStudentActive=false;
		editTeamActive=false;
		cl.show(viewTeamBottomPanel, "clear");
	}
	
	public void displayViewStudent(Student student)
	{
		nameLabelv.setText("Name: "+student.getFirstName()+" "+student.getLastName());
		if(student.getGender()=='M')
			genderLabelv.setText("Gender: Male");
		else if(student.getGender()=='F')
			genderLabelv.setText("Gender: Female");
		gradeLabelv.setText("Grade: "+student.getGrade());
		averageLabelv.setText("Average: "+student.getAverage());
		if(student.getFallSport()!=null)
		{
			if(tracing)System.out.println(student.getFallSport());
			fallSportLabelv.setText(student.getFallSport());

		}
		else
			fallSportLabelv.setText("");
		if(student.getWinterSport()!=null)
			winterSportLabelv.setText(student.getWinterSport());
		else
			winterSportLabelv.setText("");
		if(student.getSpringSport()!=null)
			springSportLabelv.setText(student.getSpringSport());
		else
			springSportLabelv.setText("");
		if(student.getYearSport()!=null)
			yearSportLabelv.setText(student.getYearSport());
		else
			yearSportLabelv.setText("");
		allergiesLabelv.setText("Allergies: "+student.getAllergies());
		
		cardLayout.show(displayPanel, "viewStudent");
		viewStudentActive=true;
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
		if(tracing)System.out.println("viewStudentActive(displayViewStudent): "+viewStudentActive);
	}
	
	public void displayMakeStudent1() //displays basic info requests
    {
    	cardLayout.show(displayPanel, "makeStudent");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(makeStudent): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
    	
    	firstNameField.setText("");
    	lastNameField.setText("");
    	sexList.setSelectedIndex(0);
    	gradeList.setSelectedIndex(0);
    	okayButton.setVisible(true);
    	averageField.setText("");
    	allergiesArea.setText("");
    	yesNoList.setSelectedIndex(0);
    	
    	averageLabel.setVisible(false);
    	averageField.setVisible(false);
    	allergiesLabel.setVisible(false);
    	yesNoList.setVisible(false);
    	allergiesLabel2.setVisible(false);
    	allergiesArea.setVisible(false);
    	okayButton2.setVisible(false);
    }
    
    public void displayStudentExistsMessage() //pop up window
    {
    	JOptionPane.showMessageDialog(null, "That student already exists!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayMakeStudent2()//displays extended menu
    {
    	averageLabel.setVisible(true);
    	averageField.setVisible(true);
    	allergiesLabel.setVisible(true);
    	yesNoList.setVisible(true);
    	okayButton.setVisible(false);
    }
    
    public void displayMakeStudent3()//displays extended allergy options
    {
    	allergiesLabel2.setVisible(true);
    	allergiesArea.setVisible(true);
    	okayButton2.setVisible(true);
    }
    
    public void displayMakeStudent4()//displays okay button if no allergies
    {
    	okayButton2.setVisible(true);
    }
    
    public void saveNewTeam()
    {
    	//create new team
    	String sport=""+sportList.getSelectedItem();
    	String gender=""+genderList.getSelectedItem();
    	String season=(""+seasonList.getSelectedItem());
    	String level=""+levelList.getSelectedItem();
    	
    	if(sport.equals("------")||gender.equals("----")||season.equals("-----")||level.equals("------"))
    		JOptionPane.showMessageDialog(null, "One or more entry is not complete!", "Error", JOptionPane.ERROR_MESSAGE);
    	else
    	{
	    	Team team=new Team(sport, gender, level, season);
	    	TeamLabel tl=new TeamLabel(team);
	    	teams.add(team);
	    	if(tracing)System.out.println("team at index 0: "+teams.get(0));
	    	teamLabels.add(tl);
	    	tl.addMouseListener(this);
	    	//sort alpha
	    	teamCounter++;
	    	displayClearScreen();	
    	}   	
    }//creates new team and adds to teams linkedList INCOMPLETE(SORT)
    
  	public void saveNewStudent()
    {
    	//create new student object
    	boolean save=true;
    	String firstName=firstNameField.getText().trim();
    	String lastName=lastNameField.getText().trim();
    	char gender=(""+sexList.getSelectedItem()).charAt(0);
    	String gradeTemp=""+gradeList.getSelectedItem();
    	int grade=0;
    	if(gradeTemp.equalsIgnoreCase("5th year"))
    		grade=13;
    	else if(gradeTemp.equals("-"))
    		save=false;
    	else
    		grade=Integer.parseInt(gradeTemp);
    	int average=-1;
    	try
    	{
    		average=Integer.parseInt(averageField.getText());
    	}
    	catch(NumberFormatException e)
    	{
    		save=false;
    	}
    	String allergies=allergiesArea.getText();

    	if(firstName.equals(""))
    		save=false;
    	if(lastName.equals(""))
    		save=false;
    	if(gender=='-')
    		save=false;
    	if(average>100||average<0)
    		save=false;
    		
    	if(tracing)System.out.println(save);
    	
    	if(save==false)
    		JOptionPane.showMessageDialog(null, "One or more entry is not complete!", "Error", JOptionPane.ERROR_MESSAGE);
    	else
    	{
    		Student student=new Student(firstName, lastName, allergies, gender, grade, average);
    		students.add(student);
    		students=sortStudentsAlpha(students,0,0);
    		studentLabels.clear();
    		studentCounter++;
    		for(int x=0; x<studentCounter; x++)
    		{
    			studentLabels.add(new StudentLabel(students.get(x)));
    		}
    		if(average<65)
    			JOptionPane.showMessageDialog(null, "Student's average is too low. They will be ineligible to play until it is above 65!", "Error", JOptionPane.ERROR_MESSAGE);	
    		displayClearScreen();
    	}
    	
    }//creates new student and adds to students linkedList 
    
  	public void displayEditStudent(Student student)//displays info for selected student and allows editing
   {
    	editStudentActive=true;
    	firstNameF.setText(student.getFirstName());
    	lastNameF.setText(student.getLastName());
    	 
    	 if(student.getGender()=='M')
    	 	sexCb.setSelectedItem("Male");
    	 else if(student.getGender()=='F')
    	 	sexCb.setSelectedItem("Female");
    	 
    	 if(student.getGrade()==9)
    	 	gradeCb.setSelectedIndex(1);
    	 else if(student.getGrade()==10)
    	 	gradeCb.setSelectedIndex(2);
    	 else if(student.getGrade()==11)
    	 	gradeCb.setSelectedIndex(3);
    	 else if(student.getGrade()==12)
    	 	gradeCb.setSelectedIndex(4);
    	 	
    	 averageF.setText(""+student.getAverage());
    	 allergiesA.setText(student.getAllergies());
    	 cardLayout.show(displayPanel, "editStudent");
    	 viewStudentActive=false;
    	 if(tracing)System.out.println("viewStudentActive(editStudent): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=true;
		editTeamActive=false;
    }
    
    public void updateStudent() //saves data entered in edit student screen
    {
    	editStudentActive=false;
    	boolean save=true;
    	String firstName=firstNameF.getText();
    	String lastName=lastNameF.getText();
    	char gender=(""+sexCb.getSelectedItem()).charAt(0);
    	String gradeTemp=""+gradeCb.getSelectedItem();
    	int grade=0;
    	if(gradeTemp.equalsIgnoreCase("5th year"))
    		grade=13;
    	else if(gradeTemp.equals("-"))
    		save=false;
    	else
    		grade=Integer.parseInt(gradeTemp);
    	int average=-1;
    	try
    	{
    		average=Integer.parseInt(averageF.getText());
    	}
    	catch(NumberFormatException e)
    	{
    		save=false;
    	}
    	String allergies=allergiesA.getText();

    	if(firstName.equals(""))
    		save=false;
    	if(lastName.equals(""))
    		save=false;
    	if(gender=='-')
    		save=false;
    	if(average>100||average<0)
    		save=false;
    		
    	if(tracing)System.out.println(save);
    	
    	if(save==false)
    		JOptionPane.showMessageDialog(null, "One or more entry is not complete!", "Error", JOptionPane.ERROR_MESSAGE);
    	else
    	{
    		students.get(currentStudent).setFirstName(firstName);
    		students.get(currentStudent).setLastName(lastName);
    		students.get(currentStudent).setGender(gender);
    		students.get(currentStudent).setGrade(grade);
    		students.get(currentStudent).setAverage(average);
    		students.get(currentStudent).setAllergies(allergies);
    		if(tracing)System.out.println("New name: "+students.get(currentStudent).getFirstName());
    		if(average<65)
    			JOptionPane.showMessageDialog(null, "Student's average is too low. They will be ineligible to play until it is above 65!", "Error", JOptionPane.ERROR_MESSAGE);
    		displayClearScreen();
    	}
    	
    	
    }
    
    public void displayMakeTeam()
    {
    	cardLayout.show(displayPanel, "makeTeam");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(makeTeam): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
    	genderList.setSelectedIndex(0);
    	sportList.setSelectedIndex(0);
    	seasonList.setSelectedIndex(0);
    	levelList.setSelectedIndex(0);
    } //displays team comboboxes
    
    public void displayTeamExistsMessage()
    {
    	JOptionPane.showMessageDialog(null, "That team already exists!", "Error", JOptionPane.ERROR_MESSAGE);
    }//pop up if team already exists
    
    public void displaySelectStudentToEdit() 
    {
    	studentLabels.clear();
    	studentSelectPanel.removeAll();
    	sortStudentsAlpha(students, 1,0);
    	for(int x=0; x<studentCounter; x++)
    	{
    		studentLabels.add(new StudentLabel(students.get(x)));
    		studentSelectPanel.add(studentLabels.get(x));
    		studentLabels.get(x).addMouseListener(this);
    		if(tracing)System.out.println("add student to panel is running");
    		studentSelectPanel.setOpaque(true);
    	}
    	cardLayout.show(displayPanel, "selectStudent");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(selectStudent): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
    }//displays list of students
    
    public void displaySelectTeamToEdit()
    {
    	teamLabels.clear();
    	teamSelectPanel.removeAll();
    	sortTeamBudget(teams, 0);
    	for(int x=0; x<teamCounter; x++)
    	{
    		teamLabels.add(new TeamLabel(teams.get(x)));
    		teamSelectPanel.add(teamLabels.get(x));
    		teamLabels.get(x).addMouseListener(this);
    	}
    	cardLayout.show(displayPanel, "selectTeam");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(selectTeam): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
    }//displays list of teams
    
    public void displayEditTeam(Team team)
    {
    	sportHeader.setText(team.getSport());
    	genderHeader.setText(team.getGender());
    	seasonHeader.setText(team.getSeason());
    	levelHeader.setText(team.getAges());
    	cardLayout.show(displayPanel, "editTeam");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(displayEditteM): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=true;
    	addStudentLabel1.setVisible(false);
    	addStudentLabel2.setVisible(false);
    	addStudentField1.setVisible(false);
    	addStudentField2.setVisible(false);
    	incomeLabel2.setVisible(false);
    	incomeField1.setVisible(false);
    	incomeField2.setVisible(false);
    	expenseLabel2.setVisible(false);
    	expenseField1.setVisible(false);
    	expenseField2.setVisible(false);
    	doneButton1.setVisible(false);
    	doneButton3.setVisible(false);
    	doneButton4.setVisible(false);
    	searchButton1.setVisible(false);
    }//displays team info and allows editing
    
    public void displayClearScreen()
    {
    	cardLayout.show(displayPanel, "clear");
    	viewStudentActive=false;
    	if(tracing)System.out.println("viewStudentActive(displayClear): "+viewStudentActive);
		viewTeamActive=false;
		editStudentActive=false;
		editTeamActive=false;
    }//clears the display panel
    
    public void checkIfStudentExists()
    {
    	boolean exists=false;
    	for(int x=0; x<studentCounter; x++)
    	{
    		if(firstNameField.getText().equals(students.get(x).getFirstName())&&lastNameField.getText().equals(students.get(x).getLastName()))
    			exists=true;
    	}
    	if(exists)
    		displayStudentExistsMessage();
    	else
    		displayMakeStudent2();
    }//checks to see if student has already been created
    
    public void checkIfTeamExists()
    {
    	//check if team exists
    	
    	boolean exists=false;
    	for(int x=0; x<teamCounter; x++)
    	{
    		if(teams.get(x).getSport().equals(""+sportList.getSelectedItem())&&teams.get(x).getAges().equals(""+levelList.getSelectedItem())&&teams.get(x).getGender().equals(""+genderList.getSelectedItem()))
    			exists=true;
    	}
    	if(exists)
    		displayTeamExistsMessage();
    	else
    		saveNewTeam();
    }//checks to see if team has already been created    
	
	public void askToReplaceMvp1()
	{
		int selected=JOptionPane.showConfirmDialog(null,"The current MVP1 is: "+teams.get(currentTeam).getMvp1().getFirstName()+" "+teams.get(currentTeam).getMvp1().getLastName()+". Would you like to replace them?", "choose one", JOptionPane.YES_NO_OPTION);
		if(selected==0)
			selectMvp1();
	} //pop up if mvp1 all ready is set
	
	public void askToReplaceMvp2()
	{
		int selected=JOptionPane.showConfirmDialog(null,"The current MVP2 is: "+teams.get(currentTeam).getMvp2().getFirstName()+" "+teams.get(currentTeam).getMvp2().getLastName()+". Would you like to replace them?", "choose one", JOptionPane.YES_NO_OPTION);
		if(selected==0)
			selectMvp2();
	} //pop up if mvp2 all ready is set
	
	public void askToReplaceTeacher()
	{
		int selected=JOptionPane.showConfirmDialog(null,"The current teacher is: "+teams.get(currentTeam).getTeacher().getFirstName()+" "+teams.get(currentTeam).getTeacher().getLastName()+". Would you like to replace them?", "choose one", JOptionPane.YES_NO_OPTION);
		if(selected==0)
			saveTeacher();
	}//pop up if teacher all ready is set
	
	public void askToReplaceCaptain()
	{
		int selected=JOptionPane.showConfirmDialog(null,"The current captain is: "+teams.get(currentTeam).getCaptain().getFirstName()+" "+teams.get(currentTeam).getCaptain().getLastName()+". Would you like to replace them?", "choose one", JOptionPane.YES_NO_OPTION);
		if(selected==0)
			selectCaptain();
	}//pop up if captain all ready is set
	
	public void selectCaptain()
	{
		currentAction=4;
		teamListLabels.clear();
		teamListPanel.removeAll();
		if(tracing)System.out.println(teams.get(currentTeam).teammatesToString());
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentLabel temp=new StudentLabel(teams.get(currentTeam).getStudentAt(x));
			teamListLabels.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamListLabels.get(x));	
		}
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	} //displays team list
	
	public void saveTeacher()
	{
		String inputValue = JOptionPane.showInputDialog("Please input teacher's name (LastName, FirstName): ");
		StringTokenizer st=new StringTokenizer(inputValue,",");
		String lastName=st.nextToken();
		String firstName=st.nextToken().trim();
		Teacher teacher=new Teacher(firstName, lastName);
		teams.get(currentTeam).setTeacher(teacher);
	}//pop up asks for teacher name, creates new teacher
	
	public void displayJerseyList()
	{
		teamListLabels.clear();
		teamListPanel.removeAll();
		teamCheckBoxes.clear();
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentCheckBox temp=new StudentCheckBox(teams.get(currentTeam).getStudentAt(x));
			if(teams.get(currentTeam).getJerseyAt(x).equals("Y"))
				temp.setSelected(true);
			else
				temp.setSelected(false);
			teamCheckBoxes.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamCheckBoxes.get(x));	
		}
		teamListPanel.add(saveJerseyButton);
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	}//displays team list and if they have returned their jersey INCOMPLETE

	public void displayAthleticFeeList()
	{
		teamListLabels.clear();
		teamListPanel.removeAll();
		teamCheckBoxes.clear();
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentCheckBox temp=new StudentCheckBox(teams.get(currentTeam).getStudentAt(x));
			if(teams.get(currentTeam).getAthleticFeeAt(x).equals("Y"))
				temp.setSelected(true);
			else
				temp.setSelected(false);
			teamCheckBoxes.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamCheckBoxes.get(x));	
		}
		teamListPanel.add(saveAthleticFeeButton);
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	}//displays team list and if they have payed their athletic fee INCMOPLETE
	
	public void selectMvp1()
	{
		currentAction=2;
		teamListLabels.clear();
		teamListPanel.removeAll();
		if(tracing)System.out.println(teams.get(currentTeam).teammatesToString());
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentLabel temp=new StudentLabel(teams.get(currentTeam).getStudentAt(x));
			teamListLabels.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamListLabels.get(x));	
		}
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	} //displays list of team
	
	public void selectMvp2()
	{
		currentAction=3;
		teamListLabels.clear();
		teamListPanel.removeAll();
		if(tracing)System.out.println(teams.get(currentTeam).teammatesToString());
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentLabel temp=new StudentLabel(teams.get(currentTeam).getStudentAt(x));
			teamListLabels.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamListLabels.get(x));	
		}
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	} //displays list of team
	
	public void saveNewExpense()
	{
		StringTokenizer st=new StringTokenizer(expenseField1.getText(),"$",false);
		try
		{
			double expense=Double.parseDouble(st.nextToken());
			if(expense<=0)
				JOptionPane.showMessageDialog(null, "Please enter a positive amount!", "Error", JOptionPane.ERROR_MESSAGE);
			else if(expenseField2.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter a source!", "Error", JOptionPane.ERROR_MESSAGE);
			else
			{
				expense=Math.round(expense*100.0)/100.0;
				teams.get(currentTeam).addExpense(expense, ""+expenseField2.getText());
				expenseLabel2.setVisible(false);
				expenseField1.setVisible(false);
				expenseField2.setVisible(false);
				doneButton4.setVisible(false);
			}
			
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter a numerical value!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	} //adds expnese to team budget
	
	public void addExpense()
	{
		expenseLabel2.setVisible(true);
		expenseField1.setVisible(true);
		expenseField2.setVisible(true);
		doneButton4.setVisible(true);
		expenseField1.setText("$");
		expenseField2.setText("");
	}//displays components needed to enter expense
	
	public void saveNewIncome()
	{
		StringTokenizer st=new StringTokenizer(incomeField1.getText(),"$",false);
		try
		{
			double expense=-1*Double.parseDouble(st.nextToken());
			if(expense>=0)
				JOptionPane.showMessageDialog(null, "Please enter a positive amount!", "Error", JOptionPane.ERROR_MESSAGE);
			else if(incomeField2.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter a source!", "Error", JOptionPane.ERROR_MESSAGE);
			else
			{
				expense=Math.round(expense*100.0)/100.0;
				teams.get(currentTeam).addExpense(expense, ""+incomeField2.getText());
				incomeLabel2.setVisible(false);
				incomeField1.setVisible(false);
				incomeField2.setVisible(false);
				doneButton3.setVisible(false);
			}
			
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter a numerical value!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	} //adds income to team budget
	
	public void addIncome()
	{
		incomeLabel2.setVisible(true);
		incomeField1.setVisible(true);
		incomeField2.setVisible(true);
		doneButton3.setVisible(true);
		incomeField1.setText("$");
		incomeField2.setText("");
	} //displays components needed to add income
	
	public void displaySelectStudentToDelete()
	{
		currentAction=1;
		teamListLabels.clear();
		teamListPanel.removeAll();
		if(tracing)System.out.println(teams.get(currentTeam).teammatesToString());
		for(int x=0; x<teams.get(currentTeam).getTeamSize(); x++)
		{
			StudentLabel temp=new StudentLabel(teams.get(currentTeam).getStudentAt(x));
			teamListLabels.add(temp);
			temp.addMouseListener(this);
			teamListPanel.add(teamListLabels.get(x));	
		}
	//	cl.show(teamListFrame, "panel");
		teamListPanel.validate();
		teamListFrame.setVisible(true);
	} //displays team list
	
	public void addStudent()
	{
		String firstName=addStudentField1.getText();
		String lastName=addStudentField2.getText();
		boolean exists=false;
		for(int x=0; x<studentCounter; x++)
		{
			if(students.get(x).getFirstName().equals(firstName)&&students.get(x).getLastName().equals(lastName))
			{
				exists=true;
				boolean alreadyOnTeam=false;
				for(int y=0; y<teams.get(currentTeam).getTeamSize(); y++)
				{
					if(teams.get(currentTeam).getStudentAt(y).equals(students.get(x)))
						alreadyOnTeam=true;
				}
				if(alreadyOnTeam)
					JOptionPane.showMessageDialog(null, "Student is already on team!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getSeason().equals("Fall")&&students.get(x).getFallSport()!=(null))
					JOptionPane.showMessageDialog(null, "Student already has a fall sport!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getSeason().equals("Winter")&&students.get(x).getWinterSport()!=(null))
					JOptionPane.showMessageDialog(null, "Student already has a winter sport!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getSeason().equals("Spring")&&students.get(x).getSpringSport()!=(null))
					JOptionPane.showMessageDialog(null, "Student already has a spring sport!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getSeason().equals("All Year")&&students.get(x).getYearSport()!=(null))
					JOptionPane.showMessageDialog(null, "Student already has an all year sport!", "Error", JOptionPane.ERROR_MESSAGE);					
				else if(teams.get(currentTeam).getGender().equals("Girl's")&&students.get(x).getGender()=='M')
					JOptionPane.showMessageDialog(null, "Male student cannot be added to girl's team!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getGender().equals("Boy's")&&students.get(x).getGender()=='F')
					JOptionPane.showMessageDialog(null, "Female student cannot be added to boy's team!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getAges().equals("Junior")&&!(students.get(x).getGrade()==10||students.get(x).getGrade()==9))
					JOptionPane.showMessageDialog(null, "Senior student cannot be added to junior team!", "Error", JOptionPane.ERROR_MESSAGE);
				else if(teams.get(currentTeam).getAges().equals("Senior")&&(students.get(x).getGrade()==10||students.get(x).getGrade()==9))
					JOptionPane.showMessageDialog(null, "Junior student cannot be added to student team!", "Error", JOptionPane.ERROR_MESSAGE);
				else
				{
					teams.get(currentTeam).addStudent(students.get(x));
					if(teams.get(currentTeam).getSeason().equals("Fall"))
						students.get(x).setFallSport(teams.get(currentTeam).getSport());
					else if(teams.get(currentTeam).getSeason().equals("Winter"))
						students.get(x).setWinterSport(teams.get(currentTeam).getSport());
					else if(teams.get(currentTeam).getSeason().equals("Spring"))
						students.get(x).setSpringSport(teams.get(currentTeam).getSport());
					else if(teams.get(currentTeam).getSeason().equals("All Year"))
						students.get(x).setYearSport(teams.get(currentTeam).getSport());
					addStudentLabel1.setVisible(false);
					addStudentLabel2.setVisible(false);
					addStudentField1.setVisible(false);
					addStudentField2.setVisible(false);
					searchButton1.setVisible(false);
					doneButton1.setVisible(false);
				}
			}
		}
		if(!exists)
			JOptionPane.showMessageDialog(null, "Student does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
	} //adds a student to team if they are eligble
	
	public void displaySelectStudentToAdd()//INCOMPLETE
	{
		//add selected student
		addStudentLabel1.setVisible(false);
		addStudentLabel2.setVisible(false);
		addStudentField1.setVisible(false);
		addStudentField2.setVisible(false);
		searchButton1.setVisible(false);
		doneButton1.setVisible(false);
		addStudentField1.setText("");
		addStudentField2.setText("");
	}
	
	public void displayAddStudentOptions()
	{
		addStudentLabel1.setVisible(true);
		addStudentLabel2.setVisible(true);
		addStudentField1.setVisible(true);
		addStudentField2.setVisible(true);
		searchButton1.setVisible(true);
		doneButton1.setVisible(true);
		addStudentField1.setText("");
		addStudentField2.setText("");		
	} //displays components needed to add student
	
	public LinkedList <Student> sortStudentsAlpha (LinkedList <Student> list,  int type, int round)
    {
    	//System.out.println("Running sort. List size: "+list.size()); 
    	if(type==0)//by first name
    	{
    		//System.out.println("sort type: first name"); 
    		LinkedList <LinkedList <Student>>  sames= new LinkedList <LinkedList <Student>>() ; 
    		//System.out.println("first type pre order List size: "+list.size()); 
    		int rem=list.size(); 
    		for (int i=0; i<rem; i++)
    		{
    			boolean found=false; 
    			//System.out.println(i+": "+sames.isEmpty()); 
    			if(!sames.isEmpty())
    			{
    				//converting into a list with repeats together 
    				
    				for(int j=0; j<sames.size(); j++)
    				{
    					if (list.get(i).getFirstName().equalsIgnoreCase(sames.get(j).get(0).getFirstName()))//name already recorded
    					{
    						//System.out.println("Repeat found: "+list.get(i).getFirstName()); 
    						sames.get(j).add(list.get(i));
    						 
    						found=true;
    						break;
    					}
    				}
    				if (!found)
    				{
    					//System.out.println("Repeat not found: "+list.get(i).getFirstName()); 
    					LinkedList <Student> temp=new LinkedList<Student>();
    					temp.add(list.get(i));
    					 
    					sames.add(temp); 
    				}
    			}
    			else
    			{
    				//System.out.println("first in list moved to same"); 
    				LinkedList <Student> temp=new LinkedList<Student>();
    				temp.add(list.get(i));
    				
    				sames.add(temp); 
    			}
    		}
    		//System.out.println("sorted to sames: "+sames.size()); 
    			
    			
    		//for(int i=0; i<sames.size(); i++)
    		//{
    		//	for(int j=0; j<sames.get(i).size(); j++)
    		//	{
    				//System.out.println("Names in sames: "+i+sames.get(i).get(j).getFirstName()); 
    		//	}
    	//	}
    		
    		for(int top=sames.size()-1; top>0; top--)
    		{
    			int largeLoc=0; 
    			for (int k=1; k<=top; k++)
    			{
    				if(sames.get(largeLoc).get(0).getFirstName().toLowerCase().compareTo(sames.get(k).get(0).getFirstName().toLowerCase())<0)
    				{
    					largeLoc=k; 
    				}
    			}
    			
    			LinkedList <Student> t= sames.get(top); 
    			LinkedList<Student> te=sames.get(largeLoc); 
    			
    			sames.remove(top);
    			sames.add(top, te); 
    			sames.remove(largeLoc);
    			sames.add(largeLoc, t); 
    			
       		}
       		//for(int i=0; i<sames.size(); i++)
    	//	{
    	//		for(int j=0; j<sames.get(i).size(); j++)
    	//		{
    	//			System.out.println("Names in sames: "+i+sames.get(i).get(j).getFirstName()); 
    	//		}
    	//	}
       		if (round==0)
			{
				LinkedList <LinkedList <Student>>  to= new LinkedList <LinkedList <Student>>() ; 
				int r=sames.size(); 
				for(int i=0; i<r; i++)
       			{
	       			LinkedList <Student> t=sames.get(i); 
	      			t=sortStudentsAlpha(t, 1, 1); 
	      			
	     			to.add(t); 
	      		}
	      		sames=to; 
			}
			
			list.clear(); 
			for(int i=0; i<sames.size(); i++)
			{
				list.addAll(sames.get(i)); 
			}
			
    		
    		
    	}
    	else if(type==1) //by last name
    	{
    		//System.out.println("\n\nsort type: last name"); 
    		LinkedList <LinkedList <Student>>  sames= new LinkedList <LinkedList <Student>>() ; 
    		//System.out.println("first type pre order List size: "+list.size()); 
    		int rem=list.size(); 
    		for (int i=0; i<rem; i++)
    		{
    			boolean found=false; 
    			//System.out.println(i+": "+sames.isEmpty()); 
    			if(!sames.isEmpty())
    			{
    				//converting into a list with repeats together 
    				
    				for(int j=0; j<sames.size(); j++)
    				{
    					if (list.get(i).getLastName().equalsIgnoreCase(sames.get(j).get(0).getLastName()))//name already recorded
    					{
    						//System.out.println("Repeat found: "+list.get(i).getLastName()); 
    						sames.get(j).add(list.get(i));
    						 
    						found=true;
    						break;
    					}
    				}
    				if (!found)
    				{
    					//System.out.println("Repeat not found: "+list.get(i).getLastName()); 
    					LinkedList <Student> temp=new LinkedList<Student>();
    					temp.add(list.get(i));
    					 
    					sames.add(temp); 
    				}
    			}
    			else
    			{
    				//System.out.println("first in list moved to same"); 
    				LinkedList <Student> temp=new LinkedList<Student>();
    				temp.add(list.get(i));
    				
    				sames.add(temp); 
    			}
    		}
    	//	System.out.println("sorted to sames: "+sames.size()); 
    			
    			
    	//	for(int i=0; i<sames.size(); i++)
    	//	{
    	//		for(int j=0; j<sames.get(i).size(); j++)
    	//		{
    	//			System.out.println("Names in sames: "+i+sames.get(i).get(j).getLastName()); 
    	//		}
    	//	}
    		
    		for(int top=sames.size()-1; top>0; top--)
    		{
    			int largeLoc=0; 
    			for (int k=1; k<=top; k++)
    			{
    				if(sames.get(largeLoc).get(0).getLastName().toLowerCase().compareTo(sames.get(k).get(0).getLastName().toLowerCase())<0)
    				{
    					largeLoc=k; 
    				}
    			}
    			
    			LinkedList <Student> t= sames.get(top); 
    			LinkedList<Student> te=sames.get(largeLoc); 
    			
    			sames.remove(top);
    			sames.add(top, te); 
    			sames.remove(largeLoc);
    			sames.add(largeLoc, t); 
    			
       		}
    //   		for(int i=0; i<sames.size(); i++)
    //		{
    //			for(int j=0; j<sames.get(i).size(); j++)
    //			{
    //				System.out.println("Names in sames: "+i+sames.get(i).get(j).getLastName()); 
    //			}
    //		}
       		if (round==0)
			{
				LinkedList <LinkedList <Student>>  to= new LinkedList <LinkedList <Student>>() ; 
				int r=sames.size(); 
				for(int i=0; i<r; i++)
       			{
	       			LinkedList <Student> t=sames.get(i); 
	      			t=sortStudentsAlpha(t, 0, 1); 
	      			
	     			to.add(t); 
	      		}
	      		sames=to; 
			}
			
			list.clear(); 
			for(int i=0; i<sames.size(); i++)
			{
				list.addAll(sames.get(i)); 
			}
			
    		
    	}
    	
    	return (list); 
    }
    
    public LinkedList <Team> sortTeamBudget(LinkedList <Team> list, int type)
    {
    	if(type==0)//by first name
    	{
    		
    		LinkedList <LinkedList <Team>>  sames= new LinkedList <LinkedList <Team>>() ; 
    		//System.out.println("first type pre order List size: "+list.size()); 
    		int rem=list.size(); 
    		for (int i=0; i<rem; i++)
    		{
    			boolean found=false; 
    			//System.out.println(i+": "+sames.isEmpty()); 
    			if(!sames.isEmpty())
    			{
    				//converting into a list with repeats together 
    				
    				for(int j=0; j<sames.size(); j++)
    				{
    					if (list.get(i).getBudget()==sames.get(j).get(0).getBudget())//name already recorded
    					{
    						//System.out.println("Repeat found: "+list.get(i).getFirstName()); 
    						sames.get(j).add(list.get(i));
    						 
    						found=true;
    						break;
    					}
    				}
    				if (!found)
    				{
    					//System.out.println("Repeat not found: "+list.get(i).getFirstName()); 
    					LinkedList <Team> temp=new LinkedList<Team>();
    					temp.add(list.get(i));
    					 
    					sames.add(temp); 
    				}
    			}
    			else
    			{
    				//System.out.println("first in list moved to same"); 
    				LinkedList <Team> temp=new LinkedList<Team>();
    				temp.add(list.get(i));
    				
    				sames.add(temp); 
    			}
    		}
    		//System.out.println("sorted to sames: "+sames.size()); 
    			
    			
    		//for(int i=0; i<sames.size(); i++)
    		//{
    		//	for(int j=0; j<sames.get(i).size(); j++)
    		//	{
    				//System.out.println("Names in sames: "+i+sames.get(i).get(j).getFirstName()); 
    		//	}
    	//	}
    		
    		for(int top=sames.size()-1; top>0; top--)
    		{
    			int largeLoc=0; 
    			for (int k=1; k<=top; k++)
    			{
    				if(sames.get(largeLoc).get(0).getBudget()>sames.get(k).get(0).getBudget())
    				{
    					largeLoc=k; 
    				}
    			}
    			
    			LinkedList <Team> t= sames.get(top); 
    			LinkedList<Team> te=sames.get(largeLoc); 
    			
    			sames.remove(top);
    			sames.add(top, te); 
    			sames.remove(largeLoc);
    			sames.add(largeLoc, t); 
    			
       		}
       		//for(int i=0; i<sames.size(); i++)
    	//	{
    	//		for(int j=0; j<sames.get(i).size(); j++)
    	//		{
    	//			System.out.println("Names in sames: "+i+sames.get(i).get(j).getFirstName()); 
    	//		}
    	//	}
       	
			LinkedList <LinkedList <Team>>  to= new LinkedList <LinkedList <Team>>() ; 
			int r=sames.size(); 
			for(int i=0; i<r; i++)
   			{
       			LinkedList <Team> t=sames.get(i); 
      			t=sortTeamBudget(t, 1); 
      			
     			to.add(t); 
      		}
      		sames=to; 
			
			
			list.clear(); 
			for(int i=0; i<sames.size(); i++)
			{
				list.addAll(sames.get(i)); 
			}
			
    		
    		
    	}
    	else if(type==1) //by last name
    	{
    		//System.out.println("\n\nsort type: last name"); 
    		LinkedList <LinkedList <Team>>  sames= new LinkedList <LinkedList <Team>>() ; 
    		//System.out.println("first type pre order List size: "+list.size()); 
    		int rem=list.size(); 
    		for (int i=0; i<rem; i++)
    		{
    			boolean found=false; 
    			//System.out.println(i+": "+sames.isEmpty()); 
    			if(!sames.isEmpty())
    			{
    				//converting into a list with repeats together 
    				
    				for(int j=0; j<sames.size(); j++)
    				{
    					if (list.get(i).getSport().equalsIgnoreCase(sames.get(j).get(0).getSport()))//name already recorded
    					{
    						//System.out.println("Repeat found: "+list.get(i).getLastName()); 
    						sames.get(j).add(list.get(i));
    						 
    						found=true;
    						break;
    					}
    				}
    				if (!found)
    				{
    					//System.out.println("Repeat not found: "+list.get(i).getLastName()); 
    					LinkedList <Team> temp=new LinkedList<Team>();
    					temp.add(list.get(i));
    					 
    					sames.add(temp); 
    				}
    			}
    			else
    			{
    				//System.out.println("first in list moved to same"); 
    				LinkedList <Team> temp=new LinkedList<Team>();
    				temp.add(list.get(i));
    				
    				sames.add(temp); 
    			}
    		}
    	//	System.out.println("sorted to sames: "+sames.size()); 
    			
    			
    	//	for(int i=0; i<sames.size(); i++)
    	//	{
    	//		for(int j=0; j<sames.get(i).size(); j++)
    	//		{
    	//			System.out.println("Names in sames: "+i+sames.get(i).get(j).getLastName()); 
    	//		}
    	//	}
    		
    		for(int top=sames.size()-1; top>0; top--)
    		{
    			int largeLoc=0; 
    			for (int k=1; k<=top; k++)
    			{
    				if(sames.get(largeLoc).get(0).getSport().toLowerCase().compareTo(sames.get(k).get(0).getSport().toLowerCase())<0)
    				{
    					largeLoc=k; 
    				}
    			}
    			
    			LinkedList <Team> t= sames.get(top); 
    			LinkedList<Team> te=sames.get(largeLoc); 
    			
    			sames.remove(top);
    			sames.add(top, te); 
    			sames.remove(largeLoc);
    			sames.add(largeLoc, t); 
    			
       		}
    //   		for(int i=0; i<sames.size(); i++)
    //		{
    //			for(int j=0; j<sames.get(i).size(); j++)
    //			{
    //				System.out.println("Names in sames: "+i+sames.get(i).get(j).getLastName()); 
    //			}
    //		}
       	
			
			list.clear(); 
			for(int i=0; i<sames.size(); i++)
			{
				list.addAll(sames.get(i)); 
			}
			
    		
    	}
    	
    	return (list); 
    }


	//not in use
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
}