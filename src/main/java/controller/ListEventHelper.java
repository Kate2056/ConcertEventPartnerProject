/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Oct 13, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListEvent;

public class ListEventHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ConcertEvent");
	
	public ListEventHelper() {
		super();
	}
	
	public void insertEvent(ListEvent e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListEvent> showAllEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<ListEvent> allEvents = em.createQuery("SELECT i from ListEvent i").getResultList();
		return allEvents;
		}
	
	public void deleteEvent(ListEvent toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEvent>typedQuery = em.createQuery("select li from ListEvent li where li.artist = :selectedArtist and li.concertDate = :selectedConcertDate and li.concertTime = :selectedConcertTime", ListEvent.class);
		typedQuery.setParameter("selectedArtist", toDelete.getArtist());
		typedQuery.setParameter("selectedConcertDate", toDelete.getConcertDate());
		typedQuery.setParameter("selectedConcertTime", toDelete.getConcertTime());
		typedQuery.setMaxResults(1);
		ListEvent result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public List<ListEvent> searchForEventByArtist(String eventArtist) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEvent> typedQuery = em.createQuery("select li from ListEvent li where li.artist = :selectedEvent", ListEvent.class);
		typedQuery.setParameter("selectedEvent", eventArtist);
		List<ListEvent> foundArtists = typedQuery.getResultList();
		em.close();
		return foundArtists;
	}
	
	public List<ListEvent> searchForEventByConcertDate(String concertDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEvent> typedQuery = em.createQuery("select li from ListEvent li where li.concertDate = :selectedConcertDate", ListEvent.class);
		typedQuery.setParameter("selectedConcertDate", concertDate);
		List<ListEvent> foundConcertDates = typedQuery.getResultList();
		em.close();
		return foundConcertDates;
	}
	public List<ListEvent> searchForEventByConcertTime(String concertTime) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListEvent> typedQuery = em.createQuery("select li from ListEvent li where li.concertTime = :selectedConcertTime", ListEvent.class);
		typedQuery.setParameter("selectedConcertTime", concertTime);
		List<ListEvent> foundConcertTimes = typedQuery.getResultList();
		em.close();
		return foundConcertTimes;
	}
	
	public ListEvent searchForEventById(int eventId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListEvent found = em.find(ListEvent.class, eventId);
		em.close();
		return found;
	}
	
	public void updateStudent(ListEvent toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public void cleanUp(){
		emfactory.close();
		}
	
}
