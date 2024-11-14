package busiframe.core.jsp;

import busiframe.core.dao.M_SysDisp;

/**
 * HTMLトークンクラス<br>
 * @since 2024/11/06
 * @version 1.00 新規作成
 */
public class HtmlToken extends TokenData {

	/** 表示情報 */
	private M_SysDisp disp = new M_SysDisp();
	
	/** head文字列 */
	StringBuffer head = new StringBuffer();
	/** body文字列 */
	StringBuffer body = new StringBuffer();
	/** metaトークン */
	JSP_Meta meta = new JSP_Meta();
	/** titleトークン */
	JSP_Title title = new JSP_Title();
	/** linkトークン */
	JSP_Link link = new JSP_Link("stylesheet", "./css/skyblue_k.css");
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("<html>").append(LF);
		str.append(head);
		str.append(body);
		str.append("</html>").append(LF);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    		return str.toString();
	}

	/**
	 * htmlソース生成<br>
	 * @since 2024/11/13
	 */
	public void create() {
		// head生成
		head.append("<head>").append(LF);
		head.append(TB).append(meta.toString()).append(LF);
		title.setTabTitlel(disp.getTabTitle());
		head.append(TB).append(title.toString()).append(LF);
		head.append(TB).append(link.toString()).append(LF);
		head.append("</head>").append(LF);
		// body生成
		body.append("<body>").append(LF);
		body.append(createError());
		body.append("</body>").append(LF);
	}

	/**
	 * エラー表示追加
	 * @since 2024/11/14
	 * @return エラー表示用HTML文
	 */
	private String createError() {
		StringBuffer str = new StringBuffer();
		return str.toString();
	}

	public void setDisp(M_SysDisp disp) {
		this.disp = disp;
	}

}
