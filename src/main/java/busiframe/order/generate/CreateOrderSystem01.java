package busiframe.order.generate;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.M_Numbering;
import busiframe.core.html.BaseDisplay;
import busiframe.order.dao.I_Order01;
import busiframe.order.dao.M_Order01;

/**
 * 受注関連生成クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class CreateOrderSystem01 implements BaseDisplay {

	/**
	 * 生成実行<br>
	 * TODO レベルによって、生成対象のテーブルは変わります。 制御方法要検討<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 受注情報 Lv.01の生成
		M_Order01 od = new M_Order01();
		od.dropTable(env);
		od.createTable(env);
		// 受注情報用採番情報登録
		M_Numbering num = new M_Numbering();
		num.getNumbering().setNumberingId(10001);
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setTableId(I_Order01.TABLE_ID_ORDER);
		num.save(env);
		// 受注登録画面 : 表示情報登録
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_ORDER_ENTRY_01, DISPLAY_CD_ORDER_ENTRY_01);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_DATE, 1, "受注日","date");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_PARTNER_NAME, 2, "相手先名","string");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_PRODUCT_NAME, 3, "商品名","string");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_NUMBER, 4, "受注数","number");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_AMOUNT, 5, "受注金額","number");
		// 受注一覧画面登録
		disp.addDispData(env, DISPLAY_ID_ORDER_LIST_01, DISPLAY_CD_ORDER_LIST_01);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_ORDER_DATE, 1, "受注日", "date");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_PARTNER_NAME, 2, "相手先名","string");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_PRODUCT_NAME, 3, "商品名","string");
	}

}
