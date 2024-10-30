package busiframe.system.generate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.system.Environment;
import busiframe.system.dao.X_Sys_Disp;
import busiframe.system.dao.X_Sys_DispDetail;
import busiframe.system.servlet.I_BaseCreate;

/**
 * システム生成クラス<br>
 */
public class CreateSystem01 implements I_BaseCreate {
	/**
	 *  データベース選択<br>
	 *  1 - ローカル、 2 - VPS 
	 */
	protected static int dbSw = 1;

	/** 表示日付書式 */
	protected static DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now().format(fomat) + " : システムの構築を開始します。");
		
		// 環境情報設定
		Environment env = new Environment();
		// データベース選択
		env.setDbSw(dbSw);
		// システム管理者をログインユーザーとして設定
		env.setLoginUserId(SYSTEM_USER_ID);

		// 表示情報関連生成
		X_Sys_Disp disp = new X_Sys_Disp();
		disp.create(env);
		X_Sys_DispDetail dd = new X_Sys_DispDetail();
		dd.create(env);
		
		System.out.println(LocalDateTime.now().format(fomat) + " : システムの構築完了しました。");
	}

}
