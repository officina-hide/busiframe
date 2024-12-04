package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
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
		disp.load(env, DISPLAY_CD_EDUCATE_MENU_01);
		System.out.println(disp.getDispData().getDispCd());
		
		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		html.append(BODY_START).append(LF);
		html.append(createHeader(disp.getDispData().getDispTitle()));
		html.append(DivTag.getSourve("container padding-y-5 text-left")).append(LF);	// 1 -->
		html.append(TB).append(FormTag.getSource("menuForm", H_POST)).append(LF);
		
		
		
		html.append(TB).append(FormTag.getEndTag()).append(LF);
		html.append("</div>");	// <-- 1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
