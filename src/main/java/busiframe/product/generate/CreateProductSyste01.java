package busiframe.product.generate;

import busiframe.core.dao.BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseDAO;
import busiframe.core.dao.I_BaseReference;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.M_Numbering;
import busiframe.core.html.BaseDisplay;
import busiframe.core.servlet.BaseHtml;
import busiframe.product.dao.I_Product;
import busiframe.product.dao.M_Product;

/**
 * 生産関係 : 初期設定クラス<br>
 * @since 2024/12/20
 * @version 1.00 新規作成
 */
public class CreateProductSyste01 implements BaseHtml, BaseDisplay, I_BaseDAO, I_BaseReference, BaseTable {

	/**
	 * 生成処理実行<br>
	 * @since 2024/12/20
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// テーブル構築 : 商品情報 Addition 2024/12/28
		M_Product product = new M_Product();
		product.dropTable(env);
		product.createTable(env);
		// 表示情報 : 生産メニュー
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_PRODUCT_MENU_01, DISPLAY_CD_PRODUCT_MENU_01,
				DISPLAY_TITLE_PRODUCT_MENU_01);
		disp.addMenuData(env, DISPLAY_ID_PRODUCT_MENU_01, MENU_CD_PRODUCT_LIST, MENU_TITLE_PRODUCT_LIST,
				MENU_ACTION_PRODUCT_LIST);
		// 表示情報 : 商品一覧
		disp.addDispData(env, DISPLAY_ID_PRODUCT_LIST_01, DISPLAY_CD_PRODUCT_LIST_01,
				DISPLAY_TITLE_PRODUCT_LIST_01);
		disp.addDispDetailData(env, DISPLAY_ID_PRODUCT_LIST_01, I_Product.COL_NAME_PRODUCT_CD,
				1, I_Product.COL_COMMENT_PRODUCT_CD, R_STRING);
		disp.addDispDetailData(env, DISPLAY_ID_PRODUCT_LIST_01, I_Product.COL_NAME_NAME,
				2, "商品名", R_STRING);
		disp.addDispProcessData(env, 0, disp.getDispData().getDispId(), "新規登録", "./productEntry01", "productEntry01");
		disp.addDispProcessData(env, 0, disp.getDispData().getDispId(), "メニューへ戻る", "./action01", MENU_PRODUCT01);
		// 商品情報 Lv.01 : 採番情報登録
		M_Numbering num = new M_Numbering();
		num.getNumbering().setNumberingId(TABLE_ID_PRD_PRODUCT);
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setTableId(TABLE_ID_PRD_PRODUCT);
		num.save(env);
		// 商品情報 Lv.01 : 初期登録用商品情報の登録
        M_Product product01 = new M_Product();
        product01.insertProduct(env, "P0001", "商品A", "商品Aの説明");
        product01.insertProduct(env, "P0002", "商品B", "商品Bの説明");
        // 商品照会 Lv01 : 表示情報関連登録
        disp.addDispData(env, DISPLAY_ID_PRODUCT_DATA_01, DISPLAY_CD_PRODUCT_DATA_01,
        		DISPLAY_TITLE_PRODUCT_DATA_01);
		disp.addDispDetailData(env, DISPLAY_ID_PRODUCT_DATA_01, I_Product.COL_NAME_PRODUCT_CD,
				1, I_Product.COL_COMMENT_PRODUCT_CD, R_STRING);
		disp.addDispDetailData(env, DISPLAY_ID_PRODUCT_DATA_01, I_Product.COL_NAME_NAME,
				2, "商品名", R_STRING);
		disp.addDispDetailData(env, DISPLAY_ID_PRODUCT_DATA_01, I_Product.COL_NAME_DESCRIPTION,
				2, "商品説明", R_TEXT);
		// 遷移処理登録 Addition 2025/02/17
		disp.addDispProcessData(env, 0, DISPLAY_ID_PRODUCT_DATA_01, "一覧へ戻る", "./productAction01",
				DISPLAY_CD_PRODUCT_LIST_01);
		disp.addDispProcessData(env, 0, DISPLAY_ID_PRODUCT_DATA_01, "編集", "./productAction01", "productEntry01");
	}

}
