package busiframe.order.dao;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * 受注情報 Lv.01クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class M_Order01 extends BaseDAO implements I_Order01{

	/**
	 * 受注テーブル削除<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, "ord_order");
	}

	/**
	 * 受注テーブル構築<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		// 基本構築
		createTable(env, "ord_order", "受注情報", "order_id", "受注情報ID");
		// 項目追加
		addColumn(env, COL_ALTER_ORDER_DATE);
	}

}
