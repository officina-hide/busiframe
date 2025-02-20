package busiframe.product.servlet;

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
 * 生産メニュー Lv.01生成クラス<br>
 * @since 2024/11/26
 * @version 1.00 新規作成
 */
public class HtmlProductMenu01 extends BaseHTML implements BaseCharacter, BaseHtml, BaseDisplay {

	/**
	 * 生産メニューLv.01HTMLソース生成<br>
	 * @since 2024/12/04
	 * @param env 環境情報x
	 * @return HTMLソース文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得 Addition 2024/12/02
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_PRODUCT_MENU_01);

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
		html.append(createHeader(disp.getDispData().getDispTitle()));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// 1 -->
		// メニュー用Form
		html.append(TB).append(FormTag.getSource("actionForm", H_POST)).append(LF);		// form -->
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		// 遷移ボタン
		//　メニューへ戻るボタン
		html.append(setMoveButton(disp)).append(LF);
		// メニュー一覧
		html.append(T2).append(DivTag.getSource("container padding-y-5 text-center")).append(LF);	// 2 -->
		// 1行のみメニュー表示としています Addition 2024/12/26
		html.append(T3);
		for(X_sysDispMenu menu : disp.getMenus()) {
			html.append(setMenuButton(menu)).append(LF);
		}
		html.append(T2).append(DivTag.getEndTag()).append(LF);	// <-- 2
		html.append(FormTag.getEndTag());		// <-- form
		html.append(DivTag.getEndTag()).append(LF);	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
