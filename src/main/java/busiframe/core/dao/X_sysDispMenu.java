package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表示メニュー情報クラス<br>
 * @since 2024/12/07
 * @version 1.00 新規作成
 */
public class X_sysDispMenu implements I_SysDispMenu {

	/** 表示メニュー情報ID */
	private int dispMenuId;
	/** 表示情報ID */
	private int dispId;
	/** 表示メニュー識別コード */
	private String dispMenuCd;
	/** メニュータイトル */
	private String menuTItle;
	/** メニューアクション */
	private String menuAction;
	/** メニュー行番号 */
	private int menuRowNo;
	
	/**
	 * 検索結果からの項目セット<br>
	 * @since 2024/12/09
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setDispMenuId(rs.getInt(COL_NAME_DISPMENU_ID));
		setDispId(rs.getInt(I_SysDisp.COL_NAME_DISP_ID));
		setDispMenuCd(rs.getString(COL_NAME_DISPMENU_CD));
		setMenuTItle(rs.getString(COL_NAME_MENU_TITLE));
		setMenuAction(rs.getString(COL_NAME_MENU_ACTION));
		setMenuRowNo(rs.getInt(COL_NAME_MENU_ROW_NO));
	}

	public int getDispMenuId() {
		return dispMenuId;
	}

	public void setDispMenuId(int dispMenuId) {
		this.dispMenuId = dispMenuId;
	}

	public int getDispId() {
		return dispId;
	}

	public void setDispId(int dispId) {
		this.dispId = dispId;
	}

	public String getDispMenuCd() {
		return dispMenuCd;
	}

	public void setDispMenuCd(String dispMenuCd) {
		this.dispMenuCd = dispMenuCd;
	}

	public String getMenuTItle() {
		return menuTItle;
	}

	public void setMenuTItle(String menuTItle) {
		this.menuTItle = menuTItle;
	}

	public String getMenuAction() {
		return menuAction;
	}

	public void setMenuAction(String menuAction) {
		this.menuAction = menuAction;
	}

	public int getMenuRowNo() {
		return menuRowNo;
	}

	public void setMenuRowNo(int menuRowNo) {
		this.menuRowNo = menuRowNo;
	}

}
