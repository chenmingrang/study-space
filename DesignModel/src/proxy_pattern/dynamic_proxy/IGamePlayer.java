package proxy_pattern.dynamic_proxy;

public interface IGamePlayer {
void login(String user,String password);
void killBoss();
void upgrade();
IGamePlayer getProxy();
}
