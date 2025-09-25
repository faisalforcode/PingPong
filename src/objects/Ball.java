package objects;

import java.awt.*;

/**
 * Represents the ball in the Pong game.
 * Handles position, movement, velocity, and collision logic.
 */
public class Ball {
    private int x, y, size; // Ball position and size
    private double velocityX, velocityY; // Ball velocity in X and Y directions
    private static final double BASE_SPEED = 4.0; // Initial speed
    private static final double MAX_SPEED = 8.0;  // Maximum speed

    /**
     * Constructs a Ball object at the specified position and size.
     * @param x Initial X position
     * @param y Initial Y position
     * @param size Diameter of the ball
     */
    public Ball(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        resetVelocity(-1); // Start going left
    }

    /**
     * Updates the ball's position and gradually increases its speed.
     */
    public void update() {
        x += velocityX;
        y += velocityY;

        // Gradually increase speed (up to max)
        if (Math.abs(velocityX) < MAX_SPEED) {
            velocityX *= 1.001; // Very gradual increase
        }
    }

    /**
     * Reverses the ball's horizontal direction (used for paddle/wall collision).
     */
    public void reverseX() {
        velocityX = -velocityX;
    }

    /**
     * Reverses the ball's vertical direction (used for wall collision).
     */
    public void reverseY() {
        velocityY = -velocityY;
    }

    /**
     * Adjusts the ball's vertical velocity, e.g. for adding spin.
     * @param adjustment Amount to adjust Y velocity by
     */
    public void adjustYVelocity(double adjustment) {
        velocityY += adjustment;
        // Clamp Y velocity to reasonable bounds
        if (velocityY > MAX_SPEED) velocityY = MAX_SPEED;
        if (velocityY < -MAX_SPEED) velocityY = -MAX_SPEED;
    }

    /**
     * Resets the ball's position and velocity for a new round.
     * @param newX New X position
     * @param newY New Y position
     * @param direction Direction for ball to move (-1 for left, 1 for right)
     */
    public void reset(int newX, int newY, int direction) {
        this.x = newX;
        this.y = newY;
        resetVelocity(direction);
    }

    /**
     * Sets the ball's velocity for a new round.
     * @param direction Direction for ball to move (-1 for left, 1 for right)
     */
    private void resetVelocity(int direction) {
        velocityX = BASE_SPEED * direction;
        velocityY = (Math.random() - 0.5) * 2; // Random Y direction
    }

    /**
     * Returns the bounding rectangle for collision detection.
     * @return Rectangle representing the ball's bounds
     */
    public Rectangle getRectangle() {
        return new Rectangle(x, y, size, size);
    }

    /**
     * Returns the vertical center of the ball (for spin calculations).
     * @return Y coordinate of the ball's center
     */
    public int getCenterY() {
        return y + size/2;
    }

    // Getters and setters
    /** @return Current X position */
    public int getX() { return x; }
    /** @return Current Y position */
    public int getY() { return y; }
    /** @return Ball diameter */
    public int getSize() { return size; }
    /** Sets the X position */
    public void setX(int x) { this.x = x; }
    /** Sets the Y position */
    public void setY(int y) { this.y = y; }
}
