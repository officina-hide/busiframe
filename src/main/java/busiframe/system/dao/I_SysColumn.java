package busiframe.system.dao;

/**
 * テーブル項目情報インターフェースクラス<br>
 * @since 2025/03/25
 * @version 1.00 新規作成
 */
public interface I_SysColumn {
	
	// テーブル情報
	public final String TABLE_NAME_SYS_COLUMN = "sys_column";
	public final String TABLE_COMMENT_SYS_COLUMN = "テーブル項目情報";
	public final String TABLE_DESCRIPTION_SYS_COLUMN = "プロジェクトで使用するテーブルの項目の情報を管理する。";

	// テーブル項目
	public final String COL_NAME_COLUMN_ID = "column_id";
	public final String COL_COMMENT_COLUMN_ID = "テーブル項目情報ID";
	public final String COL_DESCRIPTION_COLUMN_ID = "テーブル項目情報を一意に管理する為のID<br>原則として固定値をセットする。";

}
