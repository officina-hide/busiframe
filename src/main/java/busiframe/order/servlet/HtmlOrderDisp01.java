package busiframe.order.servlet;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseReference;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.order.dao.M_Order01;

/**
 * 受注照会 Lv.01HTML生成<br>
 * @since 2025/03/19
 * @version 1.00 新規作成
 */
public class HtmlOrderDisp01 extends BaseHTML implements BaseDisplay, I_BaseReference {

	/**
	 * 受注照会画面HTMLソースコード生成<br>
	 * @since 2025/03/20
	 * @param env 環境情報
	 * @param orderId 受注情報ID
	 * @return HTMLソースコード
	 */
	public String createHTML(Environment env, int orderId) {
		StringBuffer html = new StringBuffer();
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_ORDER_DISP_01);
		// 受注情報取得
		M_Order01 order = new M_Order01();
		order.load(env, orderId);

		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// 1 --> これは必ずBodyの次に入れる。
		html.append(createHeader(disp.getDispData().getDispTitle()));
		
		// 表示詳細展開
		for(int ix = 0; ix < disp.getDetails().size(); ix++) {
			X_sysDispDetail detail = disp.getDetails().get(ix);
			
			html.append(T2).append(DivTag.getSource("row")).append(LF);
			// ラベル
			html.append(T3).append("<label class=" + DQ +"md-1 text-right  padding-x-10 padding-y-5"+DQ+">")
				.append(detail.getItemLabel()).append("</label>").append(LF);
			// 項目（表示専用）
			switch(detail.getItemType()) {
			case R_DATE:
			case R_STRING:
				html.append(T3).append(DivTag.getSource("md-3")).append(LF);
				html.append("<input type=").append(DQ).append("text").append(DQ)
					.append(" class=").append(DQ).append("form-control").append(DQ)
					.append(" value=").append(DQ)
					.append(order.getOrder().getItemData(detail.getColumn().getColumnCd()).toString()).append(DQ)
					.append(" readonly>").append(LF);
				html.append(T3).append(DivTag.getEndTag()).append(LF);
				break;
			case R_NUMBER:
				DecimalFormat df = new java.text.DecimalFormat("#,##0");
				BigDecimal num = (BigDecimal) order.getOrder().getItemData(detail.getColumn().getColumnCd());
				System.out.println(df.format(num));
				html.append(T3).append(DivTag.getSource("md-2")).append(LF);
				html.append("<input type=").append(DQ).append("text").append(DQ)
					.append(" class=").append(DQ).append("form-control text-right").append(DQ)
					.append(" value=").append(DQ).append(df.format(num)).append(DQ)
					.append(" readonly>").append(LF);
				html.append(T3).append(DivTag.getEndTag()).append(LF);
				break;
			}
			html.append(T2).append(DivTag.getEndTag()).append(LF);
		}

		html.append(DivTag.getEndTag());	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
