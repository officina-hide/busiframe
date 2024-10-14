package busiframe.system.servlet;

import java.time.LocalDateTime;

/**
 * JSPファイル生成実行クラス<br>
 * 
 * @since 2024/10/14
 * @version 1.00 新規作成
 */
public class CreateJSP01 extends BaseCreate {

	public static void main(String[] args) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : JSPの生成を開始します。");
		// 完了メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : JSPの生成を完了しました。");
	}

}
