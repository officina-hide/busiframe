package busiframe.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import busiframe.core.Environment;

/**
 * 表示情報モデルクラス<br>
 * @since 2024/11/06
 * @version 1.00 新規作成
 */
public class M_SysDisp extends X_SysDisp implements I_SysDisp{

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
	
}
