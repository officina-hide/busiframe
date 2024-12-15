package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.TableTag;
import busiframe.order.servlet.BaseHTML;

/**
 * カテゴリー一覧 Lv.01を生成する。<br>
 * @since 2024/12/11
 * @version 1.00 新規登録
 */
public class HtmlEduCategoryList extends BaseHTML implements BaseDisplay {

	/**
	 * HTML : カテゴリー一覧 Lv.01生成<br>
	 * @since 2024/12/12
	 * @param env 環境情報
	 * @return　カテゴリー一覧 Lv.01ソース文字列
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_CD_EDUCATE_CATEGORY_01);
		
		// html
		html.append(HTML_START).append(LF);
		html.append(createHead(StandardCharsets.UTF_8, DISPLAY_TITLE_EDUCATE_CATEGORY_01));
		html.append(BODY_START).append(LF);
		html.append(createHeader(DISPLAY_TITLE_EDUCATE_CATEGORY_01));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// -->1
		html.append(TB).append(TableTag.getSource("table table-striped table-bordered")).append(LF);
		// タイトル
		html.append(T2).append("<thead>").append(LF);
		html.append(T3).append("<tr>").append(LF);
		for(X_sysDispDetail detail : disp.getDetails()) {
			html.append(T4).append(getTableTitleItem(detail)).append(LF);
		}
		html.append(T3).append("</tr>").append(LF);
		html.append(T2).append("</thead>").append(LF);
		
		html.append(TB).append(TableTag.getEndTag()).append(LF);
		html.append(DivTag.getEndTag());	//<--1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
