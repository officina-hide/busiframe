package busiframe.core.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.LinkTag;
import busiframe.core.html.MetaTag;
import busiframe.core.html.TitleBar;
import busiframe.core.html.TitleTag;
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
public class HtmlMenu01 implements BaseCharacter, BaseHtml, BaseDisplay {

	/**
	 * HTMLソース生成<br>
	 * TODO 要表示関連のテーブル化 2024/11/17
	 * @since 2024/11/14
	 * @param env 環境情報
	 * @return HTMLソース
	 */
	public String createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		html.append(createHtmlSource(env));
		return html.toString();
	}

	/**
	 * HTML : 総合メニューソース生成<br>
	 * TODO 要汎用化 2024/11/16
	 * @since 2024/11/16
	 * @param env 環境情報
	 * @return  総合メニューHTML文字列
	 */
	private String createHtmlSource(Environment env) {
		StringBuffer html = new StringBuffer();
		
		// 画面情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_MAIN_MENU);
		System.out.println(disp.getMenus().size());
		
		html.append(DOCTYPE_HTML).append(LF);
		// 画面遷移用Javascript設定
		// TODO ここは後で見直す予定。 2024/11/18
		html.append("<script>").append(LF);
		// menu01
		html.append(TB).append("function menu01() {").append(LF);
		html.append(T2).append("document.menuform.actionName.value=\"educate01\";").append(LF);
		html.append(T2).append("document.menuform.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		// menu02
		html.append(TB).append("function menu02() {").append(LF);
		html.append(T2).append("document.menuform.actionName.value=\"order01\";").append(LF);
		html.append(T2).append("document.menuform.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		// menu03 addtion 2024/11/26
		html.append(TB).append("function menu03() {").append(LF);
		html.append(T2).append("document.menuform.actionName.value=\""+MENU_PRODUCT01+"\";").append(LF);
		html.append(T2).append("document.menuform.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append("</script>").append(LF);
		
		html.append("<html>").append(LF);
		
		html.append("<head>").append(LF);
		html.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		html.append(TB).append(TitleTag.getSource("総合メニュー Lv.01")).append(LF);
		html.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		html.append("</head>").append(LF);
		
		html.append("<body>").append(LF);
		html.append("<header>").append(LF);
		html.append(TB).append(TitleBar.getSource("総合メニュー Lv.01"));
		html.append("</header>").append(LF);
		
		// メニュー
		// function()からaction設定を削除しformに追加する。 2024/11/26
		html.append(TB).append("<form name=\"menuform\" action=\"./action01\" method=\"post\">").append(LF);
		html.append(T2).append("<input type=\"hidden\" id=\"actionName\" name=\"actionName\"/>").append(LF);
		html.append(T2).append("<div class=\"container padding-y-5 text-center\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"menu01()\">"
			+ EDUCATE_MENU_01_TITLE + "</button>").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"menu02()\">"
			+ ORDER_MENU_01_TITLE + "</button>").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"menu03()\">"
			+ PRODUCT_MENU_01_TITLE + "</button>").append(LF);
		html.append(T2).append("</div>").append(LF);
		
		html.append(TB).append("</form>").append(LF);		
		html.append("</body>").append(LF);
		html.append("</html>").append(LF);
		return html.toString();
	}

}
