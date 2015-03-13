import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
interface iCustomField {
    int get(Objects instance, byte[] bytes, int offset);
    byte[] get(Object instance);
    int set(Object instance, byte[] bytes, int offset);

    byte[] getPrefix(Objects instance);
    byte[] getPostfix(Objects instance);
}
