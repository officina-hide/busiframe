package busiframe.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import busiframe.core.dao.Environment;
import busiframe.core.html.BaseDisplay;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * システム管理サーブレット<br>
 * Servlet implementation class SystemAction01
 * @since 2025/03/13
 * @version 1.00 新規作成
 */
@WebServlet("/systemAction01")
public class SystemAction01 extends HttpServlet implements BaseDisplay {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemAction01() {
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
		StringBuffer html = new StringBuffer();
		Environment env = (Environment) session.getAttribute("env");
		PrintWriter out = response.getWriter();
		
		String actionName = request.getParameter("actionName");
		// テーブル一覧
		if(actionName != null && actionName.equals(DISPLAY_CD_TABLE_LIST_01)) {
			HtmlSysTableList01 table = new HtmlSysTableList01();
			html.append(table.createHTML(env));
			out.print(html.toString());
			return;
		}
	}

}
