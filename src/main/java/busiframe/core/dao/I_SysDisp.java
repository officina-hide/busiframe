package busiframe.core.dao;

import busiframe.core.I_BaseRefarence;
import busiframe.core.jsp.I_BaseCharacter;

/**
 * 表示情報インターフェースクラス<br>
 * @since 2024/11/07
 * @version 1.00 新規作成
 */
public interface I_SysDisp extends I_BaseCharacter, I_BaseRefarence {

	// 基本情報
	/** テーブル名 */
	public final String TABLE_NAME = "sys_disp";
	/** テーブル解説 */
	public final String TABLE_COMMENT = "表示情報";
	
	// テーブル項目
	/** 表示情報ID */
	public final String COLUMN_NAME_DISP_ID = "disp_id";
	public final String COLUMN_COMMENT_DISP_ID = "表示情報ID";
	/** 表示識別コード */
	public final String COLUMN_NAME_DISP_CD = "disp_cd";
	public final String COLUMN_COMMENT_DISP_CD = "表示識別コード";
	/** タブ表示 */
	public final String COLUMN_NAME_TAB_TITLE = "tab_title";
	public final String COLUMN_COMMENT_TAB_TITLE = "タブタイトル";
	
	// SQL関連
	// 表示情報関連のSQLは全てここに記載する。 2024/11/10
	/** 抽出 : 表示識別コード */
	public final String SQL_LOAD_BY_CODE = 
			"SELECT * FROM " + TABLE_NAME + " "
			+ "WHERE " + COLUMN_NAME_DISP_CD + " = ? ";
	/** テーブル削除 */
	public final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
	/** テーブル構築 */
	public final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + LF
			+ COLUMN_NAME_DISP_ID + SP + R_INT + SP + S_PRIMARY_KEY + SP 
				+ S_COMMENT + SP + SQ + COLUMN_COMMENT_DISP_ID + SQ + CM + LF
			+ COLUMN_NAME_DISP_CD + SP + R_VARCHAR + "(64)" + SP + R_NOT_NULL + SP
				+ S_COMMENT + SP + SQ + COLUMN_COMMENT_DISP_CD + SQ + CM + LF
			+ COLUMN_NAME_TAB_TITLE + SP + R_VARCHAR + "(100)" + SP
				+ S_COMMENT + SP + SQ + COLUMN_COMMENT_TAB_TITLE + SQ + LF
			+ ") " + S_COMMENT + SP + SQ + TABLE_COMMENT + SQ + SP;
	/** 追加 */
	public final String SQL_INSERT = "INSERT INTO" + SP + TABLE_NAME + " (" + LF
			+ COLUMN_NAME_DISP_ID + CM + COLUMN_NAME_DISP_CD + CM + COLUMN_NAME_TAB_TITLE + SP + LF
			+ ") VALUES (?,?,?)";
}
