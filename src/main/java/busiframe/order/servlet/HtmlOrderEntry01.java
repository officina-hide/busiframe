package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.JSP.LinkTag;
import busiframe.core.JSP.MetaTag;
import busiframe.core.JSP.TitleBar;
import busiframe.core.JSP.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * HTML : 受注登録 Lv.01クラス<br>
 * <pre>
 * Lv.01の登録内容は親情報のみで、マスター管理も無し（相手先は都度入力タイプ）
 * 管理する項目はエンティティ情報から「受注」「管理レベル:01」から選択する。
 * 本クラスでは、選択済みのエンティティに対して登録項目を表示する。
 * </pre>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class HtmlOrderEntry01 implements BaseCharacter, BaseHtml {

	public String createHTML() {
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		// Javascript
		html.append("<script>").append(LF);
		html.append(TB).append("function entry() {").append(LF);
		html.append(T2).append("document.menuform.action=\"./action01\";").append(LF);
		html.append(T2).append("document.menuform.actionName.value=\"entry\";").append(LF);
		html.append(T2).append("if(window.confirm('登録してよろしいですか？')){").append(LF);
		html.append(T3).append("document.menuform.submit();").append(LF);
		html.append(T2).append("} else {").append(LF);
		html.append(T3).append("window.alert('キャンセルされました'); ").append(LF);
		html.append(T3).append("return false;").append(LF);
		html.append(T2).append("}").append(LF);
		html.append(TB).append("}").append(LF);
		html.append("</script>").append(LF);
		
		// html
		html.append(HTML_START).append(LF);
		html.append(HEAD_START).append(LF);
		html.append(TB).append(MetaTag.getSource(StandardCharsets.UTF_8)).append(LF);
		html.append(TB).append(TitleTag.getSource(ORDER_ENTRY_01_TITLE)).append(LF);
		html.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		html.append(HEAD_END).append(LF);
		
		html.append("<body>").append(LF);
		html.append("<header>").append(LF);
		html.append(TB).append(TitleBar.getSource(ORDER_ENTRY_01_TITLE));
		html.append("</header>").append(LF);
		
		html.append("<form name=\"menuform\" method=\"post\">").append(LF);
		html.append(T2).append("<input type=\"hidden\" id=\"actionName\" name=\"actionName\"/>").append(LF);
		html.append(TB).append("<div class=\"padding-x-100 padding-y-5\">").append(LF);
		// 項目一覧の表示
		html.append(T2).append("<div class=\"row\">").append(LF);
		html.append(T3).append("<label class=\"md-1 text-right  padding-x-10 padding-y-5\">受注日</label>").append(LF);
		html.append(T3).append("<div class=\"md-2\">").append(LF);
		html.append(T4).append("<input class=\"form-control\"  type=\"date\" id=\"orderDate\" name=\"orderDate\">").append(LF);
		html.append(T3).append("</div>").append(LF);
		html.append(T2).append("</div>").append(LF);
	
		// 登録ボタン
		html.append(T2).append("<div class=\"row\">").append(LF);
		html.append(T3).append("<button type=\"button\" class=\"btn btn-dark\" onclick=\"entry()\">")
			.append("登録").append("</button>").append(LF);
		html.append(T2).append("</div>").append(LF);

		html.append(TB).append("</div>").append(LF);
		
		html.append("</form>").append(LF);
		
		html.append("</body>").append(LF);
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
