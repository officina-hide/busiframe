package busiframe.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	/**
	 * 採番<br>
	 * テーブル単位で管理するID等の番号を採番する。<br>
	 * @since 2024/11/23
	 * @param env 環境情報
	 * @param tableId テーブル情報ID
	 * @return 採番番号
	 */
	public int newNumber(Environment env, int tableId) {
		int id = 0;
		int numberingId = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_NUMBERING);
			pstmt.setInt(1, tableId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id = rs.getInt(COL_NAME_CURRENT_NUMBER) + 1;
				numberingId = rs.getInt(COL_NAME_NUMBERING_ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		
		// 現在値更新
		if(numberingId > 0) {
			try {
				connection(env);
				pstmt = env.getConn().prepareStatement(SQL_UPDATE_NUMBERING);
				pstmt.setInt(1, id);
				pstmt.setInt(2, numberingId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt, rs);
			}
		}
		return id;
	}
}
