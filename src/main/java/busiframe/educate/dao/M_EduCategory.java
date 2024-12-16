package busiframe.educate.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * 教育カテゴリー情報クラス<br>
 * @since 2024/12/12
 * @version 1.00 新規作成
 */
public class M_EduCategory extends BaseDAO implements I_EduCategory {

	private X_EduCategory category;
	
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

	/**
	 * 新規登録<br>
	 * @since 2024/12/16
	 * @param env 環境情報
	 * @param categoryId 教育カテゴリー情報ID
	 * @param categoryCd 教育カテゴリー識別コード
	 * @param categoryName 教育カテゴリー名
	 */
	public void addData(Environment env, int categoryId, String categoryCd, String categoryName) {
		PreparedStatement pstmt = null;
		// 項目セット
		getCategory().setCategoryId(categoryId);
		getCategory().setCategoryCd(categoryCd);
		getCategory().setCategoryName(categoryName);
		
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_CATEGORY);
			pstmt.setInt(1, categoryId);
			pstmt.setString(2, categoryCd);
			pstmt.setString(3, categoryName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	public X_EduCategory getCategory() {
		if(category == null) {
			category = new X_EduCategory();
		}
		return category;
	}

}
