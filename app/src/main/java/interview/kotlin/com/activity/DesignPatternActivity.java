package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/14.
 */
public class DesignPatternActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("设计模式");

        String contentString ="" +
                "单例模式\n这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。 \n" +
                "建造者模式\n 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。\n\n" +
                "适配器模式\n 作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。\n " +
                "迭代器模式（Iterator Pattern）\n是 Java 和 .Net 编程环境中非常常用的设计模式。这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。\n" +
                "观察者模式\n当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。"+

                "备忘录模式（Memento Pattern）\n 保存一个对象的某个状态，以便在适当的时候恢复对象。备忘录模式属于行为型模式。\n" +
                "享元模式（Flyweight Pattern）\n主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。\n" +

                "工厂模式\n 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。\n " +
                "抽象工厂模式\n 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。 \n" +
                "模板模式\n 一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。\n" +

                "中介者模式（Mediator Pattern）\n  实体 降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。\n对象与对象之间存在大量的关联关系，这样势必会导致系统的结构变得很复杂，同时若一个对象发生改变，我们也需要跟踪与之相关联的对象，同时做出相应的处理\n" +
                "桥接模式 bridge\n 把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式 \n" +
                "代理模式\n" +
                "在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。\n 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。" +

                "策略模式\n 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。" +
                "\"在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。主要是算法\" +\n" +
                "状态模式\n在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。\n"+

                "责任链模式 （Chain of Responsibility Pattern）\n为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。" +
                "解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式，它属于行为型模式。这种模式实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL 解析、符号处理引擎等。" +
                "命令模式 （Command Pattern）\n 是一种数据驱动的设计模式，它属于行为型模式。请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。" +
                "组合实体模式（Composite Entity Pattern）\n 用在 EJB 持久化机制中。一个组合实体是一个 EJB 实体 bean，代表了对象的图解。当更新一个组合实体时，内部依赖对象 beans 会自动更新，因为它们是由 EJB 实体 bean 管理的。以下是组合实体 bean 的参与者。\n" +
                "\n" ;

        setContentTextView(contentString);

        gotoActivity("http://www.rnoob.com/design-pattern/design-pattern-tutorial.html");


    }
}
