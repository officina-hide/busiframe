package busiframe.order.generate;

import busiframe.core.dao.Environment;
import busiframe.order.dao.M_Order01;

/**
 * 受注関連生成クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class CreateOrderSystem01 {

	/**
	 * 生成実行<br>
	 * TODO レベルによって、生成対象のテーブルは変わります。 制御方法要件等<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 受注情報 Lv.01の生成
		M_Order01 od = new M_Order01();
		od.dropTable(env);
		od.createTable(env);
	}

}
