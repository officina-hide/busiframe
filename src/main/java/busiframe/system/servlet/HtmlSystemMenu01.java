package busiframe.system.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
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
		
		// JavaScript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("moveAction(name, uri)").append(SP).append("{").append(LF);
		html.append(T2).append("document.actionForm.actionName.value=").append("name").append(";").append(LF);
		html.append(T2).append("document.actionForm.action=").append("uri").append(";").append(LF);
		html.append(T2).append("document.actionForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);

		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// 1 --> これは必ずBodyの次に入れる。
		html.append(createHeader(disp.getDispData().getDispTitle()));
		html.append(createMenuHtml(disp));
		html.append(DivTag.getEndTag());	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}
}
