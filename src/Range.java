import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class {@code Range} represents a sequence of integers. Since a {@code Range} is {@link Iterable},
 * it can be used as the target of an enhanced-for loop (see examples in constructor descriptions.)
 *
 * @author Asaph Grushkin
 */
public class Range implements Iterable<Integer>, Iterator<Integer> {

    /**
     * Fieldy fields. Self-explanatory. Beginning of range, end of range, steps (for 3-arg
     * constructor) and position in range
     */
    int rangeStart;

    /**
     * Fieldy fields. Self-explanatory. End of range (duh)
     */
    int rangeEnd;

    /**
     * Fieldy fields. Self-explanatory. Size of steps (for 3-arg constructor)
     */
    int rangeStep = 1;

    /**
     * Fieldy fields. Self-explanatory. Position within range for iteration Iteration across the
     * nation
     */
    int rangePos;

    /**
     * Constructs a {@code Range} from {@code 0} (inclusive) to {@cod e stop} (exclusive).
     * <p>e.g. the following would print values from 0 to 9:
     * <pre>{@code
     * for (int val : new Range(10))
     *   System.out.println(val);
     * }</pre>
     *
     * @param stop the exclusive upper bound of this range
     * @throws IllegalArgumentException if {@code stop} is nonpositive
     */
    public Range(int stop) {
        rangeStart = 0;
        rangeEnd = stop;
        rangeStep = 1;
        if (stop <= 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructs a {@code Range} from {@code start} (inclusive) to {@code stop} (exclusive).
     *
     * <p>e.g. the following would print values from 20 to 29:
     *
     * <pre>{@code
     * for (int val : new Range(20, 30))
     *   System.out.println(val);
     * }</pre>
     *
     * @param start the inclusive lower bound of this range
     * @param stop  the exclusive upper bound of this range
     * @throws IllegalArgumentException if {@code stop <= start}
     */
    public Range(int start, int stop) {
        rangeStart = start;
        rangePos = start;
        rangeEnd = stop;
        rangeStep = 1;
        if (stop <= start) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructs a {@code Range} from {@code start} (inclusive) to {@code stop} (exclusive), moving
     * by {@code step} in each iteration.
     * <p>e.g. the following would print multiples of 100 between 0 and 1000:
     * <pre>{@code
     * for (int val : new Range(0, 1001, 100))
     *   System.out.println(val);
     * }</pre>
     *
     * @param start the inclusive lower bound of this range
     * @param stop  the exclusive upper bound of this range
     * @param step  the amount by which the range increases in each iteration
     * @throws IllegalArgumentException if the combination of arguments would result in an infinite
     *                                  sequence (or require overflow to complete)
     */
    public Range(int start, int stop, int step) {

        if (step > 0) {
            rangeStart = start;
            rangeEnd = stop;
            rangePos = start;
            rangeStep = step;
            if (rangeEnd < rangeStart || rangeEnd - rangeStart < rangeStep || step == 0) {
                throw new IllegalArgumentException();
            }
        }
        if (step < 0) {
            rangeStart = start;
            rangeEnd = stop;
            rangePos = start;
            rangeStep = step;
            if (start < stop || Math.abs(start - stop) < rangeStep) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Returns {@code true} if the range has more elements. (In other words, returns {@code true} if
     * {@link next} would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the range has more elements
     */
    @Override
    public boolean hasNext() {
        boolean rStepNegative;
        rStepNegative = rangeStep <= 0;
        if (!rStepNegative) {
            return rangePos - rangeStep < rangeEnd - rangeStep;
        }
        // for negative step
        if (rStepNegative) {

            return rangePos + rangeStep > rangeEnd + rangeStep;
        }
        return true;
    }

    /**
     * Returns the next element in the range.
     *
     * @return the next element in the range
     * @throws NoSuchElementException if the range has no more elements
     */
    @Override
    public Integer next() {
        if (rangeStep > 0) {
            Integer retInt = rangePos;
            rangePos = rangePos + rangeStep;
            if (retInt / rangeStep < rangeEnd / rangeStep) {
                if (retInt >= rangeEnd) {
                    throw new NoSuchElementException();
                }
                return retInt;
            }
            if (retInt / rangeStep <= rangeEnd / rangeStep) {
                if (retInt >= rangeEnd) throw new NoSuchElementException();
                return retInt;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            Integer retInt = rangePos;
            rangePos = rangePos + rangeStep;
            if (retInt / rangeStep <= rangeEnd / rangeStep && retInt >= rangeEnd) {
                return retInt;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /**
     * Returns an iterator over the elements of this range.
     *
     * @return an iterator over the elements of this range
     */
    @Override
    public Iterator<Integer> iterator() {
        // If you implement hasNext() and next() correctly, this is complete.
        // (i.e., a Range object is its own iterator.)
        return this;
    }
}
