

//Author: Gabriel Cohn-Richer
//Project: Final Project
//Class: CMPR112 - Java Programming
//Semester: Spring 2013
//Teacher: Mr. Huynh
//File: Final Project File 4 of 5 - Monkey.java
//Submitted: 5/19/2013

//class for Monkey - will contain all stats and methods for the Monkey racer
public class Monkey
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
	
	//this method will set the stats for each instantiation of the Monkey
	void StatSetter()
	{
		//determine gender
		int temp1 = 1 + (int)(Math.random()* 2);
		
		if (temp1 > 1)
			gender = 'F';
		else
			gender = 'M';
		
		//determine age
		age = 1 + (int)(Math.random()* 20);
		
		//determine weight
		weight = 40 + (int)(Math.random()* 85);			
			//subtract ten pounds for very old and very young monkey
			if ((age < 3) || (age > 18))
				weight -= 10;
			//subtract five pounds if the monkey is female
			if (gender == 'F')
				weight -= 5;
		
		//determine top speed
		speed = 25 + (int)(Math.random()* 35);			
			//subtract ten if monkey is very heavy or very light
			if ((weight > 75) || (weight < 50))
				speed -= 10;
			//subtract ten if monkey is very old or very young
			if ((age < 3) || (age > 18))
				speed -= 10;
			
		//determine acceleration of monkey
		acceleration = 20 + (int)(Math.random()* 30);
			//subtract four if monkey is very heavy or very light
			if ((weight > 75) || (weight < 50))
				acceleration -= 4;
			//subtract four if monkey is very old or very young
			if ((age < 3) || (age > 18))
				acceleration -= 4;
			
		//determine running distance of monkey
		runningDistance = 10 + (int)(Math.random()* 20);
			//subtract four if monkey is very heavy or very light
			if ((weight > 75) || (weight < 50))
				runningDistance -= 4;
			//subtract four if monkey is very old or very young
			if ((age < 3) || (age > 18))
				runningDistance -= 4;
			
		//determine body lift ratio of monkey
		bodyLiftRatio = 10 + (int)(Math.random()* 20);
			//subtract four if monkey is very heavy or very light
			if ((weight > 75) || (weight < 50))
				bodyLiftRatio -= 4;
			//subtract four if monkey is very old or very young
			if ((age < 3) || (age > 18))
				bodyLiftRatio -= 4;		
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
