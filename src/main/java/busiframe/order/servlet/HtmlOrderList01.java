package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;

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
		
		// script
		// html
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, ORDER_LIST_01_TITLE));
		
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
