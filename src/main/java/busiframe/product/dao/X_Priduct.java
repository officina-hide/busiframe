package busiframe.product.dao;

/**
 * 商品情報クラス<br>
 * @since 2024/12/28
 * @version 1.00 新規作成
 */
public class X_Priduct {

	/** 商品ID */
	private int productId;
	/** 商品コード */
	private String productCd;
	/** 商品名 */
	private String name;
	/** 商品説明 */
	private String description;

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
