
//Author: Gabriel Cohn-Richer
//Project: Final Project
//Class: CMPR112 - Java Programming
//Semester: Spring 2013
//Teacher: Mr. Huynh
//File: Final Project File 2 of 5 - Robot.java
//Submitted: 5/19/2013


//class for Robot - will contain all stats and methods for the Robot racer
public class Robot
{
	//declare variables for stats
	String name;
	char gender;
	int age = 0,
		weight = 0,
		speed = 0,
		acceleration = 0,
		runningDistance = 0,
		bodyLiftRatio = 0;
	
	//declare variables for current direction, direction randomizer, and current location coordinants
	char direction = 'n';
	int coordinantX = 0,
		coordinantY = 0,
		directionRandomizer = 0;
	
	//declare variables for current speed, default speed, run counter, and run energy
	int defaultSpeed = 2,
		currentSpeed = 2,
		runCounter = 0,
		runEnergy = 0;
	
	//this method will set the stats for each instantiation of the Robot
	void StatSetter()
	{
		//determine gender - of course robots have a gender - e.g. rosie the robot from the jetsons :)
		int temp1 = 1 + (int)(Math.random()* 2);
		
		if (temp1 > 1)
			gender = 'F';
		else
			gender = 'M';
		
		//determine age
		age = 1 + (int)(Math.random()* 50);
		
		//determine weight
		weight = 200 + (int)(Math.random()* 400);			
			//weight is constant regardless of gender or age
		
		//determine top speed
		speed = 5 + (int)(Math.random()* 10);			
			//subtract four if robot is very heavy or very light
			if ((weight > 350) || (weight < 250))
				speed -= 4;
			
		//determine acceleration
		acceleration = 2 + (int)(Math.random()* 3);
			//subtract four if robot is very heavy or very light
			if ((weight > 350) || (weight < 250))
				acceleration -= 1;
			
		//determine running distance
			//the robot does not get tired and has only its walking speed
			
		//determine body lift ratio
		bodyLiftRatio = 100 + (int)(Math.random()* 500);
			//body lift ratio is constant for the robot regardless of weight or age
	}
	
	//using the talk method will force a player to lose any acceleration they've gained
	void talk()
	{
		currentSpeed = defaultSpeed;
	}
	
	void walk()
	{
		if (direction == 'n')
			coordinantX--;
		
		if (direction == 's')
			coordinantX++;
		
		if (direction == 'e')
			coordinantY++;
		
		if (direction == 'w')
			coordinantY--;
	}
	
	void turn()
	{
		//records current direction to make sure that player doesn't "turn" going the same direction they were going before
		char oldDirection = direction;
		boolean sameDirection = true;
		
		//begin loop that will run until we're sure we have a new direction instead of the old direction
		while (sameDirection)
		{
			//get a random number between 1 and 4
			directionRandomizer = 1 + (int)(Math.random()* 4);
			
			//make each number correspond with a new direction
			switch(directionRandomizer)
			{
				case 1:
				direction = 'n';
				break;
				case 2:
				direction = 'e';
				break;
				case 3:
				direction = 'w';
				break;
				case 4:
				direction = 's';
				break;
			}
			
			//if the new direction isn't the same as the old direction then break the loop
			if (direction != oldDirection)
				sameDirection = false;
		}
		
		//a turn will slow any acceleration made
		currentSpeed = defaultSpeed;
	}
	
	//run method will accelerate player and increment the run counter
	//if player hits no slowing obstacles then they will reach their top speed
	//player can only run until they run out of energy
	void run()
	{
		currentSpeed += acceleration;
		runCounter++;
		
		if (runCounter >= 3)
		{
			currentSpeed = speed;
			runEnergy -= 3;
		}
		
		if (runEnergy <= 0)
		{
			currentSpeed = defaultSpeed;
			runCounter = 0;
		}
	}
	
	//if player 1 and player 2 collide both players will lose acceleration
	boolean collide(int coordinantX1, int coordinantY1, int coordinantX2, int coordinantY2)
	{
		boolean isCollision = false;
		
		if ((coordinantX1 == coordinantY1) && (coordinantX2 == coordinantY2))
			return isCollision = true;
		
		currentSpeed = defaultSpeed;
		
		return isCollision;
	}
	
	boolean lift()
	{
		boolean objectNotMoved = false;
		
		if (bodyLiftRatio > 25)
			objectNotMoved = false;
		
		else
			objectNotMoved = true;
		
		return objectNotMoved;	
	}

}
