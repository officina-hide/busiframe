package busiframe.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import busiframe.core.Environment;
import busiframe.core.I_Message;
import busiframe.core.messages.Message;

/**
 * 表示情報モデルクラス<br>
 * @since 2024/11/06
 * @version 1.00 新規作成
 */
public class M_SysDisp extends X_SysDisp implements I_SysDisp, I_Message {

	/** メッセージクラス */
	private Message msg = new Message();
	
	/**
	 * 表示識別コードによる情報取得<br>
	 * @param env 
	 * @since 2024/11/06
	 * @param dispCd 情報識別コード
	 */
	public void loadByCd(Environment env, String dispCd) {
		// TODO 【要件等】ここで直接SQLを発行して取得しているが、汎用化を検討すること。 2024/11/07
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_BY_CODE);
			pstmt.setString(1, dispCd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				itemSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
	}

	/**
	 * テーブル構築<br>
	 * 表示情報テーブルを構築する。<br>
	 * TODO 表示テーブルは独自に構築されました。標準の構築方法については要件等 2024/11/09
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		try {
			// 既登録のテーブルを削除する。
			dbmExecute(env, SQL_DROP_TABLE);
			// テーブル構築
			dbmExecute(env, SQL_CREATE_TABLE);
			// 構築完了メッセージ
			msg.console(env, MI_02_001, TABLE_COMMENT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 情報新規追加
	 * @since 2024/11/13
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param dispCd 表示識別コード
	 * @param tabTitle タブ表示
	 */
	public void addData(Environment env, int dispId, String dispCd, String tabTitle) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT);
			pstmt.setInt(1, dispId);
			pstmt.setString(2, dispCd);
			pstmt.setString(3, tabTitle);
			int rs = pstmt.executeUpdate();
			if(rs == 1) {
				// 登録成功メッセージ
				msg.console(env, MI_02_002, TABLE_COMMENT+"("+dispCd+":"+dispId+")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
	
}
