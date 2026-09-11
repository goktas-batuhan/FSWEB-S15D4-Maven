package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WorkintechList<E> extends ArrayList<E> {

    public WorkintechList() {
        super();
    }

    public WorkintechList(int initialCapacity) {
        super(initialCapacity);
    }

    public WorkintechList(Collection<? extends E> c) {
        super();
        if (c != null) {
            addAll(c);
        }
    }

    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            return super.add(e);
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (!this.contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        if (c != null) {
            for (E item : c) {
                if (this.add(item)) {
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        if (c != null) {
            for (E item : c) {
                if (!this.contains(item)) {
                    super.add(index++, item);
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public E set(int index, E element) {
        int existingIndex = indexOf(element);
        if (existingIndex == -1 || existingIndex == index) {
            return super.set(index, element);
        }
        return get(index);
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        Collections.sort((List) this);
    }

    @Override
    public boolean remove(Object object) {
        boolean removed = super.remove(object);
        sort();
        return removed;
    }

    @Override
    public E remove(int index) {
        E removed = super.remove(index);
        sort();
        return removed;
    }
}
