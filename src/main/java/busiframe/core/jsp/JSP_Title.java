package busiframe.core.jsp;

/**
 * タイトルタグクラス<br>
 * @since 2024/11/13
 * @version 1.00 新規作成
 */
public class JSP_Title extends TokenData {

	private static final String H_TITLE = "title";
	
	/** タイトル */
	private String tabTitlel;
	
	/**
	 * コンストラクタ<br>
	 * JSPのtitleタグを生成する。<br>
	 * @since 2024/11/13
	 */
	public JSP_Title() {
		setName(H_TITLE);
	}

	public void setTabTitlel(String tabTitlel) {
		this.tabTitlel = tabTitlel;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<title>").append(tabTitlel).append("</title>");
		return str.toString();
	}

	
}
