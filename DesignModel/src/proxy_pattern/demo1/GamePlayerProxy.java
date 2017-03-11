package proxy_pattern.demo1;

public class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer = null;

	/*
	 * public GamePlayerProxy(String name){ gamePlayer=new GamePlayer(this,
	 * name); }
	 */
	public GamePlayerProxy(String name) {
		gamePlayer = new GamePlayer(name);
	}

	@Override
	public void login(String user, String password) {
		gamePlayer.login(user, password);
	}

	@Override
	public void killBoss() {
		gamePlayer.killBoss();
	}

	@Override
	public void upgrade() {
		gamePlayer.upgrade();
	}

}
