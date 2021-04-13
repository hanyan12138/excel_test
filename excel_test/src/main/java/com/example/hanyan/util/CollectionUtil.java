package com.example.hanyan.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author vigo.xian
 */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean mapIsEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean mapIsNotEmpty(Map map) {
        return !mapIsEmpty(map);
    }

    public static <T> List<T> subList(Collection<T> collection, int length) {
        if (isEmpty(collection)) {
            return null;
        } else if (collection.size() <= length) {
            return new ArrayList(collection);
        } else {
            List<T> list = new ArrayList(collection);
            return new ArrayList(list.subList(0, length));
        }
    }
}
