package oksana.internship.lesson1.model;

import java.util.Comparator;


public class Quicksort {

    private void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int partition(Object[] array, int begin, int end, Comparator cmp) {
        int index = end-1;
        Object pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    /**
     * сортировка массива методом quicksort
     * @param array - массив элементов
     * @param begin - первый сравниваемый элемент
     * @param end - второй сравниваемый элемент
     * @param cmp - используемый компаратор
     */
    public void quicksort(Object[] array, int begin, int end, Comparator cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            quicksort(array, begin, index - 1, cmp);
            quicksort(array, index + 1, end, cmp);
        }
    }
}
