package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * タイトルバークラス<br>
 * @since 2024/11/17
 * @version 1.00 新規作成
 */
public class TitleBar implements BaseCharacter {

	public static String getSource(String title) {
		StringBuffer str = new StringBuffer();
		str.append(TB).append("<div").append(SP);
		str.append("class=").append(DQ).append("container bg-dark padding-y-10").append(DQ);
		str.append(">").append(LF);
		str.append(T2).append("<h1>").append(title).append("</h1>").append(LF);
		str.append(TB).append("</div>").append(LF);
		return str.toString();
	}

}
