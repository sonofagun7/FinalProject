
//Author: Gabriel Cohn-Richer
//Project: Final Project
//Class: CMPR112 - Java Programming
//Semester: Spring 2013
//Teacher: Mr. Huynh
//File: Final Project File 5 of 5 - Gameboard.java
//Submitted: 5/19/2013

import javax.swing.JOptionPane;

public class Gameboard
{
	//set up strings so that the board can be printed all in one joptionpane
	String wholeBoard = "", line1 = "", line2 = "", line3 = "", line4 = "", line5 = "", line6 = "", line7 = "",
					   line8 = "", line9 = "", line10 = "", line11 = "", line12 = "", line13 = "", line14 = "",
					   line15 = "", line16 = "", line17 = "", line18 = "", line19 = "", line20 = "";
	
	//set up variables to contain the previous coordinants to make sure they're removed from the board after a move is made
	int previousCoordinantX1 = 'a',
		previousCoordinantY1 = 'a',
		previousCoordinantX2 = 'a',
		previousCoordinantY2 = 'a';
	
	//character arrays contain the graphical contents of each vertical line of the board
	 char[] board1 = { '_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_' };
	 char[] board2 = { '|','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','|' };
	 char[] board3 = { '|','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','|' };
	 char[] board4 = { '|','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','%','%','%','o','o','o','o','o','o','o','o','o','o','o','o','o','|' };
	 char[] board5 = { '|','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','%','%','%','o','o','o','o','o','o','o','o','o','o','o','o','o','|' };
	 char[] board6 = { '|','o','o','o','o','#','#','#','#','#','o','%','%','%','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','#','#','#','#','#','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','o','o','o','#','o','o','o','o','o','o','|' };
	 char[] board7 = { '|','o','o','o','o','#','o','o','o','#','o','o','o','o','#','o','%','%','%','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','#','o','o','o','#','o','o','o','#','#','#','|' };
	 char[] board8 = { '|','o','o','o','o','#','o','o','o','#','o','o','o','o','#','o','%','%','%','#','#','#','#','#','#','#','o','o','o','o','o','#','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','#','o','o','o','#','o','o','o','o','o','o','|' };
	 char[] board9 = { '|','%','%','%','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','#','#','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','o','o','o','|' };
    char[] board10 = { '|','o','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','#','o','o','o','o','o','o','o','o','o','%','%','%','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','#','#','#','o','o','o','|' };
	char[] board11 = { '|','o','o','o','o','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','%','%','%','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','|' };
	char[] board12 = { '|','o','%','%','%','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','#','#','#','#','#','#','#','#','#','#','o','o','o','|' };
	char[] board13 = { '|','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','o','o','o','o','#','o','o','o','o','o','#','%','%','%','|' };
	char[] board14 = { '|','o','o','o','o','#','#','#','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','o','o','o','o','#','o','o','o','#','#','#','%','%','%','|' };
	char[] board15 = { '|','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','#','o','o','o','o','%','%','%','#','o','o','o','o','o','o','o','o','o','|' };
	char[] board16 = { '|','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','#','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','#','o','o','o','#','o','o','o','#','#','#','#','#','#','#','o','o','%','%','%','#','o','o','o','o','o','o','o','o','o','|' };
	char[] board17 = { '|','#','#','#','#','#','#','#','#','o','o','o','o','#','#','#','#','#','#','#','o','o','o','o','#','#','#','#','#','o','o','o','o','#','#','#','#','#','o','o','o','#','#','#','#','#','#','#','#','o','o','o','#','o','o','o','o','o','#','o','o','%','%','%','#','#','#','#','#','#','#','#','#','#','|' };
	char[] board18 = { '|','o','o','%','%','%','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','#','#','#','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','|' };
	char[] board19 = { '|','o','o','%','%','%','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','#','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','|' };
	char[] board20 = { '_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_' };
	
	//position method places the character's game marker in the correct spot on the graph
	void positionPlayer1(char player,int coordinantX,int coordinantY)
	{
		if (coordinantX == 2)
			board2[coordinantY] = player;
		
		else if (coordinantX == 3)
			board3[coordinantY] = player;
		
		else if (coordinantX == 4)
			board4[coordinantY] = player;
		
		else if (coordinantX == 5)
			board5[coordinantY] = player;
		
		else if (coordinantX == 6)
			board6[coordinantY] = player;
		
		else if (coordinantX == 7)
			board7[coordinantY] = player;
		
		else if (coordinantX == 8)
			board8[coordinantY] = player;
		
		else if (coordinantX == 9)
			board9[coordinantY] = player;
		
		else if (coordinantX == 10)
			board10[coordinantY] = player;
		
		else if (coordinantX == 11)
			board11[coordinantY] = player;
		
		else if (coordinantX == 12)
			board12[coordinantY] = player;
		
		else if (coordinantX == 13)
			board13[coordinantY] = player;
		
		else if (coordinantX == 14)
			board14[coordinantY] = player;
		
		else if (coordinantX == 15)
			board15[coordinantY] = player;
		
		else if (coordinantX == 16)
			board16[coordinantY] = player;
		
		else if (coordinantX == 17)
			board17[coordinantY] = player;
		
		else if (coordinantX == 18)
			board18[coordinantY] = player;
		
		else 
			board19[coordinantY] = player;
		
		//record position so that marker can be cleared in the next frame of the board - prevent leaving a "trail"
		previousCoordinantX1 = coordinantX;
		previousCoordinantY1 = coordinantY;
	}
	
	//place player 2 on the map
	void positionPlayer2(char player,int coordinantX,int coordinantY)
	{
		if (coordinantX == 2)
			board2[coordinantY] = player;
		
		else if (coordinantX == 3)
			board3[coordinantY] = player;
		
		else if (coordinantX == 4)
			board4[coordinantY] = player;
		
		else if (coordinantX == 5)
			board5[coordinantY] = player;
		
		else if (coordinantX == 6)
			board6[coordinantY] = player;
		
		else if (coordinantX == 7)
			board7[coordinantY] = player;
		
		else if (coordinantX == 8)
			board8[coordinantY] = player;
		
		else if (coordinantX == 9)
			board9[coordinantY] = player;
		
		else if (coordinantX == 10)
			board10[coordinantY] = player;
		
		else if (coordinantX == 11)
			board11[coordinantY] = player;
		
		else if (coordinantX == 12)
			board12[coordinantY] = player;
		
		else if (coordinantX == 13)
			board13[coordinantY] = player;
		
		else if (coordinantX == 14)
			board14[coordinantY] = player;
		
		else if (coordinantX == 15)
			board15[coordinantY] = player;
		
		else if (coordinantX == 16)
			board16[coordinantY] = player;
		
		else if (coordinantX == 17)
			board17[coordinantY] = player;
		
		else if (coordinantX == 18)
			board18[coordinantY] = player;
		
		else 
			board19[coordinantY] = player;
		
		//record position so that marker can be cleared in the next frame of the board - prevent leaving a "trail"
		previousCoordinantX2 = coordinantX;
		previousCoordinantY2 = coordinantY;
	}
	
	//display method puts each array of lines into a separate string
	void display()
	{
		for (int j = 0; j < 75; j++)
			line1 += board1[j];
		
		for (int j = 0; j < 75; j++)
			line2 += board2[j];
		
		for (int j = 0; j < 75; j++)
			line3 += board3[j];
		
		for (int j = 0; j < 75; j++)
			line4 += board4[j];
		
		for (int j = 0; j < 75; j++)
			line5 += board5[j];
		
		for (int j = 0; j < 75; j++)
			line6 += board6[j];
		
		for (int j = 0; j < 75; j++)
			line7 += board7[j];
		
		for (int j = 0; j < 75; j++)
			line8 += board8[j];
		
		for (int j = 0; j < 75; j++)
			line9 += board9[j];
		
		for (int j = 0; j < 75; j++)
			line10 += board10[j];
		
		for (int j = 0; j < 75; j++)
			line11 += board11[j];
		
		for (int j = 0; j < 75; j++)
			line12 += board12[j];
		
		for (int j = 0; j < 75; j++)
			line13 += board13[j];
		
		for (int j = 0; j < 75; j++)
			line14 += board14[j];
		
		for (int j = 0; j < 75; j++)
			line15 += board15[j];
		
		for (int j = 0; j < 75; j++)
			line16 += board16[j];
		
		for (int j = 0; j < 75; j++)
			line17 += board17[j];
		
		for (int j = 0; j < 75; j++)
			line18 += board18[j];
		
		for (int j = 0; j < 75; j++)
			line19 += board19[j];
		
		for (int j = 0; j < 75; j++)
			line20 += board20[j];
		
		//string wholeBoard shows the entire board in the same joptionpane
		wholeBoard = line1 + "\n" + line2 + "\n" + line3 + "\n" +  line4 + "\n" +  line5 + "\n" +  line6 + "\n" +
				     line7 + "\n" + line8 + "\n" + line9 + "\n" +  line10 + "\n" +  line11 + "\n" +  line12 + "\n" +
				     line13 + "\n" + line14 + "\n" + line15 + "\n" +  line16 + "\n" +  line17 + "\n" +  line18 + "\n" +
				     line19 + "\n" + line20;
				
		
		//show the game board to the user
		JOptionPane.showMessageDialog( null, wholeBoard);
		
	}	
	void clearBoard()
	{
		//clear the board to avoid duplicate prints
		wholeBoard = ""; line1 = ""; line2 = ""; line3 = ""; line4 = ""; line5 = ""; line6 = "";
		line7 = ""; line8 = ""; line9 = ""; line10 = ""; line11 = ""; line12 = ""; line13 = "";
		line14 = ""; line15 = ""; line16 = ""; line17 = ""; line18 = ""; line19 = ""; line20 = "";
		
		//clear the previous coordinant to avoid the game markers leaving a "trail" (player 1)
		if (previousCoordinantX1 == 2)
			board2[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 3)
			board3[previousCoordinantY1] = '=';
		
		else if (previousCoordinantX1 == 4)
			board4[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 5)
			board5[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 6)
			board6[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 7)
			board7[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 8)
			board8[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 9)
			board9[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 10)
			board10[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 11)
			board11[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 12)
			board12[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 13)
			board13[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 14)
			board14[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 15)
			board15[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 16)
			board16[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 17)
			board17[previousCoordinantY1] = 'o';
		
		else if (previousCoordinantX1 == 18)
			board18[previousCoordinantY1] = 'o';
		
		else 
			board19[previousCoordinantY1] = 'o';
		
		//clear the previous coordinant to avoid the game markers leaving a "trail" (player 2)
		if (previousCoordinantX2 == 2)
			board2[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 3)
			board3[previousCoordinantY2] = '=';
		
		else if (previousCoordinantX2 == 4)
			board4[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 5)
			board5[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 6)
			board6[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 7)
			board7[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 8)
			board8[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 9)
			board9[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 10)
			board10[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 11)
			board11[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 12)
			board12[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 13)
			board13[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 14)
			board14[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 15)
			board15[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 16)
			board16[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 17)
			board17[previousCoordinantY2] = 'o';
		
		else if (previousCoordinantX2 == 18)
			board18[previousCoordinantY2] = 'o';
		
		else 
			board19[previousCoordinantY2] = 'o';
	}
	
	boolean RockChecker(int XCoordinant, int YCoordinant)
	{
		boolean isRock = false;
		
		if ((XCoordinant == 2) && (board2[YCoordinant] == '#'))
			isRock = true;
			
		else if ((XCoordinant == 3) && (board3[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 4) && (board4[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 5) && (board5[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 6) && (board6[YCoordinant] == '#'))
			isRock = true;
			
		else if ((XCoordinant == 7) && (board7[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 8) && (board8[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 9) && (board9[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 10) && (board10[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 11) && (board11[YCoordinant] == '#'))
			isRock = true;
			
		else if ((XCoordinant == 12) && (board12[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 13) && (board13[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 14) && (board14[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 15) && (board15[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 16) && (board16[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 17) && (board17[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 18) && (board18[YCoordinant] == '#'))
			isRock = true;
		
		else if ((XCoordinant == 19) && (board19[YCoordinant] == '#'))
			isRock = true;
		
		return isRock;
	}
	
	boolean BuzzardChecker(int XCoordinant, int YCoordinant)
	{
		boolean isBuzzard = false;
		
		if ((XCoordinant == 2) && (board2[YCoordinant] == '%'))
			isBuzzard = true;
			
		else if ((XCoordinant == 3) && (board3[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 4) && (board4[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 5) && (board5[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 6) && (board6[YCoordinant] == '%'))
			isBuzzard = true;
			
		else if ((XCoordinant == 7) && (board7[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 8) && (board8[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 9) && (board9[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 10) && (board10[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 11) && (board11[YCoordinant] == '%'))
			isBuzzard = true;
			
		else if ((XCoordinant == 12) && (board12[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 13) && (board13[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 14) && (board14[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 15) && (board15[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 16) && (board16[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 17) && (board17[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 18) && (board18[YCoordinant] == '%'))
			isBuzzard = true;
		
		else if ((XCoordinant == 19) && (board19[YCoordinant] == '%'))
			isBuzzard = true;
		
		return isBuzzard;
	}
}


