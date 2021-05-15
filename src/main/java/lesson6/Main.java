package lesson6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * homework lesson6
 *
 * @author Amina
 * 14.05.2021
 */
public class Main {

    public static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ArrayMethods a = new ArrayMethods(1,2,4,4,2,3,4,1,7 );
            log.info(a.getElementsAfter4().toString());
            ArrayMethods b = new ArrayMethods(1,1,4,4,1,4 );
            b.checkList();
            log.info("Проверка на наличие 1 и 4:"+ b.is4or1);
        }catch (RuntimeException e){
            log.throwing(e);
        }
    }
}
