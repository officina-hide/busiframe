package busiframe.core.jsp;

import busiframe.core.Environment;
import busiframe.core.dao.M_SysDisp;

/**
 * JSP生成実行用クラス<br>
 * TODO 本クラスの目的は、各種のJSP生成クラスのテスト用として使用されます。<br>
 * @since 2024/11/01
 * @version 1.00 新規作成
 */
public class CreateJSP01 {

	public static void main(String[] args) {
		//環境設定
		Environment env = new Environment();
		env.setDbSw(env.DBSW_LOCAL);
		
		// ログインの表示情報を取得する。
		M_SysDisp disp = new M_SysDisp();
		disp.loadByCd(env, "login01");
		// ログインLv.01のJSPを生成する。
		JspDocument jd = new JspDocument();
		jd.setJspOutPath("./src/main/webapp");
		jd.outputSouece();
	}

}
