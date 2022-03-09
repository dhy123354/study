import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.naming.Name;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Description:
 *
 * @author veliger@163.com
 * @date 2019-04-12 21:23
 **/
@Getter @Setter @AllArgsConstructor @ToString
class User{
    private String name;
    private int age;
}

public class AtomicReferenceDemo {

}

