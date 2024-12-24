package busiframe.product.generate;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;

/**
 * 生産関係 : 初期設定クラス<br>
 * @since 2024/12/20
 * @version 1.00 新規作成
 */
public class CreateProductSyste01 implements BaseDisplay{

	/**
	 * 生成処理実行<br>
	 * @since 2024/12/20
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_PRODUCT_MENU_01, DISPLAY_CD_PRODUCT_MENU_01,
				DISPLAY_TITLE_PRODUCT_MENU_01);
		disp.addMenuData(env, DISPLAY_ID_PRODUCT_MENU_01, MENU_CD_PRODUCT_LIST, MENU_TITLE_PRODUCT_LIST,
				MENU_ACTION_PRODUCT_LIST);
	}

}
