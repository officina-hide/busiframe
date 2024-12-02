package busiframe.core.html;

import busiframe.core.tools.BaseCharacter;

/**
 * HTML:タイトルタグクラス<br>
 * @since 2024/11/17
 * @version 1.0 新規作成
 */
public class TitleTag implements BaseCharacter {

	/**
	 * タイトルタグソース生成
	 * @param title タブ表示用タイトル
	 * @return タイトルタグ
	 */
	public static String getSource(String title) {
		StringBuffer str = new StringBuffer();
		str.append("<title>").append(title).append("</title>");
		return str.toString();
	}

}
