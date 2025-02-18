package busiframe.product.servlet;

import java.nio.charset.StandardCharsets;

import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseReference;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.html.BaseDisplay;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;
import busiframe.order.servlet.BaseHTML;
import busiframe.product.dao.I_Product;
import busiframe.product.dao.M_Product;

/**
 * 商品照会 Lv.01生成クラス<br>
 * @since 2025/02/03
 * @version 1.00 新規作成
 */
public class HtmlProductData01 extends BaseHTML implements BaseHtml, BaseCharacter, BaseDisplay, I_BaseReference {

	/**
	 * 画面表示用HTMLソース生成<br>
	 * @since 2025/02/03
	 * @param env 環境情報
	 * @param productId 商品情報ID
	 * @return 画面表示用HTMLソース
	 */
	public Object createHTML(Environment env, int productId) {
		// 表示情報取得
		M_Display disp = new M_Display();
		disp.load(env, DISPLAY_ID_PRODUCT_DATA_01);
		// 商品情報取得
		M_Product product = new M_Product();
		product.load(env, productId);

		StringBuffer html = new StringBuffer();
		html.append(DOCTYPE_HTML).append(LF);
		html.append(HTML_START).append(LF);
		
		// Javascript
		html.append(SCRIPT_START).append(LF);
		html.append(TB).append("function").append(SP).append("moveAction(name, uri)").append(SP).append("{").append(LF);
		html.append(T2).append("document.actionForm.actionName.value=").append("name").append(";").append(LF);
		html.append(T2).append("document.actionForm.action=").append("uri").append(";").append(LF);
		html.append(T2).append("document.actionForm.submit();").append(LF);
		html.append(TB).append("}").append(LF);
		html.append(SCRIPT_END).append(LF);
		
		// html
		html.append(createHead(StandardCharsets.UTF_8, disp.getDispData().getDispTitle()));
		
		html.append(BODY_START).append(LF);
		html.append(DivTag.getSource("container padding-y-5 text-left")).append(LF);	//-->1
		html.append(createHeader(disp.getDispData().getDispTitle()));
		// form
		html.append(TB).append(FormTag.getSource("actionForm", H_POST)).append(LF);	//--> Form
		
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);

		// 遷移ボタン表示
		html.append(setMoveButton(disp)).append(LF);
		
		// form : 各項目を詳細情報の一覧から表示する。
		for(int ix = 0; ix < disp.getDetails().size(); ix++) {
			X_sysDispDetail detail = disp.getDetails().get(ix);
			// 表示項目判定
			String data = "";
			switch(detail.getItemCd()) {
			case I_Product.COL_NAME_PRODUCT_CD:
				data = product.getProduct().getProductCd();
				break;
			case I_Product.COL_NAME_NAME:
				data = product.getProduct().getName();
				break;
			case I_Product.COL_NAME_DESCRIPTION:
				data = product.getProduct().getDescription();
				break;
			}
			html.append(T2).append(DivTag.getSource("row")).append(LF);
			// label
			html.append(T3).append("<label class=" + DQ +"md-2 text-right padding-y-5 padding-x-10 "+DQ+">")
				.append(detail.getItemLabel()).append("</label>").append(LF);
			// item
			switch(detail.getItemType()) {
			case R_STRING:	//文字列
				html.append(T3).append(DivTag.getSource("md-4")).append(LF);
				html.append(T4).append("<input class=").append(DQ).append("form-control").append(DQ).append(SP)
					.append("type=").append(DQ).append("text").append(DQ).append(SP)
					.append("id=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("name=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("value=").append(DQ).append(data).append(DQ).append(" readonly>").append(LF);
				html.append(T3).append(DivTag.getEndTag()).append(LF);
				break;
			case R_TEXT:	// 複数行文字列
				html.append(T3).append(DivTag.getSource("md-4")).append(LF);
				html.append(T4).append("<textarea class=").append(DQ).append("form_control").append(DQ).append(SP)
					.append("id=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("name=").append(DQ).append(detail.getItemCd()).append(DQ).append(SP)
					.append("row=3").append(SP).append("cols=50").append(" readonly>")
					.append(data)
					.append("</textarea>").append(LF);
				html.append(T3).append(DivTag.getEndTag()).append(LF);
				break;
			}
			
			html.append(T2).append(DivTag.getEndTag()).append(LF);
		}
		
		html.append(TB).append(FormTag.getEndTag()).append(LF);	//<-- Form
		
		html.append(DivTag.getEndTag()).append(LF);	//<--1
		html.append(BODY_END).append(LF);
		
		html.append(HTML_END).append(LF);
		return html.toString();
	}

}
