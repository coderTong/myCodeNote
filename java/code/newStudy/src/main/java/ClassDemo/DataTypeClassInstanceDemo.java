package ClassDemo;

/**
 * Created by codew on 2018/1/29.
 */
public class DataTypeClassInstanceDemo {

    public static void main(String[] args) throws Exception{

        // 8大基本数据类型class实例
        Class intClass = int.class;
        Class booleanClass = boolean.class;

        System.out.println( Integer.class == int.class );
        System.out.println( Integer.TYPE == int.class );

        System.out.println("----------------------------");
        int[] arr1 = {1,2,4};
        Class arr1Clas = arr1.getClass();
        System.out.println(arr1Clas);

        Class arr2Class = int[].class;
        System.out.println(arr1Clas == arr2Class);
    }
}
