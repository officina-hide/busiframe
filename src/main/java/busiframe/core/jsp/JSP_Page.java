package busiframe.core.jsp;

import java.nio.charset.StandardCharsets;

/**
 * JSP Pageトークン<br>
 * @since 2024/11/05
 * @version 1.00 新規作成
 */
public class JSP_Page extends TokenData {

	/**
	 * コンストラクター<br>
	 * JSPのPageタグを生成する。<br>
	 * @since 2024/11/05
	 */
	public JSP_Page() {
		setName("page");
		addParameter("language", "java");
		addParameter("contentType", "text/html; charset="+StandardCharsets.UTF_8.toString());
		addParameter("pageEncoding", StandardCharsets.UTF_8.toString());
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<%@ ").append(getName()).append(SP);
		str.append("language=").append(DQ).append(getPlist().get("language")).append(DQ).append(SP);
		str.append("contentType=").append(DQ).append(getPlist().get("contentType")).append(DQ).append(SP);
		str.append("pageEncoding=").append(DQ).append(getPlist().get("pageEncoding")).append(DQ);
		str.append("%>");
		return str.toString();
	}
	
}
