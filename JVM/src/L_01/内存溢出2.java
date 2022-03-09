package L_01;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class 内存溢出2 {
    public static void main(String[] args) throws JsonProcessingException {
        Dept d = new Dept();
        d.setName("Market");

        Emp e1 = new Emp();
        e1.setName("csp");
        e1.setDept(d);

        Emp e2 = new Emp();

        e2.setName("hzw");
        e2.setDept(d);

        d.setEmps(Arrays.asList(e1, e2));

        // 输出结果：{"name":"Market","emps":[{"name":"csp"},{"name":"hzw"}]}
        ObjectMapper mapper = new ObjectMapper();// 要导入jackson包
        System.out.println(mapper.writeValueAsString(d));
    }

    static class Dept {
        private String name;
        private List<Emp> emps;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Emp> getEmps() {
            return emps;
        }

        public void setEmps(List<Emp> emps) {
            this.emps = emps;
        }
    }

    static class Emp {
        private String name;
        @JsonIgnore
        private Dept dept;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Dept getDept() {
            return dept;
        }

        public void setDept(Dept dept) {
            this.dept = dept;
        }
    }
}
