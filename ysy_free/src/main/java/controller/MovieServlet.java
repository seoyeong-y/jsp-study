package controller;

import java.io.IOException;
import java.util.ArrayList;

import domain.MovieVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.MovieDAO;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String cmdReq;
		cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("list")) {
			MovieDAO dao = new MovieDAO();

			ArrayList<MovieVO> movieList = dao.getMovieList();
			request.setAttribute("movieList", movieList);
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("info")) {
			String movieId = request.getParameter("id");
			if (movieId != null) {
				MovieDAO dao = new MovieDAO();
				MovieVO movie = dao.read(movieId); // 해당 영화 정보를 DB에서 조회
				if (movie != null) {
					request.setAttribute("movie", movie);
					RequestDispatcher view = request.getRequestDispatcher("movie_info.jsp");
					view.forward(request, response);
				} else {
					response.sendRedirect("home.jsp"); // 영화 정보를 찾을 수 없는 경우 홈으로 리다이렉트
				}
			} else {
				response.sendRedirect("home.jsp"); // id가 없는 경우 홈으로 리다이렉트
			}
		} else if (cmdReq.equals("delete")) {
			MovieDAO dao = new MovieDAO();
			String strId = request.getParameter("id");
			dao.delete(strId);

			ArrayList<MovieVO> movieList = dao.getMovieList();
			request.setAttribute("movieList", movieList);
			RequestDispatcher view = request.getRequestDispatcher("movie_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			MovieDAO dao = new MovieDAO();
			MovieVO movie = dao.read(request.getParameter("id"));
			request.setAttribute("movie", movie);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
