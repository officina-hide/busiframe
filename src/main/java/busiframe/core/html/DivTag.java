package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * divタグクラス<br>
 * @since 2024/12/03
 * @version 1.00 新規作成
 */
public class DivTag  implements BaseCharacter {

	/**
	 * htmlソースコード生成<br>
	 * @param classString クラス文字列
	 * @return　HTMLソース文字列
	 */
	public static Object getSourve(String classString) {
		StringBuffer html = new StringBuffer();
		html.append("<div").append(SP).append("class=").append(DQ).append(classString).append(DQ).append(">");
		return html.toString();
	}

}
