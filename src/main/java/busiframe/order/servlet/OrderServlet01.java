package busiframe.order.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import busiframe.core.dao.Environment;
import busiframe.order.dao.M_Order01;

/**
 * 受注関連サーブレットクラス<br>
 * 本クラスでは、受注管理 Lv.01で行われる受注関連の応答を制御します。<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 * Servlet implementation class OrderServlet01
 */
@WebServlet("/order01")
public class OrderServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet01() {
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
		// 入力チェック TODO 未実装 2024/11/22
		// 処理を判定する。
		String actionName = request.getParameter("actionName");
		if(actionName != null && actionName.equals("entry")) {
			// 受注日取得
			LocalDate orderDate = LocalDate.parse(request.getParameter("orderDate"));
			// 受注情報登録
			M_Order01 order = new M_Order01();
			order.getOrder().setOrderDate(orderDate);
			order.getOrder().setPartnerName(request.getParameter("partnerName"));
			order.save(env);
			// TODO 登録確認 未実装 2024/11/22
			// 受注一覧へ遷移する。
			HTMLOrderList01 orderList = new HTMLOrderList01();
			html.append(orderList.createHTML());
		}
		
		PrintWriter out = response.getWriter();
		out.print(html.toString());
		
		return;
	}

}
