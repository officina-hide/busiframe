package busiframe.system.dao;

import busiframe.core.dao.I_BaseDAO;
import busiframe.core.tools.BaseCharacter;

/**
 * テーブル項目情報インターフェースクラス<br>
 * @since 2025/03/25
 * @version 1.00 新規作成
 */
public interface I_SysColumn extends BaseCharacter, I_BaseDAO {
	
	// テーブル情報
	public final String TABLE_NAME_SYS_COLUMN = "sys_column";
	public final String TABLE_COMMENT_SYS_COLUMN = "テーブル項目情報";
	public final String TABLE_DESCRIPTION_SYS_COLUMN = "プロジェクトで使用するテーブルの項目の情報を管理する。";

	// テーブル項目
	public final String COL_NAME_COLUMN_ID = "column_id";
	public final String COL_COMMENT_COLUMN_ID = "テーブル項目情報ID";
	public final String COL_DESCRIPTION_COLUMN_ID = "テーブル項目情報を一意に管理する為のID<br>原則として固定値をセットする。";
	public final String COL_ALTER_COLUMN_ID = "ALTER TABLE" + SP + TABLE_NAME + SP
			+ "ADD" + SP + COL_NAME_COLUMN_ID + SP + "INT NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_COLUMN_ID + SQ + SP;

	// テーブル項目識別コード
	public final String COL_NAME_COLUMN_CD = "column_cd";
	public final String COL_COMMENT_COLUMN_CD = "テーブル項目識別コード";
	public final String COL_DESCRIPTION_COLUMN_CD = "テーブル項目を識別する為のコード<br>テーブル内では一意のコードをセットする。";
	public final String COL_ALTER_COLUMN_CD = "ALTER TABLE" + SP + TABLE_NAME_SYS_COLUMN + SP
			+ "ADD" + SP + COL_NAME_COLUMN_CD + SP + "VARCHAR(100)  NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_COLUMN_CD + SQ + SP;
	// テーブル情報ID
	public final String COL_ALTER_TABLE_ID_COLUMN = "ALTER TABLE" + SP + TABLE_NAME_SYS_COLUMN + SP
			+ "ADD" + SP + I_SysTable.COL_NAME_TABLE_ID + SP + "INT NOT NULL" + SP
			+ "COMMENT" + SP + SQ + I_SysTable.COL_COMMENT_TABLE_ID + SQ + SP;
	// テーブル項目属性
	// TODO リファレンス情報が構築された時点でIDに変更する。 2025/03/26
	public final String COL_NAME_COLUMN_TYPE = "column_type";
	public final String COL_COMMENT_COLUMN_TYPE = "テーブル項目属性";
	public final String COL_DESCRIPTION_COLUMN_TYPE = "テーブル項目が土の属性で管理されているかを表す。";
	public final String COL_ALTER_COLUMN_TYPE = "ALTER TABLE" + SP + TABLE_NAME_SYS_COLUMN + SP
			+ "ADD" + SP + COL_NAME_COLUMN_TYPE + SP + "VARCHAR(32) NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_COLUMN_TYPE + SQ + SP;
	
	// SQL文
	public final String SQL_INSERT_COLUMN = "INSERT INTO " + TABLE_NAME_SYS_COLUMN + " ("
			+ COL_NAME_COLUMN_ID + CM + COL_NAME_COLUMN_CD + CM +
			I_SysTable.COL_NAME_TABLE_ID + CM	+ COL_NAME_COLUMN_TYPE + CM +
			COL_NAME_NAME + ", " + COL_NAME_DESCRIPTION + ") VALUES (?, ?, ?, ?, ?, ?)";
	/* 
	 * SQL : 一覧取得（テーブル情報ID） Addition 2025/03/30
	 */
	public final String SQL_LOAD_COLUMN_BY_TABLE_ID = "SELECT * FROM" + SP + TABLE_NAME_SYS_COLUMN + SP
			+ "WHERE" + SP + I_SysTable.COL_NAME_TABLE_ID + " = ? ";
	/*
	 * SQL : 取得（テーブル項目識別ID） Addition 2025/03/30
	 */
	public final String SQL_LOAD_COLUMN_BY_COLUMN_ID = "SELECT * FROM" + SP + TABLE_NAME_SYS_COLUMN + SP
			+ "WHERE" + SP + COL_NAME_COLUMN_ID + " = ? ";
}
