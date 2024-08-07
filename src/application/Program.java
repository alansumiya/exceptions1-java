package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			try {
				System.out.print("Room number: ");
				int number = sc.nextInt();
				System.out.println("Check-in date (dd/MM/yyyy): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy): ");
				Date checkOut = sdf.parse(sc.next());
				
				
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
				
				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				System.out.println("Check-in date (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				
				//esse método vai lançar uma exceção caso ela ocorra
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservaton: " + reservation);
			}	
			catch(ParseException e) {
				System.out.println("Invalid date format");
			}
			catch(DomainException e) {
				//imprime a mensagem que o método updateDate lançou do erro
				System.out.println("Error in reservation: " + e.getMessage());
			}
		sc.close();

	}

}
