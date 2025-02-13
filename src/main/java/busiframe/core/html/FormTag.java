package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * HTML : Formタグクラス<br>
 * @since 2024/12/05
 * @version 1.00 新規作成
 */
public class FormTag implements BaseCharacter {

	/**
	 * Formタグヒース生成<br>
	 * @since 2024/12/05
	 * @param name Form名
	 * @param method メソッド
	 * @return Formタグソース文字列
	 */
	public static String getSource(String name, String method) {
		StringBuffer html = new StringBuffer();
		//html.append(TB).append("<form name=\"menuform\" method=\"post\">").append(LF);
		html.append("<form").append(SP)
			.append("name=").append(DQ).append(name).append(DQ).append(SP)
			.append("method=").append(DQ).append(method).append(DQ).append(SP)
			.append("class=").append(DQ).append("padding-y-5").append(DQ).append(SP)
			.append(">");
		return html.toString();
	}

	/**
	 * Formエンドタグソース生成<br>
	 * @since 2024/12/05
	 * @return Formエンドタグソース文字列
	 */
	public static Object getEndTag() {
		StringBuffer html = new StringBuffer();
		html.append("</form>");
		return html.toString();
	}

}
