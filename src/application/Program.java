package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractProcessing;
import model.services.PaypalPayment;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy):");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		Contract c1 = new Contract(number, date, totalValue);
		
		System.out.println("Enter number of installments: ");
		Integer numberInstallments = sc.nextInt();
		
		ContractProcessing cp = new ContractProcessing(new PaypalPayment());
		cp.processContract(c1, numberInstallments);
		
		for (Installment it : c1.getList()) {
			System.out.println(it);
		}

		
		sc.close();
		
	}

}
