package java_shop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Payment extends Order {

	Scanner sc = new Scanner(System.in);
	private static final String ROUTING_NUMBER = "051000017";

	public void modeOfPayment(int payType, double sum) {

		switch (payType) {
		case 1:
			System.out.println("Enter the dollars");
			double change = sc.nextDouble();
			if(change < sum)
			{
				System.out.println("Insufficient Dollars....Please enter correct dollars");
				change = sc.nextDouble();
			}
			change = change - sum;
			System.out.println("Change: " + formatTotal(change) + "\n");
			break;

		case 2:
			System.out.println("Enter the credit card details\n");
			System.out.print("Enter the card number");
			long cardNumber = sc.nextLong();
			boolean valid = isValid(cardNumber);
			while (!valid) {
				System.out.println("\n" + cardNumber + " is Invalid. ");
				System.out.print("Enter the card number");
				cardNumber = sc.nextLong();
				valid = isValid(cardNumber);
			}
			validateDate();
			System.out.println("Please enter cvv");
			int cvv = sc.nextInt();
			break;
		case 3:
			boolean flag = true;
			while(flag){
			System.out.println("\nPlease Enter Valid Routing number");
			String routingNumber = sc.next();
			if(routingNumber.equals(ROUTING_NUMBER))
			{
				flag = false;
			}
			}
			char getChar = ' ';
				int i;
				do {
					System.out.println("\nPlease Enter Valid Member Number");
					String str = sc.next();
					for (i = 0; i < 3; i++) {
						getChar = str.charAt(i);
						if (getChar == '0')
							continue;
					}
				} while (getChar != '0');
				System.out.println("\nPlease Enter Check Number");
				long checkNumber = sc.nextLong();
				break;
			}
			

		}

	public static int getDigit(int number) {

		if (number <= 9) {
			return number;
		} else {
			int firstDigit = number % 10;
			int secondDigit = (int) (number / 10);

			return firstDigit + secondDigit;
		}
	}

	public boolean isValid(long cardNumber) {
		int total = sumOfDoubleEvenPlace(cardNumber) + sumOfOddPlace(cardNumber);
		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int sumOfDoubleEvenPlace(long number) {
		int result = 0;
		long temp = 0;
		while (number > 0) {
			temp = number % 100;
			result += getDigit((int) (temp / 10) * 2);
			number = number / 100;
		}
		return result;
	}

	public int sumOfOddPlace(long cardNumber) {
		int result = 0;
		while (cardNumber > 0) {
			result += (int) (cardNumber % 10);
			cardNumber = cardNumber / 100;
		}
		return result;
	}

	public void validateDate() {
		System.out.println("Enter Expiration date MM/YY");
		String input = sc.next();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		simpleDateFormat.setLenient(false);
		Date expiry = null;
		boolean expired;
		try {
			expiry = simpleDateFormat.parse(input);
		} catch (ParseException e) {

			System.out.println("Invalid date");
			sc.nextLine();
			validateDate();

		}

	}

}
