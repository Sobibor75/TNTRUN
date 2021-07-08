package me.sobibor.tntrun.player;

import org.bukkit.entity.Player;

public class User {
    private final UserInfo userInfo;
    private Player player;


    public User(UserInfo userInfo) {
        if (userInfo == null)
            userInfo = new UserInfo(0, 0);
        this.userInfo = userInfo;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        if (player != null)
            this.player = player;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
