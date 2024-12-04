package busiframe.educate.generate;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;

/**
 * 教育関連システム初期生成クラス<br>
 * @since 2024/12/04
 * @version 1.00 新規作成
 */
public class CreateEducateSystem01 implements BaseDisplay {

	/**
	 * 生成実行<br>
	 * @since 2024/12/04
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 表示情報に教育メニュー Lv.01を登録する。
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_EDUCATE_MENU_01, DISPLAY_CD_EDUCATE_MENU_01, "教育メニュー");
	}

}
