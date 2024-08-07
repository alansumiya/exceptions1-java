package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		//condição no construtor chama programação defensiva
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// pega a diferença entre as datas em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		//converte os milisegundos calculados e transforma em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//essa classe por ser void como não retorna nada, vai precisar lançar uma exceção. Com o throws ele pode lançar uma exceção, dependendo do erro que pode acontecer no método
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		//testa se a data do check-in ou check-out é antes da data autal
		if(checkIn.before(now) || checkOut.before(now)) {
			
			//o throw lança uma exceção, no caso é esse illegal, este trata um erro caso os parâmetro que foram passados são inválidos
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//Caso não tenha acontecido nenhum erro ele retorna null
		
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}
	
	
	
	
	
	
	
}
