package al.tonikolaba.entity.enemies;

import al.tonikolaba.entity.Enemy;
import al.tonikolaba.handlers.Content;
import al.tonikolaba.tilemap.TileMap;
import java.security.SecureRandom;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author ArtOfSoul
 */

public class Zogu extends Enemy {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private BufferedImage[] idleSprites;

    private int tick;
    private double a;
    private double b;

    public Zogu(TileMap tm) {

        super(tm);

        health = maxHealth = 2;

        width = 39;
        height = 20;
        cwidth = 25;
        cheight = 15;

        damage = 1;
        moveSpeed = 5;

        idleSprites = Content.getZogu()[0];

        animation.setFrames(idleSprites);
        animation.setDelay(4);

        tick = 0;
        a = SECURE_RANDOM.nextDouble() * 0.06 + 0.07;
        b = SECURE_RANDOM.nextDouble() * 0.06 + 0.07;

    }

    @Override
    public void update() {

        // check if done flinching
        if (flinching) {
            flinchCount++;
            if (flinchCount == 6)
                flinching = false;
        }

        tick++;
        x = Math.sin(a * tick) + x;
        y = Math.sin(b * tick) + y;

        // update animation
        animation.update();

    }

    @Override
    public void draw(Graphics2D g) {

        if (flinching && (flinchCount == 0 || flinchCount == 2)) {
            return;
        }

        super.draw(g);

    }

}
