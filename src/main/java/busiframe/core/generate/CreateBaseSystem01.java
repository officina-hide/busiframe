package busiframe.core.generate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.core.dao.I_BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.I_SysDispDetail;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.M_Numbering;
import busiframe.core.html.BaseDisplay;

/**
 * 基盤システム構築<br>
 * @version 2024/11/22
 * @version 1.00 新規作成
 */
public class CreateBaseSystem01 implements I_BaseTable, BaseDisplay {

	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/**
	 * 生成実行<br>
	 * @since 2023/11/22
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : 基盤システムに関する機能の生成を開始します。");

		// 採番情報の生成
		M_Numbering num = new M_Numbering();
		num.dropTable(env);
		num.createTable(env);
		// 表示関連情報
		M_Display disp = new M_Display();
		disp.dropTable(env);
		disp.createTable(env);
		// 表示詳細情報用採番情報の登録 Addition 2024/12/07
		num.getNumbering().setNumberingId(I_SysDispDetail.TABLE_ID_SYS_DISPDETAIL);
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setTableId(I_SysDispDetail.TABLE_ID_SYS_DISPDETAIL);
		num.save(env);
		// 採番情報登録 : 表示メニュー情報 Addition 2025/02/26
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setNumberingId(TABLE_ID_SYS_DISPMENU);
		num.getNumbering().setTableId(TABLE_ID_SYS_DISPMENU);
		num.save(env);
		// 表示処理情報用採番情報の登録 Addition 2025/01/21
		num.getNumbering().setNumberingId(TABLE_ID_SYS_DISPPROCESS);
		num.getNumbering().setCurrentNumber(100000);
		num.getNumbering().setTableId(TABLE_ID_SYS_DISPPROCESS);
		num.save(env);
		
		// 表示情報 : メインメニュー画面 Addition 2025/02/10
		disp.addDispData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_MAIN_MENU, DISPLAY_TITLE_MAIN_MENU);
		// メインメニュー : メニュー情報登録 Addition 2025/02/25
		disp.addMenuData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_EDUCATE_MENU_01,
				DISPLAY_TITLE_EDUCATE_MENU_01, "./action01", 1);
		disp.addMenuData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_ORDER_MENU_01,
				DISPLAY_TITLE_ORDER_MENU_01, "./action01", 1);
		disp.addMenuData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_PRODUCT_MENU_01,
				DISPLAY_TITLE_PRODUCT_MENU_01, "./action01", 1);
		disp.addMenuData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_PROJECT_MENU_01,
				DISPLAY_TITLE_PROJECT_MENU_01, ACTION_URI_MAIN_MENU, 2);
		disp.addMenuData(env, DISPLAY_ID_MAIN_MENU, DISPLAY_CD_SYSTEM_MENU_01,
				DISPLAY_TITLE_SYSTEM_MENU_01, ACTION_URI_MAIN_MENU, 3);
		
		// 完了メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : 基盤システムに関する機能の生成を完了しました。");
	}

}
