package busiframe.project.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.order.servlet.BaseHTML;

/**
 * プロジェクト管理メニュー Lv.01生成クラス<br>
 * @since 2025/03/01
 * @version 1.00 新規開発
 */
public class HtmlProjectMenu01 extends BaseHTML implements BaseDisplay {

	/**
	 * プロジェクト管理メニューLv.01HTMLソース生成<br>
	 * @param env 環境情報
	 * @return HTMLソース文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_PROJECT_MENU_01);
		
		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(createHeader(disp.getDispData().getDispTitle()));
		
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
