package proxy_pattern.demo1;

public class GamePlayer implements IGamePlayer{
	
	private String name="";
	
/*	public GamePlayer(IGamePlayer _GamePlayer,String name){
		if (_GamePlayer==null) {
			throw new RuntimeException("不能创建真是的角色！");
		}else {
			this.name=name;
		}
	}*/
	public GamePlayer(String name){
			this.name=name;
	}
	@Override
	public void login(String user, String password) {
		System.out.println("登录名为"+user+"的用户"+this.name+"登录成功！");
	}

	@Override
	public void killBoss() {
		System.out.println(this.name+"正在打怪！");
	}

	@Override
	public void upgrade() {
		System.out.println(this.name+"升级了！");
	}

}
