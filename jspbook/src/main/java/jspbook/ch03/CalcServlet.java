package jspbook.ch03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1 = 0, num2 = 0, result = 0;
		boolean ret = true;
		String op="";
		
		//전달될 컨텐트에 대한 타입 설정과 캐릭터셋 설정
		response.setContentType("text/html; charset=UTF-8");
		
		//클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		
		//HTML 폼 num1, num2 값을 변수에 할당
		//getParameter() 메서드는 문자열을 리턴
		//숫자 경우 Integer.parseInt()로 int 변환
		
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		
		if(strNum1 == null || strNum1.equals(""))
			ret = false;
		if(strNum2 == null || strNum2.equals(""))
			ret = false;
		
		op = request.getParameter("operator");
		
		if(op != null && ret) {
			//calc() 메서드 호출로 결과를 받아온다.
			num1 = Integer.parseInt(strNum1);
			num2 = Integer.parseInt(strNum2);
			Calc calc = new Calc(num1, num2, op);
			result = calc.getResult();
		}
		
		//출력 스트림을 통해 화면을 구성한다.
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산기</TITLE></HEAD>");
		out.println("<BODY><center>");
		out.println("<H2>계산결과</H2>");
		out.println("<HR>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
