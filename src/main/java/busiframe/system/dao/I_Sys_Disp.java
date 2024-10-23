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
	public final String TALBE_NAME = "Sys_Disp";
	public final String TABLE_COMMENT = "表示情報";
	
	// 項目関係
	/** 表示情報ID */
	public final String COLUMN_NAME_DISP_ID = "disp_id";
	public final String COLUMN_COMMENT_DISP_ID = "表示情報ID";
	
	// SQL関連
	/** テーブル構築用 */
	public final String SQL_CREATE_TABLE = 
			"CREATE TABLE" + SP +TALBE_NAME + " (" + LF
				+ COLUMN_NAME_DISP_ID + SP +"INT PRIMARY KEY COMMENT" + SP + SQ + COLUMN_COMMENT_DISP_ID + SQ + CM +LF
				
			+ ")" + SP + "COMMENT" + SP + SQ + TABLE_COMMENT + SQ;
}
