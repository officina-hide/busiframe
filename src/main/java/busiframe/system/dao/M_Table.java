package busiframe.system.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * テーブル情報クラス<br>
 * テーブル情報 -- テーブル項目情報
 * @since 2025/03/14
 * @version 1.00 新規作成
 * @version 1.01 テーブル項目情報関連追加
 */
public class M_Table extends BaseDAO implements I_SysTable, I_SysColumn {

	/** テーブル情報 */
	private X_SysTable table = new X_SysTable();
	
	/**
	 * テーブル削除<br>
	 * @since 2025/03/14
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		// テーブル情報削除
		dropTable(env, TABLE_NAME_SYS_TABLE);
		// テーブル項目情報削除
		dropTable(env, TABLE_NAME_SYS_COLUMN);
	}

	/**
	 * テーブル構築<br>
	 * @since 2025/03/14
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		// テーブル情報
		createTable(env, TABLE_NAME_SYS_TABLE, TABLE_COMMENT_SYS_TABLE,
				COL_NAME_TABLE_ID, COL_COMMENT_TABLE_ID);
		addColumn(env, COL_ALTER_TABLE_CD);
		addColumn(env, COL_ALTER_NAME);
		addColumn(env, COL_ALTER_DESCRIPTION);
		// テーブル情報 : 構築メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : テーブル情報を構築しました。");
		
		// テーブル項目情報
		createTable(env, TABLE_NAME_SYS_COLUMN, TABLE_COMMENT_SYS_COLUMN,
				COL_NAME_COLUMN_ID, COL_COMMENT_COLUMN_ID);
		// テーブル項目情報 : 構築メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : テーブル項目情報を構築しました。");
	}

	/**
	 * テーブル情報登録<br>
	 * @since 2025/03/15
	 * @param env 環境情報
	 * @param tableId テーブル情報ID
	 * @param tableDescription 
	 * @param tableCommet 
	 * @param tableCd 
	 */
	public void addTableData(Environment env, int tableId, String tableCd, String tableCommet, String tableDescription) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_TABLE);
			pstmt.setInt(1, tableId);
			pstmt.setString(2, tableCd);
			pstmt.setString(3, tableCommet);
			pstmt.setString(4, tableDescription);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
	
	public X_SysTable getTable() {
		return table;
	}

}
