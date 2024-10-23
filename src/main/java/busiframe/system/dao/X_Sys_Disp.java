package busiframe.system.dao;

import busiframe.system.Environment;

/**
 * 表示情報DAOクラス<br>
 * TODO 本クラスは自動生成では無いが、個別のカスタマイズは行わない事 2024/10/23<br>
 * @since 2024/10/23
 * @version 1.00 新規作成
 */
public class X_Sys_Disp extends BaseDAO implements I_Sys_Disp {

	/**
	 * 表示情報構築<br>
	 * 表示情報テーブルの構築、必要な表示情報の登録を行う。<br>
	 * @since 2024/10/23
	 * @param env 環境設定
	 */
	public void create(Environment env) {
		// 表示情報テーブル構築
		dmlExecute(env, SQL_CREATE_TABLE);
	}

}
