package tukorea.web.club.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tukorea.web.club.domain.StudentVO;
import tukorea.web.club.persistence.StudentDAO;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		String cmdReq;
		cmdReq = request.getParameter("cmd");
		if (cmdReq == null)
			return;

		StudentDAO studentDAO = new StudentDAO();
		JSONArray arrayJson = new JSONArray();

		if (cmdReq.equals("list")) {
			try {
				List<StudentVO> studentList = studentDAO.getStudentList();
				for (StudentVO vo : studentList) {
					JSONObject json = new JSONObject();
					json.put("id", vo.getId());
					json.put("passwd", vo.getPasswd());
					json.put("username", vo.getUsername());
					json.put("snum", vo.getSnum());
					json.put("depart", vo.getDepart());
					json.put("mobile", vo.getMobile());
					json.put("email", vo.getEmail());
					arrayJson.put(json);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
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
