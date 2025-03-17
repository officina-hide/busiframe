package busiframe.system.dao;

import busiframe.core.dao.I_BaseDAO;
import busiframe.core.tools.BaseCharacter;

/**
 * テーブル情報インターフェースクラス<br>
 * @since 2025/03/14
 * @version 1.00 新規作成
 */
public interface I_Table extends BaseCharacter, I_BaseDAO {

	// テーブル情報
	public final String TABLE_NAME_SYS_TABLE = "sys_table";
	public final String TABLE_COMMENT_SYS_TABLE = "テーブル情報";
	public final String TABLE_DESCRIPTION_SYS_TABLE = "プロジェクトで使用するテーブルに関する情報を管理する。";

	// テーブル項目
	public final String COL_NAME_TABLE_ID = "table_id";
	public final String COL_COMMENT_TABLE_ID = "テーブル情報ID";
	public final String COL_DESCRIPTION_TABLE_ID = "テーブル情報を一意に管理する為のID<br>原則として固定値をセットする。";
	
	// テーブル識別コード
	public final String COL_NAME_TABLE_CD = "table_cd";
	public final String COL_COMMENT_TABLE_CD = "テーブル識別コード";
	public final String COL_DESCRIPTION_TABLE_CD = "テーブルを識別する為のコード。";
	public final String COL_ALTER_TABLE_CD = "ALTER TABLE" + SP + TABLE_NAME_SYS_TABLE + SP
			+ "ADD" + SP + COL_NAME_TABLE_CD + SP + "VARCHAR(100)  NOT NULL UNIQUE" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_TABLE_CD + SQ + SP;
	/** 名前 */
	public final String COL_ALTER_NAME = "ALTER TABLE" + SP + TABLE_NAME_SYS_TABLE + SP
			+ "ADD" + SP + COL_NAME_NAME + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_NAME + SQ + SP;
	/** 解説 */
	public final String COL_ALTER_DESCRIPTION = "ALTER TABLE" + SP + TABLE_NAME_SYS_TABLE + SP
			+ "ADD" + SP + COL_NAME_DESCRIPTION + SP + "VARCHAR(3000)"
			+ "COMMENT" + SP + SQ + COL_COMMENT_DESCRIPTION + SQ + SP;
	
	// SQL関係
	/** SQL : 新規追加  Addition 2023/03/17 */
	public final String SQL_INSERT_TABLE = "INSERT INTO" + SP + TABLE_NAME_SYS_TABLE + SP + "("
			+ COL_NAME_TABLE_ID + CM + COL_NAME_TABLE_CD + CM + COL_NAME_NAME
			+ CM + COL_NAME_DESCRIPTION + ") VALUES (?,?,?,?)" + SP;
	
}
