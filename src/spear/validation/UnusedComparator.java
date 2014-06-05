package spear.validation;

/**
 * Compare two non-terminals and test if they refer to the same semantic object.
 * 
 * @author Dan DaCosta
 * 
 * @param <D>
 *            The first non-terminal.
 * @param <U>
 *            The second non-terminal.
 */
public abstract class UnusedComparator<D, U> {
	public abstract boolean same(D d, U u);
}
