package lesson7;

/**
 * homework lesson7
 *
 * @author Amina
 * 28.05.2021
 */
public enum Priority {
    ONE(1),
    TWO(2),
    TREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    public final int level;

    Priority(int level) {
        this.level = level;
    }
}
