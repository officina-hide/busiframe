package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.html.LinkTag;
import busiframe.core.html.MetaTag;
import busiframe.core.html.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * 教育メニューLv.01を生成する。<br>
 * @since 2024/11/18
 * @version 1.00 新規作成
 */
public class HtmlEducateMenu01 implements BaseCharacter, BaseHtml {

	/**
	 * HTML : 教育用メニューHTML生成
	 * @since 2024/11/18
	 * @return 教育メニューHTML文字列
	 */
	public String createHTML() {
		StringBuffer str = new StringBuffer();
		str.append(DOCTYPE_HTML).append(LF);
		str.append(HTML_START).append(LF);
		str.append("<head>").append(LF);
		str.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		str.append(TB).append(TitleTag.getSource(EDUCATE_MENU_01_TITLE)).append(LF);
		str.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		str.append("</head>").append(LF);
		str.append(HTML_END).append(LF);
		return str.toString();
	}

}
