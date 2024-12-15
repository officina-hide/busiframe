package busiframe.educate.dao;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * 教育カテゴリー情報クラス<br>
 * @since 2024/12/12
 * @version 1.00 新規作成
 */
public class M_EduCategory extends BaseDAO implements I_EduCategory {

	/**
	 * テーブル削除<br>
	 * @since 2024/12/13
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_EDU_CATEGORY);
	}

	/**
	 * テーブル構築<br>
	 * @since 2024/12/14
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_EDU_CATEGORY, TABLE_COMMENT_EDU_CATEGORY,
				COL_NAME_CATEGORY_ID, COL_COMMENT_CATEGORY_ID);
		addColumn(env, COL_ALTER_CATEGORY_CD);
		addColumn(env, COL_ALTER_CATEGORY_NAME);
	}

}
