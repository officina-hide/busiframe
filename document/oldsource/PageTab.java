package busiframe.core.JSP;

import java.nio.charset.Charset;

import busiframe.core.tools.BaseCharacter;

/**
 * JSP:Pageタブクラス<br>
 * @since 2024/11/16
 * @version 1.00 新規作成
 */
public class PageTab implements BaseCharacter {

	/**
	 * @param name
	 * @return
	 */
	public static String getSource(Charset name) {
		StringBuffer str = new StringBuffer();
		str.append("<%@page").append(SP);
		str.append("language=").append(DQ).append("java").append(DQ).append(SP);
		str.append("contentType=").append(DQ).append("text/html; charset=").append(name).append(DQ).append(SP);
		str.append("pageEncoding=").append(DQ).append(name).append(DQ).append(SP);
		str.append("%>");
		return str.toString();
	}

}
