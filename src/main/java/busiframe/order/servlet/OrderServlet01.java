package busiframe.order.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

import busiframe.core.dao.Environment;
import busiframe.core.html.BaseDisplay;
import busiframe.order.dao.I_Order01;
import busiframe.order.dao.M_Order01;

/**
 * 受注関連サーブレットクラス<br>
 * 本クラスでは、受注管理 Lv.01で行われる受注関連の応答を制御します。<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 * Servlet implementation class OrderServlet01
 */
@WebServlet("/order01")
public class OrderServlet01 extends HttpServlet implements BaseDisplay {
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
		return;
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

		// 処理を判定する。

		// メニューからの遷移の場合。
		if(actionName.equals(DISPLAY_CD_ORDER_ENTRY_01)) {
			// 受注登録画面へ遷移する。
			HtmlOrderEntry01 oe01 = new HtmlOrderEntry01();
			html.append(oe01.createHTML(env));
			out.print(html.toString());
			return;
		}
		if(actionName.equals(DISPLAY_CD_ORDER_LIST_01)) {
			// 受注一覧画面へ遷移する。
			HtmlOrderList01 ol01 = new HtmlOrderList01();
			html.append(ol01.createHTML(env));
			out.print(html.toString());
			return;
		}
		
		// 入力チェック TODO 未実装 2024/11/22
		if(actionName.equals("entry")) {
			// 受注情報登録
			M_Order01 order = new M_Order01();
			// TODO 表示情報からの項目展開は未実装 2024/11/30
			// 受注日
			LocalDate orderDate = LocalDate.parse(request.getParameter(I_Order01.COL_NAME_ORDER_DATE));
			order.getOrder().setOrderDate(orderDate);
			// 相手先
			order.getOrder().setPartnerName(request.getParameter(I_Order01.COL_NAME_PARTNER_NAME));
			// 商品名
			order.getOrder().setProductName(request.getParameter(I_Order01.COL_NAME_PRODUCT_NAME));
			// 受注数
			BigDecimal onum = new BigDecimal(request.getParameter(I_Order01.COL_NAME_ORDER_NUMBER));
			order.getOrder().setOrderNumber(onum);
			// 受注金額
			BigDecimal oamt = new BigDecimal(request.getParameter(I_Order01.COL_NAME_ORDER_AMOUNT));
			order.getOrder().setOrderAmount(oamt);
			
			order.save(env);
			// TODO 登録確認 未実装 2024/11/22
			// 受注一覧へ遷移する。
			HtmlOrderList01 orderList = new HtmlOrderList01();
			html.append(orderList.createHTML(env));
		}
		
		out.print(html.toString());
		
		return;
	}

}
