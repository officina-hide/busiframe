package busiframe.system.dao;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * テーブル情報クラス<br>
 * テーブル情報 -- テーブル項目情報
 * @since 2025/03/14
 * @version 1.00 新規作成
 */
public class M_Table extends BaseDAO implements I_Table {

	/**
	 * テーブル削除<br>
	 * @since 2025/03/14
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_SYS_TABLE);
	}

	/**
	 * テーブル構築<br>
	 * @since 2025/03/14
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_SYS_TABLE, TABLE_COMMENT_SYS_TABLE,
				COL_NAME_TABLE_ID, COL_COMMENT_TABLE_ID);
		addColumn(env, COL_ALTER_TABLE_CD);
		addColumn(env, COL_ALTER_NAME);
		addColumn(env, COL_ALTER_DESCRIPTION);
	}

}
