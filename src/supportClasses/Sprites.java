package supportClasses;

public enum Sprites {
    GRASS("\uD83C\uDF3E "),
    ROCK("\uD83E\uDEA8 "),
    TREE("\uD83C\uDF33 "),
    PREDATOR("\uD83D\uDC3A "),
    HERBIVORE("\uD83D\uDC07 "),
    EMPTY_PLACE("   ");
    private String sprite;

    Sprites(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
