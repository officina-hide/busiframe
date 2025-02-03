package busiframe.product.servlet;

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
 * 生産関係サーブレットクラス<br>
 * @since 2024/12/27
 * @version 1.00 新規作成
 * Servlet implementation class ProductServlet01
 */
@WebServlet("/productAction01")
public class ProductServlet01 extends HttpServlet implements BaseDisplay {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet01() {
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
		// 商品一覧画面へ遷移する。
		if(actionName.equals(DISPLAY_CD_PRODUCT_LIST_01)) {
			HtmlProProductList ppl = new HtmlProProductList();
			html.append(ppl.createHTML(env));
			out.print(html.toString());
			return;
		}
		if(actionName.equals(DISPLAY_CD_PRODUCT_DATA_01)) {
			HtmlProductData pd = new HtmlProductData();
		}
	}

}
