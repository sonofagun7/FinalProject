

//Author: Gabriel Cohn-Richer
//Project: Final Project
//Class: CMPR112 - Java Programming
//Semester: Spring 2013
//Teacher: Mr. Huynh
//File: Final Project File 3 of 5 - Human.java
//Submitted: 5/19/2013

//class for Human - will contain all stats and methods for the Human racer
public class Human
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
	
	//this method will set the stats for each instantiation of the Human
	void StatSetter()
	{
		//determine gender
		int temp1 = 1 + (int)(Math.random()* 2);
		
		if (temp1 > 1)
			gender = 'F';
		else
			gender = 'M';
		
		//determine age
		age = 12 + (int)(Math.random()* 65);
		
		//determine weight
		weight = 110 + (int)(Math.random()* 250);			
			//subtract ten pounds for very old and very young human
			if ((age < 16) || (age > 55))
				weight -= 10;
			//subtract ten pounds if the human is female
			if (gender == 'F')
				weight -= 10;
		
		//determine top speed
		speed = 15 + (int)(Math.random()* 25);			
			//subtract five if human is very heavy or very light
			if ((weight > 210) || (weight < 110))
				speed -= 5;
			//subtract five if human is very old or very young
			if ((age < 16) || (age > 55))
				speed -= 5;
			
		//determine acceleration
		acceleration = 10 + (int)(Math.random()* 15);
			//subtract four if human is very heavy or very light
			if ((weight > 210) || (weight < 110))
				acceleration -= 3;
			//subtract five if human is very old or very young
			if ((age < 16) || (age > 55))
				acceleration -= 5;
			
		//determine running distance
		runningDistance = 15 + (int)(Math.random()* 25);
			//subtract four if human is very heavy or very light
			if ((weight > 210) || (weight < 110))
				runningDistance -= 7;
			//subtract four if human is very old or very young
			if ((age < 16) || (age > 55))
				runningDistance -= 7;
			
		//determine body lift ratio
		bodyLiftRatio = 20 + (int)(Math.random()* 40);
			//subtract four if human is very heavy or very light
			if ((weight > 210) || (weight < 110))
				bodyLiftRatio -= 7;
			//subtract four if human is very old or very young
			if ((age < 16) || (age > 55))
				bodyLiftRatio -= 7;		
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
