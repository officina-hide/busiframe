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
 *     ・教育メニュー /educate01
 *     ・受注管理 /order01 未実装(2024/11/18)
 * </pre>
 * 
 * @since 2024/11/14
 * @version 1.00 新規作成 2024/11/14
 */
public class HtmlMenu01 implements BaseCharacter, BaseHtml {

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
		str.append(DOCTYPE_HTML).append(LF);
		// 画面遷移用Javascript設定
		// TODO ここは後で見直す予定。 2024/11/18
		str.append("<script>").append(LF);
		str.append(TB).append("function menu01() {").append(LF);
		str.append(T2).append("document.menuform.action=\"./action01?actionName=educate01\";").append(LF);
		str.append(T2).append("document.menuform.submit();").append(LF);
		str.append(TB).append("}").append(LF);
		str.append(TB).append("function menu02() {").append(LF);
		str.append(T2).append("document.menuform.action=\"./action01?actionName=order01\";").append(LF);
		str.append(T2).append("document.menuform.submit();").append(LF);
		str.append(TB).append("}").append(LF);
		str.append("</script>").append(LF);
		
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
		
		// メニュー
		str.append(TB).append("<form name=\"menuform\" method=\"post\">").append(LF);
		str.append(T2).append("<div class=\"container padding-y-5 text-center\">").append(LF);
		str.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"menu01()\">"
			+ EDUCATE_MENU_01_TITLE + "</button>").append(LF);
		str.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"menu02()\">受注メニュー Lv.01</button>")
			.append(LF);
		str.append(T2).append("</div>").append(LF);
		
		str.append(TB).append("</form>").append(LF);		
		str.append("</body>").append(LF);
		str.append("</html>").append(LF);
		return str.toString();
	}

}
