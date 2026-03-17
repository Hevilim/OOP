package io.github.goblinvault.entity;

public interface Attackable {
    void takeDamage(int damage);
    boolean isAlive();
}
