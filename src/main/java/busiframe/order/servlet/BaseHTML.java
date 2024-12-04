package busiframe.order.servlet;

import java.nio.charset.Charset;

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
}
