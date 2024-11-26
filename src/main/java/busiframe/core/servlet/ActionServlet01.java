package busiframe.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import busiframe.core.dao.Environment;
import busiframe.educate.servlet.HtmlEducateMenu01;
import busiframe.order.servlet.HtmlOrderMenu01;
import busiframe.product.servlet.HtmlProductMenu01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ActionServlet01
 */
@WebServlet("/action01")
public class ActionServlet01 extends HttpServlet implements BaseHtml {

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
		HttpSession session = request.getSession();
		
		if(actionName == null || actionName.equals("menu01")) {
			// Menu01表示
			HtmlMenu01 menu01 = new HtmlMenu01();
			html.append(menu01.createHTML());
			// 環境情報をsessionにセットする。
			Environment env = new Environment();
			env.setDbSw(1);
			env.setLoginUserId(1001);
			session.setAttribute("env", env);
		}
		if(actionName != null && actionName.equals("educate01")) {
			// 教育メニューLv.01表示
			HtmlEducateMenu01 edu01 = new HtmlEducateMenu01();
			html.append(edu01.createHTML());
		}
		if(actionName != null && actionName.equals("order01")) {
			// 受注メニューLv.01表示
			HtmlOrderMenu01 order01 = new HtmlOrderMenu01();
			html.append(order01.createHTML());
		}
		if(actionName != null && actionName.equals(MENU_PRODUCT01)) {
			// 生産メニュー Lv.01表示
			HtmlProductMenu01 product01 = new HtmlProductMenu01();
			html.append(product01.createHTML());
		}
		
		PrintWriter out = response.getWriter();
		out.print(html.toString());
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
