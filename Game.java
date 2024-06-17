package com.yourproject;

/**
 * Represents a Game entity with its attributes.
 */
public class Game {

    private String gameName;
    private String aspect;
    private double value;
    private String releaseDate;
    private String platforms;

    /**
     * Constructs a new Game with the specified attributes.
     * @author jenil
     *
     * @param gameName    The name of the game.
     * @param aspect      The aspect of the game.
     * @param value       The value of the aspect for the game.
     * @param releaseDate The release date of the game.
     * @param platforms   The platforms on which the game is available.
     */
    public Game(String gameName, String aspect, double value, String releaseDate, String platforms) {
        this.gameName = gameName;
        this.aspect = aspect;
        this.value = value;
        this.releaseDate = releaseDate;
        this.platforms = platforms;
    }

    /**
     * Retrieves the name of the game.
     *
     * @return The name of the game.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Sets the name of the game.
     *
     * @param gameName The name of the game.
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Retrieves the aspect of the game.
     *
     * @return The aspect of the game.
     */
    public String getAspect() {
        return aspect;
    }

    /**
     * Sets the aspect of the game.
     *
     * @param aspect The aspect of the game.
     */
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    /**
     * Retrieves the value of the aspect for the game.
     *
     * @return The value of the aspect.
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the aspect for the game.
     *
     * @param value The value of the aspect.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Retrieves the release date of the game.
     *
     * @return The release date of the game.
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the game.
     *
     * @param releaseDate The release date of the game.
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Retrieves the platforms on which the game is available.
     *
     * @return The platforms on which the game is available.
     */
    public String getPlatforms() {
        return platforms;
    }

    /**
     * Sets the platforms on which the game is available.
     *
     * @param platforms The platforms on which the game is available.
     */
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    /**
     * Returns a string representation of the Game object.
     *
     * @return A string representation of the Game object.
     */
    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", aspect='" + aspect + '\'' +
                ", value=" + value +
                ", releaseDate='" + releaseDate + '\'' +
                ", platforms='" + platforms + '\'' +
                '}';
    }
}
