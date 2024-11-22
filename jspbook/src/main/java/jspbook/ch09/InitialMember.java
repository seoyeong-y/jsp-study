package jspbook.ch09;

import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InitialMember
 *
 */
@WebListener
public class InitialMember implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		ArrayList<Member> datas = new ArrayList<Member>();

		for (int i = 0; i < 8; i++) {
			Member data = new Member("강호동" + i, "test" + i + "@tukorea.ac.kr");
			datas.add(data);
		}

		// email이 빠진 2개 샘플 데이터 추가
		datas.add(new Member("홍길동", null));
		datas.add(new Member("김길동", null));

		// application scope에 members 및 member 객체 저장
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
