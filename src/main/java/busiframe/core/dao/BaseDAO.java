package busiframe.core.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DAO基盤クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class BaseDAO implements I_BaseDAO {

	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

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

	/**
	 * テーブル削除<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 * @param tableName テーブル名
	 */
	public void dropTable(Environment env, String tableName) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_TABLE_DROP.replaceAll("<01>", tableName));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
	
	/**
	 * テーブル構築<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 * @param tableName テーブル名
	 * @param tableComment テーブル論理名
	 * @param keyColumnName Key項目名
	 * @param keyColumnComment Key項目論理名
	 */
	public void createTable(Environment env, String tableName, String tableComment, String keyColumnName,
			String keyColumnComment) {
		PreparedStatement pstmt = null;
		String sql = SQL_TABLE_CREATE.replaceAll("<01>", tableName);
		sql = sql.replaceAll("<02>", keyColumnName);
		sql = sql.replaceAll("<03>", keyColumnComment);
		sql = sql.replaceAll("<04>", tableComment);
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
	 * テーブル項目追加<br>
	 * 原則ID項目以外はAlterでテーブルに項目を追加する。<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 * @param alterSQL 追加用SQL文
	 */
	public void addColumn(Environment env, String alterSQL) {
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(alterSQL);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
}
