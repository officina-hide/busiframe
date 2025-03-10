package busiframe.system.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.order.servlet.BaseHTML;

/**
 * システム管理メニュー Lv.01生成クラス<br>
 * @since 2025/03/10
 * @version 1.00 新規作成
 */
public class HtmlSystemMenu01 extends BaseHTML implements BaseDisplay{

	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_SYSTEM_MENU_01);
		
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
