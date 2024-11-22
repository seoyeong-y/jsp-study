package jspbook.ch08;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class MsgTagSimpleHandler extends SimpleTagSupport {
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.println("커스텀 태그 핸들러 출력 메시지 !!");
	}
}
