package busiframe.educate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 教育カテゴリー情報クラス<br>
 * @since 2024/12/16
 * @version 1.00 新規作成
 */
public class X_EduCategory implements I_EduCategory {

	/** 教育カテゴリー情報ID */
	private int categoryId;
	/** 教育カテゴリー識別コード */
	private String categoryCd;
	/** 教育カテゴリー名 */
	private String categoryName;
	
	/**
	 * 検索結果から項目をセットする。<br>
	 * @since 2024/12/17
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setCategoryId(rs.getInt(COL_NAME_CATEGORY_ID));
		setCategoryCd(rs.getString(COL_NAME_CATEGORY_CD));
		setCategoryName(rs.getString(COL_NAME_CATEGORY_NAME));
	}

	public int getCategoryId() {
		return categoryId;
	}
	
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCd() {
		return categoryCd;
	}
	public void setCategoryCd(String categoryCd) {
		this.categoryCd = categoryCd;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
