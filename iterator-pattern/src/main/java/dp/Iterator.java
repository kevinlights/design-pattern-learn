package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
interface Iterator {
    void first();
    void next();
    boolean hasNext();
    Object currentItem();
}
