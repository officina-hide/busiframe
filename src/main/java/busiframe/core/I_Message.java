package busiframe.core;

/**
 * メッセージ情報インターフェースクラス<br>
 * TODO 以下の分類は変更される場合があります。<br>
 * M - メッセージ<br>
 * I - お知らせ、E - エラー、W - 警告<br>
 * 01 - システム関連、02 - SQL関連<br>
 * 
 * @since 2024/11/09
 * @version 1.00 新規作成 2024/11/09
 */
public interface I_Message {

	// メッセージ番号
	// システム関連
	/** MI01001 : 処理開始メッセージ */
	public final String MI_01_001 = "MI01001";	
	public final String MI_01_001_MSG = "<01>の処理を開始します。";
	/** MI01002 : 処理終了メッセージ */
	public final String MI_01_002 = "MI01002";	
	public final String MI_01_002_MSG = "<01>の処理を完了しました。。";
	
	// SQL関連
	/** MI02001 : テーブル等構築完了メッセージ */
	public final String MI_02_001 = "MI02001";
	public final String MI_02_001_MSG = "<01>の構築を完了しました。";
	/** MI02002 : テーブル情報新規登録メッセージ */
	public final String MI_02_002 = "MI02002";
	public final String MI_02_002_MSG = "<01>を新規登録しました。";
}
