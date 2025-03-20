package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;

/**
 * 受注照会 Lv.01HTML生成<br>
 * @since 2025/03/19
 * @version 1.00 新規作成
 */
public class HtmlOrderDisp01 extends BaseHTML implements BaseDisplay {

	/**
	 * 受注照会画面HTMLソースコード生成<br>
	 * @since 2025/03/20
	 * @param env 環境情報
	 * @return HTMLソースコード
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		// 表示情報取得
		M_Display disp = new M_Display();

		html.append(DOCTYPE_HTML).append(LF);
		disp.load(env, DISPLAY_ID_ORDER_DISP_01);
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// 1 --> これは必ずBodyの次に入れる。
		html.append(createHeader(disp.getDispData().getDispTitle()));
		
		html.append(DivTag.getEndTag());	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
