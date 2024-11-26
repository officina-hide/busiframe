package busiframe.core.dao;

/**
 * 表示関連情報クラス<br>
 * @since 2024/11/26
 * @version 1.00 新規作成
 */
public class M_Display extends BaseDAO implements I_SysDisp {

	/**
	 * テーブル削除<br>
	 * @since 2024/11/27
	 * @param env 関連情報
	 */
	public void dropTable(Environment env) {
		// 表示情報テーブル削除
		dropTable(env, TABLE_NAME_SYS_DISP);
	}

	/**
	 * テーブル構築<br>
	 * @since 2024/11/27
	 * @param env 関連情報
	 */
	public void createTable(Environment env) {
		// 表示情報テーブル構築
		createTable(env, TABLE_NAME_SYS_DISP, TABLE_COMMENT_SYS_DISP,
				COL_NAME_DISP_ID, COL_COMMENT_DISP_ID);
		addColumn(env, COL_ALTER_DISP_CD);
	}

}
