package org.karpukhin.springmvcdemo.funcs;

import java.util.Collection;

/**
 * @author Pavel Karpukhin
 */
public class CollectionMethods {

    /**
     * Returns true if given collection contains the specified element
     * @param collection collection
     * @param element    element
     * @return true if given collection contains the specified element
     */
    public static boolean contains(Collection collection, Object element) {
        return collection.contains(element);
    }
}
