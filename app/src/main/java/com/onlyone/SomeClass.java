
package com.onlyone;


class Resource {

}

public class SomeClass {

    private volatile static Resource resource = null;

    public static Resource getResource() {
        if (resource == null) {
            synchronized (Resource.class) {
                if (resource == null) {
                    resource = new Resource();
                }
            }
        }
        return resource;
    }


    int[] dates = {1, 2, 3};

    public long Evaluate(int[] datas, int x) {
        int length = datas.length;
        long result = 0;
        for (int i = length - 1; i >= 0; i--) {
            result = datas[i] + result * x;
        }
        return result;
    }


}