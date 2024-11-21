package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 基盤DAOインターフェースクラス<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 */
public interface I_BaseDAO extends BaseCharacter {

	// SQL関連
	/** SQL : 汎用テーブル削除 */
	public final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS <01>";
	/**
	 * SQL : 汎用テーブル構築<br>
	 * このSQではテーブルの構築を行いますが、項目はPrimary Keyとなる項目のみです。<br>
	 * 例.<br>
	 *     SQL_TABLE_CREATE.replaceall("<01)>", <I>テーブル名</I>);<br>
	 *     SQL_TABLE_CREATE.replaceall("<02)>", <I>Key項目名</I>);<br>
	 *     SQL_TABLE_CREATE.replaceall("<03)>", <I>Key項目論理名</I>);<br>
	 *     SQL_TABLE_CREATE.replaceall("<04)>", <I>テーブル論理名</I>);<br>
	 * @since 2024/11/21
	 */
	public final String SQL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS <01> ("
			+ "<02> INT PRIMARY KEY COMMENT " + SQ + "<03>" + SQ + SP
			+ ") COMMENT " + SQ + "<04>" + SQ + SP;
}
