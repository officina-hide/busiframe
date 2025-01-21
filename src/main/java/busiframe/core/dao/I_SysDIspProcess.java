package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 表示処理情報インターフェースクラス<br>
 * @since 2025/01/16
 * @version 1.00 新規作成
 */
public interface I_SysDIspProcess extends BaseCharacter {
	
	// テーブル関連
	public final String TABLE_NAME_SYS_DISPPROCESS = "sys_dispprocess";
	public final String TABLE_COMMENT_SYS_DISPPROCESS = "表示処理情報";
	public final String TABLE_DESCRIPTION_SYS_DISPPROCESS = "表示画面で処理を行う為のボタン類を定義する。";

	// テーブル項目
	// 表示処理情報ID
	public final String COL_NAME_DISP_PROCESS_ID = "disp_process_id";
	public final String COL_COMMENT_DISP_PROCESS_ID = "表示処理情報ID";
	public final String COL_DESCRIPTION_DISP_PROCESS_ID = "表示処理情報を一意に管理する為のID情報で固定のIDが付与される。";
	// 表示情報ID(親ID : ALTER以下はI_SysDisp参照）Addition 2025/01/21
	public final String COL_ALTER_DISP_ID_SYS_DISPPROCESS = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPPROCESS + SP
			+ "ADD" + SP + I_SysDisp.COL_NAME_DISP_ID + SP + "INT NOT NULL" + SP
			+ "COMMENT" + SP + SQ + I_SysDisp.COL_COMMENT_DISP_ID + SQ + SP ;
	// ボタンタイトル Addition 2025/01/21
	public final String COL_NAME_BUTTON_TITLE = "button_title";
	public final String COL_COMMENT_BUTTON_TITLE = "ボタンタイトル";
	public final String COL_DESCRIPTION_BUTTON_TITLE = "表示画面に表示するボタンの表示タイトルを定義する。";
	public final String COL_ALTER_BUTTON_TITLE = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPPROCESS + SP
			+ "ADD" + SP + COL_NAME_BUTTON_TITLE + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_BUTTON_TITLE + SQ + SP;
	// アクションURL Addition 2025/01/21
	public final String COL_NAME_ACTION_URL = "action_url";
	public final String COL_COMMENT_ACTION_URL = "アクションURL";
	public final String COL_DESCRIPTION_ACTION_URL = "ボタンクリック時に遷移先となるアクションURLを定義する。";
	public final String COL_ALTER_ACTION_URL = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPPROCESS + SP
			+ "ADD" + SP + COL_NAME_ACTION_URL + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ACTION_URL + SQ + SP;
	// アクション名 Addition 2025/01/21
	public final String COL_NAME_ACTION_NAME = "action_name";
	public final String COL_COMMENT_ACTION_NAME = "アクション名";
	public final String COL_DESCRIPTION_ACTION_NAME = "遷移先のアクションで処理を分別する為の名前を定義する。";
	public final String COL_ALTER_ACTION_NAME = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPPROCESS + SP
			+ "ADD" + SP + COL_NAME_ACTION_NAME + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ACTION_NAME + SQ + SP;
	
	// 登録関係
	/** SQL : 新規登録 Addition 2025/01/21 */
	public final String SQL_INSERT = "INSERT INTO" + SP + TABLE_NAME_SYS_DISPPROCESS + SP
			+ "(" + COL_NAME_DISP_PROCESS_ID + CM + I_SysDisp.COL_NAME_DISP_ID
			+ CM + COL_NAME_BUTTON_TITLE + CM + COL_NAME_ACTION_URL
			+ CM + COL_NAME_ACTION_NAME + ")" + SP +  "VALUES" + SP + "(?,?,?,?,?)" + SP;
}
