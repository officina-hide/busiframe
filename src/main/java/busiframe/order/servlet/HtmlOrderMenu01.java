package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
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
public class HtmlOrderMenu01 extends BaseHTML implements BaseCharacter, BaseDisplay {

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
		html.append(createHead(StandardCharsets.UTF_8, ORDER_MENU_01_TITLE));
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	//--> 1.
		html.append(createHeader(DISPLAY_TITLE_ORDER_MENU_01));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	//--> 2.

		// Form内にテーブルを作成する。
		html.append(TB).append(FormTag.getSource("menuform", H_POST)).append(LF);
		
		html.append(T2).append("<input type=\"hidden\" id=\"actionName\" name=\"actionName\"/>").append(LF);
		//　メニューへ戻るボタン
		html.append(T2).append("<div class=\"row text-right\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"returnMenu()\">")
			.append("メニューへ戻る").append("</button>").append(LF);
		html.append(T2).append("</div>").append(LF);
		// メニューボタン（1行目)
		html.append(T2).append("<div class=\"container padding-y-5 text-center\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"order01("
				+	SQ + DISPLAY_CD_ORDER_ENTRY_01 + SQ + ")" + DQ+ ">")
			.append("受注登録 Lv.01").append("</button>").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"order01("
				+ SQ + DISPLAY_CD_ORDER_LIST_01 + SQ + ")" + DQ + ">")
			.append("受注一覧 Lv.01").append("</button>").append(LF);
		html.append(T2).append("</div>").append(LF);
		
		html.append(TB).append(FormTag.getEndTag()).append(LF);
		html.append(DivTag.getEndTag()).append(LF);	// <--2.
		html.append(DivTag.getEndTag()).append(LF);	//<-- 1.
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
