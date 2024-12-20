package al.tonikolaba.entity;

import al.tonikolaba.handlers.Content;
import al.tonikolaba.tilemap.TileMap;

import java.awt.image.BufferedImage;

/**
 * @author ArtOfSoul
 */

import java.security.SecureRandom;

public class EnergyParticle extends MapObject {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static final int ENERGY_UP = 0;
    public static final int ENERGY_LEFT = 1;
    public static final int ENERGY_DOWN = 2;
    public static final int ENERGY_RIGHT = 3;
    private int count;
    private boolean remove;
    private BufferedImage[] sprites;

    public EnergyParticle(TileMap tm, double x, double y, int dir) {
        super(tm);
        this.x = x;
        this.y = y;

        double d1 = SECURE_RANDOM.nextDouble() * 2.5 - 1.25;
        double d2 = -SECURE_RANDOM.nextDouble() - 0.8;

        if (dir == ENERGY_UP) {
            dx = d1;
            dy = d2;
        } else if (dir == ENERGY_LEFT) {
            dx = d2;
            dy = d1;
        } else if (dir == ENERGY_DOWN) {
            dx = d1;
            dy = -d2;
        } else {
            dx = -d2;
            dy = d1;
        }

        count = 0;
        sprites = Content.getEnergyParticle()[0];
        animation.setFrames(sprites);
        animation.setDelay(-1);
    }

    public void update() {
        x += dx;
        y += dy;
        count++;
        if (count == 60)
            remove = true;
    }

    public boolean shouldRemove() {
        return remove;
    }
}
