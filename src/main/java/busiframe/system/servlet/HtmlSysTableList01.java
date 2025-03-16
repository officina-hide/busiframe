package busiframe.system.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.order.servlet.BaseHTML;

/**
 * テーブル一覧 Lv.01Html生成<br>
 * @since 2025/03/13
 * @version 1.00 新規作成
 */
public class HtmlSysTableList01 extends BaseHTML implements BaseDisplay {

	/**
	 * HTML生成<br>
	 * @since 2025/03/13
	 * @param env 環境情報
	 * @return HTML文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_TABLE_LIST_01);
		
		html.append(DOCTYPE_HTML).append(LF);
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
