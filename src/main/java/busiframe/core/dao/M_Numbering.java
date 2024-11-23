package busiframe.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 採番情報クラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public class M_Numbering extends BaseDAO implements I_Numbering {

	private X_Numbering numbering;
	
	/**
	 * テーブル削除<br>
	 * @since 2024/11/22
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_NUMBERING);
	}
	
	/**
	 * テーブル構築<br>
	 * @since 2024/11/22
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_NUMBERING, TABLE_COMMENT_NUMBERING,
				COL_NAME_NUMBERING_ID, COL_COMMENT_NUMBERING_ID);
		addColumn(env, COL_ALTER_CURRENT_NUMBER);
		addColumn(env, COL_ALTER_TABLE_ID.replaceAll("<01>", TABLE_NAME_NUMBERING));
	}

	public X_Numbering getNumbering() {
		if(numbering == null) {
			numbering = new X_Numbering();
		}
		return numbering;
	}

	/**
	 * 登録<br>
	 * @since 2024/11/22
	 * @param env 環境情報
	 */
	public void save(Environment env) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_NUMBERING);
			pstmt.setInt(1, getNumbering().getNumberingId());
			pstmt.setInt(2, getNumbering().getCurrentNumber());
			pstmt.setInt(3, getNumbering().getTableId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
}
