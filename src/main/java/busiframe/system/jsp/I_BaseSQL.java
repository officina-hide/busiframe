package busiframe.system.jsp;

public interface I_BaseSQL {

	/** 改行 */
	public final String LF = "\n";
	/** シングルコーテーション */
	public final String SQ = "'";
	/** 打プルコーテーション */
	public final String DQ = "\"";
	/** タブ */
	public final String TB = "\t";
	public final String TB2 = "\t\t";
	public final String TB3 = "\t\t\t";
	public final String TB4 = "\t\t\t\t";
	/** 空白 */
	public final String SP = " ";
	/** カンマ「,」 */
	public final String CM = ",";
	
	// 項目属性
	/** 数値 */
	public final String R_INTEGER = "integer";
	/** 文字列 */
	public final String R_STRING = "string";
	
	// テーブル共通項目
	/** 登録日 */
	public final String COLUMN_NAME_CREATED_AT = "created_at";
	public final String COLUMN_COMMENT_CREATED_AT = "登録日";
	/** 登録者 */
	public final String COLUMN_NAME_CREATED_BY = "created_by";
	public final String COLUMN_COMMENT_CREATED_BY = "登録者";
	/** 更新日 */
	public final String COLUMN_NAME_UPDATED_AT = "updated_at";
	public final String COLUMN_COMMENT_UPDATED_AT = "更新日";
	/** 更新者 */
	public final String COLUMN_NAME_UPDATED_BY = "updated_by";
	public final String COLUMN_COMMENT_UPDATED_BY = "更新者";
	
	// SQL関連
	/** テーブル共通項目構築用 */
	public final String CREATE_BASE_COLUMN =
			COLUMN_NAME_CREATED_AT + SP + "DATETIME NOT NULL DEFAULT NOW() COMMENT" + SP
				+SQ+COLUMN_COMMENT_CREATED_AT + SQ + CM + LF
			+ COLUMN_NAME_CREATED_BY + SP + "INT NOT NULL DEFAULT 1001 COMMENT" + SP
				+SQ+COLUMN_COMMENT_CREATED_BY + SQ + CM + LF
			+ COLUMN_NAME_UPDATED_AT + SP + "DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT" + SP
				+ SQ + COLUMN_COMMENT_UPDATED_AT + SQ + CM + LF
			+ COLUMN_NAME_UPDATED_BY + SP + "INT NOT NULL DEFAULT 1001 COMMENT" + SP
				+SQ+COLUMN_COMMENT_UPDATED_BY + SQ + LF;
}
