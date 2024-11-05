package busiframe.core.jsp;

/**
 * JSP Taglibトークンクラス<br>
 * @since 2024/11/06
 * @version 1.00 新規作成
 */
public class JSP_Taglib extends TokenData {

	public JSP_Taglib() {
	}

	/**
	 * コンストラクタ<br>
	 * JSPのTaglibタグを生成する。<br>
	 * @since 2024/11/06
	 */
	public JSP_Taglib(String prefix, String uri) {
		setName("taglib");
		addParameter("prefix", prefix);
		addParameter("uri", uri);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<%@ ").append(getName()).append(SP);
		str.append("prefix=").append(DQ).append(getPlist().get("prefix")).append(DQ).append(SP);
		str.append("uri=").append(DQ).append(getPlist().get("uri")).append(DQ).append(SP);
		str.append("%>");
		return str.toString();
	}

}
