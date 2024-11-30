package busiframe.order.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 受注情報テーブルクラス<br>
 * 本クラスは、テーブル情報と1対1の関係で情報を保持します。<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 */
public class X_Order01 implements I_Order01 {

	/** 受注情報ID */
	private int orderId;
	/** 受注日 */
	private LocalDate orderDate;
	/** 相手先名 addition 2024/11/25 */
	private String partnerName;
	/** 商品名 Addition 2024/11/30 */
	private String productName;
	/** 受注数 Addition 2024/11/30 */
	private BigDecimal orderNumber;
	/** 受注金額 Addition 2024/11/30 */
	private BigDecimal orderAmount;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}
}
