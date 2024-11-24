package service;

import java.util.ArrayList;

import domain.BookingVO;
import persistence.BookingDAO;

public class BookingService {
	private BookingDAO bookingDAO;

	public BookingService() {
		this.bookingDAO = new BookingDAO();
	}

	public boolean addBooking(BookingVO booking) {
		return bookingDAO.add(booking);
	}

	public ArrayList<BookingVO> getBookings(String memberId) {
		return bookingDAO.getBookingList(memberId);
	}

	public boolean deleteBooking(int bookingId) {
		return bookingDAO.delete(bookingId);
	}
}
