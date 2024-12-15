package busiframe.educate.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import busiframe.core.dao.Environment;
import busiframe.core.html.BaseDisplay;

/**
 * Servlet implementation class EducateServlet01
 */
@WebServlet("/educate01")
public class EducateServlet01 extends HttpServlet implements BaseDisplay{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducateServlet01() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String actionName = request.getParameter("actionName");
		StringBuffer html = new StringBuffer();
		Environment env = (Environment) session.getAttribute("env");
		PrintWriter out = response.getWriter();
		// カテゴリー一覧
		if(actionName.equals(DISPLAY_CD_EDUCATE_MENU_01)) {
			HtmlEduCategoryList ecl = new HtmlEduCategoryList();
			html.append(ecl.createHTML(env));
			out.print(html.toString());
			return;
		}
	}

}
