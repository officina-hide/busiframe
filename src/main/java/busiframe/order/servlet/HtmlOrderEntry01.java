package busiframe.order.servlet;

import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * HTML : 受注登録 Lv.01クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class HtmlOrderEntry01 implements BaseCharacter, BaseHtml {

	public String createHTML() {
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		// Javascript
		// html
		return html.toString();
	}

}
