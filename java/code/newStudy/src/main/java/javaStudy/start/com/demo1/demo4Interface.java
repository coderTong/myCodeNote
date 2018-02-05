package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

interface IUSB
{
    void swapData();
}

class Mouse implements IUSB
{
    public void swapData()
    {

    }
}

class Print implements IUSB
{
    public void swapData()
    {

    }
}


// 主板
class MotherBoard
{
    private static IUSB[] usbs = new IUSB[6];
    private static int index = 0;

    public static void pluginIn(IUSB usb)
    {
        if (index == usbs.length)
        {
            //满了
            return;
        }

        usbs[index] = usb;
        index++;
    }

    public static void doWork()
    {
        for (IUSB usb:usbs) {

            if (usb != null)
            {
                usb.swapData();
            }

        }
    }

}






public class demo4Interface {
}
