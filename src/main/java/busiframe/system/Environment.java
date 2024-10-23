package busiframe.system;

import java.sql.Connection;

/**
 * 環境情報クラス<br>
 * @author officina-hide.net © 2024
 * @since 2024/08/02 新規作成
 * @version 1.00 新規作成
 * @version 1.01 loginUserIdの項目を追加。<br>
 * 						ログイン時にログインしたユーザーのIDがセットされます。
 * @version 1.02 Copyrughtの変数を追加
 */
public class Environment { 

	private Connection conn = null;
	private String dsn;
	private String databaseUser;
	private String databasePassword;
	private int dbSw = 1;
	
	/** ログインユーザー情報ID */
	private int loginUserId;
	/** Copyright情報 */
	// FIXME システムパラメータとしてデータベースかする事 2024/08/20
	private String copuright = "Copyright © 2024 officina-hide.net";
	
//	/**
//	 * コンストラクター<br>
//	 * officina-hide.netとローカルのデータベースをここで切り替えて指定する。<br>
//	 * ローカルのデータベースはネットが使用できないときに指定する。<br>
//	 * @since 2024/08/02 新規作成
//	 */
//	public Environment() {
//	}
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public String getDsn() {
		return dsn;
	}
	public String getDatabaseUser() {
		return databaseUser;
	}
	public String getDatabasePassword() {
		return databasePassword;
	}
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}
	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	public int getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(int loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getCopuright() {
		return copuright;
	}

	public void setDbSw(int dbSw) {
		if(dbSw == 1) {
			setDsn("jdbc:mariadb://localhost:3306/busiframe");
			setDatabaseUser("root");
			setDatabasePassword("root");
		} else {
			setDsn("jdbc:mariadb://www.officina-hide.net:3306/busiframe");
			setDatabaseUser("training");
			setDatabasePassword("qaz12wsx");
		}
		this.dbSw = dbSw;
	}

	public int getDbSw() {
		return dbSw;
	}

}
