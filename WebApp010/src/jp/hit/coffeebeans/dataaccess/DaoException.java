package jp.hit.coffeebeans.dataaccess;

/**
 * データアクセスパッケージに属するクラスでは、利用しているクラスで発生する例外をキャッチして DaoExceptionでラップして再通知します。
 * メッセージには、"データベース関連エラー"を設定します。
 */


public class DaoException extends Exception {
	
	/*
	 * コンストラクタ
	 * @param message
	 * @param cause
	 */
	
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
