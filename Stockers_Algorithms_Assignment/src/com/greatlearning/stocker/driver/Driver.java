package com.greatlearning.stocker.driver;

import java.util.Scanner;

import com.greatlearning.stocker.service.Operations;

public class Driver {
	public static double[] price;
	public static int option;
	public static boolean[] flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operations op = new Operations();
		System.out.println("Enter the no of companies");
		int N = sc.nextInt();
		price = new double[N];
		flag = new boolean[N];
		for(int i=0;i<N;i++) {
			System.out.println("Enter current stock price of the company "+(i+1));
			price[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			flag[i] = sc.nextBoolean();
		}
		do {
			System.out.println("\n----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("----------------------------------------------");
			option = sc.nextInt();
			switch(option) {
			case 0:
				System.out.println("Exited Successfully");
				break;
			case 1:
				op.order(price, 0, price.length-1,true);
				System.out.println("Stock prices in ascending order are :");
				op.priceOrder(price, N);
				break;
			case 2:
				op.order(price, 0, price.length-1,false);
				System.out.println("Stock prices in descending order are :");
				op.priceOrder(price, N);
				break;
			case 3:
				op.rise(flag, N);
				break;
			case 4:
				op.fall(flag, N);
				break;
			case 5:
				System.out.println("Enter the Key Value");
				double key =sc.nextDouble(); 
				op.order(price, 0, price.length-1,true);
				op.search(price,0,price.length-1,key);
				
				break;
			default:
				System.out.println("Please Enter valid option");
			
				}
			
		}while(option!=0);
	sc.close();	
	}
}
