/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Oct 12, 2022
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class ListEvent {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String artist;
	@Column
	private LocalDate concertDate;
	@Column
	private LocalTime concertTime;
	@JoinColumn
	private ListTicket ticket;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public LocalDate getConcertDate() {
		return concertDate;
	}
	
	public void setConcertDate(LocalDate concertDate) {
		this.concertDate = concertDate;
	}
	
	public LocalTime getConcertTime() {
		return concertTime;
	}
	
	public void setConcertTime(LocalTime concertTime) {
		this.concertTime = concertTime;
	}
	
	public ListTicket getTicket() {
		return ticket;
	}
	
	public void setTicket(ListTicket ticket) {
		this.ticket = ticket;
	}
	
	//Constructors
	public ListEvent() {
		super();
	}
	
	public ListEvent(String artist, LocalDate concertDate, LocalTime concertTime) {
		super();
		this.artist = artist;
		this.concertDate = concertDate;
		this.concertTime = concertTime;
	}

	//Methods
	@Override
	public String toString() {
		return "ListEvent [id=" + id + ", artist=" + artist + ", concertDate=" + concertDate + ", concertTime="
				+ concertTime + "]";
	}
	
	
	
	
	
	
}
