package busiframe.core.generate;

import busiframe.core.dao.Environment;
import busiframe.order.generate.CreateOrderSystem01;

/**
 * システム生成クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class CreateSystem01 implements BaseGenerate {
	/**
	 *  データベース選択<br>
	 *  1 - ローカル、 2 - VPS 
	 */
	protected static int dbSw = 1;

	public static void main(String[] args) {
		// 開始メッセージ
		System.out.println("システムの生成を開始します。");
		
		// 環境情報設定
		Environment env = new Environment();
		// データベース選択
		env.setDbSw(dbSw);
		// システム管理者をログインユーザーとして設定
		env.setLoginUserId(SYSTEM_USER_ID);
		
		// 基盤システム関連
		CreateBaseSystem01 cbs = new CreateBaseSystem01();
		cbs.execute(env);
		// 受注関連生成
		CreateOrderSystem01 cos = new CreateOrderSystem01();
		cos.execute(env);
		
		// 完了メッセージ
		System.out.println("システムの生成を完了しました。");
	}

}
