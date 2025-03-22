package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.List;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
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
		// 表示情報取得 Addition 2024/12/02
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_ORDER_LIST_01);
		// 受注情報一覧取得
		M_Order01 order = new M_Order01();
		List<X_Order01> orders = order.getOrderList(env);

		html.append(DOCTYPE_HTML).append(LF);
		
		// JavaScript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("entryAction(id)").append(SP).append("{").append(LF);
		html.append(T2).append("document.actionForm.action=")
			.append(SQ).append(ACTION_URI_ORDER_01).append(SQ).append(";").append(LF);
		html.append(T2).append("document.actionForm.productId.value=id;").append(LF);
		html.append(T2).append("document.actionForm.actionName.value=")
			.append(SQ).append(DISPLAY_CD_ORDER_DISP_01).append(SQ).append(";").append(LF);
		html.append(T2).append("document.actionForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);
		
		// html
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, DISPLAY_TITLE_ORDER_LIST_01));
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// --> 1.
		html.append(createHeader(DISPLAY_TITLE_ORDER_LIST_01));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// --> 2.
		
		// Form内にテーブルを作成する。
		html.append(TB).append(FormTag.getSource("actionForm", H_POST)).append(LF);

		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		// id変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("productId").append(DQ).append(SP)
			.append("name=").append(DQ).append("productId").append(DQ).append("/>").append(LF);

		// 遷移ボタン表示
		html.append(setMoveButton(disp)).append(LF);
		// 一覧表
		html.append(TB).append(TableTag.getSource("table table-striped table-bordered table-hover")).append(LF);
		// タイトル
		html.append(T2).append("<thead>").append(LF);
		for(X_sysDispDetail detail : disp.getDetails()) {
			html.append(T4).append("<th>").append(detail.getItemLabel()).append("</th>").append(LF);
		}
		html.append(T2).append("</thead>").append(LF);

		// 項目一覧
		html.append(T2).append("<tbody>").append(LF);
		DecimalFormat df = new DecimalFormat("#,##0");
		for(X_Order01 od : orders) {
			html.append(T3).append("<tr")
				.append(SP).append("onclick=").append(DQ)
				.append("entryAction(").append(od.getOrderId()).append(")").append(DQ).append(">").append(LF);
			html.append(T4).append("<td>").append(od.getOrderDate()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(od.getPartnerName()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(od.getProductName()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(df.format(od.getOrderNumber().intValue())).append("</td>").append(LF);
			html.append(T4).append("<td>").append(df.format(od.getOrderAmount().intValue())).append("</td>").append(LF);
			html.append(T3).append("</tr>").append(LF);
		}
		html.append(T2).append("</tbody>").append(LF);
		html.append(TB).append("</table>").append(LF);
		
		html.append(TB).append(FormTag.getEndTag()).append(LF);		
		html.append(DivTag.getEndTag()).append(LF);	//<-- 2.
		html.append(DivTag.getEndTag()).append(LF);	//<-- 1.
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
