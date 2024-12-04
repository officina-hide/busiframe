package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 表示情報インターフェースクラス<br>
 * @since 2024/11/27
 * @version 1.00 新規作成
 */
public interface I_SysDisp extends BaseCharacter {
	
	// テーブル関連
	public final String TABLE_NAME_SYS_DISP = "sys_disp";
	public final String TABLE_COMMENT_SYS_DISP = "表示情報";
	public final String TABLE_DESCRIPTION_SYS_DISP = "表示画面の情報を管理するテーブル。原則1画面1情報";

	// テーブル項目
	// 表示情報ID
	public final String COL_NAME_DISP_ID = "disp_id";
	public final String COL_COMMENT_DISP_ID = "表示情報ID";
	public final String COL_DESCRIPTION_DISP_ID = "表示情報を一意に管理する為のID番号<br>一部の画面については固定値をセットする。";
	// 表示識別コード
	public final String COL_NAME_DISP_CD = "disp_cd";
	public final String COL_COMMENT_DISP_CD = "表示識別コード";
	public final String COL_DESCRIPTION_DISP_CD = "表示情報を識別する為のコード。変更可能。システム内では一意の名称を設定する。";
	public final String COL_ALTER_DISP_CD = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISP + SP
			+ "ADD" + SP + COL_NAME_DISP_CD + SP + "VARCHAR(100) NOT NULL UNIQUE" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_DISP_CD + SQ + SP;
	// 画面タイトル Addtion 2024/12/04
	public final String COL_NAME_DISP_TITLE = "disp_title";
	public final String COL_COMMENT_DISP_TITLE = "表示タイトル";
	public final String COL_DESCRIPTION_DISP_TITLE = "画面上部に表示されるタイトル";
	public final String COL_ALTER_DISP_TITLE = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISP + SP
			+ "ADD" + SP + COL_NAME_DISP_TITLE + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_DISP_TITLE + SQ + SP;
	
	// SQL関連
	/** SQL : 追加 */
	public final String SQL_INSERT_DISP = "INSERT INTO" + SP + TABLE_NAME_SYS_DISP + SP + "("
			+ COL_NAME_DISP_ID + CM + COL_NAME_DISP_CD
			+ CM + COL_NAME_DISP_TITLE + ")" + SP		//Addition 2024/12/04
			+ "VALUES" + SP + "(?,?,?)" + SP;
	/** SQL : 取得  Addition 2024/11/30 */
	public final String SQL_LOAD_DISP = "SELECT * FROM" + SP + TABLE_NAME_SYS_DISP + SP
			+ "WHERE" + SP + COL_NAME_DISP_CD + " = ? ";
}
