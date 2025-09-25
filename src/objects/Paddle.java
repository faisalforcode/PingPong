package objects;

import java.awt.*;

/**
 * Represents a paddle in the Pong game.
 * Handles position, movement, and boundary logic for a player paddle.
 */
public class Paddle {
    private int x, y, width, height, speed; // Paddle position, size, and movement speed

    /**
     * Constructs a Paddle object with specified position, size, and speed.
     * @param x Initial X position
     * @param y Initial Y position
     * @param width Paddle width
     * @param height Paddle height
     * @param speed Movement speed per update
     */
    public Paddle(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    /**
     * Moves the paddle up by its speed.
     */
    public void moveUp() {
        y -= speed;
    }

    /**
     * Moves the paddle down by its speed.
     */
    public void moveDown() {
        y += speed;
    }

    /**
     * Keeps the paddle within the vertical bounds of the game window.
     * @param minY Minimum Y position (top boundary)
     * @param maxY Maximum Y position (bottom boundary)
     */
    public void stayInBounds(int minY, int maxY) {
        if (y < minY) y = minY;
        if (y + height > maxY) y = maxY - height;
    }

    /**
     * Returns the bounding rectangle for collision detection.
     * @return Rectangle representing the paddle's bounds
     */
    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    // Getters
    /** @return Current X position */
    public int getX() { return x; }
    /** @return Current Y position */
    public int getY() { return y; }
    /** @return Paddle width */
    public int getWidth() { return width; }
    /** @return Paddle height */
    public int getHeight() { return height; }
}
