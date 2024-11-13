package busiframe.core.jsp;

import java.nio.charset.StandardCharsets;

/**
 * JSP_metaタグクラス<br>
 * @since 2024/11/13
 * @version 1.00 新規作成
 */
public class JSP_Meta extends TokenData {

	private static final String J_META = "meta";
	private static final String J_CHARSET = "charset";

	/**
	 * コンストラクタ<br>
	 * JSPのMETAタグを生成します。<br>
	 * @since 2024/11/13
	 */
	public JSP_Meta() {
		setName(J_META);
		addParameter(J_CHARSET, StandardCharsets.UTF_8.toString());
	}

	@Override
	public String toString() {
		// metaタグの文字列を出力する。
		StringBuffer str = new StringBuffer();
		str.append("<").append(getName()).append(SP);
		str.append(J_CHARSET).append("=").append(DQ).append(getPlist().get(J_CHARSET)).append(DQ).append(SP);
		str.append(">");
		return str.toString();
	}
	
}
