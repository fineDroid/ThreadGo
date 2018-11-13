import com.finedroid.multiWork.MultiService;

/*
 * 验证synchronized关键字使用方法
 */
public class Main {

    public static void main(String[] args) {

        MultiService multiService = new MultiService();

        MultiService.MyThread p1 = new MultiService.MyThread(multiService);
        MultiService.MyThread p2 = new MultiService.MyThread(new MultiService());
        MultiService.MyThread p3 = new MultiService.MyThread(multiService);
        MultiService.MyThread p4 = new MultiService.MyThread(multiService);
        MultiService.MyThread p5 = new MultiService.MyThread(new MultiService());
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }


}
