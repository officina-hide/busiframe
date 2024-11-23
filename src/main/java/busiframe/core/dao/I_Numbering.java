package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 採番情報インターフェースクラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public interface I_Numbering extends BaseCharacter {

	// テーブル関連
	public final String TABLE_NAME_NUMBERING = "sys_numbering";
	public final String TABLE_COMMENT_NUMBERING = "採番情報 Lv.01";

	// テーブル項目
	// 採番情報ID
	public final String COL_NAME_NUMBERING_ID = "numbering_id";
	public final String COL_COMMENT_NUMBERING_ID = "採番情報ID";
	// 現在値
	public final String COL_NAME_CURRENT_NUMBER = "current_number";
	public final String COL_COMMENT_CURRENT_NUMBER = "現在値";
	public final String COL_DESCRIPTION_CURRENT_NUMBER = "採番等で現在発行されている最大の値";
	public final String COL_ALTER_CURRENT_NUMBER = "ALTER TABLE" + SP + TABLE_NAME_NUMBERING + SP
			+ "add" + SP + COL_NAME_CURRENT_NUMBER + SP + "INT NOT NULL UNIQUE COMMENT" + SP
			+ SQ + COL_COMMENT_CURRENT_NUMBER + SQ + SP;
	// テーブル情報ID TODO テーブル情報インターフェースクラスで定義予定 2024/11/22
	public final String COL_NAME_TABLE_ID = "table_id";
	public final String COL_COMMENT_TABLE_ID = "テーブル情報ID";
	public final String COL_ALTER_TABLE_ID = "ALTER TABLE <01> ADD" + SP
			+ COL_NAME_TABLE_ID + SP + "INT NOT NULL COMMENT" + SP
			+ SQ + COL_COMMENT_TABLE_ID + SQ + SP;
	
	// SQL関連
	/** SQL : 新規登録 */
	public final String SQL_INSERT_NUMBERING = "INSERT INTO" + SP + TABLE_NAME_NUMBERING + SP
			+ "(" + COL_NAME_NUMBERING_ID + CM + COL_NAME_CURRENT_NUMBER + CM
			+ COL_NAME_TABLE_ID + ") VALUES (?,?,?)" + SP;
}
