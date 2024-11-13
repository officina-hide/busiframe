package budiframe.generate;

import busiframe.core.Environment;
import busiframe.core.I_Message;
import busiframe.core.dao.M_SysDisp;
import busiframe.core.messages.Message;

/**
 * 表示情報関連生成<br>
 * 本クラスでは、JSP関連の表示に必要なテーブルの生成と初期情報の登録を行う。<br>
 * @since 2024/11/09
 * @version 1.00 新規作成																																																													
 */
public class CreateDisp implements I_Generate, I_Message {

	public static void main(String[] args) {
		// 環境設定
		Environment env = new Environment();
		env.setDbSw(env.DBSW_LOCAL);
		// システム管理者をログインユーザーとして設定
		env.setLoginUserId(SYSTEM_USER_ID);
		
		// 開始メッセージ
		Message msg = new Message();
		msg.console(env, MI_01_001, "表示情報関連の生成");
		// 表示情報テーブル構築
		M_SysDisp disp = new M_SysDisp();
		disp.createTable(env);
		disp.addData(env, 10001, "login01", "ログイン Lv.01");
				
		// 完了メッセージ
		msg.console(env, MI_01_002, "表示情報関連の生成");
	}

}
