
package mastermind2;

import java.util.Scanner;

public class MasterMind2
{

	public static void main(String[] args) /**
											 * @author Elian main class
											 **/
	{
		Methods methods = new Methods(); /**
											 * @author Elian Calling methods in the main class
											 * 
											 **/
		Scanner input = new Scanner(System.in);
		/**
		 * @author Elian Importing Scanner ;) .
		 **/
		Colors[] correctColors;/**
								 * @author Elian list to hold the correct colors (choose'd by the computer)
								 **/
		String[] playerGuesses;/**
								 * @author Elian list to hold users colors (picked colors)
								 **/
		boolean isWin;/**
						 * @author Elian if true games keep going. if false, means user have fill the
						 *         correct answer and the program Congratulate the player.
						 **/
		int trys = 0; /**
						 * @author Elian variable to hold the amount of attempts the user have.
						 **/
		int attempts; /**
						 * @author Elian variable to hold the amount of attempts the user used.
						 **/
		methods.show_dificulty();
		/**
		 * @author Elian to show the table of difficulty's to the user.
		 **/
		
			try
			{

				trys = methods.dificulty(input.nextInt());

			} catch (Exception e)
			{
				System.out.println("Verkeerde invoer");
				trys = 8;
			}
		
		correctColors = new Colors[4];
		for (int i = 0; i < 4; i++)
		{
			int randomIndex = methods.color_random();
			correctColors[i] = methods.colorChoose(randomIndex);
		}

		attempts = 0;
		while (attempts < trys)
		{
			playerGuesses = new String[4];
			methods.spatie();
			methods.mogelijke_kleuren();
			methods.spatie();
			for (int i = 0; i < 4; i++)
			{

				methods.spatie();
				methods.Vak(i);
				playerGuesses[i] = input.next();
			}

			methods.decoder(playerGuesses, correctColors);

			isWin = true;
			for (int i = 0; i < 4; i++)
			{
				if (!playerGuesses[i].equals(correctColors[i].toString().toLowerCase()))
				{
					isWin = false;
					break;
				}
			}

			if (isWin)
			{
				methods.spatie();
				System.out.println("¡Gefeliciteerd, you won!");
				methods.spatie();
				for (int i = 0; i < 4; i++)
				{
					System.out.println("ANTW_Vak_" + (i + 1) + ": " + correctColors[i]);
				}
				break;
			}

			attempts++;
			if (attempts == trys)
			{
				methods.spatie();
				System.out.println("¡You Lost! The correct colors waren: ");
				methods.spatie();
				for (int i = 0; i < 4; i++)
				{
					System.out.println("ANTW_Vak_" + (i + 1) + ": " + correctColors[i]);
				}
			}
		}

		input.close();
	}
}