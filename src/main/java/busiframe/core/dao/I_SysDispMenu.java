package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 表示メニュー情報インターフェースクラス<br>
 * @since 2024/12/05
 * @version 1.00 新規作成
 */
public interface I_SysDispMenu extends BaseCharacter {
	
	// テーブル関連
	public final String TABLE_NAME_SYS_DISPMENU = "sys_dispmenu";
	public final String TABLE_COMMENT_SYS_DISPMENU = "表示メニュー情報";
	public final String TABLE_DESCRIPTION_SYS_DISPMENU = "表示画面のメニューに表示されるボタンを管理するテーブル";
	
	// テーブル項目
	// 表示情報ID
	public final String COL_NAME_DISPMENU_ID = "dispmenu_id";
	public final String COL_COMMENT_DISPMENU_ID = "表示メニュー情報ID";
	public final String COL_DESCRIPTION_DISPMENU_ID = "表示メニュー情報を一意に管理する為のID番号";
	// 表示情報ID
//	public final String COL_NAME_DISP_ID = "disp_id";
//	public final String COL_COMMENT_DISP_ID = "表示情報ID";
//	public final String COL_DESCRIPTION_DISP_ID = "表示メニューを表示する画面の表示情報ID";
	public final String COL_ALTER_DISP_ID_DISPMENU = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "ADD" + SP + I_SysDisp.COL_NAME_DISP_ID + SP + "INT NOT NULL DEFAULT 0" + SP
			+ "COMMENT" + SP + SQ + I_SysDisp.COL_COMMENT_DISP_ID + SQ + SP;
	// 表示メニュー識別コード
	public final String COL_NAME_DISPMENU_CD = "dispmenu_cd";
	public final String COL_COMMENT_DISPMENU_CD = "表示メニュー識別コード";
	public final String COL_DESCRIPTION_DISPMENU_CD = "表示メニュー画面で一意のメニューとして識別する為のコード";
	public final String COL_ALTER_DISPMENU_CD = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "ADD" + SP + COL_NAME_DISPMENU_CD + SP + "VARCHAR(100) NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_DISPMENU_CD + SQ + SP;
	// メニュータイトル Addition 2024/12/07
	public final String COL_NAME_MENU_TITLE = "menu_title";
	public final String COL_COMMENT_MENU_TITLE = "メニュータイトル";
	public final String COL_DESCRIPTION_MENU_TITLE = "メニューボタンに表示されるタイトル";
	public final String COL_ALTER_MENU_TITLE = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "ADD" + SP + COL_NAME_MENU_TITLE + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_MENU_TITLE + SQ + SP;
	// メニューアクション Addition 2024/12/07
	public final String COL_NAME_MENU_ACTION = "menu_action";
	public final String COL_COMMENT_MENU_ACTION = "メニューアクション";
	public final String COL_DESCRIPTION_MENU_ACTION = "メニューFormで指定される遷移先のURIを設定する。";
	public final String COL_ALTER_MENU_ACTION = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "ADD" + SP + COL_NAME_MENU_ACTION + SP + "VARCHAR(200)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_MENU_ACTION + SQ + SP;
	// メニュー表示行 Addition 2025/03/01
	public final String COL_NAME_MENU_ROW_NO = "menu_row_no";
	public final String COL_COMMENT_MENU_ROW_NO = "表示行番号";
	public final String COL_DESCRIPTION_MENU_ROW_NO = "メニューを複数行表示するときに表示する行を指定する番号。";
	public final String COL_ALTER_MENU_ROW_NO = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "ADD" + SP + COL_NAME_MENU_ROW_NO + SP + "INT DEFAULT 1" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_MENU_ROW_NO + SQ + SP;
	
	// SQL関係
	/** SQL : 新規登録 Addition 2024/12/09 */ 
	public final String SQL_INSERT_DISPMENU = "INSERT INTO" + SP + TABLE_NAME_SYS_DISPMENU + SP + "("
			+ COL_NAME_DISPMENU_ID + CM + I_SysDisp.COL_NAME_DISP_ID + CM
			+ COL_NAME_DISPMENU_CD + CM + COL_NAME_MENU_TITLE + CM
			+ COL_NAME_MENU_ACTION + CM + COL_NAME_MENU_ROW_NO + ")"
			+ "VALUES" + "(?,?,?,?,?,?)" + SP;
	/** SQL : 情報リスト作成用 Addition 2024/12/09 */
	public final String SQL_LOAD_DISPMENU = "SELECT * FROM" + SP + TABLE_NAME_SYS_DISPMENU + SP
			+ "WHERE" + SP + I_SysDisp.COL_NAME_DISP_ID + " = ? ";
}
