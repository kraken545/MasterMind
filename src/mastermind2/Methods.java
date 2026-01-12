package mastermind2;

import java.util.Random;

enum Colors
{
	GREEN, PINK, BLUE, RED, PURPLE, ORANGE
}

public class Methods
{
	public void show_dificulty()/** shows the all the difficulty's options **/
	{
		System.out.println("Choose Dificulty: (1, 2 or 3)");
		System.out.println("1. Easy (8 pogginen)");
		System.out.println("2. Medium (5 pogginen)");
		System.out.println("3. Difícult (3 pogginen)");
	}
	public int dificulty(int dificultad)/** Process of choose the game difficulty **/
	{
		int maxIntentos;
	
		switch (dificultad)
		{
		case 1:
			maxIntentos = 8;
			break;
		case 2:
			maxIntentos = 5;
			break;
		case 3:
			maxIntentos = 3;
			break;
		default:
			System.out.println("dat is niet mogelijk, easy mode automatisch gekozen");
			maxIntentos = 8;
		}
		return maxIntentos;
	}

	public void spatie() /** class to generate a blank line (space) **/
	{
		System.out.println("");

	}

	public void mogelijke_kleuren()/** Shows all the possible colors to choose **/
	{
		System.out.println("Mogelijke kleuren: GREEN, PINK, BLUE, RED, PURPLE, ORANGE");

	}

	public Colors colorChoose(int index)/** process of choosing a color (user) **/
	{
		return Colors.values()[index];
	}

	public int color_random()/** process of choosing a color for the game itself (hidden colors) using Random **/
	{
		Random random = new Random();
		return random.nextInt(Colors.values().length);
	}

	public void decoder(String[] playerGuesses, Colors[] correctColors) /** Decoder compare the player- and the hiddenColors to have a result  **/
	{
		boolean isWin = true;
		boolean[] checked = new boolean[correctColors.length];

		for (int i = 0; i < playerGuesses.length; i++)
		{
			if (playerGuesses[i].equals(correctColors[i].toString().toLowerCase()))
			{
				System.out.println("Vak_" + (i + 1) + " is goed!");
			} else
			{
				isWin = false;
				boolean found = false;

				for (int j = 0; j < correctColors.length; j++)
				{
					if (playerGuesses[i].equals(correctColors[j].toString().toLowerCase()) && !checked[j])
					{
						found = true;
						checked[j] = true;
					}
				}

				if (found)
				{
					System.out.println("Vak_" + (i + 1) + " niet goed, maar kleur komt wel in de doosje.");
				} else
				{
					System.out.println("Vak_" + (i + 1) + " is niet goed!");
				}
			}
		}

	}
}
