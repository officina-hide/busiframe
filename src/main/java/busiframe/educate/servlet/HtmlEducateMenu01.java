package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispMenu;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;
import busiframe.order.servlet.BaseHTML;

/**
 * 教育メニューLv.01を生成する。<br>
 * @since 2024/11/18
 * @version 1.00 新規作成
 */
public class HtmlEducateMenu01 extends BaseHTML implements BaseCharacter, BaseHtml, BaseDisplay {

	/**
	 * HTML : 教育用メニューHTML生成
	 * @since 2024/11/18
	 * @param env 環境情報
	 * @return 教育メニューHTML文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得 Addition 2024/12/02
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_EDUCATE_MENU_01);
		// HTML
		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		
		// JavaScript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("menufunction(name, uri)").append(SP).append("{").append(LF);
		html.append(T2).append("document.menuForm.action=").append("uri").append(";").append(LF);
		html.append(T2).append("document.menuForm.actionName.value=").append("name").append(";").append(LF);
		html.append(T2).append("document.menuForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);

		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(createHeader(disp.getDispData().getDispTitle()));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// 1 -->
		
		// メニュー用Form
		html.append(TB).append(FormTag.getSource("menuForm", H_POST)).append(LF);
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		// 遷移ボタン
		// メニューボタン
		html.append(T2).append("<div").append(SP)
			.append("class=").append(DQ).append("container padding-y-5 text-center").append(DQ).append(">").append(LF);
		for(X_sysDispMenu menu : disp.getMenus()) {
			html.append(T3).append("<button").append(SP)
				.append("type=").append(DQ).append("button").append(DQ).append(SP)
				.append("class=").append(DQ).append("btn btn-dark").append(DQ).append(SP)
				.append("onclick=").append(DQ).append("menufunction(")
				.append(SQ).append(menu.getDispMenuCd()).append(SQ).append(CM)
				.append(SQ).append(menu.getMenuAction()).append(SQ)
				.append(")").append(DQ).append(">")
				.append(menu.getMenuTItle())
				.append("</button>").append(LF);
		}
		html.append(T2).append("</div>").append(LF);
		html.append(TB).append(FormTag.getEndTag()).append(LF);
		
		html.append("</div>");	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
