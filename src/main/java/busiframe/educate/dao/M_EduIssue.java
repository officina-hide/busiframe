package busiframe.educate.dao;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * 問題情報クラス<br>
 * @since 2025/04/23
 * @version 1.00 新規作成
 */
public class M_EduIssue extends BaseDAO implements I_EduIssue {

	/**
	 * 問題情報テーブル削除<br>
	 * @since 2025/04/23
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {	
		dropTable(env, TABLE_NAME_EDU_ISSUE);
	}

	/**
	 * 問題情報テーブル作成<br>
	 * @since 2025/04/23
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_EDU_ISSUE, TABLE_COMMENT_EDU_ISSUE,
				COL_NAME_ISSUE_ID, COL_COMMENT_ISSUE_ID);
	}

}
