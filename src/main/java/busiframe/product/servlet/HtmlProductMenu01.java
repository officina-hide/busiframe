package busiframe.product.servlet;

import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * 生産メニュー Lv.01生成クラス<br>
 * @since 2024/11/26
 * @version 1.00 新規作成
 */
public class HtmlProductMenu01 implements BaseCharacter, BaseHtml {

	/**
	 * @return
	 */
	public String createHTML() {
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		return html.toString();
	}

}
