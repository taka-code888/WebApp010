package jp.hit.coffeebeans.service;

/*
 * サービスパッケージに属するクラスでは、　下位情報で発生する例外をキャッチして
 * ServiceExceptionでラップして再通知します
 * メッセージには”サービス関連エラー”を設定します
 */


public class ServiceException extends Exception {
	
	/*
	 *@param message
	 *@param cause 
	 */
	
	public ServiceException(String message, Throwable cause) {
		// TODO 自動生成されたコンストラクター・スタブ
	    super(message, cause);
		
	}

}
