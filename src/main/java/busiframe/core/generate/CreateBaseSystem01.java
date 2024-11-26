package busiframe.core.generate;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.dao.M_Numbering;

/**
 * 基盤システム構築<br>
 * @version 2024/11/22
 * @version 1.00 新規作成
 */
public class CreateBaseSystem01 {

	/**
	 * 生成実行<br>
	 * @since 2023/11/22
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 採番情報の生成
		M_Numbering num = new M_Numbering();
		num.dropTable(env);
		num.createTable(env);
		// 表示関連情報
		M_Display disp = new M_Display();
		disp.dropTable(env);
		disp.createTable(env);
	}

}
