package busiframe.core.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 表示詳細情報インターフェースクラス<br>
 * @since 2024/11/27
 * @version 1.00 新規作成
 */
public interface I_SysDispDetail  extends BaseCharacter, I_BaseTable {
	
	// テーブル関連
	public final String TABLE_NAME_SYS_DISPDETAIL = "sys_dispdetail";
	public final String TABLE_COMMENT_SYS_DISPDETAIL = "表示詳細情報";
	public final String TABLE_DESCRIPTION_SYS_DISPDETAIL = "表示画面で使用する項目の情報を管理する。原則1項目1情報";
	
	// テーブル項目
	// 表示詳細情報ID
	public final String COL_NAME_DISP_DETAIL_ID = "disp_detail_id";
	public final String COL_COMMENT_DISP_DETAIL_ID = "表示詳細情報ID";
	public final String COL_DESCRIPTION_DISP_DETAIL_ID = "表示詳細情報を一意に管理する為のID情報で固定のIDが付与される。";
	// 表示情報ID → I_SysDispにて設定（Alterのみここで定義する)
	public final String COL_ALTER_DISP_ID_SYS_DISPDETAIL = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "ADD" + SP + I_SysDisp.COL_NAME_DISP_ID + SP + "INT NOT NULL" + SP
			+ "COMMENT" + SP + SQ + I_SysDisp.COL_COMMENT_DISP_ID + SQ + SP ;
	// 項目CD addition 2024/11/28
	public final String COL_NAME_ITEM_CD = "item_cd";
	public final String COL_COMMENT_ITEM_CD = "項目識別コード";
	public final String COL_DESCRIPTION_ITEM_CD = "画面上に配置される項目を識別する為の英数字のコード。画面内では一意のコードとする。";
	public final String COL_ALTER_ITEM_CD = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "ADD" + SP + COL_NAME_ITEM_CD + SP + "VARCHAR(100) NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ITEM_CD + SQ + SP;
	// 表示順 Addition 2024/11/28
	public final String COL_NAME_ITEM_SEQ = "item_seq";
	public final String COL_COMMENT_ITEM_SEQ = "項目並び順";
	public final String COL_DESCRIPTION_ITEM_SEQ = "画面上での項目の並び順を指定する。Lv.01では原則1行1項目とする。<br>0は非表示";
	public final String COL_ALTER_ITEM_SEQ = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "ADD" + SP + COL_NAME_ITEM_SEQ + SP + "INT NOT NULL DEFAULT 0" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ITEM_SEQ + SQ + SP;
	// ラベル addtion 2024/11/28
	public final String COL_NAME_ITEM_LABEL = "item_label";
	public final String COL_COMMENT_ITEM_LABEL = "項目ラベル";
	public final String COL_DESCRIPTION_ITEM_LABEL = "画面項目を説明するラベル。nullの場合はラベル無しとする。";
	public final String COL_ALTER_ITEM_LABEL = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "ADD" + SP + COL_NAME_ITEM_LABEL + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ITEM_LABEL + SQ + SP;
	// 属性名 addition 2024/22/28 TODO リファレンス情報が整備された時点でIDに変更する。 2024/11/28
	public final String COL_NAME_ITEM_TYPE = "item_type";
	public final String COL_COMMENT_ITEM_TYPE = "項目属性名";
	public final String COL_DESCRIPTION_ITEM_TYPE = "項目の属性を表す名称（日付・文字列・パスワード等）";
	public final String COL_ALTER_ITEM_TYPE = "ALTER TABLE" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "ADD" + SP + COL_NAME_ITEM_TYPE + SP + "VARCHAR(32) NOT NULL" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ITEM_TYPE + SQ + SP;
	
	// SQL関連
	/** SQL : 新規追加 */
	public final String SQL_INSERT_DISPDETAIL = "INSERT INTO" + SP + TABLE_NAME_SYS_DISPDETAIL + SP + "("
			+ COL_NAME_DISP_DETAIL_ID + CM + I_SysDisp.COL_NAME_DISP_ID + CM
			+ COL_NAME_ITEM_CD + CM + COL_NAME_ITEM_SEQ + CM + COL_NAME_ITEM_LABEL + CM
			+ COL_NAME_ITEM_TYPE + ")" + SP + "VALUES" + SP + "(?,?,?,?,?,?)";
	/** SQL : 取得 Addition 2024/11/30 */ 
	public final String SQL_LOAD_DISPDETAIL = "SELECT * FROM" + SP + TABLE_NAME_SYS_DISPDETAIL + SP
			+ "WHERE" + SP + I_SysDisp.COL_NAME_DISP_ID + " = ? "
			+ "ORDER BY" + SP + COL_NAME_ITEM_SEQ;
}
