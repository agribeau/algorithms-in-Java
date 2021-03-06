## 线性表的链式存储--链表

### 简介

链表中的元素包含两个数据成员：
1. 数据域
2. 指针域

数据域存储着该元素的数据，指针域存储者该元素所指向的下一个元素所在的内存地址。由于指针域的存在，链表中的元素在内存中的地址可以是不连续的

### 时间复杂度分析

在链表首部添加/删除元素 O(1)
在链表尾部添加/删除元素( 如果不跟踪尾结点，时间复杂度为 O(n) ) O(1)

在链表中增加元素 O(n/2) = O(n)
在链表中删除元素 O(n/2) = O(n)
在链表中修改元素 O(n)
在链表中查找元素 O(n)

### 实现简介

这个使用 Java 实现的链表有两个特点：

1. 存在虚拟结点( dummy node )
2. 跟踪了链表的尾结点

如果不设置虚拟结点，在对链表进行插入和删除操作时，需要对首结点特殊处理。因为插入和删除结点时需要先找到该结点的前驱结点，而首节点不存在前驱结点。

至于跟踪链表的尾结点的目的，是为了后面使用链表来实现队列这种结构。