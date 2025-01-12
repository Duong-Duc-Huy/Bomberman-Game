package oop.bomberman.entities;


import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import oop.bomberman.graphics.Sprite;

import java.awt.*;


public abstract class Entity {
    protected int x;
    protected int y;
    protected Image img;
    protected boolean alive;
    protected int layer;

    public Entity() {
    }

    public Entity(int x_unit, int y_unit, Image img) {
        this.x = x_unit * Sprite.SCALED_SIZE;
        this.y = y_unit * Sprite.SCALED_SIZE;
        this.img = img;
        alive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public boolean isAlive() {
        return alive;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
    public Rectangle2D getRect() {
        return new Rectangle2D(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public boolean intersects(Entity entity) {
        return this.getRect().intersects(entity.getRect());
    }

    public boolean contains(Entity entity) {
        return this.getRect().contains(entity.getRect());
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();

}
