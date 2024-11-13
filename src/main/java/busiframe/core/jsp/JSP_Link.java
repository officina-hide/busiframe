package busiframe.core.jsp;

/**
 * JSPのlinkタグクラス<br>
 * @since 2024/11/13
 * @version 1.00 新規作成
 */
public class JSP_Link extends TokenData {

	/**
	 * コンストラクタ<br>
	 * JSPのlinkタグの情報をセットする。
	 * @param relation 参照属性
	 * @param href 参照先
	 */
	public JSP_Link(String relation, String href) {
		setName("link");
		addParameter("relation", relation);
		addParameter("href", href);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<").append("link").append(SP);
		str.append("rel=").append(DQ).append(getPlist().get("relation")).append(DQ).append(SP);
		str.append("href=").append(DQ).append(getPlist().get("href")).append(DQ);
		str.append(">");
		return str.toString();
	}

	
}
