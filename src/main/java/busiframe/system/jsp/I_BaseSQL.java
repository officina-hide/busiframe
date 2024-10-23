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
}
