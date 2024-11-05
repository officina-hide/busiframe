package busiframe.core.jsp;

/**
 * HTMLトークンクラス<br>
 * @since 2024/11/06
 * @version 1.00 新規作成
 */
public class HtmlToken extends TokenData {

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<html>").append(LF);
		str.append("</html>").append(LF);
		return str.toString();
	}

}
