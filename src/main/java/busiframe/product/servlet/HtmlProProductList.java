package busiframe.product.servlet;

import java.nio.charset.StandardCharsets;
import java.util.List;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
import busiframe.core.html.TableTag;
import busiframe.order.servlet.BaseHTML;
import busiframe.product.dao.M_Product;
import busiframe.product.dao.X_Product;

/**
 * 商品一覧 Lv.01生成クラス
 * @since 2025/01/15
 * @version 1.00 新規作成
 */
public class HtmlProProductList extends BaseHTML implements BaseDisplay {

	public Object createHTML(Environment env) {
		StringBuffer html = new StringBuffer();
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_CD_PRODUCT_LIST_01);
		// 商品情報一覧
		M_Product product = new M_Product();
		List<X_Product> products = product.getList(env);

		html.append(DOCTYPE_HTML).append(LF);
		// html
		html.append(HTML_START).append(LF);
		
		// JavaScript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("moveAction(name, uri)").append(SP).append("{").append(LF);
		html.append(T2).append("document.actionForm.actionName.value=").append("name").append(";").append(LF);
		html.append(T2).append("document.actionForm.action=").append("uri").append(";").append(LF);
		html.append(T2).append("document.actionForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(TB).append("function").append(SP).append("entryAction(id)").append(SP).append("{").append(LF);
		html.append(T2).append("document.actionForm.action='./productAction01';").append(LF);
		html.append(T2).append("document.actionForm.id=id;").append(LF);
		html.append(T2).append("document.actionForm.actionName.value=")
			.append(SQ).append(DISPLAY_CD_PRODUCT_DATA_01).append(SQ).append(";").append(LF);
		html.append(T2).append("document.actionForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);
		
		html.append(createHead(StandardCharsets.UTF_8, DISPLAY_TITLE_PRODUCT_LIST_01));
		html.append(BODY_START).append(LF);
		html.append(createHeader(DISPLAY_TITLE_PRODUCT_LIST_01));
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	//-->1
		// Form内にテーブルを作成する。
		html.append(TB).append(FormTag.getSource("actionForm", H_POST)).append(LF);
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		
		// 遷移ボタン表示
		html.append(setMoveButton(disp)).append(LF);
		// 一覧表
		html.append(TB).append(TableTag.getSource("table table-striped table-bordered table-hover")).append(LF);
		// タイトル
		html.append(T2).append("<thead>").append(LF);
		for(X_sysDispDetail detail : disp.getDetails()) {
			html.append(T4).append("<th>").append(detail.getItemLabel()).append("</th>").append(LF);
		}
		html.append(T2).append("</thead>").append(LF);
		// 明細
		html.append(T2).append("<tbody>").append(LF);
		for(X_Product pr : products) {
			html.append(T3).append("<tr")
				.append(SP).append("onclick=").append(DQ).append("entryAction(").append(pr.getProductId()).append(")").append(DQ).append(">").append(LF);
			html.append(T4).append("<td>").append(pr.getProductCd()).append("</td>").append(LF);
			html.append(T4).append("<td>").append(pr.getName()).append("</td>").append(LF);
			html.append(T3).append("</tr>").append(LF);
		}
		html.append(T2).append("</tbody>").append(LF);
		
		
		html.append(TB).append(TableTag.getEndTag()).append(LF);	//<-- 一覧表 End
		
		html.append(TB).append(FormTag.getEndTag()).append(LF);
		html.append(DivTag.getEndTag()).append(LF);	//<--1
		html.append(BODY_END).append(LF);
		html.append(HTML_END).append(LF);

		return html.toString();
	}

}
