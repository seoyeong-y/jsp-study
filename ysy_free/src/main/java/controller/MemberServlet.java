package controller;

import java.io.IOException;
import java.util.ArrayList;

import domain.MemberVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
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

		if (cmdReq.equals("login")) {
			response.sendRedirect("login.jsp");
		} else if (cmdReq.equals("join")) {
			response.sendRedirect("register.html");
		} else if (cmdReq.equals("mypage")) {
			HttpSession session = request.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member");
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("mypage.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("list")) {
			MemberService service = new MemberService(); // MemberService 사용
			ArrayList<MemberVO> memberList = service.getMemberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher view = request.getRequestDispatcher("member_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			MemberService service = new MemberService(); // MemberService 사용
			MemberVO member = service.getMemberById(request.getParameter("id"), request.getParameter("passwd"));
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("logout")) {
			request.getSession().invalidate(); // 세션 무효화
			response.sendRedirect("welcome.html"); // 로그인 페이지로 리다이렉트
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		String cmdReq;
		cmdReq = request.getParameter("cmd");
		String message = "";

		if (cmdReq.equals("login")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");

			MemberService service = new MemberService(); // MemberService 사용
			MemberVO member = service.login(id, passwd);

			if (member != null) {
				session.setAttribute("member", member);
				response.sendRedirect("MovieServlet?cmd=list");
			} else {
				request.setAttribute("message", "ID 또는 비밀번호가 올바르지 않습니다.");
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
		} else if (cmdReq.equals("join")) {
			MemberVO memberVO = new MemberVO();

			memberVO.setId(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setAge(request.getParameter("age"));
			memberVO.setSex(request.getParameter("sex"));
			memberVO.setPhone(request.getParameter("phone"));

			MemberService service = new MemberService(); // MemberService 사용

			if (service.registerMember(memberVO))
				message = "가입 축하합니다";
			else
				message = "가입 실패입니다";

			request.setAttribute("greetings", message);
			request.setAttribute("members", memberVO);

			RequestDispatcher view = request.getRequestDispatcher("MovieServlet?cmd=list");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			MemberVO memberVO = new MemberVO();

			memberVO.setId(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setAge(request.getParameter("age"));
			memberVO.setSex(request.getParameter("sex"));
			memberVO.setPhone(request.getParameter("phone"));

			MemberService service = new MemberService(); // MemberService 사용

			if (service.updateMember(memberVO)) {
				session.setAttribute("member", memberVO);
				message = "수정이 완료되었습니다.";
			} else
				message = "수정 실패입니다.";

			request.setAttribute("greetings", message);
			request.setAttribute("members", memberVO);

			RequestDispatcher view = request.getRequestDispatcher("MovieServlet?cmd=list");
			view.forward(request, response);
		}
	}

}
