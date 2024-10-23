package busiframe.system.servlet;

import java.time.format.DateTimeFormatter;

/**
 * 生成用共用クラス<br>
 * 本クラスは、各生成クラスで共通に使われる機能を提供します。<br>
 * TODO 機能及びパッケージ一位置については変更される可能性があります。<br>
 * @since 2024/10/14
 * @version 1.00 新規作成
 */
public class BaseCreate implements I_BaseCreate {
	
	
	/** 表示日付書式 */
	protected static DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

}
