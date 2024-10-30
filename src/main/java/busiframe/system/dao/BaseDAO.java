package busiframe.system.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import busiframe.system.Environment;
import busiframe.system.jsp.I_BaseSQL;

/**
 * DAO汎用クラス<br>
 * @since 2024/10/23
 * @version 1.00 新規作成
 */
public class BaseDAO implements I_BaseSQL {

	/** 表示日付書式 */
	protected static DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	/**
	 * データベース管理用SQL実行<br>
	 * @since 2024/09/02
	 * @param env 環境情報
	 * @param sql 実行SQL文
	 */
	public void dmlExecute(Environment env, String sql) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * データ登録
	 * @param dc 
	 * @param sql 
	 * @param env 
	 * @return
	 */
	public boolean addExecute(Environment env, String sql, DataCollection dc) {
		boolean chk = false;
		PreparedStatement pstmt = null;
		try {
			connection(env);
			for(List<Object> dlist : dc.getDataList()) {
				if(pstmt != null) {
					pstmt.clearParameters();
				}
				pstmt = env.getConn().prepareStatement(sql);
				for(int ix = 0; ix < dlist.size(); ix++) {
					switch(dc.getitemType(ix)) {
					case R_INTEGER:
						pstmt.setInt(ix+1, (int) dlist.get(ix));
						break;
					case R_STRING:
						pstmt.setString(ix+1, (String) dlist.get(ix));
						break;
					}
				}
				int rs = pstmt.executeUpdate();
				if(rs == 1) {
					chk = true;
				} else {
					chk = false;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
		return chk;
	}
	
	/**
	 * データベース接続<br>
	 * <p>環境情報にある接続情報に対してデータベースを接続する。</p>
	 * @param env
	 */
	public boolean connection(Environment env) {
		boolean chk = true;
		try {
			if(env.getConn() != null && env.getConn().isClosed() == false) {
				//既に接続済の場合は以降の処理を行わない。
				return chk;
			}
			Class.forName("org.mariadb.jdbc.Driver");
			env.setConn(DriverManager.getConnection(env.getDsn()	, env.getDatabaseUser(),
					env.getDatabasePassword()));
			System.out.println("AutoCommit Mode = "+env.getConn().getAutoCommit());
			System.out.println(LocalDateTime.now().format(fomat) + " : データベースに接続しました。"+"【seDB="+env.getDbSw()+"】");
		} catch (SQLException | ClassNotFoundException e) {
			chk = false;
		}
		
		return chk;
	}

	/**
	 * データベース情報を閉じる。
	 * @param pstmt SQL文
	 * @param rs 検索結果
	 */
	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if(pstmt != null && pstmt.isClosed() == false) {
				pstmt.close();
			}
			if(rs != null && pstmt.isClosed() == false) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
