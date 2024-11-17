package busiframe.core.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.JSP.LinkTag;
import busiframe.core.JSP.MetaTag;
import busiframe.core.JSP.TitleBar;
import busiframe.core.JSP.TitleTag;
import busiframe.core.tools.BaseCharacter;

/**
 * メニューLv01を作成します。<br>
 * TODO 本来メニューはメニュー情報から作成されます。 2024/11/14
 * <pre>
 * メニュー情報が本稼働するまで、以下の機能メニューを表示する。
 *     ・受注管理 /order01
 *     ・教育管理 /educate01
 * </pre>
 * 
 * @since 2024/11/14
 * @version 1.00 新規作成 2024/11/14
 */
public class HtmlMenu01 implements BaseCharacter {

	/**
	 * HTMLソース生成<br>
	 * TODO 要表示関連のテーブル化 2024/11/17
	 * @since 2024/11/14
	 * @return HTMLソース
	 */
	public String createHTML() {
		StringBuffer html = new StringBuffer();
		html.append(createHtmlSource());
		return html.toString();
	}

	/**
	 * HTML : JSP用ドキュメントヘッド生成<br>
	 * TODO 要汎用化 2024/11/16
	 * @since 2024/11/16
	 * @return ドキュメントヘッドソース文字列
	 */
	private String createHtmlSource() {
		StringBuffer str = new StringBuffer();
		str.append("<!DOCTYPE html>").append(LF);
		str.append("<html>").append(LF);
		str.append("<head>").append(LF);
		str.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		str.append(TB).append(TitleTag.getSource("総合メニュー Lv.01")).append(LF);
		str.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		str.append("</head>").append(LF);
		str.append("<body>").append(LF);
		str.append("<header>").append(LF);
		str.append(TB).append(TitleBar.getSource("総合メニュー Lv.01"));
		str.append("</header>").append(LF);
		str.append("</body>").append(LF);
		str.append("</html>").append(LF);
		return str.toString();
	}

}
