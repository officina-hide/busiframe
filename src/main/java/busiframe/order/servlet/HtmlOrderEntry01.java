package busiframe.order.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.LinkTag;
import busiframe.core.html.MetaTag;
import busiframe.core.html.TitleBar;
import busiframe.core.html.TitleTag;
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
 * @version 1.01 表示情報から項目を生成する。 2024/11/30
 */
public class HtmlOrderEntry01 implements BaseCharacter, BaseHtml, BaseDisplay {


	/**
	 * 受注登録HTMLソース生成<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 * @return HTML文字列
	 */
	public String createHTML(Environment env) {
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_CD_ORDER_ENTRY_01);
		
		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		// Javascript
		html.append("<script>").append(LF);
		html.append(TB).append("function entry() {").append(LF);
		html.append(T2).append("document.menuform.action=\"./order01\";").append(LF);
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
		
		// 表示明細情報から展開する。 Updated 2024/11/30
		for(int ix = 0; ix < disp.getDetails().size(); ix++) {
			X_sysDispDetail detail = disp.getDetails().get(ix);
			html.append(T2).append("<div class=\"row\">").append(LF);
			// ラベル
			html.append(T3).append("<label class=" + DQ +"md-1 text-right  padding-x-10 padding-y-5"+DQ+">")
				.append(detail.getItemLabel()).append("</label>").append(LF);
			// 項目
			switch(detail.getItemType()) {
			case "date":	//日付
				html.append(T3).append("<div class=\"md-2\">").append(LF);
				html.append(T4).append("<input class=").append(DQ).append("form-control").append(DQ).append(SP)
					.append("type=").append(DQ).append("date").append(DQ).append(SP)
					.append("id=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("name=").append(DQ).append(detail.getItemCd()).append(DQ).append(">").append(LF);
				html.append(T3).append("</div>").append(LF);
				break;
			case "string":	//文字列
				html.append(T3).append("<div class=\"md-4\">").append(LF);
				html.append(T4).append("<input class=").append(DQ).append("form-control").append(DQ).append(SP)
					.append("type=").append(DQ).append("text").append(DQ).append(SP)
					.append("id=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("name=").append(DQ).append(detail.getItemCd()).append(DQ).append(">").append(LF);
				html.append(T3).append("</div>").append(LF);
				break;
			case "number":	//数値
				html.append(T3).append("<div class=\"md-2\">").append(LF);
				html.append(T4).append("<input class=").append(DQ).append("form-control").append(DQ).append(SP)
					.append("type=").append(DQ).append("number").append(DQ).append(SP)
					.append("id=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("name=").append(DQ).append(detail.getItemCd()).append(DQ).append(">").append(LF);
				html.append(T3).append("</div>").append(LF);
			}
			html.append(T2).append("</div>").append(LF);
		}
			
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
