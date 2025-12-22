package org.example;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws IllegalAccessException {
        Person person1 = new Person("name1", 20);
        Person person2 = new Person("name2", 25);
        Student student1 = new Student(person1, 1);
        Student student2 = new Student(person2, 2);
        Group group1 = new Group("group1");
        group1.addStudent(student1);
        group1.addStudent(student2);
        System.out.println(group1);
        System.out.println(createJson(group1));
    }
    private static String createJson(Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder sb = new StringBuilder("{");
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            addElement(sb, field, value);
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
    private  static void addElement(StringBuilder sb, Field field, Object value) throws IllegalAccessException {
        sb.append('"')
                .append(field.getName())
                .append('"')
                .append(": ");
        addValue(sb, value);
    }
    private  static void addValue(StringBuilder sb, Object value) throws IllegalAccessException {
        if (value == null) sb.append("null");
        else if (value.getClass().isArray()) addArray(sb, value);
        else if (value instanceof String) sb.append('"').append(value).append('"');
        else if (value instanceof Number || value instanceof Boolean) sb.append(value);
        else if (value instanceof java.util.Date) formatDate(sb, (java.util.Date) value);
        else sb.append(createJson(value));
        sb.append(", ");
    }
    private  static void addArray(StringBuilder sb, Object value) throws IllegalAccessException {
        sb.append("[");
        int length = Array.getLength(value);
        boolean addded = false;
        for (int i = 0; i < length; i++) {
            Object element = Array.get(value, i);
            if (element != null) {
                addValue(sb, element);
                addded = true;
            }
        }
        if (addded) sb.setLength(sb.length() - 2);
        sb.append("]");
    }
    private static void formatDate(StringBuilder sb, java.util.Date date) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String dateStr = sdf.format(date);
        sb.append('"').append(dateStr).append('"');
    }
}