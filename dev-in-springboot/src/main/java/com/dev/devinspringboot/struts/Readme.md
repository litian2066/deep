## 玩转数据结构
### 动态数组 
废话不多说直接上代码
```java
    /**
     * 自己封装数组
     */
    public class Array<E> {
    
        private E[] data;
        private int size;
    
        // 构造函数, 传入数组的容量capacity构造Array
        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }
    
        public Array() {
            this(10);
        }
    
        /**
         * 向所有元素后添加一个新元素
         * @param e
         */
        public void addLast(E e) {
            if (size == data.length) {
                resize(data.length * 2);
            }
            data[size++] = e;
        }
    
        /**
         * 在制定位置插入元素, 需要挪动元素
         * @param index
         * @param e
         */
        public void add(int index, E e) {
            // 验证index是否合法
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add is failed. Require index >= 0 and index < size");
            }
            // 扩容
            if (size == data.length) {
               resize(2 * data.length);
            }
            // 挪动位置
            for (int i = size; i > index - 1 ; i--) {
                data[i] = data[i - 1];
            }
            data[index] = e;
            size++;
        }
    
        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    
        // 向数组头添加一个元素
        public void addFirst(E e) {
            add(0, e);
        }
    
        // 获取index索引位置的元素
        public E get(int index) {
            // 验证index是否合法
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Get is failed. Require index >= 0 and index < size");
            }
            return data[index];
        }
    
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }
    
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }
    
        public E remove(int index) {
            // 验证index是否合法
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Remove is failed. Require index >= 0 and index < size");
            }
            E ret = data[index];
            for (int i = index +1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null; // 去除闲散对象
            // 为了防止时间复杂度震荡,故不能在数组长度小于一半的时候进行缩容, 要等到少于四分之一的时候进行缩容;
            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return ret;
        }
    
        public E removeFirst() {
            return remove(0);
        }
    
        public E removeLast() {
            return remove(size - 1);
        }
    
        public void removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
            }
        }
    
        public E getFirst() {
            return get(0);
        }
    
        public E getLast() {
            return get(size - 1);
        }
    
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size) {
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }
    
        public int getSize() {
            return size;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public int getCapacity() {
            return data.length;
        }
    }
```
复杂度分析:  
```$xslt
     大O描述的是算法的运行时间和输入数据之间的关系 分析时 忽略常数
     * T = 2*n + 2          O(n)
     * T = 2000*n + 10000   O(n) 渐进时间复杂度
     * T = 1*n*n + 0        O(n^2) 描述n趋近于无穷的情况
     * addLast(e)       O(1)
     * addFirst(e)      O(n) 在第一个位置插入元素肯定要挪位置 所以是N的复杂度
     * add(index, e)    O(2/n) = O(n) 平均而言要挪动二分之一的元素 所以是N的复杂度
     * removeLast(e) O(1)
     * removeFirst(e) O(n)
     * remove(index, e) O(n)
     * resize() O(n)
     * 修改操作
     * set(index, e) O(1)
     * get(index) O(1)
     * contains(e) O(n)
     * find(e) O(n)
     * 均摊时间复杂度分析：
     *  在增和删除的时候会有扩容的情况出现，然而resize操作是O(n)的复杂度
     *  假设当前capacity = 8， 并且每一次添加操作都使用addLast
     *  在添加第九个元素的时候需要resize操作  所以会有消耗8 + 1 的时间 加上之前添加8次的操作也就是17次基本的操作
     *  9次addLast操作，出发resize 总共进行了17次基本操作
     *  平均下来，每次addLast操作，进行2次基本操作
     *  假设capacity = n， n+ 1次addLast， 出发resize， 总共进行2n+1次基本操作
     *  所以平均下来，每次addLast操作， 进行了2次基本操作
     *  这样平均下来，时间复杂度是O（1） 的
     * 复杂度震荡：
     * removeLast时resize过于着急解决方式是Lazy的处理 等到删除到整个数组的容积的四分之一就可以了

```
*****
### 栈  
   【|标题一|标题二|标题三|标题四|
   |- |:---|---:|:---:|
   |xxxxxxxxx|xxxxxxxxx|xxxxxxxxx|xxxxxxxxx|
   |xxxxxxxxxxxxxx|xxxxxxxxxxxxxx|xxxxxxxxxxxxxx|xxxxxxxxxxxxxx|
   |xxxxxxxxx|xxxxxxxxx|xxxxxxxxx|xxxxxxxxx||】
    
