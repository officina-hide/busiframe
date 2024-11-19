package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.JSP.LinkTag;
import busiframe.core.JSP.MetaTag;
import busiframe.core.JSP.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * 教育メニューLv.01を生成する。<br>
 */
public class HtmlEducateMenu01 implements BaseCharacter, BaseHtml {

	/**
	 * @return
	 */
	public String createHTML() {
		StringBuffer str = new StringBuffer();
		str.append(DOCTYPE_HTML).append(LF);
		str.append("<html>").append(LF);
		str.append("<head>").append(LF);
		str.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		str.append(TB).append(TitleTag.getSource(EDUCATE_MENU_01_TITLE)).append(LF);
		str.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		str.append("</head>").append(LF);
		str.append("</html>").append(LF);
		return str.toString();
	}

}
