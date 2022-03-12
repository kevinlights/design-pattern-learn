package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        List<Object> products = new ArrayList<>();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("四十二章经");

        AbstractObjectList list = new ProductList(products);
        AbstractIterator iterator = list.createIterator();

        System.out.println("正向遍历：");

        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + "，");
            iterator.next();
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");

        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + "，");
            iterator.previous();
        }
    }
}

abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List<Object> getObjects() {
        return this.objects;
    }

    public abstract AbstractIterator createIterator();
}

interface AbstractIterator {
    void next();
    boolean isLast();
    void previous();
    boolean isFirst();
    Object getNextItem();
    Object getPreviousItem();
}

class ProductList extends AbstractObjectList{
    public ProductList(List<Object> objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {
        // return new ProductIterator(this);
        return new Itr();
    }

    // 使用内部类的方式创建迭代器，方便迭代器访问 product 对象的数据
    private class Itr implements AbstractIterator {
        private int cursor1;
        private int cursor2;

        public Itr() {
            cursor1 = 0;
            cursor2 = objects.size() - 1;
        }

        @Override
        public void next() {
            if (cursor1 < objects.size()) {
                cursor1++;
            }
        }

        @Override
        public boolean isLast() {
            return (cursor1 == objects.size());
        }

        @Override
        public void previous() {
            if (cursor2 > -1) {
                cursor2--;
            }
        }

        @Override
        public boolean isFirst() {
            return (cursor2 == -1);
        }

        @Override
        public Object getNextItem() {
            return objects.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }
}

class ProductIterator implements AbstractIterator {
    private ProductList productList;
    private List<Object> products;
    private int cursor1; // 正向遍历游标
    private int cursor2;// 逆向遍历游标

    public ProductIterator(ProductList productList) {
        this.productList = productList;
        this.products = productList.getObjects();
        this.cursor1 = 0;
        this.cursor2 = this.products.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < products.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return (cursor1 == products.size());
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return (cursor2 == -1);
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
