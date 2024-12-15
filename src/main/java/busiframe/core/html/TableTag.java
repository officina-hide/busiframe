package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * tableタグクラス<br>
 * @since 2024/12/03
 * @version 1.00 新規作成
 */
public class TableTag implements BaseCharacter {

	/**
	 * tableタグHTMLソース生成<br>
	 * @since 2024/12/03
	 * @param classString クラス文字列
	 * @return HTMLソース文字列
	 */
	public static String getSource(String classString) {
		StringBuffer html = new StringBuffer();
		html.append("<table").append(SP)
			.append("class=").append(DQ).append("table table-striped table-bordered").append(DQ).append(">");
		return html.toString();
	}

	/**
	 * HTML : Table END タグソース生成<br>
	 * @since 2024/12/15
	 * @return Table END タグソース文字列
	 */
	public static Object getEndTag() {
		StringBuffer html = new StringBuffer();
		html.append("</table>");
		return html.toString();
	}

}
