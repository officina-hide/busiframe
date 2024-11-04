package busiframe.core.jsp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * JSP構造体
 */
public class JspDocument implements I_BaseCharacter{

	/** 出力Path */
	private String jspOutPath;
	/** JSPトップドキュメント */
	private StringBuffer JspDocument;
	
	/**
	 * コンストラクタ : 初期設定を行う。<br>
	 * @since 2024/11/04
	 */
	public JspDocument() {
		// JSP用HTMLヘッダーセット
		JspDocument = createJSPDocument();
	}

	/**
	 * JSP用ドキュメントヘッダー生成<br>
	 * @since 2024/11/04
	 * @return JSP用ドキュメントヘッダ
	 */
	private StringBuffer createJSPDocument() {
		StringBuffer html = new StringBuffer();
		html.append("").append(LF);
		return html;
	}

	/**
	 * JSPソース出力<br>
	 * 出力ファイルPathの表示情報のJSP名を持つJSPファイルを出力する。<br>
	 * @since 2024/11/02
	 */
	public void outputSouece() {
		try {
			// 出力ファイルOpen
			File file = new File(jspOutPath+"/"+"login.jsp");
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
			writer.write("test");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setJspOutPath(String jspOutPath) {
		this.jspOutPath = jspOutPath;
	}

}
