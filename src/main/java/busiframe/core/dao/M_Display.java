package busiframe.core.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 表示関連情報クラス<br>
 * @since 2024/11/26
 * @version 1.00 新規作成
 */
public class M_Display extends BaseDAO implements Serializable, I_SysDisp, I_SysDispDetail, I_SysDispMenu, I_SysDIspProcess {

	private static final long serialVersionUID = 1L;

	/** 表示情報 */
	private X_SysDisp dispData = new X_SysDisp();
	/** 表示詳細情報リスト */
	private List<X_sysDispDetail> details = new ArrayList<>();
	/** 表示メニュー情報リスト */
	private List<X_sysDispMenu> menus = new ArrayList<>();
	/** 表示処理情報リスト */
	private List<X_sysDispProcess> processes = new ArrayList<>();
	
	/**
	 * テーブル削除<br>
	 * @since 2024/11/27
	 * @param env 関連情報
	 */
	public void dropTable(Environment env) {
		// 表示処理情報テーブル削除 Addition 2025/01/16
		dropTable(env, TABLE_NAME_SYS_DISPPROCESS);
		// 表示詳細テーブル削除
		dropTable(env, TABLE_NAME_SYS_DISPDETAIL);
		// 表示メニュー情報テーブル削除 Addition 2024/12/05
		dropTable(env, TABLE_NAME_SYS_DISPMENU);

		// 表示情報テーブル削除
		dropTable(env, TABLE_NAME_SYS_DISP);
	}

	/**
	 * テーブル構築<br>
	 * @since 2024/11/27
	 * @param env 関連情報
	 */
	public void createTable(Environment env) {
		// 表示情報テーブル構築
		createTable(env, TABLE_NAME_SYS_DISP, TABLE_COMMENT_SYS_DISP,
				COL_NAME_DISP_ID, COL_COMMENT_DISP_ID);
		addColumn(env, COL_ALTER_DISP_CD);
		addColumn(env, COL_ALTER_DISP_TITLE);		// Addition 2024/12/04
		addColumn(env, COL_ALTER_TABLE_ID_ORDER);	// Addition 2025/03/24
		// 表示詳細情報テーブル構築
		createTable(env, TABLE_NAME_SYS_DISPDETAIL, TABLE_COMMENT_SYS_DISPDETAIL,
				COL_NAME_DISP_DETAIL_ID, COL_COMMENT_DISP_DETAIL_ID);
		addColumn(env, COL_ALTER_DISP_ID_SYS_DISPDETAIL);
		addColumn(env, COL_ALTER_ITEM_CD);
		addColumn(env, COL_ALTER_ITEM_SEQ);
		addColumn(env, COL_ALTER_ITEM_LABEL);
		addColumn(env, COL_ALTER_ITEM_TYPE);
		// 表示メニュー情報テーブル構築
		createTable(env, TABLE_NAME_SYS_DISPMENU, TABLE_COMMENT_SYS_DISPMENU,
				COL_NAME_DISPMENU_ID, COL_COMMENT_DISPMENU_ID);
		addColumn(env, COL_ALTER_DISP_ID_DISPMENU);
		addColumn(env, COL_ALTER_DISPMENU_CD);
		addColumn(env, COL_ALTER_MENU_TITLE);
		addColumn(env,COL_ALTER_MENU_ACTION);
		addColumn(env, COL_ALTER_MENU_ROW_NO);
		// 表示処理情報テーブル構築 Addition 2025/01/16
		createTable(env, TABLE_NAME_SYS_DISPPROCESS, TABLE_COMMENT_SYS_DISPPROCESS,
				COL_NAME_DISP_PROCESS_ID, COL_COMMENT_DISP_PROCESS_ID);
		addColumn(env, I_SysDIspProcess.COL_ALTER_DISP_ID_SYS_DISPPROCESS);
		addColumn(env, COL_ALTER_BUTTON_TITLE);
		addColumn(env, COL_ALTER_ACTION_URL);
		addColumn(env, COL_ALTER_ACTION_NAME);

	}

	/**
	 * 表示情報登録<br>
	 * @since 2024/11/28
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param dispCd 表示識別コード
	 * @param dispTitle 表示タイトル Addition 2024/12/04
	 */
	public void addDispData(Environment env, int dispId, String dispCd, String dispTitle) {
		addDispData(env, dispId, dispCd, dispTitle, 0);
	}

	/**
	 * 表示情報登録 Lv.02<br>
	 * テーブルID指定
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param dispCd 表示識別コード
	 * @param dispTitle 表示タイトル Addition 2024/12/04
	 * @param tableId　テーブル情報ID
	 */
	public void addDispData(Environment env,  int dispId, String dispCd, String dispTitle, int tableId) {
		PreparedStatement pstmt = null;
		getDispData().setDispId(dispId);
		getDispData().setDispCd(dispCd);
		getDispData().setDispTitle(dispTitle);
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_DISP);
			pstmt.setInt(1, getDispData().getDispId());
			pstmt.setString(2, getDispData().getDispCd());
			pstmt.setString(3, getDispData().getDispTitle());		// Addition 2024/12/04
			pstmt.setInt(4, tableId);	// Addition 2025/03/24
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * 表示詳細情報登録<br>
	 * @since 2024/11/28
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param itemCd 項目識別コード
	 * @param itemSeq 項目並び順
	 * @param itemLabel 項目ラベル
	 * @param itemType 属性名
	 */
	public void addDispDetailData(Environment env, int dispId, String itemCd, int itemSeq, String itemLabel, String itemType) {
		PreparedStatement pstmt = null;
		// 表示詳細情報ID採番
		M_Numbering num = new M_Numbering();
		int dispdetailId = num.newNumber(env, TABLE_ID_SYS_DISPDETAIL);
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_DISPDETAIL);
			pstmt.setInt(1, dispdetailId);
			pstmt.setInt(2, dispId);
			pstmt.setString(3, itemCd);
			pstmt.setInt(4, 1);
			pstmt.setString(5, itemLabel);
			pstmt.setString(6, itemType);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
	
	/**
	 * 表示メニュー情報登録<br>
	 * @since 2024/12/07
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @param menuCd メニュー識別コード
	 * @param menuTItle メニュータイトル
	 * @param menuAction メニューアクション
	 * @param namuRowNo メニュー行番号	Addition 2025/03/01
	 */
	public void addMenuData(Environment env, int dispId, String menuCd, String menuTItle, String menuAction,
			int namuRowNo) {
		PreparedStatement pstmt = null;
		M_Numbering num = new M_Numbering();
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_DISPMENU);
			pstmt.setInt(1, num.newNumber(env, TABLE_ID_SYS_DISPMENU));
			pstmt.setInt(2, dispId);
			pstmt.setString(3, menuCd);
			pstmt.setString(4, menuTItle);
			pstmt.setString(5, menuAction);
			pstmt.setInt(6, namuRowNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * 表示処理情報登録<br>
	 * @since 2025/01/21
	 * @param env 環境情報
	 * @param dispprocessId 表示処理情報ID
	 * @param dispId 表示情報ID
	 * @param buttonTitle ボタンタイトル
	 * @param actionURL アクションURL
	 * @param actionName アクション名
	 */
	public void addDispProcessData(Environment env, int dispprocessId, int dispId, String buttonTitle,
			String actionURL, String actionName) {
		PreparedStatement pstmt = null;
		M_Numbering num = new M_Numbering();
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(I_SysDIspProcess.SQL_INSERT);
			pstmt.setInt(1, num.newNumber(env, TABLE_ID_SYS_DISPPROCESS));
			pstmt.setInt(2, dispId);
			pstmt.setString(3, buttonTitle);
			pstmt.setString(4, actionURL);
			pstmt.setString(5, actionName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * 取得<br>
	 * @deprecated 2025/02/06 出来る限りIDから取得するようにする。しばらくは必要かとヴかを判定する(2025/10くらいまで）<br>
	 * @param env 環境情報
	 * @param dispCd 表示識別コード
	 */
	public void load(Environment env, String dispCd) {
		// 表示情報を取得する。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPCD);
			pstmt.setString(1, dispCd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dispData.setItems(rs);
			}
			if(dispData.getDispId() > 0) {
				// 表示詳細情報取得
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPDETAIL);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispDetail detail = new X_sysDispDetail();
					detail.setItems(rs);
					getDetails().add(detail);
				}
				// 表示メニュー情報取得
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPMENU);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispMenu menu = new X_sysDispMenu();
					menu.setItems(rs);
					getMenus().add(menu);
				}
				// 表示処理情報取得 Addition 2025/01/22
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPPROCESS);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispProcess process = new X_sysDispProcess();
					process.setItems(rs);
					getProcesses().add(process);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
	}

	/**
	 * 取得(表示情報ID)<br>
	 * 説明 : 表示情報IDを持つ表示情報を取得し、関連する表示詳細、メニュー、処理の子情報も取得する。<br>
	 * @since 2025/02/06
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 */
	public void load(Environment env, int dispId) {
		// 表示情報を取得する。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPID);
			pstmt.setInt(1, dispId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dispData.setItems(rs);
			}
			if(dispData.getDispId() > 0) {
				// 表示詳細情報取得
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPDETAIL);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispDetail detail = new X_sysDispDetail();
					detail.setItems(rs);
					getDetails().add(detail);
				}
				// 表示メニュー情報取得
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPMENU);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispMenu menu = new X_sysDispMenu();
					menu.setItems(rs);
					getMenus().add(menu);
				}
				// 表示処理情報取得 Addition 2025/01/22
				pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPPROCESS);
				pstmt.setInt(1, dispData.getDispId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					X_sysDispProcess process = new X_sysDispProcess();
					process.setItems(rs);
					getProcesses().add(process);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
	}

	public X_SysDisp getDispData() {
		return dispData;
	}

	public List<X_sysDispDetail> getDetails() {
		if(details == null) {
			details = new ArrayList<>();
		}
		return details;
	}

	public List<X_sysDispMenu> getMenus() {
		if(menus == null) {
			menus = new ArrayList<>();
		}
		return menus;
	}

	public List<X_sysDispProcess> getProcesses() {
		if(processes == null) {
			processes = new ArrayList<>();
		}
		return processes;
	}

}
