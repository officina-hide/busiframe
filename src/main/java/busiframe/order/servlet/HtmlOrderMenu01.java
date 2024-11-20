package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.JSP.LinkTag;
import busiframe.core.JSP.MetaTag;
import busiframe.core.JSP.TitleBar;
import busiframe.core.JSP.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * 受注メニューLv01を生成する。<br>
 * <pre>
 * ・受注登録 Lv.01
 * ・受注一覧 Lv.01
 * </pre>
 * @since 2024/11/19
 * @version 1.00 新規作成
 */
public class HtmlOrderMenu01 implements BaseCharacter, BaseHtml {

	/**
	 * HTML : 受注メニュー用HTML生成<br>
	 * @since 2024/11/19
	 * @return 受注メニュー用HTML文字列
	 */
	public String createHTML() {
		StringBuffer str = new StringBuffer();
		str.append(DOCTYPE_HTML).append(LF);
		
		str.append("<script>").append(LF);
		str.append(TB).append("function returnMenu() {").append(LF);
		str.append(T2).append("document.menuform.action=\"./action01\";").append(LF);
		str.append(T2).append("document.menuform.actionName.value=\"menu01\";").append(LF);
		str.append(T2).append("document.menuform.submit();").append(LF);
		str.append(TB).append("}").append(LF);
		str.append(TB).append("function orderEntry01() {").append(LF);
		str.append(T2).append("document.menuform.action=\"./action01\";").append(LF);
		str.append(T2).append("document.menuform.actionName.value=\"orderEntry01\";").append(LF);
		str.append(T2).append("document.menuform.submit();").append(LF);
		str.append(TB).append("}").append(LF);
		str.append(TB).append("function orderList01() {").append(LF);
		str.append(T2).append("document.menuform.action=\"./action01\";").append(LF);
		str.append(T2).append("document.menuform.actionName.value=\"orderList01\";").append(LF);
		str.append(T2).append("document.menuform.submit();").append(LF);
		str.append(TB).append("}").append(LF);
		str.append("</script>").append(LF);
		
		str.append(HTML_START).append(LF);
		str.append("<head>").append(LF);
		str.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		str.append(TB).append(TitleTag.getSource(ORDER_MENU_01_TITLE)).append(LF);
		str.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		str.append("</head>").append(LF);
		
		str.append("<body>").append(LF);
		str.append("<header>").append(LF);
		str.append(TB).append(TitleBar.getSource(ORDER_MENU_01_TITLE));
		str.append("</header>").append(LF);
		str.append("<div class=\"container padding-y-5 text-left\">").append(LF);
		str.append(TB).append("<form name=\"menuform\" method=\"post\">").append(LF);
		str.append(T2).append("<input type=\"hidden\" id=\"actionName\" name=\"actionName\"/>").append(LF);
		//　メニューへ戻るボタン
		str.append(T2).append("<div class=\"row text-right\">").append(LF);
		str.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"returnMenu()\">")
			.append("メニューへ戻る").append("</button>").append(LF);
		str.append(T2).append("</div>").append(LF);
		// メニューボタン（1行目)
		str.append(T2).append("<div class=\"container padding-y-5 text-center\">").append(LF);
		str.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"orderEntry01()\">")
			.append("受注登録 Lv.01").append("</button>").append(LF);
		str.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"orderList01()\">")
			.append("受注一覧 Lv.01").append("</button>").append(LF);
		str.append(T2).append("</div>").append(LF);
		
		str.append("</form>").append(LF);
		str.append("</div>").append(LF);
		str.append("</body>").append(LF);
		str.append(HTML_END).append(LF);
		return str.toString();
	}

}
