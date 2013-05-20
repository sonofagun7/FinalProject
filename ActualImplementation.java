
//Author: Gabriel Cohn-Richer
//Project: Final Project
//Class: CMPR112 - Java Programming
//Semester: Spring 2013
//Teacher: Mr. Huynh
//File: Final Project File 1 of 5 - ActualImplementation.java
//Submitted: 5/19/2013


import javax.swing.JOptionPane;

public class ActualImplementation
{
	public static void main(String[] args)
	{
		int clock = 60; //game clock set for 60 rounds (1 minute each round in game time)
		boolean gameNotOver = true;  //boolean value to break loop if time runs out or if one player wins
		int positionX1 = 19,  //player 1 position X coordinant
			positionY1 = 1,  //player 1 position Y coordinant
			positionX2 = 19,  //player 2 position X coordinant
			positionY2 = 73,  //player 2 position Y coordinant
			turnRandomizer = 0, //variable to determine whether or not the player will perform a random turn
			finalclock = 0, //final clock time to be saved for proper ending message
			finalX1 = 0, //final X1 coordinant to be saved for proper ending message
			finalX2 = 0,  //final X2 coordinant to be saved for proper ending message
			speedCounter = 0; //counts the number of moves each player can make per turn based on their current speed
		char marker1 = 'x', //player 1 game marker showing location on map
			 marker2 = 'x';  //player 2 game marker showing location on map
		
		//instantiate two classes of each character since they cannot be instantiated inside if statements and used outside
		Monkey player1M = new Monkey();
		Human player1H = new Human();
		Robot player1R = new Robot();
		Monkey player2M = new Monkey();
		Human player2H = new Human();
		Robot player2R = new Robot();
			 
		//introducing the user to the game and explaining the rules
		JOptionPane.showMessageDialog( null, "Welcome to the racing game!" );
		JOptionPane.showMessageDialog( null, "You will be able to pick two characters\n" +
											 "and race them through a maze.  You can\n" +
											 "choose between a monkey, a human, and a\n" +
											 "robot.  The monkey is very quick, but can't\n" +
											 "lift heavey objects out of the way.  The\n" +
											 "robot is very slow, but very strong.  And\n" +
											 "the human is of average speed and strength.");
		JOptionPane.showMessageDialog( null, "The characters will race through the maze\n" +
											 "for 60 minutes.  If nobody has won at the\n" +
											 "of the hour, then the race is a draw.  May\n" +
											 "the best biped win!");
		JOptionPane.showMessageDialog( null, "                            Map Key                           \n\n" +
											 "o - This is a plain old piece of ground.  Good for walking on.\n" +
											 "# - This is a rock.  Players must move it or go around it.    \n" +
											 "% - This is a buzzard.  Players must make them fly away.      \n" +
											 "= - This is the finish line.  Players must cross it to win.     ");
		
		
		//user selects first racer (monkey, human, or robot)
		String playerChoice = JOptionPane.showInputDialog( null, "Please choose your first racer.  Enter M\n" +
																 "for monkey, H for human, or R for robot.");
		//if player chooses monkey, set up monkey from class Monkey
		if (playerChoice.equals("M") || playerChoice.equals("m"))
		{
			marker1 = 'M';
			player1M.StatSetter();
			player1M.name = JOptionPane.showInputDialog("Please name the monkey.");
			JOptionPane.showMessageDialog( null, player1M.name + "'s stats are as follows.\n" +
												 "Gender:  " + player1M.gender + "\n" +
												 "Age:  " + player1M.age + "\n"	+
												 "Weight:  " + player1M.weight + "\n" +
												 "Speed:  " + player1M.speed + "\n" +
												 "Acceleration:  " + player1M.acceleration + "\n" +
												 "Running Distance:  " + player1M.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player1M.bodyLiftRatio);
		}
		
		//if player chooses human, set up human from class Human
		else if (playerChoice.equals("H") || playerChoice.equals("h"))
		{
			marker1 = 'H';
			player1H.StatSetter();
			player1H.name = JOptionPane.showInputDialog("Please name the human.");
			JOptionPane.showMessageDialog( null, player1H.name + "'s stats are as follows.\n" +
												 "Gender:  " + player1H.gender + "\n" +
												 "Age:  " + player1H.age + "\n"	+
												 "Weight:  " + player1H.weight + "\n" +
												 "Speed:  " + player1H.speed + "\n" +
												 "Acceleration:  " + player1H.acceleration + "\n" +
												 "Running Distance:  " + player1H.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player1H.bodyLiftRatio);
		}
		
		//if player chooses robot, set up robot from class Robot
		else
		{
			marker1 = 'R';
			player1R.StatSetter();
			player1R.name = JOptionPane.showInputDialog("Please name the robot.");
			JOptionPane.showMessageDialog( null, player1R.name + "'s stats are as follows.\n" +
												 "Gender:  " + player1R.gender + "\n" +
												 "Age:  " + player1R.age + "\n"	+
												 "Weight:  " + player1R.weight + "\n" +
												 "Speed:  " + player1R.speed + "\n" +
												 "Acceleration:  " + player1R.acceleration + "\n" +
												 "Running Distance:  " + player1R.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player1R.bodyLiftRatio);
		}
		
		
		
		
		//user selects second racer (monkey, human, or robot)
		playerChoice = JOptionPane.showInputDialog( null, "Please choose your second racer.  Enter M\n" +
														  "for monkey, H for human, or R for robot.");
		
		//if player chooses monkey, set up monkey from class Monkey
		if (playerChoice.equals("M") || playerChoice.equals("m"))
		{
			marker2 = 'M';
			player2M.StatSetter();
			player2M.name = JOptionPane.showInputDialog("Please name the monkey.");
			JOptionPane.showMessageDialog( null, player2M.name + "'s stats are as follows.\n" +
												 "Gender:  " + player2M.gender + "\n" +
												 "Age:  " + player2M.age + "\n"	+
												 "Weight:  " + player2M.weight + "\n" +
												 "Speed:  " + player2M.speed + "\n" +
												 "Acceleration:  " + player2M.acceleration + "\n" +
												 "Running Distance:  " + player2M.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player2M.bodyLiftRatio);
		}
		
		//if player chooses human, set up human from class Human
		else if (playerChoice.equals("H") || playerChoice.equals("h"))
		{
			marker2 = 'H';
			player2H.StatSetter();
			player2H.name = JOptionPane.showInputDialog("Please name the human.");
			JOptionPane.showMessageDialog( null, player2M.name + "'s stats are as follows.\n" +
												 "Gender:  " + player2M.gender + "\n" +
												 "Age:  " + player2M.age + "\n"	+
												 "Weight:  " + player2M.weight + "\n" +
												 "Speed:  " + player2M.speed + "\n" +
												 "Acceleration:  " + player2M.acceleration + "\n" +
												 "Running Distance:  " + player2M.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player2M.bodyLiftRatio);
		}
		
		//if player chooses robot, set up robot from class Robot
		else
		{
			marker2 = 'R';
			player2R.StatSetter();
			player2R.name = JOptionPane.showInputDialog("Please name the robot.");
			JOptionPane.showMessageDialog( null, player2R.name + "'s stats are as follows.\n" +
												 "Gender:  " + player2R.gender + "\n" +
												 "Age:  " + player2R.age + "\n"	+
												 "Weight:  " + player2R.weight + "\n" +
												 "Speed:  " + player2R.speed + "\n" +
												 "Acceleration:  " + player2R.acceleration + "\n" +
												 "Running Distance:  " + player2R.runningDistance + "\n" +
												 "Body Lift Ratio:  " + player2R.bodyLiftRatio);
		}
		

		
		//initiate a new game board from class Gameboard
		Gameboard thisgame = new Gameboard();
		
		//beginning the game with a while loop
		while (gameNotOver)
		{
			//if time runs out or either player crosses the finish line the loop will end
			if ((clock <= 0) || (positionX1 == 2) || (positionX2 == 2))
				{
					gameNotOver = false;
					
					//save final times in special variables so that proper ending message can be given
					finalclock = clock;
					finalX1 = positionX1;
					finalX2 = positionX2;
				}
			
			//place the player markers in the correct positions on the game board
			thisgame.positionPlayer1(marker1,positionX1,positionY1);
			thisgame.positionPlayer2(marker2, positionX2, positionY2);
			
			//then display the game board
			thisgame.display();
			
			//then clear the game board to prevent old game boards from appearing in the jframe
			thisgame.clearBoard();
			
			//decrement the clock
			clock--;
						
			//now that we are between turns we will have to change the positions of the players
			//since we don't know which players the users picked we'll need to create if statements for every possibility
			
			//player 1 monkey begin move
			if (marker1 == 'M')
			{
				player1M.runEnergy = player1M.runningDistance;
				speedCounter = player1M.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player1M.coordinantX = positionX1;
					player1M.coordinantY = positionY1;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player1M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					
					//move the player
					player1M.walk();
					
					//initiate run protocol by calling run function
					player1M.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX1 = player1M.coordinantX;
					positionY1 = player1M.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player1M.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player1M.turn();
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX1 == 20)
					{
						positionX1--;
						player1M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 0)
					{
						positionY1++;
						player1M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 74)
					{
						positionY1--;
						player1M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX1,positionY1))
					{
						if (player1M.lift())
						{
							if (player1M.direction == 'n')
							{
								positionX1++;
								player1M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1M.direction == 's')
							{
								positionX1--;
								player1M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1M.direction == 'e')
							{
								positionY1--;
								player1M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY1++;
								player1M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX1,positionY1))
					{
						player1M.talk();
						speedCounter = 0;
						player1M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0);
				
			} // end player 1 monkey move
				
			//player 1 human begin turn
			if (marker1 == 'H')
			{
				player1H.runEnergy = player1H.runningDistance;
				speedCounter = player1H.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player1H.coordinantX = positionX1;
					player1H.coordinantY = positionY1;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player1H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
	
					//move the player
					player1H.walk();
					
					//initiate run protocol by calling run function
					player1H.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX1 = player1H.coordinantX;
					positionY1 = player1H.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player1H.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player1H.turn();
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX1 == 20)
					{
						positionX1--;
						player1H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 0)
					{
						positionY1++;
						player1H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 74)
					{
						positionY1--;
						player1H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX1,positionY1))
					{
						if (player1H.lift())
						{
							if (player1H.direction == 'n')
							{
								positionX1++;
								player1H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1H.direction == 's')
							{
								positionX1--;
								player1H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1H.direction == 'e')
							{
								positionY1--;
								player1H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY1++;
								player1H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX1,positionY1))
					{
						player1H.talk();
						speedCounter = 0;
						player1H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0); 
				
			} // end player 1 human move
			
			//player 1 robot begin turn
			if (marker1 == 'R')
			{	
				player1R.runEnergy = player1R.runningDistance;
				speedCounter = player1R.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player1R.coordinantX = positionX1;
					player1R.coordinantY = positionY1;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player1R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}

					//move the player
					player1R.walk();
					
					//initiate run protocol by calling run function
					player1R.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX1 = player1R.coordinantX;
					positionY1 = player1R.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player1R.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player1R.turn();
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX1 == 20)
					{
						positionX1--;
						player1R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 0)
					{
						positionY1++;
						player1R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY1 == 74)
					{
						positionY1--;
						player1R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX1,positionY1))
					{
						if (player1R.lift())
						{
							if (player1R.direction == 'n')
							{
								positionX1++;
								player1R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1R.direction == 's')
							{
								positionX1--;
								player1R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1R.direction == 'e')
							{
								positionY1--;
								player1R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY1++;
								player1R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}	
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX1,positionY1))
					{
						player1R.talk();
						speedCounter = 0;
						player1R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0);
				
			} // end player 1 robot move
			
			//player 2 monkey begin turn
			if (marker2 == 'M')
			{
				player2M.runEnergy = player2M.runningDistance;
				speedCounter = player2M.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player2M.coordinantX = positionX2;
					player2M.coordinantY = positionY2;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player2M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					
					//move the player
					player2M.walk();
					
					//initiate run protocol by calling run function
					player2M.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX2 = player2M.coordinantX;
					positionY2 = player2M.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player2M.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player2M.turn();
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX2 == 20)
					{
						positionX2--;
						player2M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 0)
					{
						positionY2++;
						player2M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 74)
					{
						positionY2--;
						player2M.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX2,positionY2))
					{
						if (player2M.lift())
						{
							if (player2M.direction == 'n')
							{
								positionX2++;
								player2M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player2M.direction == 's')
							{
								positionX2--;
								player2M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1M.direction == 'e')
							{
								positionY2--;
								player2M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY2++;
								player2M.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX2,positionY2))
					{
						player2M.talk();
						speedCounter = 0;
						player2M.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0);
				
			} // end player 2 monkey move
			
			//player 2 human begin turn
			if (marker2 == 'H')
			{
				player2H.runEnergy = player2H.runningDistance;
				speedCounter = player2H.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player2H.coordinantX = positionX2;
					player2H.coordinantY = positionY2;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player2H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}				
					
					//move the player
					player2H.walk();
					
					//initiate run protocol by calling run function
					player2H.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX2 = player2H.coordinantX;
					positionY2 = player2H.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player2H.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player2H.turn();
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX2 == 20)
					{
						positionX2--;
						player2H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 0)
					{
						positionY2++;
						player2H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 74)
					{
						positionY2--;
						player2H.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX2,positionY2))
					{
						if (player2H.lift())
						{
							if (player2H.direction == 'n')
							{
								positionX2++;
								player2H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player2H.direction == 's')
							{
								positionX2--;
								player2H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player2H.direction == 'e')
							{
								positionY2--;
								player2H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY2++;
								player2H.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX2,positionY2))
					{
						player2H.talk();
						speedCounter = 0;
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0);
				
			} // end player 2 human move
			
			//player 2 robot begin turn
			if (marker2 == 'R')
			{
				player2R.runEnergy = player2R.runningDistance;
				speedCounter = player2R.currentSpeed;
				do
				{
					//pull the current coordinants into the class since there is no call by reference in java
					player2R.coordinantX = positionX2;
					player2R.coordinantY = positionY2;
				
					//move the player - player has 1 in 7 chance of performing a random turn
					turnRandomizer = 1 + (int)(Math.random()* 7);
					if (turnRandomizer == 3)
					{
						player2R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2H.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					
					//move the player
					player2R.walk();
					
					//initiate run protocol by calling run function
					player2R.run();
					
					//decrement the speedCounter
					speedCounter--;
				
					//pull the new coordinants out of the class and back into the main program
					positionX2 = player2R.coordinantX;
					positionY2 = player2R.coordinantY;
					
					//if players collide with each other then speed will drop to zero and the turn is over
					if (player2R.collide(positionX1, positionY1, positionX2, positionY2))
					{
						speedCounter = 0;
						player2R.turn();
						player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if the player has reached the boundaries of the board then they will need to back up and turn
					if (positionX2 == 20)
					{
						positionX2--;
						player2R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 0)
					{
						positionY2++;
						player2R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
					if (positionY2 == 74)
					{
						positionY2--;
						player2R.turn();
						speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
						player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				
					//if player has reached a rock in their path they will need to either back up and turn or lift the rock out of the way
					if (thisgame.RockChecker(positionX2,positionY2))
					{
						if (player2R.lift())
						{
							if (player2R.direction == 'n')
							{
								positionX2++;
								player2R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player2R.direction == 's')
							{
								positionX2--;
								player2R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else if (player1M.direction == 'e')
							{
								positionY2--;
								player2R.turn();
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}
							else
							{
								positionY2++;
								player2R.turn();		
								speedCounter -= (speedCounter / 2);  //speed halves when a turn is completed
								player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
							}		
						}
					}
				
					//if player meets a buzzard in the road they will need to talk to it in order to get it to move - this will stop them and end their turn
					if (thisgame.BuzzardChecker(positionX2,positionY2))
					{
						player2R.talk();
						speedCounter = 0;
						player2R.runCounter = 0; //runCounter is set back to zero since a slowing obstacle was hit
					}
				} while (speedCounter > 0);
				
			} // end player 2 robot move
		
		}// end while loop for main game (either a player has won, both players have won, or time has run out
		
		//endgame message for both players crossing the finish line simultaneously
		if ((finalX1 == 2) && (finalX2 == 2))
			JOptionPane.showMessageDialog( null, "Unbelieveable! Both players crossed the finish line\n" +
													"at the same time!  This game ended in a draw with " + finalclock +
													"\nminutes left on the clock.");
		
		//endgame message for clock running out
		if (finalclock == 0)
			JOptionPane.showMessageDialog( null, "Time has run out!  Nobody won this time." );

		//endgame messages for player 1 wins
		if ((finalX1 == 2) && (finalX2 != 2))
		{
			if (marker1 == 'M')
				JOptionPane.showMessageDialog( null, player1M.name + " the monkey has won with\n" +
													 finalclock + " minutes left on the clock!\n\n" +
													 "Congratulations " + player1M.name + "!");
			
			else if (marker1 == 'H')
				JOptionPane.showMessageDialog( null, player1H.name + " the human has won with\n" +
													 finalclock + " minutes left on the clock!\n\n" +
						 							 "Congratulations " + player1H.name + "!");
			
			else
				JOptionPane.showMessageDialog( null, player1R.name + " the robot has won with\n" +
						 							 finalclock + " minutes left on the clock!\n\n" +
						 							 "Congratulations " + player1R.name + "!");
		}// end endgame messages for player 1 wins
		
		//endgame messages for player 2 wins
		if ((finalX2 == 2) && (finalX1 != 2))
		{
			if (marker2 == 'M')
				JOptionPane.showMessageDialog( null, player2M.name + " the monkey has won with\n" +
													 finalclock + " minutes left on the clock!\n\n" +
													 "Congratulations " + player2M.name + "!");
			
			else if (marker2 == 'H')
				JOptionPane.showMessageDialog( null, player2H.name + " the human has won with\n" +
													 finalclock + " minutes left on the clock!\n\n" +
						 							 "Congratulations " + player2H.name + "!");
			
			else
				JOptionPane.showMessageDialog( null, player2R.name + " the robot has won with\n" +
						 							 finalclock + " minutes left on the clock!\n\n" +
						 							 "Congratulations " + player2R.name + "!");
		}// end endgame messages for player 2 wins
		
		//exit program messages	
		JOptionPane.showMessageDialog( null, "Thanks for playing!" );
		JOptionPane.showMessageDialog( null, "Exiting Program..." );
				
	}// end method main

}// end class ActualImplementation
