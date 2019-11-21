import java.io.File;
import java.io.FileFilter;

public class FileDemoFileTwo {


    public static void main(String[] args) {

        File dir = new File("/Users/codew/Desktop/Net/java");
        printDir2(dir);
    }


    public static void printDir2(File dir){

        File[] files2 = dir.listFiles(new FileFilter() {


            @Override
            public boolean accept(File pathname) {


                return pathname.getName().endsWith(".md") || pathname.isDirectory();
            }
        });


        File[] files1 = dir.listFiles((File pathname)->{

            return pathname.getName().endsWith(".md") || pathname.isDirectory();
        });

        File[] files = dir.listFiles( fi -> fi.getName().endsWith(".md") || fi.isDirectory() );

        for (File file: files) {


            if (file.isFile()){

                System.out.println("文件名:" + file.getAbsolutePath());
            }else
            {
                printDir2(file);
            }

        }
    }
}
