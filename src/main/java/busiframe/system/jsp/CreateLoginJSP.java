package busiframe.system.jsp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import busiframe.system.Environment;
import busiframe.system.servlet.BaseCreate;

/**
 * ログイン用JSP生成クラス<br>
 * @since 2024/10/15
 * @version 1.00 新規作成
 */
public class CreateLoginJSP extends BaseCreate  {

	/**
	 * ログイン用JSP生成(Lv.01)
	 * TODO 本メソッドの変更もしくは非推奨になる可能性があります。 2024/10/15
	 * @param env 環境情報
	 */
	public void create01(Environment env) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : ログオンJSPの生成を開始します。");
		// 生成用ファイルOpen
		try {
			JspSource js = new JspSource();
			js.setTitle("ログイン Lv.01");
			js.setActionURI("./login01");
			js.create();
			Path path = Paths.get(".\\src\\main\\webapp", "login.jsp");
			BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(js.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
