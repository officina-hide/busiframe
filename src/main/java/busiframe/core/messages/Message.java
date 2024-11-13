package busiframe.core.messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.core.Environment;
import busiframe.core.I_Message;

/**
 * メッセージクラス<br>
 * TODO 
 * @since 2024/11/09
 * @version 1.00 新規作成
 */
public class Message implements I_Message {
	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/**
	 * @param env
	 * @param msgNo
	 * @param strings
	 */
	public void console(Environment env, String msgNo, String...strings) {
		// メッセージ取得
		String msgStr = getMessage(msgNo, strings);
		System.out.println(msgNo+":"+LocalDateTime.now().format(fomat)+":"+msgStr);
	}

	/**
	 * メッセージセット<br>
	 * @since 2024/11/09
	 * @param msgNo メッセージ番号
	 * @param strings 表示情報
	 * @return 表示用メッセージ文字列
	 */
	private String getMessage(String msgNo, String[] strings) {
		String msg = null;
		// TODO 以下はデーへダース化する予定 2024/11/09
		switch(msgNo) {
		case MI_01_001:
			msg = MI_01_001_MSG.replaceAll("<01>", strings[0]);
			break;
		case MI_01_002:
			msg = MI_01_002_MSG.replaceAll("<01>", strings[0]);
			break;
		case MI_02_001:
			msg = MI_02_001_MSG.replaceAll("<01>", strings[0]);
			break;
		case MI_02_002:
			msg = MI_02_002_MSG.replaceAll("<01>", strings[0]);
			break;
		}
		return msg;
	}

}
