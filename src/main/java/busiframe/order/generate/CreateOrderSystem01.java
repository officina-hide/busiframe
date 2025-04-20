package busiframe.order.generate;

import java.math.BigDecimal;
import java.time.LocalDate;

import busiframe.core.dao.I_BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseReference;
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
public class CreateOrderSystem01 implements BaseDisplay, I_BaseReference, I_BaseTable {

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
		num.getNumbering().setTableId(TABLE_ID_ORD_ORDER);
		num.save(env);
		// 受注登録画面 : 表示情報登録
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_ORDER_ENTRY_01, DISPLAY_CD_ORDER_ENTRY_01, "受注登録 Lv.01");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_DATE, 1, "受注日","date", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_PARTNER_NAME, 2, "相手先名","string", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_PRODUCT_NAME, 3, "商品名","string", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_NUMBER, 4, "受注数","number", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_ENTRY_01, I_Order01.COL_NAME_ORDER_AMOUNT, 5, "受注金額","number", 0);
		// 受注一覧画面登録
		disp.addDispData(env, DISPLAY_ID_ORDER_LIST_01, DISPLAY_CD_ORDER_LIST_01, "受注一覧 Lv.01");
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_ORDER_DATE, 1, "受注日", "date", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_PARTNER_NAME, 2, "相手先名","string", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_PRODUCT_NAME, 3, "商品名","string", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_ORDER_NUMBER, 4, "受注数", "number", 0);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_LIST_01, I_Order01.COL_NAME_ORDER_AMOUNT, 4, "受注金額", "number", 0);
		disp.addDispProcessData(env, 0, DISPLAY_ID_ORDER_LIST_01, "メニューへ戻る",
				ACTION_URI_MAIN_MENU, DISPLAY_CD_ORDER_MENU_01);
		// 受注照会 Lv.01画面
		disp.addDispData(env, DISPLAY_ID_ORDER_DISP_01, DISPLAY_CD_ORDER_DISP_01, DISPLAY_TITLE_ORDER_DISP_01,
				TABLE_ID_ORD_ORDER);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_DISP_01, I_Order01.COL_NAME_ORDER_DATE,
				1, 	I_Order01.COL_COMMENT_ORDER_DATE, R_DATE, COL_ID_ORDER_DATE);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_DISP_01, I_Order01.COL_NAME_PARTNER_NAME,
				2, 	I_Order01.COL_COMMENT_PARTNER_NAME, R_STRING, COL_ID_PARTNER_NAME);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_DISP_01, I_Order01.COL_NAME_PRODUCT_NAME,
				3, 	I_Order01.COL_COMMENT_PRODUCT_NAME, R_STRING, COL_ID_PRODUCT_NAME);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_DISP_01, I_Order01.COL_NAME_ORDER_NUMBER,
				4, 	I_Order01.COL_COMMENT_ORDER_NUMBER, R_NUMBER, COL_ID_ORDER_NUMBER);
		disp.addDispDetailData(env, DISPLAY_ID_ORDER_DISP_01, I_Order01.COL_NAME_ORDER_AMOUNT,
				5, 	I_Order01.COL_COMMENT_ORDER_AMOUNT, R_NUMBER, COL_ID_ORDER_AMOUNT);
		disp.addDispProcessData(env, 0, DISPLAY_ID_ORDER_DISP_01, "一覧へ戻る",
				ACTION_URI_ORDER_01, DISPLAY_CD_ORDER_LIST_01);
		
		// 受注情報初期登録 Addition 2025/03/03
		// TODO 将来的にはJSON又はCSVで出来るようにしていく。 2025/03/03
		od.getOrder().setOrderDate(LocalDate.now());
		od.getOrder().setPartnerName("A商店");
		od.getOrder().setProductName("商品001");
		od.getOrder().setOrderNumber(new BigDecimal(1));
		od.getOrder().setOrderAmount(new BigDecimal(10000));
		od.getOrder().setOrderId(0);
		od.save(env);
	}

}
