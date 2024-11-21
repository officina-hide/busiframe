package busiframe.core.jsp;

import busiframe.core.tools.BaseCharacter;

/**
 * HTML:リンクタグクラス<br>
 * @since 2024/11/17
 * @version 1.00 新規作成
 */
public class LinkTag implements BaseCharacter {

	/**
	 * リンクタグソース生成<br>
	 * @since 2024/11/17
	 * @param relation リンクタイプ
	 * @param href リンクソース
	 * @return リンクタグソース文字列
	 */
	public static String getSource(String relation, String href) {
		StringBuffer str = new StringBuffer();
		str.append("<link").append(SP);
		str.append("rel=").append(DQ).append(relation).append(DQ).append(SP);
		str.append("href=").append(DQ).append(href).append(DQ);
		str.append(">");
		return str.toString();
	}

}
