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
		str.append("</html>").append(LF);
		return str.toString();
	}

	/**
	 * htmlソース生成<br>
	 * @since 2024/11/13
	 */
	public void create() {
		//head生成
		head.append("<head>").append(LF);
		head.append(meta.toString()).append(LF);
		title.setTabTitlel(disp.getTabTitle());
		head.append(title.toString()).append(LF);
		head.append(link.toString()).append(LF);
		head.append("</head>").append(LF);
	}

	public void setDisp(M_SysDisp disp) {
		this.disp = disp;
	}

}
