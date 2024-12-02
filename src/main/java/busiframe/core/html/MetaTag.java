package busiframe.core.html;

import java.nio.charset.Charset;

import busiframe.core.tools.BaseCharacter;

/**
 * JSP:mataタグクラス<br>
 * @since 2024/11/16
 * @version 1.00 新規作成
 */
public class MetaTag implements BaseCharacter {

	/**
	 * JSP:metaタグ生成
	 * @since 2024/11/16
	 * @param name
	 * @return metaタグ文字列
	 */
	public static String getSource(Charset name) {
		StringBuffer str = new StringBuffer();
		str.append("<meta").append(SP);
		str.append("charset=").append(DQ).append(name).append(DQ);
		str.append(">");
		return str.toString();
	}

}
