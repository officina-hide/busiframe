package busiframe.order.servlet;

import java.nio.charset.Charset;

import busiframe.core.dao.X_sysDispDetail;
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

	/** POST */
	public final String H_POST = "post";
	
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

}
