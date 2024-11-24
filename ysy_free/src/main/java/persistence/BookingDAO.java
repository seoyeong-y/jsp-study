package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BookingVO;

public class BookingDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean add(BookingVO booking) {
		connect();
		String sql = "INSERT INTO booking (memberId, movieName, theaterId, bookingDate, seats) VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, booking.getMemberId());
			pstmt.setString(2, booking.getMovieName());
			pstmt.setInt(3, booking.getTheaterId());
			pstmt.setDate(4, Date.valueOf(booking.getBookingDate()));
			pstmt.setString(5, booking.getSeats());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean delete(int bookingId) {
		connect();
		String sql = "DELETE FROM booking WHERE bookingId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookingId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public ArrayList<BookingVO> getBookingList(String memberId) {
		connect();
		ArrayList<BookingVO> bookingList = new ArrayList<BookingVO>();
		String sql = "SELECT b.bookingId, b.movieName, t.theaterName, b.bookingDate, b.seats "
				+ "FROM booking b JOIN theater t ON b.theaterId = t.theaterId WHERE b.memberId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVO booking = new BookingVO();
				booking.setBookingId(rs.getInt("bookingId"));
				booking.setMovieName(rs.getString("movieName"));
				booking.setTheaterName(rs.getString("theaterName"));
				booking.setBookingDate(rs.getDate("bookingDate").toString());
				booking.setSeats(rs.getString("seats"));
				bookingList.add(booking);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bookingList;
	}
}
