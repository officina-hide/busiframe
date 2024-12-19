package busiframe.educate.servlet;

import java.nio.charset.StandardCharsets;
import java.util.List;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
import busiframe.core.html.TableTag;
import busiframe.educate.dao.M_EduCategory;
import busiframe.educate.dao.X_EduCategory;
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
		// カテゴリー一覧取得
		M_EduCategory cat = new M_EduCategory();
		List<X_EduCategory> catList = cat.getCategoryList(env);
		
		// html
		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		
		// JavaScript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("question()").append(SP).append("{").append(LF);
		html.append(T2).append("document.categoryList.action=").append(DQ).append("./educate01").append(DQ).append(";").append(LF);
		html.append(T2).append("document.categoryList.actionName.value=")
			.append(DQ).append(DISPLAY_CD_QUESTION_LIST_01).append(DQ).append(";").append(LF);
		html.append(T2).append("document.categoryList.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);
		
		html.append(createHead(StandardCharsets.UTF_8, DISPLAY_TITLE_EDUCATE_CATEGORY_01));
		html.append(BODY_START).append(LF);
		html.append(createHeader(DISPLAY_TITLE_EDUCATE_CATEGORY_01));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	// -->1
		// Form内にテーブルを作成する。
		html.append(TB).append(FormTag.getSource("categoryList", H_POST)).append(LF);
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		// テーブル
		html.append(TB).append(TableTag.getSource("table table-striped table-bordered")).append(LF);
		// タイトル
		html.append(T2).append("<thead>").append(LF);
		html.append(T3).append("<tr>").append(LF);
		for(X_sysDispDetail detail : disp.getDetails()) {
			html.append(T4).append(getTableTitleItem(detail)).append(LF);
		}
		html.append(T3).append("</tr>").append(LF);
		html.append(T2).append("</thead>").append(LF);
		
		// 項目一覧
		html.append(T2).append("<tbody>").append(LF);
		for(X_EduCategory category : catList) {
			html.append(T3).append("<tr>").append(LF);
			html.append(T4).append("<td>").append(category.getCategoryName()).append("</td>").append(LF);
			// 問題一覧ボタン
			html.append(T4).append("<td>").append("<button").append(SP)
				.append("type=").append(DQ).append("button").append(DQ).append(SP)
				.append("class=").append(DQ).append("btn btn-dark").append(DQ).append(SP)
				.append("onclick=").append(DQ).append("question()").append(DQ).append(">")
				.append("問題一覧").append("</button>").append("</td>").append(LF);
			html.append(T3).append("</tr>").append(LF);
		}
		html.append(T2).append("</tbody>").append(LF);
		
		html.append(TB).append(TableTag.getEndTag()).append(LF);
		html.append(TB).append(FormTag.getEndTag()).append(LF);
		html.append(DivTag.getEndTag());	//<--1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
