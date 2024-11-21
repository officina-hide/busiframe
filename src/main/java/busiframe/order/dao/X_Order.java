package busiframe.order.dao;

import java.time.LocalDate;

/**
 * 受注情報テーブルクラス<br>
 * 本クラスは、テーブル情報と1対1の関係で情報を保持します。<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 */
public class X_Order {

	/** 受注情報ID */
	private int orderId;
	/** 受注日 */
	private LocalDate orderDate;
	
	
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
}
