package busiframe.order.servlet;

import java.nio.charset.Charset;

import busiframe.core.dao.M_Display;
import busiframe.core.dao.X_sysDispDetail;
import busiframe.core.dao.X_sysDispMenu;
import busiframe.core.dao.X_sysDispProcess;
import busiframe.core.html.ButtonTag;
import busiframe.core.html.DivTag;
import busiframe.core.html.FormTag;
import busiframe.core.html.LinkTag;
import busiframe.core.html.MetaTag;
import busiframe.core.html.TitleBar;
import busiframe.core.html.TitleTag;
import busiframe.core.servlet.BaseHtml;
import busiframe.core.tools.BaseCharacter;

/**
 * HTML汎用クラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public class BaseHTML implements BaseCharacter, BaseHtml {
	
	/**
	 * headタグソース生成
	 * @since 2024/11/22
	 * @param charName キャラクターセット名
	 * @param title タイトル
	 * @return headタグソース文字列
	 */
	public String createHead(Charset charName, String title) {
		StringBuffer html = new StringBuffer();
		html.append(HEAD_START).append(LF);
		html.append(TB).append(MetaTag.getSource(charName)).append(LF);
		html.append(TB).append(TitleTag.getSource(title)).append(LF);
		html.append(TB).append(LinkTag.getSource("stylesheet", "./css/skyblue_k.css")).append(LF);
		html.append(HEAD_END).append(LF);
		return html.toString();
	}
	
	/**
	 * bodyタグ内のheaderタグソース生成
	 * @since 2024/11/22
	 * @param title タイトル文字列
	 * @return headerタグソース文字列
	 */
	public String createHeader(String title) {
		StringBuffer html = new StringBuffer();
		html.append(HEADER_START).append(LF);
		html.append(TB).append(TitleBar.getSource(title));
		html.append(HEADER_END).append(LF);
		return html.toString();
	}
	
	/**
	 * HTML : テーブルタイトル項目ソース生成<br>
	 * @since 2024/12/16
	 * @param detail 表示詳細情報
	 * @return テーブルタイトル項目ソース文字列
	 */
	public String getTableTitleItem(X_sysDispDetail detail) {
		StringBuffer html = new StringBuffer();
		html.append("<th>").append(detail.getItemLabel()).append("</th>");
		return html.toString();
	}

	/**
	 * HTML : 遷移ボタンソース生成<br>
	 * @since 2024/12/25、2025/01/23
	 * @param disp 表示情報
	 * @return 遷移ボタンソース文字列
	 */
	public String setMoveButton(M_Display disp) {
		StringBuffer html = new StringBuffer();
		html.append(T2).append(DivTag.getSource("row text-right")).append(LF);
		// 表示処理リストの処理ボタンを表示する。
		for(X_sysDispProcess process : disp.getProcesses()) {
			StringBuffer fname = new StringBuffer("moveAction(").append(SQ).append(process.getActionName()).append(SQ)
					.append(CM).append(SQ).append(process.getActionURL()).append(SQ).append(")");
			html.append(T3).append(ButtonTag.getSource(process.getButtonTitle(), fname.toString())).append(LF);
		}
		
		html.append(T2).append(DivTag.getEndTag()).append(LF);
		return html.toString();
	}

	/**
	 * HTML : メニューボタンソース生成<br>
	 * @since 2024/12/26
	 * @param menu 表示メニュー情報
	 * @return メニューボタンソース文字列
	 */
	public String setMenuButton(X_sysDispMenu menu) {
		StringBuffer html = new StringBuffer();
		html.append("<button").append(SP);
		html.append("type=").append(DQ).append("button").append(DQ).append(SP);
		html.append("class=").append(DQ).append("btn btn-dark").append(DQ).append(SP);
		html.append("onclick=").append(DQ).append("moveAction").append("(")
			.append(SQ).append(menu.getDispMenuCd()).append(SQ).append(CM)
			.append(SQ).append(menu.getMenuAction()).append(SQ).append(")").append(DQ).append(">");
		html.append(menu.getMenuTItle());
		html.append("</button>");
		return html.toString();
	}

	/**
	 * メニューForm生成<br>
	 * @since 2025/03/13
	 * @param disp 表示情報
	 * @return メニュ用HTM文字列
	 */
	public String createMenuHtml(M_Display disp) {
		StringBuffer html = new StringBuffer();
		// メニュー用Form
		html.append(TB).append(FormTag.getSource("actionForm", H_POST)).append(LF);		// form -->
		// actionName変数
		html.append(T2).append("<input").append(SP)
			.append("type=").append(DQ).append("hidden").append(DQ).append(SP)
			.append("id=").append(DQ).append("actionName").append(DQ).append(SP)
			.append("name=").append(DQ).append("actionName").append(DQ).append("/>").append(LF);
		// メニュー一覧
		int rowNo = 0;
		for(X_sysDispMenu menu : disp.getMenus()) {
			if(rowNo == 0) {
				html.append(T2).append(DivTag.getSource("container padding-y-5 text-center")).append(LF);	
			}
			if(rowNo != menu.getMenuRowNo()) {
				html.append(T2).append(DivTag.getEndTag()).append(LF);
				html.append(T2).append(DivTag.getSource("container padding-y-5 text-center")).append(LF);
			}
			rowNo = menu.getMenuRowNo();
			html.append(T3).append(setMenuButton(menu)).append(LF);
		}
		html.append(T2).append(DivTag.getEndTag()).append(LF);

		html.append(FormTag.getEndTag());		// <-- form		
		return html.toString();
	}
}
