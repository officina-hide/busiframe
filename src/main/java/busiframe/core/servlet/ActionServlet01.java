package busiframe.core.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import busiframe.educate.servlet.HtmlEducateMenu01;

/**
 * Servlet implementation class ActionServlet01
 */
@WebServlet("/action01")
public class ActionServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet01() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("actionName");
		StringBuffer html = new StringBuffer();
		
		if(actionName == null || actionName.equals("menu01")) {
			// Menu01表示
			HtmlMenu01 menu01 = new HtmlMenu01();
			html.append(menu01.createHTML());
		}
		if(actionName != null && actionName.equals("educate01")) {
			// 教育メニューLv.01表示
			HtmlEducateMenu01 edu01 = new HtmlEducateMenu01();
			html.append(edu01.createHTML());
		}
		
		
		PrintWriter out = response.getWriter();
		out.print(html.toString());
		
		return;
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
