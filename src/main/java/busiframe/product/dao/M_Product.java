package busiframe.product.dao;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;

/**
 * 商品情報クラス<br>
 * @since 2024/12/28
 * @version 1.00 新規作成
 */
 public class M_Product extends BaseDAO implements I_Product {

	/**
	 * テーブル削除<br>
	 * @since 2024/12/31
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_PRODUCT);
	}

	/**
	 * テーブル構築<br>
	 * @since 2025/01/06
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_PRODUCT, TABLE_COMMENT_PRODUCT,
				COL_NAME_PRODUCT_ID, COL_COMMENT_PRODUCT_ID);
		addColumn(env, COL_ALTER_PRODUCT_CD);
		addColumn(env, COL_ALTER_NAME);
		addColumn(env, COL_ALTER_DESCRIPTION);
	}

}
