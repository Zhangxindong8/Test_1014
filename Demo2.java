import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        try {
            // 创建一个文件字符输入流对象
            FileReader fr = new FileReader("D:\\book.txt");
            BufferedReader br = new BufferedReader(fr);
            String str=br.readLine();
            System.out.println("----------------------------------------");
            while (str != null) {
                System.out.println(str);
                // 读取下一行
                str = br.readLine();
            }
            System.out.println("----------------------------------------");
            br.close();
            fr.close();
        } catch (java.io.FileNotFoundException err) {
            err.printStackTrace();
        }
        catch (java.io.IOException err) {
            err.printStackTrace();
        }
        // 根据出版社名称，查找书籍数量和总价格
        Scanner s1 = new Scanner(System.in);
        System.out.println("请输入出版社名称：");
        String publisherName = s1.next();
        findInfoByPublisher(publisherName);
        // 根据ISBN号来获取书名、作者、出版社
        Scanner s2 = new Scanner(System.in);
        System.out.println("请输入ISBN号：");
        String ISBN = s2.next();
        findInfoByISBN(ISBN);
        // 统计页码值不少于某个值的书籍数量
        Scanner s3 = new Scanner(System.in);
        System.out.println("请输入页码：");
        String pageSize = s2.next();
        getBookCount(pageSize);
    }

    // 根据出版社名称，查找书籍数量和总价格
    private static void findInfoByPublisher(String Publisher){
        int sum = 0;   // 数量
        double sumPrice = 0;       // 总价格
        try {
            // 创建一个文件字符输入流对象
            FileReader fr = new FileReader("D:\\book.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();  // 第一行
            while (str != null) {
                String[] infos = str.split(",");
                if (infos[3].equals(Publisher)) {
                    sum ++;
                    sumPrice += Double.parseDouble(infos[4]);
                }
                str = br.readLine();    // 下一行
            }
            if ( sum > 0 ) {
                System.out.println("总数为："+sum);
                System.out.println("总价格为："+sumPrice);
            } else if ( sum == 0 ){
                System.out.println("没有找到该出版社的书籍！");
            }
            br.close();
            fr.close();
        } catch (java.io.FileNotFoundException err) {
            err.printStackTrace();
        }
        catch (java.io.IOException err) {
            err.printStackTrace();
        }
    }

    // 根据ISBN号来获取书名、作者、出版社
    private static void findInfoByISBN(String ISBN){
        int sum = 0;
        try {
            // 创建一个文件字符输入流对象
            FileReader fr = new FileReader("D:\\book.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();  // 第一行
            while (str != null) {
                String[] infos = str.split(",");
                if (infos[0].equals(ISBN)) {
                    sum ++;
                    System.out.println("书名："+infos[1]);
                    System.out.println("出版社："+infos[3]);
                    System.out.println("作者："+infos[2]);
                }
                str = br.readLine();    // 下一行
            }
            if ( sum == 0) {
                System.out.println("没有该指定ISBN的书籍！");
            }
            br.close();
            fr.close();
        } catch (java.io.FileNotFoundException err) {
            err.printStackTrace();
        }
        catch (java.io.IOException err) {
            err.printStackTrace();
        }
    }

    // 统计页码值不少于某个值的书籍数量
    private static void getBookCount(String page){
        int sum = 0;
        try {
            // 创建一个文件字符输入流对象
            FileReader fr = new FileReader("D:\\book.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();  // 第一行
            while (str != null) {
                String[] infos = str.split(",");
                if ( Integer.parseInt(infos[5]) > Integer.parseInt(page) ) {
                    sum++;
                }
                str = br.readLine();    // 下一行
            }
            if (sum > 0) {
                System.out.println("书籍数量："+sum);
            } else {
                System.out.println("没有找到页码值不少于该值的书籍！");
            }
            br.close();
            fr.close();
        } catch (java.io.FileNotFoundException err) {
            err.printStackTrace();
        }
        catch (java.io.IOException err) {
            err.printStackTrace();
        }
    }
}

