package ClassDemo.ArrayTest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by codew on 2018/1/29.
 */
public class ArrayTestDEmo {


    public static void main(String[] args) throws Exception{


    }

    public static void arraycopy(Object src,
                                 int srcPos,
                                 Object dest,
                                 int destPos,
                                 int length)
    {

        if (src == null || dest == null){

            throw new NullPointerException("原数组和目标数组都不能为null");
        }

        if (!src.getClass().isArray() || !dest.getClass().isArray()){

            throw new ArrayStoreException("源和目标都必须是数组");
        }

        if (srcPos < 0 || destPos < 0 || length < 0 ||
                srcPos + length > Array.getLength(src) ||
                destPos + length > Array.getLength(dest)){

            throw new IndexOutOfBoundsException("索引越界");
        }

        if (src.getClass().getComponentType() != dest.getClass().getComponentType()){

            throw new ArrayStoreException("目标和源的元素类型必须相同!");
        }

        for (int index = srcPos; index < srcPos + length; index++) {

            Object val = Array.get(src, index);

            Array.set(dest, destPos, val);
            destPos++;
        }

    }
    private void test()
    {
        Object arr = new int[]{12, 323, 23, 22};
        Array.set(arr, 2, 100);

        int val = Array.getInt(arr, 2);
        System.out.println(val);
    }
}
