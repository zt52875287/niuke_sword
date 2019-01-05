package com.数据流中的中位数;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/18
 */
public class Solution {

    @Test
    public void tester() {

        int arr[] = new int[]{1, 7, 2, 5, 3, 8, 6, 12, 9, 4};
        int a[] = new int[]{2, 5, 3, 8, 10, 6, 1, 4, 9};

        for (int i = 0; i < arr.length; i++) {
            Insert(arr[i]);
            System.out.println(maxheap);
            System.out.println(minheap);
            System.out.println("中位数：" + GetMedian());
            System.out.println("----------------");

        }


    }

    ArrayList<Integer> maxheap = new ArrayList<>();
    ArrayList<Integer> minheap = new ArrayList<>();


    public void Insert(Integer num) {

        //为了避免出现heap.get(x)空指针，这里对插入的前两个元素单独处理。
        if (maxheap.size() == 0) {
            maxheap.add(num);
            return;
        } else if (minheap.size() == 0) {
            if (num >= maxheap.get(0)) {
                minheap.add(num);
            } else {
                minheap.add(maxheap.remove(0));
                maxheap.add(num);
            }
            return;
        }

        //插入 ，将小于大根堆堆顶的元素插入到大根堆，其余的全部插入到小根堆
        //（其实反过来也是可以的：将大于小根堆堆顶的元素插入到小根堆，其余的全部插入到大根堆）
        //（两种插入方法二选其一，这里这样做，是为了保证 大根堆中的任意元素 小于等于 小根堆中的任意元素）
        if (num < maxheap.get(0)) {
            maxheap.add(num);
            adjustAdd(maxheap, 0, maxheap.size() - 1, true);
        } else {
            minheap.add(num);
            adjustAdd(minheap, 0, minheap.size() - 1, false);
        }

        //每次插完数据都需要调整堆，保证两个堆的size满足下面两种情况之一:（这样就可以保证随时可以取到中位数）
        // 1. 大根堆数量=小根堆数量（中位数是：（大根堆堆顶+小根堆堆顶）/2）
        // 2. 大根堆数量=小根堆数量-1（中位数是：小根堆堆顶）

        //小根堆多两个，需要把堆顶调整到大根堆
        if (maxheap.size() + 1 < minheap.size()) {
            //新添加一个元素到尾部，需要从下向上调整一遍
            maxheap.add(minheap.get(0));
            adjustAdd(maxheap, 0, maxheap.size() - 1, true);
            //删除一个元素，先把首尾元素位置交换，然后删掉尾部元素，在从上到下调整一遍
            adjustRemove(minheap, false);
            return;
        }

        //大根堆多一个，需要把堆顶调整到小根堆
        if (maxheap.size() > minheap.size()) {
            //新添加一个元素到尾部，需要从下向上调整一遍
            minheap.add(maxheap.get(0));
            adjustAdd(minheap, 0, minheap.size() - 1, false);
            //删除一个元素，先把首尾元素位置交换，然后删掉尾部元素，在从上到下调整一遍
            adjustRemove(maxheap, true);
            return;
        }


    }

    //插入一个元素到尾部，从下至上调整一次，复杂度O(logn)
    private void adjustAdd(ArrayList<Integer> heap, int head, int tail, boolean isMaxHeap) {

        int povit = heap.get(tail);
        for (int i = (tail - head - 1) / 2; i >= head; i = (i - 1) / 2) {

            if (isMaxHeap) {
                if (povit <= heap.get(i)) break;
            } else {
                if (povit >= heap.get(i)) break;
            }

            heap.set(tail, heap.get(i));
            tail = i;
            if(i==0) break;
        }
        heap.set(tail, povit);

    }

    //删除一个元素，并调整堆
    //交换第一个和最后一个元素,然后删掉最后一个元素
    //这样，除了第一个元素之外，其他所有元素都满足堆的设定，我们从上往下调整一次，复杂度同样是O(logn)
    private void adjustRemove(ArrayList<Integer> heap, boolean isMaxHeap) {

        //交换第一个和最后一个元素,然后删掉最后一个元素
        int povit = heap.get(heap.size() - 1);
        int head =0;
        heap.set(0, povit);
        heap.remove(heap.size() - 1);

        for (int i = 1; i < heap.size(); i = i * 2 + 1) {
            if (isMaxHeap) {
                if (i < heap.size() - 1 && heap.get(i) < heap.get(i + 1)) i++;
            } else {
                if (i < heap.size() - 1 && heap.get(i) > heap.get(i + 1)) i++;
            }

            if (isMaxHeap) {
                if (povit > heap.get(i)) break;
            } else {
                if (povit < heap.get(i)) break;
            }

            heap.set(head, heap.get(i));
            head = i;

        }
        heap.set(head, povit);

    }


    public Double GetMedian() {

        //两个堆中当前有0个元素
        if (maxheap.size() == 0 && minheap.size() == 0) return 0.0;
        //两个堆中，当前只有一个元素
        if (maxheap.size() == 1 && minheap.size() == 0) return maxheap.get(0) + 0.0;

        //普遍情况
        // 1. 大根堆数量=小根堆数量（中位数是：（大根堆堆顶+小根堆堆顶）/2）
        // 2. 大根堆数量=小根堆数量-1（中位数是：小根堆堆顶）
        if (maxheap.size() == minheap.size()) {
            return (maxheap.get(0) + minheap.get(0) + 0.0) / 2;
        } else {
            return minheap.get(0) + 0.0;
        }
    }

}
