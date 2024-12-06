package busiframe.core.generate;

import busiframe.core.dao.Environment;
import busiframe.core.dao.I_SysDispDetail;
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
		// 表示詳細情報用採番情報の登録 Addition 2024/12/07
		M_Numbering num_disp = new M_Numbering();
		num_disp.getNumbering().setNumberingId(I_SysDispDetail.TABLE_ID_SYS_DISPDETAIL);
		num_disp.getNumbering().setCurrentNumber(100000);
		num_disp.getNumbering().setTableId(I_SysDispDetail.TABLE_ID_SYS_DISPDETAIL);
		num_disp.save(env);
	}

}
