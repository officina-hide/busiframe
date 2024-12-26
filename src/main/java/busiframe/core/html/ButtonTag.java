package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * ボタンタグクラス<br>
 * @since 2024/12/25
 * @version 1.00 新規作成
 */
public class ButtonTag implements BaseCharacter {

	/**
	 * 
	 * @param name
	 * @param functionName
	 * @return
	 */
	public static String getSource(String name, String functionName) {
		StringBuffer html = new StringBuffer();
		html.append("<button class=").append(DQ).append("btn btn-dark").append(DQ).append(SP)
			.append("onclick=").append(DQ).append(functionName).append(DQ).append(">")
			.append(name).append("</button>");
		return html.toString();
	}

}
