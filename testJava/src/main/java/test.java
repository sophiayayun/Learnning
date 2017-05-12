import java.util.Calendar;
import java.util.Date;

/**
 * Created by dengyayun on 17/3/27.
 */
public class test {
    public static void main(String[] args) {
//        Map<String, String> amount = new HashMap<String, String>();
//        System.out.println(amount == null);
//        Date d = new Date();
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.MONTH, 3);
//        System.out.println(c.getTime());

        for(int i=0; i<=31; i++) {
            for (int j=i,k=0; k<2; j++,k++) {
                System.out.println("select* from DZCouponShard" + i + ".DZ_Coupon" + (i+j) + " a where a.`OrderId` = 400000000 and a.`OrderType` =1;");
            }
        }

    }
}
