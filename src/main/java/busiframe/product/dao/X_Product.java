package busiframe.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 商品情報クラス<br>
 * @since 2024/12/28
 * @version 1.00 新規作成
 */
public class X_Product implements I_Product {

	/** 商品ID */
	private int productId;
	/** 商品コード */
	private String productCd;
	/** 商品名 */
	private String name;
	/** 商品説明 */
	private String description;

	/**
	 * 検索結果から項目をセットする。<br>
	 * @since 2025/01/29
	 * @param rs 環境情報
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setProductId(rs.getInt(COL_NAME_PRODUCT_ID));
		setProductCd(rs.getString(COL_NAME_PRODUCT_CD));
		setName(rs.getString(COL_NAME_NAME));
		setDescription(rs.getString(COL_NAME_DESCRIPTION));
	}
	
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
