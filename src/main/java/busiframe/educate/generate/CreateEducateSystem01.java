package busiframe.educate.generate;

import busiframe.core.dao.BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.I_SysDispMenu;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.M_Numbering;
import busiframe.core.html.BaseDisplay;

/**
 * 教育関連システム初期生成クラス<br>
 * @since 2024/12/04
 * @version 1.00 新規作成
 */
public class CreateEducateSystem01 implements BaseDisplay, BaseTable {

	/**
	 * 生成実行<br>
	 * @since 2024/12/04
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 表示情報に教育メニュー Lv.01を登録する。
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_EDUCATE_MENU_01, DISPLAY_CD_EDUCATE_MENU_01, "教育メニュー");
		// 表示メニュー情報に「カテゴリー一覧」メニューを追加する。
		M_Numbering num = new M_Numbering();
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setNumberingId(TABLE_ID_SYS_DISPMENU);
		num.getNumbering().setTableId(TABLE_ID_SYS_DISPMENU);
		num.save(env);
		/*
		 *  表示情報にメニュー情報を登録する。<br> Addition 2023/12/05
		 *  メニュー : カテゴリー一覧
		 */
	}

}
