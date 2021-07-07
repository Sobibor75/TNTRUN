package me.sobibor.tntrun.state;

import me.sobibor.tntrun.player.User;

import java.util.function.Consumer;

public enum Status {
    WAITING("Ожидание", 10, null),
    GAME("Игра", 300,user -> {
        
    }),
    END("Конец", 310,);

    private final String name;
    private final int time;
    private Consumer<User> consumer;


    Status(String name, int time, Consumer<User> consumer) {
        this.name = name;
        this.time = time;
        this.consumer = consumer;
    }

    public Consumer<User> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<User> consumer) {
        this.consumer = consumer;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
