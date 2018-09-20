import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class creditCardScanner
	{
		static long cardNumber;
		
		public static void main(String[] args) throws FileNotFoundException
			{
				Scanner userInput = new Scanner(System.in);
				
				System.out.println("Please choose wether you would rather input a card number(1) or enter a file(2).");
				int choiceOfInput = userInput.nextInt();
				
				if(choiceOfInput == 1){
					inputThatCard();
				}
				else if(choiceOfInput == 2){
					lottaCards();
				}
				
				
				calculations();
				lottaCards();
				inputThatCard();
			
		}

		private static void inputThatCard()
			{
				Scanner userInput = new Scanner(System.in);
				
				System.out.println("Please input a credit card number.");
				cardNumber = userInput.nextLong();
				calculations();
				
			}

		private static void lottaCards() throws FileNotFoundException
			{
				System.out.println("Please enter a file.");
				Scanner manyCards = new Scanner(new File("creditCardNumbers.txt"));
				while (manyCards.hasNext())
				{
					calculations();
				}
				
			}

		private static void calculations()
			{
				
			
				
				
				long[] cardArray = new long[16];
				long cardDoubled;
				long cardDoubledLastDigit = 0;
				long cardDoubledFirstDigit = 0;
				long sum = 0;
				
				
				for(int i = 15; i >= 0; i--)
					{
					long lastDigit = cardNumber%10;
					cardNumber = cardNumber / 10;
					
					cardArray[i] = lastDigit;
							
					}
				
						
						for(int t = 0; t < cardArray.length; t = t + 2)
							{
								cardDoubled = 0;
								cardDoubled = (cardArray[t] * 2);
								
								cardDoubledFirstDigit = 0;
								cardDoubledLastDigit = 0;
							
								if(cardDoubled > 9)
								{
									
									cardDoubledLastDigit = cardDoubled%10;
									cardDoubledFirstDigit = cardDoubled/10;
									 
									
									cardArray[t] = cardDoubledFirstDigit + cardDoubledLastDigit;
								
								
								
								}
								else
								{
								cardArray[t] = cardDoubled;	
								}
									
							}

				for(int i = 0; i < cardArray.length; i++){
					sum = sum + cardArray[i];
					
				}
				if((sum % 10) != 0){
					System.out.println("This is not a valid credit card.");
				}
				else{
					System.out.println("This is a valid credit card.");
				}
							
				
			}
		
	}
