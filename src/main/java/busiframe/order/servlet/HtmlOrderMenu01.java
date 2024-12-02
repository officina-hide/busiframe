package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.html.LinkTag;
import busiframe.core.html.MetaTag;
import busiframe.core.html.TitleBar;
import busiframe.core.html.TitleTag;
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
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		
		html.append("<script>").append(LF);
		html.append(TB).append("function returnMenu() {").append(LF);
		html.append(T2).append("document.menuform.action=\"./action01\";").append(LF);
		html.append(T2).append("document.menuform.actionName.value=\"menu01\";").append(LF);
		html.append(T2).append("document.menuform.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(TB).append("function order01(name) {").append(LF);
		html.append(T2).append("document.menuform.action=\"./order01\";").append(LF);
		html.append(T2).append("document.menuform.actionName.value=name;").append(LF);
		html.append(T2).append("document.menuform.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append("</script>").append(LF);
		
		html.append(HTML_START).append(LF);
		html.append("<head>").append(LF);
		html.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		html.append(TB).append(TitleTag.getSource(ORDER_MENU_01_TITLE)).append(LF);
		html.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		html.append("</head>").append(LF);
		
		html.append("<body>").append(LF);
		html.append("<header>").append(LF);
		html.append(TB).append(TitleBar.getSource(ORDER_MENU_01_TITLE));
		html.append("</header>").append(LF);
		html.append("<div class=\"container padding-y-5 text-left\">").append(LF);
		html.append(TB).append("<form name=\"menuform\" method=\"post\">").append(LF);
		html.append(T2).append("<input type=\"hidden\" id=\"actionName\" name=\"actionName\"/>").append(LF);
		//　メニューへ戻るボタン
		html.append(T2).append("<div class=\"row text-right\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"returnMenu()\">")
			.append("メニューへ戻る").append("</button>").append(LF);
		html.append(T2).append("</div>").append(LF);
		// メニューボタン（1行目)
		html.append(T2).append("<div class=\"container padding-y-5 text-center\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"order01('orderEntry01')\">")
			.append("受注登録 Lv.01").append("</button>").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"order01('orderList01')\">")
			.append("受注一覧 Lv.01").append("</button>").append(LF);
		html.append(T2).append("</div>").append(LF);
		
		html.append("</form>").append(LF);
		html.append("</div>").append(LF);
		html.append("</body>").append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
