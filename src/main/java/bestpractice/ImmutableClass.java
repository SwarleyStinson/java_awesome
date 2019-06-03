package bestpractice;

//how to make immutable
//1. no setters
//2. private final fields ()
//3. final class
//4. dont't return mutable objects
/** advantages:
 * thread safe no sync, good for cashing
 * */
public final class ImmutableClass {
    private final int i;

    public ImmutableClass(int i) {
        this.i = i;
    }
}
