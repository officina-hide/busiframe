package busiframe.order.servlet;

import java.nio.charset.Charset;

import busiframe.core.jsp.LinkTag;
import busiframe.core.jsp.MetaTag;
import busiframe.core.jsp.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * HTML汎用クラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public class BaseHTML implements BaseCharacter, BaseHtml {

	/**
	 * @param charName
	 * @param title
	 * @return
	 */
	public String createHead(Charset charName, String title) {
		StringBuffer html = new StringBuffer();
		html.append(HEAD_START).append(LF);
		html.append(TB).append(MetaTag.getSource(charName)).append(LF);
		html.append(TB).append(TitleTag.getSource(title)).append(LF);
		html.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		html.append(HEAD_END).append(LF);
		return html.toString();
	}
}
