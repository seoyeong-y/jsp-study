package controller;

import java.io.IOException;

import domain.BookingVO; // 예매 정보 객체
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BookingService; // 예매 처리 서비스

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService bookingService;

	@Override
	public void init() throws ServletException {
		bookingService = new BookingService(); // 예매 서비스 초기화
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmdReq = request.getParameter("cmd");

		if ("book".equals(cmdReq)) {
			// 영화 ID를 받기
			int movieId = Integer.parseInt(request.getParameter("id"));
			String movieName = request.getParameter("movieName");

			// 예매 폼을 보여주는 JSP로 포워드
			request.setAttribute("movieId", movieId);
			request.setAttribute("movieName", movieName);
			RequestDispatcher view = request.getRequestDispatcher("booking.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmdReq = request.getParameter("cmd");

		if ("book".equals(cmdReq)) {
			// 예매 정보 처리
			BookingVO booking = new BookingVO();
			booking.setMemberId(request.getParameter("memberId"));
			booking.setMovieName(request.getParameter("movieName"));
			booking.setTheaterId(Integer.parseInt(request.getParameter("theaterId")));
			booking.setSeats(request.getParameter("seats"));

			boolean result = bookingService.addBooking(booking); // 예매 서비스 호출

			if (result) {
				response.sendRedirect("BookingServlet?cmd=list"); // 예매 성공 후 리스트 페이지로 리디렉션
			} else {
				request.setAttribute("message", "예매 실패");
				RequestDispatcher view = request.getRequestDispatcher("booking.jsp");
				view.forward(request, response); // 예매 실패 시 예매 폼으로 돌아감
			}
		}
	}
}
