package busiframe.system.dao;

import busiframe.system.jsp.I_BaseSQL;

/**
 * 表示情報インターフェースクラス<br>
 * TODO 本クラスは自動生成では無いが、個別のカスタマイズは行わない事 2024/10/23<br>
 * @since 2024/10/23
 * @version 1.00 新規作成
 */
public interface I_Sys_Disp extends I_BaseSQL {

	// 基本情報
	/** テーブル名 */
	public final String TABLE_NAME = "sys_disp";
	public final String TABLE_COMMENT = "表示情報";
	
	// 項目関係
	/** 表示情報ID */
	public final String COLUMN_NAME_DISP_ID = "disp_id";
	public final String COLUMN_COMMENT_DISP_ID = "表示情報ID";
	/** 表示識別コード */
	public final String COLUMN_NAME_DISP_CD = "disp_cd";
	public final String COLUMN_COMMENT_DISP_CD = "表示識別コード";
	/** 画面タイトル */
	public final String COLUMN_NAME_DISP_TITLE = "disp_title";
	public final String COLUMN_COMMENT_DISP_TITLE = "稼麺タイトル";
	
	// SQL関連
	/** テーブル削除用 */
	public final String SQL_DELETE_TABLE = "DROP TABLE" +SP + TABLE_NAME;
	/** テーブル構築用 */
	public final String SQL_CREATE_TABLE = 
			"CREATE TABLE" + SP +TABLE_NAME + " (" + LF
				+ COLUMN_NAME_DISP_ID + SP +"INT PRIMARY KEY COMMENT" + SP + SQ + COLUMN_COMMENT_DISP_ID + SQ + CM +LF
				+ COLUMN_NAME_DISP_CD + SP + "VARCHAR(32) NOT NULL COMMENT" + SP
					+ SQ + COLUMN_COMMENT_DISP_CD + SQ + CM + LF
				+ COLUMN_NAME_DISP_TITLE + SP + "VARCHAR(100) COMMENT" + SP
					+SQ + COLUMN_COMMENT_DISP_TITLE + SQ + CM + LF
				+ CREATE_BASE_COLUMN
			+ ")" + SP + "COMMENT" + SP + SQ + TABLE_COMMENT + SQ;
	/** 初期登録 */
	public final String SQL_INSERT_DATA = 
			"INSERT INTO" + SP + TABLE_NAME + " ("
				+ COLUMN_NAME_DISP_ID + CM + COLUMN_NAME_DISP_CD + CM
				+ COLUMN_NAME_DISP_TITLE + CM
				+ COLUMN_NAME_CREATED_BY + CM + COLUMN_NAME_UPDATED_BY 
				+ ") VALUES (?,?,?,?,?)";
	/** 情報取得(表示識別コード) */
	public final String SQL_LOAD_BY_CD = 
			"SELECT * FROM" + SP + TABLE_NAME + SP
			+ "WHERE" + SP + COLUMN_NAME_DISP_CD + " = ? ";
	/** 表示詳細情報取得用 */
	public final String SQL_LOAD_DISPDETAIL = 
			"SELECT * FROM" + SP + I_Sys_DispDetail.TABLE_NAME+ SP
				+ "WHERE" + SP + COLUMN_NAME_DISP_ID + " = ? "
				+ "ORDER BY" + SP + I_Sys_DispDetail.COLUMN_NAME_DISP_SEQ + SP;
}
