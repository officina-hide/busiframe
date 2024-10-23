package busiframe.system.servlet;

import java.time.LocalDateTime;

import busiframe.system.Environment;
import busiframe.system.jsp.CreateLoginJSP;

/**
 * JSPファイル生成実行クラス<br>
 * 
 * @since 2024/10/14
 * @version 1.00 新規作成
 */
public class CreateJSP01 extends BaseCreate {
	/**
	 *  データベース選択<br>
	 *  1 - ローカル、 2 - VPS 
	 */
	protected static int dbSw = 1;

	public static void main(String[] args) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : JSPの生成を開始します。");
		
		// 環境情報設定
		Environment env = new Environment();
		// データベース選択
		env.setDbSw(dbSw);
		// システム管理者をログインユーザーとして設定
		env.setLoginUserId(SYSTEM_USER_ID);
		
		// ログインJSP生成
		CreateLoginJSP clj = new CreateLoginJSP();
		clj.create01(env);
		
		// 完了メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : JSPの生成を完了しました。");
	}

}
