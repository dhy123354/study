package 观察者模式;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

class Course {

    private Date time;
    private String place;
    private String content;

    public Course() {
    }

    public Course(Date time, String place, String content) {
        this.time = time;
        this.place = place;
        this.content = content;
    }
}

/**
 * 老师类
 * - 观察者之一
 * - 观察学生的上课情况
 */
class TeacherObserver implements Observer {
    private Course course;
    @Override
    public void update(Observable o, Object arg) {
        DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println("我是老师,正在讲课中...");
        course = new Course(new Date(), "A栋教学楼", "Java课程");
        System.out.println("===========================");
    }
}

/*************************************/

/**
 * 班主任来听课
 * - 观察者之一
 * - 观察学生的上课情况
 */
class HeadTeacherObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是班主任来听课了,正在检查课程质量...");
        System.out.println("学生反馈课程质量为:" + arg);
    }
}

/*************************************/

/**
 * 学生主体
 * - 被观察的对象
 */
class StudentObservable extends Observable {
    /**
     * 上课状态
     */
    private String state;

    public void doNotify() {
        // 设置标志
        this.setChanged();
        // 通知观察者做出相应动作
        this.notifyObservers(state);
    }

    public void setState(String s) {
        System.out.println(s);
    }
}

/*************************************/

public class 观察者模式 {
    public static void main(String[] args) {
        // 创建学生主体
        StudentObservable studentObservable = new StudentObservable();
        // 创建观察者老师
        TeacherObserver teacherObversable = new TeacherObserver();
        // 创建观察者班主任
        HeadTeacherObserver headTeacherObserver = new HeadTeacherObserver();
        // 学生反映上课状态
        studentObservable.setState("(*^▽^*)讲的不错,很好,随手点个关注和在看!");
        studentObservable.addObserver(teacherObversable);
        studentObservable.addObserver(headTeacherObserver);
        // 开始上课
        studentObservable.doNotify();
        // 上课结束
        studentObservable.deleteObserver(headTeacherObserver);
        studentObservable.deleteObserver(teacherObversable);
    }
}

