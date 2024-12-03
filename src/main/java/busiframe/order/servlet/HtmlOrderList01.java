package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;
import java.util.List;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.TableTag;
import busiframe.order.dao.M_Order01;
import busiframe.order.dao.X_Order01;

/**
 * HTML : 受注一覧 Lv.01クラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public class HtmlOrderList01 extends BaseHTML implements BaseDisplay {

	/**
	 * 受注一覧表示用HTML生成<br>
	 * @since 2024/11/22
	 * @param env 環境情報
	 * @return 受注一覧表示用HTML文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		// 表示情報取得 Addition 2024/12/02
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_CD_ORDER_LIST_01);
		// 受注情報一覧取得
		M_Order01 order = new M_Order01();
		List<X_Order01> orders = order.getOrderList(env);
		
		// script
		// html
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, ORDER_LIST_01_TITLE));
		html.append(BODY_START).append(LF);
		html.append(createHeader(ORDER_LIST_01_TITLE));
		html.append(DivTag.getSourve("container padding-y-5 text-left")).append(LF);
		html.append(TB).append(TableTag.getSource("table table-striped table-bordered")).append(LF);
		// タイトル
		html.append(T2).append("<thead>").append(LF);
		html.append(T3).append("<tr>").append(LF);
		for(X_sysDispDetail detail : disp.getDetails()) {
			html.append(T4).append("<th>").append(detail.getItemLabel()).append("</th>").append(LF);
		}
		html.append(T3).append("</tr>").append(LF);
		html.append(T2).append("</thead>").append(LF);
		// 項目一覧
		html.append(T2).append("<tbody>").append(LF);
		for(X_Order01 od : orders) {
			html.append(T3).append("<tr>").append(LF);
			html.append(T4).append("<td>").append(od.getOrderDate()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(od.getPartnerName()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(od.getProductName()).append("</td>").append(LF);
			html.append(T3).append("</tr>").append(LF);
		}
		html.append(T2).append("</tbody>").append(LF);
		
		html.append(TB).append("</table>").append(LF);
		html.append("</div>").append(LF);
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
