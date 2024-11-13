package busiframe.core.jsp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import busiframe.core.dao.M_SysDisp;

/**
 * JSP構造体
 */
public class JspDocument implements I_BaseCharacter{

	/** 表示情報 */
	private M_SysDisp disp = new M_SysDisp();
	
	/** 出力Path */
	private String jspOutPath;
	/** JSPトップドキュメント */
	private StringBuffer document;
	/** JSPトークン */
	private JSP_Page page = new JSP_Page();
	private JSP_Taglib core = new JSP_Taglib("c","jakarta.tags.core");
	private JSP_Taglib fmt = new JSP_Taglib("fmt","jakarta.tags.fmt");
	/** htmlトークン */
	private HtmlToken html = new HtmlToken();
	
	/**
	 * コンストラクタ : 初期設定を行う。<br>
	 * @since 2024/11/04
	 */
	public JspDocument() {
		// JSP用HTMLヘッダーセット
//		document = createJSPDocument();
	}

	/**
	 * JSPソース出力<br>
	 * 出力ファイルPathの表示情報のJSP名を持つJSPファイルを出力する。<br>
	 * @param jd 
	 * @since 2024/11/02
	 */
	public void outputSouece() {
		try {
			// 出力ファイルOpen
			File file = new File(jspOutPath+"/"+"login.jsp");
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
			document = createJSPDocument();
			writer.write(document.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * JSP用ドキュメントヘッダー生成<br>
	 * @since 2024/11/04
	 * @return JSP用ドキュメントヘッダ
	 */
	private StringBuffer createJSPDocument() {
		StringBuffer hl = new StringBuffer();
		hl.append(page.toString()).append(LF);
		hl.append(core.toString()).append(LF);
		hl.append(fmt.toString()).append(LF);
		hl.append("<!DOCTYPE html>").append(LF);
		html.setDisp(disp);
		html.create();
		hl.append(html.toString());
		return hl;
	}

	public void setJspOutPath(String jspOutPath) {
		this.jspOutPath = jspOutPath;
	}
	public void setDisp(M_SysDisp disp) {
		this.disp = disp;
	}

}
