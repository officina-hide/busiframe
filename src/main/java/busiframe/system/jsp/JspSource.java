package busiframe.system.jsp;

import busiframe.system.dao.X_Sys_Disp;

/**
 * JSPソースクラス<br>
 * @since 2024/10/16
 * @version 1.00 新規作成
 */
public class JspSource implements I_BaseSQL {

	/** ドキュメントヘッダー */
	private StringBuffer docHead = new StringBuffer();
	/** HTMLソース */
	private HtmlSource hs;
	/** ページタイトル */
	private String title;
	/** Actionサーブレット名 */
	private String actionURI;

	public JspSource() {
		docHead.append("<%@ page language=").append(DQ).append("java").append(DQ).append(SP)
			.append("contentType=").append(DQ).append("text/html; charset=UTF-8").append(DQ).append(SP)
			.append("pageEncoding=").append(DQ).append("UTF-8").append(DQ).append("%>").append(LF);
		docHead.append("<%@taglib prefix=").append(DQ).append("c").append(DQ).append(SP)
			.append("uri=").append(DQ).append("jakarta.tags.core").append(DQ).append("%>").append(LF);
		docHead.append("<%@taglib prefix=").append(DQ).append("fmt").append(DQ).append(SP)
			.append("uri=").append(DQ).append("jakarta.tags.fmt").append(DQ).append("%>").append(LF);
		docHead.append("<!DOCTYPE html>").append(LF);
	}

	/**
	 * JSPコード生成<br>
	 * @param disp 
	 * @since 2024/10/16
	 */
	public void create(X_Sys_Disp disp) {
		hs = new HtmlSource();
		hs.setActionURI(actionURI);
		hs.createHead(title);
		hs.createBody(title);
	}

	@Override
	public String toString() {
		// JSPのソースコードを出力する。
		return docHead.toString()+hs.toString();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setActionURI(String actionURI) {
		this.actionURI = actionURI;
	}

	/**
	 * HTML構造体<br>
	 * @since 2024/10/16
	 */
	private class HtmlSource {

		/** headソース */
		private StringBuffer head = new StringBuffer();
		/** bodyソース */
		private StringBuffer body = new StringBuffer();
		/** ヘッダーソース */
		private StringBuffer header = new StringBuffer();
		/** エラーソース */
		private StringBuffer errhtml;
		/** Actionサーブレット名 */
		private String actionURI;
		
		/**
		 * <head>部生成
		 * @since 2024/10/20
		 * @param title - タイトル表示用文字列
		 */
		public void createHead(String title) {
			head.append("<head>").append(LF);
			head.append("<meta charset=").append(DQ).append("UTF-8").append(DQ).append(">").append(LF);
			head.append("<title>").append(title).append("</title>").append(LF);
			head.append("<link rel=").append(DQ).append("stylesheet").append(DQ).append(SP)
				.append("href=").append(DQ).append("./css/skyblue_k.css").append(DQ).append(">").append(LF);
		}

		/**
		 * <body>部生成
		 * @since 2024/10/20
		 * @param title - タイトル表示用文字列
		 */
		public void createBody(String title) {
			body.append("<body>").append(LF);
			body.append(createHeader(title));
			body.append(createErrorMsg());
			body.append(createForm());
			body.append("</body>").append(LF);
		}

		/**
		 * 
		 * @return
		 */
		private String createForm() {
			// TODO ここではとりあえずlogin画面の生成を行う 2024/10/21
			StringBuffer html = new StringBuffer();
			html.append(TB).append("<form action=").append(DQ).append(actionURI).append(DQ).append(SP)
				.append("method=").append(DQ).append("post").append(DQ).append(">").append(LF);
			html.append(TB2).append("<div class=").append(DQ).append("padding-x-100 padding-y-50").append(DQ).append(">").append(LF);
			html.append(TB3).append("<div class=").append(DQ).append("row").append(DQ).append(">").append(LF);
			// ここはSys_DispDetailの設定から生成
			
			html.append(TB4).append("<label class=").append(DQ).append("md-4 text-right  padding-x-10 padding-y-5").append(DQ).append(">")
				.append("ログインID").append("</label>").append(LF);
			
			html.append(TB3).append("</div>").append(LF);
			html.append(TB2).append("</div>").append(LF);
			html.append(TB).append("</form>").append(LF);
			return html.toString();
		}

		/**
		 * <header>部生成<br>
		 * @since 2024/10/20
		 * @param title - タイトル表示用文字列
		 * @return <header>文字列
		 */
		private String createHeader(String title) {
			header = new StringBuffer();
			header.append(TB).append("<header>").append(LF);
			header.append(TB2).append("<div class=")
				.append(DQ).append("container bg-dark padding-y-10").append(DQ).append(">").append(LF);
			header.append(TB3).append("<h1>").append(title).append("</h1>").append(LF);
			header.append(TB2).append("</div>").append(LF);
			header.append(TB).append("</header>").append(LF);
			return header.toString();
		}

		/**
		 * 標準エラーメッセージ生成<br>
		 * @since 2024/10/20
		 * @return エラーメッセージHTML文字列
		 */
		private String createErrorMsg() {
			errhtml = new StringBuffer();
			errhtml.append(TB).append("<%-- リクエストスコープに alerts があれば --%>").append(LF);
			errhtml.append(TB).append("<div class=").append(DQ).append("padding-y-5 text-center").append(DQ).append(">").append(LF);
			errhtml.append(TB2).append("<c:forEach var=").append(DQ).append("alert").append(DQ).append(SP)
				.append("items=").append(DQ).append("${alerts}").append(DQ).append(">").append(LF);
			errhtml.append(TB3).append("<div class=").append(DQ).append("row color-error padding-y-5").append(DQ).append(">").append(LF);
			errhtml.append(TB4).append("<div class=").append(DQ).append("col").append(DQ).append(">${alert}</div>").append(LF);
			errhtml.append(TB3).append("</div>").append(LF);
			errhtml.append(TB2).append("</c:forEach>").append(LF);
			errhtml.append(TB).append("</div>").append(LF);
			return errhtml.toString();
		}

		@Override
		public String toString() {
			StringBuffer str = new StringBuffer();
			str.append("<html>").append(LF);
			str.append(head.toString()).append(LF);
			str.append(body.toString());
			str.append("</html>");
			return str.toString();
		}

		public void setActionURI(String actionURI) {
			this.actionURI = actionURI;
		}
	}
}
