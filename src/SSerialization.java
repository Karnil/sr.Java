import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 3/13/15.
 */
class SSerialization {
    private List<iCustomField> fields;

    private static iCustomField getCustomFieldClass(Field f) throws Exception {
        if (f.getType().isEnum()) {
            return new EnumField(f);
        } else if (f.getType().isAssignableFrom(String.class)) {
            return new StringField(f);
        } else if (f.getType().isAssignableFrom(int.class)) {
            return new IntField(f);
        } else if (f.getType().isAssignableFrom(long.class)) {
            return new LongField(f);
        } else if (f.getType().isAssignableFrom(short.class)) {
            return new ShortField(f);
        } else if (f.getType().isAssignableFrom(char.class)) {
            return new CharField(f);
        } else if (f.getType().isAssignableFrom(boolean.class)) {
            return new BooleanField(f);
        }

        throw new Exception("Field type unknown");
    }

    public void prepareSerialization(Class neededClass ,String... fieldsNames) throws Exception {
        List<String> listOfNames = Arrays.asList(fieldsNames);
        Field[] declaredFields = neededClass.getDeclaredFields();

        if (fields == null)
            fields = new LinkedList<iCustomField>();

        for (Field f: declaredFields) {
            if (listOfNames.contains(f.getName()))
                fields.add(getCustomFieldClass(f));
            else
                throw new Exception("Field not exist in class");
        }
    }
}
