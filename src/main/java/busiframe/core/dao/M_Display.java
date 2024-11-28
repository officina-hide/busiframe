package busiframe.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 表示関連情報クラス<br>
 * @since 2024/11/26
 * @version 1.00 新規作成
 */
public class M_Display extends BaseDAO implements I_SysDisp, I_SysDispDetail {

	/**
	 * テーブル削除<br>
	 * @since 2024/11/27
	 * @param env 関連情報
	 */
	public void dropTable(Environment env) {
		// 表示詳細テーブル削除
		dropTable(env, TABLE_NAME_SYS_DISPDETAIL);
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
		// 表示詳細情報テーブル構築
		createTable(env, TABLE_NAME_SYS_DISPDETAIL, TABLE_COMMENT_SYS_DISPDETAIL,
				COL_NAME_DISP_DETAIL_ID, COL_COMMENT_DISP_DETAIL_ID);
		addColumn(env, COL_ALTER_DISP_ID_SYS_DISPDETAIL);
		addColumn(env, COL_ALTER_ITEM_CD);
		addColumn(env, COL_ALTER_ITEM_SEQ);
		addColumn(env, COL_ALTER_ITEM_LABEL);
		addColumn(env, COL_ALTER_ITEM_TYPE);
	}

	/**
	 * 表示情報登録<br>
	 * @since 2024/11/28
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param dispCd 表示識別コード
	 */
	public void addDispData(Environment env, int dispId, String dispCd) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_DISP);
			pstmt.setInt(1, dispId);
			pstmt.setString(2, dispCd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * 表示詳細情報登録<br>
	 * @since 2024/11/28
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param itemCd 項目識別コード
	 * @param itemSeq 項目並び順
	 * @param itemLabel 項目ラベル
	 * @param itemType 属性名
	 */
	public void addDispDetailData(Environment env, int dispId, String itemCd, int itemSeq, String itemLabel, String itemType) {
		PreparedStatement pstmt = null;
		// 表示詳細情報ID採番
		M_Numbering num = new M_Numbering();
		int dispdetailId = num.newNumber(env, TABLE_ID_SYS_DISPDETAIL);
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_DISPDETAIL);
			pstmt.setInt(1, dispdetailId);
			pstmt.setInt(2, dispId);
			pstmt.setString(3, itemCd);
			pstmt.setInt(4, 1);
			pstmt.setString(5, itemLabel);
			pstmt.setString(6, itemType);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

}
