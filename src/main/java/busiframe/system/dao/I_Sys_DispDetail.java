package busiframe.system.dao;

import busiframe.system.jsp.I_BaseSQL;

/**
 * 表示詳細情報インターフェースクラス<br>
 * @since 2024/10/25
 * @version 1.00 新規作成
 */
public interface I_Sys_DispDetail extends I_BaseSQL {
	
	// 基本情報
	/** テーブル名 */
	public final String TABLE_NAME = "sys_dispdetail";
	public final String TABLE_COMMENT = "表示情報";
	
	// 項目情報
	/** 表示詳細情報ID */
	public final String COLUMN_NAME_DISPDETAIL_ID = "dispdetail_id";
	public final String COLUMN_COMMENT_DISPDETAIL_ID = "表示詳細情報ID";
	/** 表示情報ID */
	public final String COLUMN_NAME_DISP_ID = I_Sys_Disp.COLUMN_NAME_DISP_ID;
	public final String COLUMN_COMMENT_DISP_ID = I_Sys_Disp.COLUMN_COMMENT_DISP_ID;
	/** 表示順序 */
	public final String COLUMN_NAME_DISP_SEQ = "disp_seq";
	public final String COLUMN_COMMENT_DISP_SEQ = "表示順序";
	/** 項目ラベル */
	public final String COLUMN_NAME_LABEL = "label";
	public final String COLUMN_COMMENT_LABEL = "項目ラベル";
	
	// SQL関連
	/** テーブル削除用 */
	public final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS" +SP + TABLE_NAME;
	/** テーブル構築用 */
	public final String SQL_CREATE_TABLE = 
			"CREATE TABLE IF NOT EXISTS" + SP +TABLE_NAME + " (" + LF
				+ COLUMN_NAME_DISPDETAIL_ID + SP +"INT PRIMARY KEY COMMENT" + SP 
					+ SQ + COLUMN_COMMENT_DISPDETAIL_ID + SQ + CM +LF
				+ COLUMN_NAME_DISP_ID + SP + "INT NOT NULL COMMENT" + SP
					+ SQ + COLUMN_COMMENT_DISP_ID + SQ + CM + LF
				+ COLUMN_NAME_DISP_SEQ + SP + "INT COMMENT" + SP
					+ SQ + COLUMN_COMMENT_DISP_SEQ + SQ + CM + LF
				+ COLUMN_NAME_LABEL + SP + "VARCHAR(100) COMMENT" + SP
					+ SQ + COLUMN_COMMENT_LABEL + SQ + CM + LF
				+ CREATE_BASE_COLUMN
				+ ")" + SP + "COMMENT" + SP + SQ + TABLE_COMMENT + SQ;
	/** 情報登録用 */
	public final String SQL_INSERT_DATA = 
			"INSERT INTO" + SP + TABLE_NAME + " ("
				+ COLUMN_NAME_DISPDETAIL_ID + CM + COLUMN_NAME_DISP_ID + CM
				+ COLUMN_NAME_DISP_SEQ + CM + COLUMN_NAME_LABEL + CM
				+ COLUMN_NAME_CREATED_BY + CM + COLUMN_NAME_UPDATED_BY 
				+ ") VALUES (?,?,?,?,?,?)";
}
