







---

# 1. 语法基础

## 1.1 数据类型

​	在Java语言中将数据类型分为以下两大类：

  ### 1.1.1 基本数据类型

​         byte、short、int、long、float、double、boolean、char
​          1个     2个       4个   8个       4个       8个          1个           2个

  在Java语言中用于描述整数数据的类型有：byte、short、int、long，推荐使用int类型
   其中byte类型在内存空间中占1个字节，表示的范围是：-2^7 ~ 2^7-1.
                                                    -128 ~ 127.
   其中short类型在内存空间中占2个字节，表示的范围是：-2^15 ~ 2^15-1.
                                                    -32768 ~ 32767.
   其中int类型在内存空间中占4个字节，表示的范围是：-2^31 ~ 2^31-1.
                                                    正负二十一亿之间.
   其中long类型在内存空间中占8个字节，表示的范围是：-2^63 ~ 2^63-1.
                                                    比int类型还大的数.

   其中float类型在内存空间中占4个字节，叫做单精度浮点数，通常可以有效到小数点后7位
   其中double类型在内存空间占8个字节，叫做双精度浮点数，通常可以有效到小数点后15位

PS：由于float类型和double类型都不能实现精确运算，因此在以后的商业开发中可能需要借助java.math.BigDecimal类型加以描述。

   在Java语言中用于描述真假信息的类型有：boolean，数值只有：true(真) 和 false(假)
   其中boolean类型在内存空间的大小没有明确的规定，通常认为占1个字节。

 字符类型
   在Java语言中用于描述单个字符的数据类型是：char，如：'a'  '1'  '中'等         
   其中char类型在内存空间中占2个字节，在以后的开发中很少使用该类型，而是使用String类型来描述多个字符组成的字符串，如"xiaomage"等
   由于计算机的底层只识别0和1组成的二进制序列，为了使得'a'这样的图案能够存储到计算机中就需要给该图案指定编号，这种编号叫做ASCII，要求大家记住的ASCII有：
      'a' - 97    'A' - 65   '0' - 48     空格 - 32   换行 - 10   
   要求大家记住的转义字符有：
       \" - "   \' - '   \\ - \   \n - 换行   \t - 制表符

![image-20200728090134239](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728090134.png)

### 1.1.2 引用数据类型
​         数组、类、接口、枚举、注解

- 数组

  - 一维数组

    ```
    1.1 基本概念
       当需要在程序中记录单个数据内容时，则应该声明一个变量即可；
       当需要在程序中记录多个类型相同的数据内容时，则应该声明一个一维数组，一维数组本质上就是内存中一段连续的存储单元。
    如：
       int score = 59; 
       int score2 = 60;
       ...
    
    1.2 数组的声明
    (1)语法格式
       数据类型[] 数组名称 = new 数据类型[数组的长度];
    如：
       int[] arr = new int[3];  - 表示声明一个长度为3元素类型为int类型的一维数组
       int num = 3;             - 表示声明一个初始值为3元素类型为int类型的变量
       int arr[] = new int[3];  - 不推荐使用         	   
    
    注意事项：
       只有在声明数组时[]中的数字才表示数组的长度，否则一律代表数组的下标。
    
    (2)元素的初始化
       数据类型[] 数组名称 = {元素值1, 元素值2, ...};
    如：
       int[] arr = {1, 2, 3}; - 表示声明一个长度为3元素初始值为1,2,3的一维数组
    ```

    测试： int[] arr;    之后arr能放下其它数么？还是能接收个引用？

  

  - 二维数组

      ```
      2.1 基本概念
      一维数组本质上就是一段连续的存储单元，用于存放多个类型相同的数据内容。
      二维数组本质上就是由多个一维数组组成的数组，也就是说二维数组中的每个元素都是一维数组，而一维数组的每个元素才是具体的数据内容。

      2.2 声明方式
      (1)语法格式
      数据类型[][] 数组名称 = new 数据类型[行数][列数];
      如：
      int[][] arr = new int[2][3]; - 表示声明一个具有2行3列元素类型为int类型的二维数组
      其中行下标为：0 ~ 1；
      其中列下标为：0 ~ 2；

      (2)元素的初始化
      数据类型[][] 数组名称 = {{元素值1, 元素值2, ...}, {元素值3, 元素值4, ...}, ...};
      如：
      int[][] arr = {{1, 2, 3}, {4, 5, 6}}; - 表示声明一个2行3列的二维数组
      ```

- 数组理解：

  - 一维数组初始状态：

    ![image-20200728100245937](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100245.png)

  - 一维数组的概念:

    ![image-20200728100356425](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100356.png)

  - 一维数组的赋值操作

    ![image-20200728100440658](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100440.png)

  - 一维数组的插入操作

  ![image-20200728100532137](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100532.png)

  - 一维数组的删除操作

  ![image-20200728100605219](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100605.png)

  - 一维数组的查改操作

  ![image-20200728100646346](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100646.png)

  - 二维数组的基本概念

  ![image-20200728100729429](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728100729.png)

## 1.2 运算符

### 1.2.1 算术运算符

```
\+ 表示加法运算符      -  表示减法运算
\* 表示乘法运算符      /  表示除法运算符
% 表示取模/取余运算符
```

注意事项：
   (1)当两个整数相除时，则结果只取整数部分丢弃小数部分。
   (2)若希望保留小数部分，处理方式如下：
        a.将其中一个操作数强制转换为double类型之后再运算；
        b.使用其中一个操作数乘以1.0之后再运算；
   (3)0不能做除数，0.0可以做除数，但都不推荐使用；
   (4)+既可以作为加法运算符也可以作为字符串连接符，区分方式如下：
      只要+两端的操作数中有1个操作数是字符串，则按照连接符处理，连接结果还是字符串

### 1.2.2 关系/比较运算符
    <  表示是否小于运算符          <= 表示是否小于等于运算符
    >  表示是否大于运算符          >= 表示是否大于等于运算符
    == 表示是否等于运算符          != 表示是否不等于运算符

所有以关系运算符为最终运算的表达式结果一定是boolean类型。

### 1.2.3 自增减运算符

```
+ 表示加法运算符        ++ 表示自增运算符

- 表示减法运算符        -- 表示自减运算符
```

注意：
   a.对于单个变量来说，++无论出现在变量的前面还是后面从结果上来说都是等价的；
   b.ia++ 叫做后++，表示先让ia的数值作为整个表达式的结果，然后再让ia进行加1的操作；
     ++ia 叫做前++，表示先让ia的数值进行加1操作，然后再让ia的数值作为表达式的结果；

### 1.2.4  逻辑运算符

```
 && 表示逻辑与运算符，相当于"并且"，同真为真，一假为假。
 || 表示逻辑或运算符，相当于"或者"，一真为真，同假为假。
  !  表示逻辑非运算符，相当于"取反"，真为假，假为真。
```

短路特性：
   对于逻辑与运算符来说，若第一个操作数结果为假则整个表达式一定为假，此时跳过第二个操作数的判断；
   对于逻辑或运算符来说，若第一个操作数结果为真则整个表达式一定为真，此时跳过第二个操作数的判断；   

### 1.2.5 位运算符

```
& 表示按位与运算符，按照二进制位进行与运算，同1为1,一0为0(1-真  0-假)；
| 表示按位或运算符，按照二进制位进行或运算，一1为1,同0为0；
~ 表示按位取反运算符，按照二进制位进行取反运算，1为0，0为1；
^ 表示按位异或运算符，按照二进制位进行异或运算，相同为0，不同为1；
<<  表示左移运算符，按照二进制位向左移动，右边使用0补充；
>>  表示右移运算符，按照二进制位向右移动，左边使用符号位补充；
>>> 表示无符号右移运算符，按照二进制位向右移动，左边使用0补充；
```

### 1.2.6 三目运算符

```
条件表达式 ? 语句1 : 语句2   
	=> 判断条件表达式是否成立
        => 若成立，则执行语句1;
        => 若不成立，则执行语句2;
```

### 1.2.7 赋值运算符

```
简单赋值:
	= 表示赋值运算符，用于将=右边的数据赋值给=左边的变量来覆盖该变量原来的数值。
	10 == ia; 用于判断10是否等于ia的数值
	ia = 10;  用于将数据10赋值给变量ia
复合赋值
   +=  -=  *=  /=
   int ia = 3;
   ia = ia + 2;  => ia += 2; 
```

### 1.2.8 运算符优先级

```
(1) ()的优先级极高，通常最先计算；
(2) =的优先级极低，通常最后计算；
(3) * / % 的优先级高于 + -，同级时从左向右计算；
```

![image-20200728092712363](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728092712.png)

## 1.3 语法结构

### 1.3.1 顺序结构

```
按照逻辑从上到下。
```

### 1.3.2 分支结构

- ```
  if分支结构:
  (1)语法格式
     if(条件表达式){
        语句块;
     }
  
  (2)执行流程
     判断条件表达式是否成立
         => 若成立，则执行语句块；
         => 若不成立，则跳过语句块；
  ```

- ```
  if-else分支结构:
  (1)语法格式
     if(条件表达式){
        语句块1;
     }
     else{
        语句块2;
     }
  
  (2)执行流程
     判断条件表达式是否成立
         => 若成立，则执行语句块1；
         => 若不成立，则执行语句块2；
  ```

- ```
  if-else if-else分支结构:
  (1)语法格式
     if(条件表达式1){
        语句块1;
     } 
     else if(条件表达式2){
        语句块2;
     }
     ...
     else{
         语句块n;
     }
  
  (2)执行流程
     判断条件表达式1是否成立
         => 若成立，则执行语句块1
         => 若不成立，则判断条件表达式2是否成立
                 => 若成立，则执行语句块2
                 => 若不成立，则执行语句块n
  ```


- ```
  switch-case分支结构
  (1)语法格式
     switch(变量/表达式){
        case 字面值1: 语句块1; break;
        case 字面值2: 语句块2; break;
        ...
        default:语句块n;
     } 
  
  (2)执行流程  
     计算变量/表达式的数值 => 判断是否匹配字面值1
         => 若匹配，则执行语句块1 => 执行break跳出当前结构
         => 若不匹配，则判断是否匹配字面值2
                 => 若匹配，则执行语句块2 => 执行break跳出当前结构
                 => 若不匹配，则执行语句块n
  
  (3)注意事项
     switch()中支持byte、short、char以及int类型，从jdk1.5开始支持枚举类型，从jdk1.7开始支持String类型。
  ```

  练习：
     提示用户输入考试的成绩，使用if-else if-else分支结构判断所在等级并打印(不合理成绩暂时不考虑)。
        [90 ~ 100]   等级A     /10     9  10  
        [80 ~ 89]    等级B     /10     8  
        [70 ~ 79]    等级C     /10     7
        [60 ~ 69]    等级D     /10     6
        [0 ~ 59]     等级E     default:

  ```java
  public static void main(String[] args) { // if-else if-else
          while (true){
              System.out.println("请输入该生成绩：");
              Scanner sc = new Scanner(System.in);
  
              int point = sc.nextInt();
              int num = point/10;
              if (num>=9){
                  System.out.println("A");
              }else if (num >=8) {
                  System.out.println("B");
              } else if (num >=7) {
                  System.out.println("C");
              }else if (num >=6) {
                  System.out.println("D");
              }else{
                  System.out.println("E");
              }
          }
      }
  ```

  ```java
  public static void main(String[] args) {  // switch-case
          while (true){
              System.out.println("请输入该生成绩：");
              Scanner sc = new Scanner(System.in);
  
              int point = sc.nextInt();
              int num = point/10;
              switch (num){
                  case 10:
                  case 9: System.out.println("A");break;
                  case 8: System.out.println("B");break;
                  case 7: System.out.println("C");break;
                  case 6: System.out.println("D");break;
                  default: System.out.println("E");
  
              }
          }
      }
  
  ```
- while循环结构


- do...while结构



### 1.3.3 循环结构

- ```
  for循环：
  (1)语法格式
     for(初始化表达式; 条件表达式; 修改初始值表达式){
        循环体;
     }
  
  (2)执行流程   
     执行初始化表达式 => 判断条件表达式是否成立
         => 若成立，则执行循环体 => 执行修改初始值表达式 => 判断条件表达式是否成立
         => 若不成立，则循环结束
  
  ```

练习：

- 使用for循环打印三位数中的所有水仙花数(参考PPT)。

    ```java
    import static java.lang.Math.pow;
    public static void main(String[] args) {
            //水仙花数：水仙花数是指一个3位数，它的每个位上的数字的3次幂之和等于它本身
            int first;
            int second;
            int third;
            int num;
            for (int i = 100; i < 1000; i++) {
                first = i/100;
                second = i/10%10;
                third =i%10;
                num = (int) (pow(first,3)+pow(second,3)+pow(third,3));
                if (i == num) {
                    System.out.print(num+" ");   //153 370 371 407 
                }
            }
        }
    ```

    

- ```java
    使用双重for循环打印以下图形：
        *
        **
        ***
        ****
        *****
     //控制行
     for (int i = 0; i < 5; i++) {
     	//控制列
     	for (int j = 0; j < 5; j++) {
     		if(j<=i){
      			System.out.print("*");
 		}
          	}
          	System.out.println(); //换行
     }  
      
        
    进阶版为：打印一个菱形，
    //打印一个菱形
      *
     ***
    *****
     ***
      *
    //控制行
    for (int i=1; i<=2; i++) {
       	for(int j=1; j<=3-i; j++){
    		System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; j++){
            System.out.print("*");
        }
        System.out.println();
    }
    
    for(int i=3; i>=1; i--){
        for(int j=1; j<=3-i; j++){
            System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; j++){
            System.out.print("*");
        }
        System.out.println();
    }
    
    
    打印一个间隔型菱形：
      *
     * *
    * * *
     * *
      *
    for (int i=1; i<=2; i++) {
        for(int j=1; j<=3-i; j++){
            System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; j++){
            if(j%2 == 0){
                System.out.print(" ");
                continue;
            }
            System.out.print("*");
        }
        System.out.println();
    }
    
    for(int i=3; i>=1; i--){
        for(int j=1; j<=3-i; j++){
            System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; j++){
            if(j%2 == 0){
                System.out.print(" ");
                continue;
            }
            System.out.print("*");
        }
        System.out.println();
    }
    ```
    
- 打印99乘法表

```java
//打印九九乘法表
for (int i = 1; i < 10; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(j+"x"+i+"="+(i*j)+" ");  //三种格式化输出
        //System.out.printf("%dx%d=%d"+" ",j,i,i*j);
        //System.out.format("%dx%d=%d"+" ",j,i,i*j);
    }
    System.out.println();
}
```

- 冒泡排序

```java
int []arr = {8,10,1,5,7,3,2,6,9};
//冒泡排序
int tmp = 0;
for (int i = 0; i < arr.length; i++) {
//每轮冒上去一个最大的值。
    for (int j = 0; j < arr.length-i-1; j++) {
    //每次从头到已排好的前一个
        if (arr[j] > arr[j+1]) {
            //前边比后边大,则交换
            tmp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = tmp;
        }
    }
}

for (int num:arr) {
	System.out.print(num+" ");
}
```



## 1.4 输入与输出  todo

### 1.4.1 输入原则



### 1.4.2 简单输出



### 1.4.3 格式化输出





# 2. 面向对象编程

## 2.1 类、对象及引用

### 2.1.1 类

```
基本概念
   类就是"分类"的含义，用于作为多个对象共性的抽象描述，是创建对象的模板(图纸)。
   在Java语言中类是一种引用数据类型，里面包含用于描述特征的成员变量以及用于描述行为的成员方法共同组成。
   对象是客观存在的实体(楼)，在Java语言中体现为堆区的一块内存区域。   

类的定义
(1)类定义的语法格式
   class 类名{
      类体;
   }   
如：
   class Person{
   }
注意：
   当类名由多个单词组成时，要求每个单词的首字母都要大写。
     
(2)成员变量定义的语法格式
   class 类名{
       数据类型 成员变量名 = 初始值;   // 其中 =初始值 通常都省略，但分号不可以省略 
   }
如：
   class Person{
       String name;
       int age;
   } 
注意：
   当成员变量名由多个单词组成时，要求从第二个单词起每个单词的首字母大写。
扩展：
   成员变量 : 主要指声明在类体内、方法体外的变量，作用域从声明开始到类体结束。
   局部变量 : 主要指声明在方法体内部的变量，作用域从声明开始到方法体结束。
```

### 2.1.2 对象

```
对象的创建
(1)语法格式
   new 类名();
如：
   new Person();  - 表示创建Person类型的对象

(2)注意事项
   a.使用new关键字创建/构造对象的过程，叫做类的实例化。
   b.创建对象的本质就是在堆区申请一块存储区域，用于存放该对象独有的成员变量信息。
```

### 2.1.3 引用

```
(1)基本概念
   使用引用数据类型声明的变量叫做引用型变量，简称为"引用"。
   引用主要用于记录对象在堆区中的内存地址信息便于下次访问。

(2)语法格式
   类名 引用变量名;
如：
   Person p;  - 表示声明Person类型的引用变量p
   Person p = new Person(); - 声明Person类型的引用p指向Person类型的对象

   访问对象中成员变量的方式：
       引用.成员变量名;
   如：
       p.name = "zhangfei";
       p.age = 30;
```



## 2.2 成员方法

### 2.2.1 语法格式

```java
   class 类名{
       返回值类型 成员方法名(形参列表){
           成员方法体;
       }
   }
如：
   class Person{
       void show(){
           System.out.println("没事出来秀一下！");
       }
   }
注意：
   当成员变量名由多个单词组成时，要求从第二个单词起每个单词的首字母大写。
```

### 2.2.2 方法的详解
```
(1)返回值类型
   返回值主要指从方法体内向方法体外返回的数据内容。
   返回值类型主要指返回值的数据类型，可以是基本数据类型，也可以是引用数据类型。
   如：
      当返回的数据内容是66时，则返回值类型写 int 类型即可；
      当返回的数据内容是3.14时，则返回值类型写double类型即可；
      当返回的数据内容是"hello"时，则返回值类型写String类型即可；
   在方法体中使用return关键字用于返回数据内容并结束当前方法。
   如：
      当返回的数据内容是66时，则方法体中写：return 66;
      当返回的数据内容是3.14时，则方法体中写：return 3.14;
   当该方法不需要返回任何数据内容时，则返回值类型写void即可。

(2)形参列表
   形式参数主要指从方法体外向方法体内传入的数据内容，格式为：数据类型 形参变量名。
   形参列表指多个形式参数，格式为：数据类型 形参变量名1, 数据类型 形参变量名2, ...
   如：
      当传入的数据内容是66时，则形参列表写为：int i;
      当传入的数据内容是3.14时，则形参列表写为：double d;
      当传入的数据内容是"hello"时，则形参列表写为：String s;
      当传入的数据内容是66和3.14时，则形参列表写为：int i, double d;
      当传入的数据内容是66和"hello"时，则形参列表写为：int i, String s;
   当该方法不需要传入任何数据内容时，则形参列表啥也不写即可；

(3)成员方法体
   成员方法体中主要编写描述该方法功能的语句块；   
```

### 2.2.3 方法的调用
```
(1)语法格式
   引用.成员方法名(实参列表);
如：
   p.show();  //表示调用p对应Person类型中的show方法，实参啥也没有传递

(2)注意事项
   a.实际参数列表主要用于对形式参数列表进行初始化工作，因此类型、个数、顺序等
     都必须保持一致。
   b.实际参数列表可以传递字面值、变量、表达式以及方法的调用等。
```

### 2.2.4 方法的传参

```
方法的传参过程：
  (1)main方法是程序的入口，先为main方法的局部变量申请内存空间并初始化；
  (2)调用max方法时，为max方法的形参变量申请内存空间；
  (3)使用实参变量的数值给形参变量进行初始化；
  (4)执行max方法的方法体，执行完毕后释放形参变量的内存空间；
  (5)main方法中res得到max方法的返回值继续向下执行；
  
 a.当基本数据类型作为方法的参数传递时，通常形参变量的改变不会影响到实参变量；
 b.当引用数据类型作为方法的参数传递时，通常形参变量指向内容的改变会影响到实参变量指向的内容，因为两个变量共享同一块堆区空间；
 c.当引用数据类型作为方法的参数传递时，若形参变量改变指向后再改变指向的内容时，不会对实参变量指向的内容有影响，因为两个变量各自拥有一块独立的堆区空间；
```

测试：参数传递。

### 2.2.5 方法的递归调用

```
基本概念
   递归主要指在方法体的内部调用当前方法自身的形式。
使用方式
  (1)使用递归必须找到规律以及退出条件；
  (2)使用递归必须使得问题简单化而不是复杂化；
  (3)若递归影响到程序的执行性能，则应该使用递推替代之；
```

```
- 递推关系：一个任务如何分解为类似任务与基本任务
- 结束条件：最后的那个任务完成
- 执行顺序演进
```

```java
// 斐波那切数列特点：
1月    2月    3月    4月    5月    6月    7月    8月    9月    10月    11月    12月   
 1      1     2      3     5      8      13    21    34     55      89     144     
//递推与递归实现
private static int fib(int n) {
    int f1_pre = 0;
    int f1 = 1;
    int tmp_sum = 0;
    //int sum_pre = 0;
    //每次迭代，进行前两项的求和
    for (int i = 0; i < n-1; i++) { //n=1：不进行计算， n=2：进行一次计算。 第n次进行n-1次计算。
        // 先求两者之和，将后者存在pre上，并将和存在f1上，f1作为结果输出。
        tmp_sum = f1_pre+f1;
        f1_pre = f1;
        f1 = tmp_sum;
    }

    return f1;
}

//递归实现
规律：递推公式：第n项 = n-1项及n-2项之和。
结束条件：从后到前计算到最初的两项即截止。

int fib(n){
    return n < 2 ? 1 : fib(n-1)+f(n-2);
}
```

练习：自定义成员方法计算参数n指定整数的阶乘并返回。

**需要进一步去leetcode去训练。**

- 费氏数列的递归分析

![image-20200728142241325](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728142241.png)

- 费氏数列的递推分析

![image-20200728142326684](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728142326.png)

## 2.3 构造方法与方法重载

```
如：
   Person p = new Person();  - 表示声明Person类型的引用p指向Person类型的对象
   p.show();                 - 表示调用名字为show的成员方法
```

### 2.3.1 构造方法

```
(1)构造方法语法格式
   class 类名{
      类名(形参列表){
          构造方法体;
      } 
   }
如：
   class Person{
      Person(){
         System.out.println("无参构造方法！");
      }
   }

(2)注意事项
   a.构造方法的名称与类名相同，并且没有返回值类型连void都不许有。
   b.当使用new关键字构造对象时，会自动调用构造方法实现成员变量的初始化工作。

(3)默认构造方法
   当一个类的定义中没有出现任何形式的构造方法时，编译器会自动添加无参的空构造方法，叫做默认/缺省构造方法，如：Person(){}.
   若类中出现了自定义构造方法，则编译器不再提供任何构造方法。

```

- 程序执行流程与内存分析

![image-20200728105436159](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728105436.png)

### 2.3.2 方法的重载

```
(1)基本概念
   	在Java语言中若方法名相同但参数列表不同，这样的方法之间构成重载关系(Overload)。

(2)体现形式
   	方法重载的体现形式为：参数的个数不同、参数的类型不同以及参数的顺序不同，与参数变量名和返回值类型无关，但建议返回值类型最好相同。
   	判断方法能否重载的核心：调用方法时能否加以区分。
(3)重载的意义：
	方法重载的意义在于调用者只需要记住一个方法名就可以调用各种不同的版本从而带来各种不同的效果。
    如：
       int i = 10;
       System.out.println(i);
       double d = 3.14;
       System.out.println(d);
       boolean b = true;
       System.out.println(b);
```

## 2.4 this关键字

```
this基本概念
   若在构造方法中出现了this关键字，则代表当前正在构造的对象；
   若在成员方法中出现了this关键字，则代表当前正在调用的对象；

原理分析：
   当成员方法中访问成员变量时会默认加上this.，this.相当于汉语中"我的"，因此不同的对象调用同一个方法时会导致this关键字不同，那么this.访问成员变量的结果随之不同。

使用方式
  (1)当形参变量名与成员变量名同名时，在方法体中会优先使用形参变量，若希望使用成员
     变量则需要在变量名的前面加上this.加以说明(掌握)。
  (2)在构造方法的第一行使用this(实参)的方式可以调用本类中的其它构造方法(了解)。
```

## 2.5 封装

```
基本概念
   语法上可以给成员变量赋值一些符合语法但不合理的数值，这种情况在编译阶段和运行阶段都不会报错或给出任何的提示信息，此数值虽然合法但与现实生活不符；
   为了避免上述问题的发生，就需要对成员变量进行密封包装处理来保证该成员变量的合法合理性，这种机制就叫做封装。
实现流程
  (1)私有化成员变量，使用private关键字修饰；
  (2)提供公有的get和set方法，在方法体中进行合理值的判断，使用public关键字修饰；
  (3)在构造方法中使用set方法进行合理值的判断；
```

练习

```java
public class Person {

    //1. 私有化成员变量
    private int age;
    private String name;

    //2. 提供公有的get、set方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("年龄不合理！");
        }else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Person(){
        System.out.println("无参构造方法");
    }
    //3. 在构造方法中使用set方法进行合理值的判断
    Person(int age){
        setAge(age);
        System.out.println("age构造方法");
    }
    Person(int age, String name){
        setAge(age);
        setName(name);
        System.out.println("age,name构造方法");
    }


    void show(){
        System.out.println(this.age+" "+this.name);
    }


    public static void main(String[] args) {
        Person p = new Person(-1,"haha");
        p.show();  // 年龄不合理！
				   // age,name构造方法
				   // 0 haha
    }
}
```



## 2.6 static关键字

```
基本概念:
	通常情况下成员变量隶属于对象层级，也就是每当创建一个对象就会拥有独立的内存空间来存放独立的成员变量信息，若所有对象中某个成员变量完全相同时还要各自存储，则会造成内存空间的浪费。
   	为了解决上述问题则使用static关键字修饰该成员变量表达静态的含义，此时该成员变量由对象层级提升为类层级只有一份并被所有对象共享，会随着类的加载而准备就绪与是否创建对象无关。
   	static关键字既能修饰成员变量也能修饰成员方法，推荐使用 类名. 的方式访问。

使用方式:
    (1)非静态的成员方法中既能访问非静态的成员又能访问静态的成员。
       (成员：成员变量 + 成员方法  静态成员被所有对象共享)
    (2)静态的成员方法中只能访问静态的成员不能访问非静态的成员。
       (成员：成员变量 + 成员方法  调用该方法时可能还没有创建对象)
    (3)只有隶属于类层级被所有对象共享的内容才可以使用static关键字修饰。
       (不能滥用static关键字)
```

> 类加载机制：[https://baijiahao.baidu.com/s?id=1636309817155065432&wfr=spider&for=pc](https://baijiahao.baidu.com/s?id=1636309817155065432&wfr=spider&for=pc)

![image-20200728131127628](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728131127.png)

## 2.7 单例模式实现 Singleton

> [单例模式的多种实现](https://www.runoob.com/design-pattern/singleton-pattern.html)

```
(1)基本概念
   当一个类对外提供且只提供一个对象时，这样的类叫做单例类。
   而设计单例类的思想和编程模式叫做 单例设计模式。

(2)实现流程
   a.私有化构造方法，使用private关键字修饰；
   b.提供本类类型的引用指向本类的对象，使用private static关键字共同修饰；
   c.提供公有的get方法负责将对象返回出去，使用static关键字修饰；

(3)实现方式
   单例设计模式分为两种：饿汉式 和 懒汉式，在以后的开发中推荐饿汉式。
```

```
每个.java文件中只能有一个public修饰的class
```



![image-20200728131159089](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728131159.png)

练习：构建一个单例类(饿汉式)  

```java
public class TestSingleton {  //一个.java文件中仅可以存在一个public修饰的类    

    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s1 == s2);
        //执行私有构造方法
        //true

    }

}


//该类对外提供且只提供一个对象，饿汉式，最简单的一种方式。
class Singleton{

    //1. 私有化构造方法
    private Singleton(){
        System.out.println("执行私有构造方法");
    }
    //2. 提供本类类型的引用指向本类的对象，使用private static关键字共同修饰
    private static Singleton singleton = new Singleton();
    //3. 提供公有的get方法负责将对象返回出去，使用static关键字修饰；
    public static Singleton getSingleton(){
        return singleton;
    }

}
```

如何能提供且仅能提供有限个对象？

## 2.8 继承

```
基本概念
   当多个类之间有相同的特征和行为时，可以将共性的内容提取出来组成一个公共类，让多个类分别吸收公共类中已有的特征和行为，而在多个类中只需要编写自己独有特征和行为的机制就叫做继承。  
   使用继承可以提高代码的复用性、可维护性以及可扩展性。
   在Java语言中使用extends(扩展)关键字来表达继承关系。
如：
   public class Student extends Person{}  - 表示Student类继承自Person类
   其中Person类叫做超类、基类、父类。
   其中Student类叫做派生类、孩子类、子类。

注意事项
  (1)子类可以继承父类的成员变量，包括私有成员变量但不能直接访问；
     子类不可以继承父类的构造方法和私有成员方法；
```

**Java中的类：**

- 只支持单继承，不支持多继承。



## 2.9 super关键字

```
(1)基本概念
   this关键字主要代表本类的对象；
   super关键字主要代表父类的对象；

(2)使用方式
   使用this.的方式可以访问本类的成员变量和成员方法；
   使用super.的方式可以访问父类的成员变量和成员方法；
 
   使用this()在构造方法的第一行表示调用本类中的其他构造方法；
   使用super()在构造方法的第一行表示调用父类的构造方法；

要求大家掌握的用法：
   a.使用this.的方式可以区分同名的成员变量和形参变量；
   b.使用super(实参)的方式可以调用父类的构造方法；
   c.使用super.的方式可以可以调用父类中被重写的方法；
```

## 2.10 方法的重写(Override)

```
(1)基本概念
   当子类从父类类继承的方法不足以满足子类的需求时，就需要在子类中重新写一个与父类一样的方法来覆盖从父类继承的版本，这个过程叫做方法的重写。

(2)重写的原则(笔试题)
   a.要求方法名相同、参数列表相同以及返回值类型相同，从jdk1.5开始允许返回子类类型；
   b.要求方法的访问权限不能变小，可以相同或者变大；
   c.要求不能抛出更大的异常(异常机制)；
```

```java
public class Student extends Person{ //练习了继承、关键字、方法的重写
    private int stu_id;

    Student(){
        System.out.println("Student()");
    }

    Student(int age,String name,int stu_id){
        super(age, name);
        System.out.println("Student(int age,String name,int stu_id)");
        setSut_id(stu_id);
    }

    public int getSut_id() {
        return stu_id;
    }

    public void setSut_id(int sut_id) {
        this.stu_id = sut_id;
    }

    @Override
    protected void show(){
        System.out.print(this+": ");
        super.show();
    }

    public static void main(String[] args) {
        Student student = new Student(18,"xixi",1972);
        student.show();
    }

}
```



## 2.11 访问控制

```
(1)常用的访问控制符(笔试题)
   访问控制符    访问权限     本类         本包中的类    子类      其它包中的其它类
----------------------------------------------------------------------------------
    public       公有的        ok         ok         ok             ok
    protected    保护的        ok         ok         ok             no
啥也不写default    默认的        ok         ok         no             no
    private      私有的        ok         no         no             no

要求大家掌握的内容：
    a.public修饰的内容可以在任意位置使用；
    b.private修饰的内容只能在本类中使用；
    c.通常情况下，成员方法都使用public修饰，成员变量都使用private修饰；
(2)包的定义
    package 包名;    
    package 包名1.包名2...包名; - 主要用于定义多层包，为了便于管理和避免命名冲突.
```



## 2.12 final关键字

```
(1)基本概念
   final本意为"最终的，不可更改的"，可以修饰类、成员方法、成员变量；

(2)使用方式
   使用final关键字修饰类，体现在该类不能被继承。
       - 为了防止滥用继承，如：java.lang.String类等。
   使用final关键字修饰成员方法体现在该方法不能被重写。
       - 为了防止不经意间造成的重写，如：java.text.DateFormat类等。
   使用final关键字修饰成员变量体现在该变量必须初始化而且不能更改。
       - 为了防止不经意间修改数值，如：java.lang.Thread类的MAX_PRIORITY等。
```

```
扩展：
   在以后的开发中很少单独使用static关键字或final关键字修饰成员变量，通常都是使用public static final共同修饰成员变量来表达常量的含义，常量的命名规范是：所有字母大写，不同单词之间采用下划线连接，如：
   public static final double PI = 3.1415926;
```



## 2.13 对象创建的过程(补充类加载机制)

```
(1)单个对象创建的执行过程:
    (1)main方法是程序的入口，当创建对象时会在堆区申请一块存储区域；
    (2)若没有指定成员变量的初始值时，则采用默认初始化进行；
    (3)若指定成员变量的初始值后，则采用显式初始化进行；
    (4)执行构造块可以对成员变量进行赋值；
    (5)执行构造方法体可以对成员变量进行再次赋值；
    (6)此时对象创建完毕，继续向下执行；
 显示初始化=> 构造块 => 构造方法体   
```

 ```java
public class TestObject {
	private int cnt = 1;  //在声明成员变量的同时指定初始值  => 显式初始化  (1)
	
	{
		cnt = 2; //构造块  (2)
	}
	
	public TestObject(){
		cnt = 3; //构造方法体 (3)
	}
	
	public static void main(String[] args) {
	
		TestObject to = new TestObject();
		System.out.print("to.cnt = " + to.cnt); //0  1  2 3
	}
}
 ```


 ```
(2)子类对象创建的执行过程:
    (1)main方法是程序的入口；
    (2)先加载父类再加载子类，因此先执行父类的静态代码块，再执行子类的静态代码块；
    (3)执行父类的构造块和父类的构造方法体，此时父类部分构造完毕；
    (4)执行子类的构造块和子类的构造方法体，此时子类对象构造完毕；
    (5)继续执行后续的代码；
 ```

```java
public class TestSuperObject {

	{
		System.out.println("TestSuperObject类中的构造块");  //(2)    c
	}
	
	static{
		System.out.println("TestSuperObject类中的静态代码块"); //(1)   a
	}
	
	public TestSuperObject(){
		System.out.println("TestSuperObject()");  //(3)   d
	}
	
	public static void main(String[] args) {
		
		TestSuperObject tso = new TestSuperObject();
	}

}
```

```java
public class TestSubObject extends TestSuperObject {

	{
		System.out.println("TestSubObject类中的构造块");  //(2)   e
	}
	
	static{
		System.out.println("TestSubObject类中的静态代码块"); //(1)  b
	}
	
	public TestSubObject(){
		System.out.println("TestSubObject()");  //(3)  f
	}
	
	public static void main(String[] args) {
		
		TestSubObject tso = new TestSubObject();

	}

}
```



![image-20200728141245404](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728141245.png)



## 2.14 多态

```
(1)基本概念
   多态主要指同一种事物表现出来的多种形态。
   人：学生、教师、工人、... 
   饮料：可乐、雪碧、红牛、乐虎、...
   动物：猫、狗、鸟、小强、...  
   整数：byte b1 = 10; short s1 = 10; int i1 = 10; ...   
   ... 

(2)语法格式
   父类类型 引用变量名 = new 子类类型();
如：
   Animal ad = new Dog();  //狗是一种动物，但狗作为动物具有其独特的show方法。
   ad.show();
解析：
   编译阶段调用父类的show方法，运行阶段调用子类重写以后的show方法。

(3)多态的效果
- 父类的引用可以直接调用子类的重写的方法；   ** 多态的真正好处
- 父类引用不能直接调用子类独有的方法；
- 父类引用可以直接调用父类独有的的方法；
    (1)当父类的引用指向子类的对象时，父类的引用可以直接调用父类独有(子类中没有)的方法；
    (2)当父类的引用指向子类的对象时，父类的引用不可以直接调用子类独有的方法；
    (3)对于父子类都拥有的非静态成员方法来说，编译阶段调用父类版本，运行阶段调用子类版本    //只有这种情况下，父类指向子类的引用才可以调用子类的show()方法
    (4)对于父子类都拥有的静态方法来说，编译和运行阶段都调用父类版本，与对象无关；
```

练习：

​	 自定义矩形(Rect)类，特征有：横纵坐标、长度及宽度，要求实现封装并提供打印方法；
​     自定义圆形(Circle)类，特征有：横纵坐标、半径，要求实现封装并提供打印方法；
​     提取共性自定义图形(Shape)类。
​     自定义TestShape类，自定义成员方法实现既能打印矩形又能打印圆形的方法并调用。

## 2.15 instanceof关键字

```
(1)基本概念
	判断对象是否来自某个指定的类，(只能是引用类型，不能是基本类型)
		是==>返回true
		否==>返回false
(2)使用
	instancceof 常用于解决ClassCastException 
```

```java
Person person = new Student(18,"xixi",1972);
System.out.println(person instanceof Person); //true
System.out.println(person instanceof Student);  //true
```



## 2.16 抽象类

```
在Java中, 使用abstract关键字 修饰的类, 称为抽象类 !   
首先它是一个类，除了不能实例化，其它都可以。
抽象类必须被继承才有意义。抽象类可以继承自另一个抽象类。
抽象类中 非抽象的部分 是抽取出的公共部分。
抽象类中, 抽象的方法可以被子类重写,  我们称这种操作叫做抽象方法的 实现 !
```

```java
public abstract class Employee
{
   private String name;
   private String address;
   private int number;
   
   public abstract double computePay();
   
   //其余代码
}
```

```
声明抽象方法会造成以下两个结果：
    如果一个类包含抽象方法，那么该类必须是抽象类。
    任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
```

- **抽象类总结**

  - 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
  - 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
  - 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
  - 构造方法，类方法（用 static 修饰的方法）, final方法，私有方法不能声明为抽象方法。
  - 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。但最终一定要实现。

  

- 面试题

```
一个类, 如果没有抽象方法, 可以不可以被定义为 抽象类 ? 如果可以, 有什么意义 !
答:  可以定义为抽象类, 它的意义在于不让程序创建本类对象 !

抽象关键字 abstract 与哪些关键字 不能共存: 
答:
    private :   私有的方法,  子类无法重写 ! 
    final   :   final修饰的方法, 不能被重写!
    static  :   静态的方法, 不依赖于对象! 
```

## 2.17 模板方法设计模式

```
定义一个功能的骨架 , 一部分功能是确定的 ,一部分功能是不确定的 . 把确定的功能实现, 不确定的功能抽取出来, 延迟到子类中进行实现。
```

- 案例：

```

```

## 2.18 接口interface

```
如果一个类中的全部方法都是抽象方法, 全部属性都是全局常量, 那么此时可以将这个类定义为一个接口；
接口之间可以继承，接口可以被实现, 且一个类可以实现多个接口；  
接口如果没有被实现,  那么这个接口没有任何的意义。

定义接口的格式: 
    interface 接口名称{
        //全局常量
        //抽象方法
    }

实现接口的格式:
    class 类名 implements 接口1,接口2...接口n{
        //实现抽象方法
    }
    
特别的：
在编写接口中的抽象方法时,可以使用简写格式: 

    格式:  返回值声明 方法名();

    例如:
        编写方法 a
            void a();
        编译器会自动识别为: 
            public abstract void a();
在接口中, 无法定义变量,只能定义全局常量,定义的方式也可以简写:

    格式: 数据类型 常量名 = 初始化值;

    例如:
        定义常量:
            int a = 10;
        编译器会自动识别为:
            public static final int a = 10;
```

问题：抽象类与接口的异同？ 见question.md

## 2.19 匿名对象

```
我们添加对象名称, 是为了创建对象后, 能多次操作这个对象  ,
有时, 我们创建一个对象,  可能只打算使用一次, 那么我们就可以使用匿名对象 !

格式:
        new 类名();
案例:
        new Util().haha(3000);
匿名对象 只能使用一次, 使用完毕后, 会被GC视为垃圾, 进行回收 !
```

## 2.20 内部类
```
内部类, 就是编写在一个类中的成员类 !

格式:
    class 外部类名{
        //成员属性
        //成员方法
        class 内部类名{

        }
    }
```

- 案例

```

```

```
-   缺点: 一个类在设计时, 应只包含特征(属性)和行为(方法) , 内部类的定义 , 打破了原有的定义格式 !
-   优点: 内部类 可以直接访问外部类私有的属性, 可以简化程序的开发, 又能保证程序的封装 !

内部类对象创建的格式:

    外部类名 外部类对象名 = new 外部类名();
    外部类名.内部类名 对象名 = 外部类对象名.new 内部类类名();
案例:
    Outer o = new Outer();
    Outer.Inner i = o.new Inner();
```

```
内部类被编译后, 会生成class文件吗?   如果存在, 文件是如何命名的? 

答:  会生成class文件 命名方式为:  外部类名$内部类名.cl
```

### 2.20.1 静态内部类

```
在内部类前加上static修饰。
格式: 
    class 外部类名{
        //成员属性
        //成员方法
        static class 内部类名{

        }
    }

创建对象的格式:
    外部类名.内部类名 对象名 = new 外部类名.内部类名();
```

### 2.20.2 匿名内部类

```
不存在类名的内部类, 我们称其为匿名内部类, 匿名内部类只可使用一次, 且必须是定义时使用 !

匿名内部类, 必须存在父类或父接口 !!
语法格式:

    new 父类名称(){
        //匿名内部类的代码块
    };
```

```java
案例:
    public class Person{
        private String name;
        private int age;
        public void say(){
            System.out.println("哈哈哈");
        }
    }

    public class Demo{
        public static void main(String[] args){
            Person p = new Person(){
                public void say(){
                    System.out.println("嘿嘿嘿");
                }
            };
            p.say();
        }
    }
```

## 2.21 回调接口

```java
案例:
    public class A {
        /**
         * 求两个数字的和 , 
         * @param num1  求和的第一个数字
         * @param num2  求和的第二个数字
         * @param b 产生结果后, 会将结果传递给B
         */
        public void sum(int num1,int num2,B b) {
            int s = num1+num2;
            b.run(s);
        }
    }

    public interface B {
        void run(int sum);
    }

    public class Demo {
        static B b = new B() { // B的静态内部类
            @Override
            public void run(int sum) {
                System.out.println("run方法执行了 "+sum);
            }
        };
        public static void main(String[] args) {
            A a = new A();
            a.sum(100, 200,b);
            System.out.println("哈哈哈");
        }
    }
```

## 2.22  零碎知识

### 2.22.1 Java中的包

```
Java 所提供的 常见的包
-   java.lang 包 , 是Jre的核心包, JVM启动时会自动加载, 使用此包中的类不需要导包!
-   java.util 包 , 是Java的工具包, 包含了很多的工具类, 是我们后期学习的重点 !
-   java.io   包 , 是输入输出的包, 常用于文件的读写!
-   java.net  包 , 是Java中的网络包, 包含了用于网络编程的所有API . 
-   java.sql  包 , 是操作数据库的包 . 
```



### 2.22.2 Object 对象

```
在java类的体系中, 我们称Object类 为所有类的基类 !  
Object类位于继承关系的顶端 ! 如果一个类定义时没有声明父类, 则默认父类为Object  !
```

### 2.22.3 toString方法 

```
Object类中的toString方法，默认返回的是 : 类名@运算的十六进制hashCode值；
当使用System.out.println打印对象时, 默认打印的是对象的toString方法的返回值；
我们通常会给类 重写 toString方法, 然后让其返回对于当前对象的文字描述信息。
```

- 案例：
```java
public class Person{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
```

### 2.22.4 equals 方法

```
作用：
	判断两个引用所指向的内存空间中的值是否相同
	==  判断基本数据类型的值是否相等；判断两个引用指向是否是同一对象；
编写equals方法原则：
```

```
1. 自反性
x.equals(x); // true

2. 对称性
x.equals(y) == y.equals(x); // true

3. 传递性
if (x.equals(y) && y.equals(z))
    x.equals(z); // true;
4. 一致性
多次调用 equals() 方法结果不变
x.equals(y) == x.equals(y); // true

5. 非空性
对任何不是 null 的对象 x 调用 x.equals(null) 结果都为 false
x.equals(null); // false;
```

### 2.22.5 hashCode方法

```
此方法返回一个int类型的数据 , 只需要遵循如下规范即可:

    1.  一致性：同一个对象,属性不更改的情况下, hashCode值应该是一致的；
    2.  两个属性完全相同的对象, hashCode值应该一致；
    3.  hashCode值 ,不是用来判断对象是否相同的依据, hashCode值相同, 对象不一定相等, 因为不同类的实例对象可能会产生相同的hashCode值。
        不过在设计hashCode方法时,我们建议,hashCode值的比较的结果 应与equals比较结果 一致 !

使用：
	一般与equals方法 一起使用!。
```

### 2.22.6 clone方法

```
快速创建一个对象。比new更快，节省了内存测量的过程。
clone方法是Object实现的,我们在使用时,现需要添加克隆标记；
添加标记的方式, 是让一个类实现Cloneable 接口 !
```

```java
案例:
public class Person implements Cloneable{

    private String name;
    private int age;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}
```

## 2.23 基本数据类型的包装类

```java
byte        java.lang.Byte
short       java.lang.Short
int         java.lang.Integer
long        java.lang.Long
double      java.lang.Double
float       java.lang.Float
char        java.lang.Character
boolean     java.lang.Boolean
```

- **拆箱与装箱**

```
什么是装箱:
    将一个基本数据类型的数据 转换为 包装类对象的过程 !
什么是拆箱:
    将一个包装类的对象 转换为 基本数据类型数据的过程 !
```

- **JDK1.5版本之前, 需手动拆箱与装箱**

```java
装箱操作:
    格式: 
        方式1.    Integer i = new Integer(int值);
        方式2.    Integer i = Integer.valueOf(int值);

拆箱操作:   
    格式:
        int n = Integer对象.intValue();

案例:

    Integer i1 = new Integer(100);
    Integer i2 = Integer.valueOf(100);

    int int1 = i1.intValue();
    int int2 = i2.intValue();
    System.out.println(int1);
    System.out.println(int2);
    System.out.println(int1==int2);

在1.5版本之前, 进行包装类的操作, 特别麻烦 . 例如, 需要将两个integer 进行加法运算, 需如下编写代码:
    Integer i1 = new Integer(100);
    Integer i2 = Integer.valueOf(100);

    int sum = i1.intValue()+i2.intValue();
```

- **JDK1.5版本加入了 自动装箱和拆箱操作**

```
在integer的自动装箱操作中, 加入了一个知名的设计模式, 叫享元设计模式 !  其他的包装类是否有享元？

将-128 - 127的返回的数据, 进行了重复利用 !
```

- **包装类常用属性**

```
MAX_VALUE   :   全局常量, 表示指定包装类的最大值。
MIN_VALUE   :   全局常量, 表示指定包装了的最小值。
```

- **包装类常用方法**

```
将字符串数据, 转换为指定的数据类型 !

-   方式1.    包装类.parseXXX()
        例如:
        int num = Integer.parseInt(String 文本);

-   方式2.    Integer num = new Integer(String 文本);

注意:
    在转换时, 字符串的格式必须是指定类型的,  例如: 不能将"哈哈哈"转换为int类型!  

    转换时数据类型不匹配会抛出错误:
    NumberFormatException   数字格式化异常
```

- **面试题**

```java
Integer i1 = 127;
Integer i2 = 127;
System.out.println(i1==i2); //数据范围-128 - 127 结果为: true
Integer i1 = 128;
Integer i2 = 128;
System.out.println(i1==i2); // false
```

## 2.24 String类

### 2.24.1 String类简介

```
-   String的值 一经确定 不可更改。
    在java 8中，String类的内部实现, 是通过 final char[] 来完成的。 又因为数组的长度一经确定无法改变。所以字符串的值一旦确定, 不可更改。
    final保证这个引用变量所引用的地址不会改变，即一直引用同一个对象，但这个String对象str完全可以发生改变。

    在字符串拼接操作时, 系统会舍弃原有字符串 , 开辟新的空间存储拼接的结果, 所以会产生大量的系统垃圾, 建议后期进行开发时, 尽可能少的拼接字符串 !

-   字符串常量池（采用享元设计模式-第二个地方）
    因为我们经常在程序总编写字符串, 且很多时候, 在一个程序中会出现多个相同的字符串 , 官方为了优化这种操作, 加入了字符串常量池 !
    如果程序中使用了一个字符串, 则值会被存储到常量池中, 下次使用时 会自动去常量池中寻找 , 如果存在则重复使用, 不存在则创建新的字符串 并存储到常量池中 !

    注意:  通过new 的到的字符串, 一定是新开辟的内存空间 !

注意: 我们称""引住的部分为字符串字面量 , 一段字符串的字面量,就是一个匿名的String对象 !     
```

在 Java 8 中，String 内部使用 char 数组存储数据。

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];
}
```

源码解析之为什么说String的之一经确定不可修改？

有人会问：

```java
String str = "abc";
str = "bcd";
System.out.println(str);  //输出bcd
```

输出bcd不是修改了str的值了么，这不就可变了么？

我们知道“abc”与“bcd”为两个字符串常量，分别存储在字符串常量池的两个位置。

又根据源码 final char value[]; 我们知道，字符串由字符数组来存储，final修饰的引用类型变量value不可以更改引用，也就是不可以更改指向，但这个引用所指向的数组内容可以改变，且因为是不可变长数组，故：

```java
final char[] value = {'a', 'b', 'c'};
value[0] = 'd';
System.out.println(value);  //输出dbc
```

且无法向数组内添加或删除新的元素。这样的话指向就发生了改变。

![image-20200728200146574](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728203355.png)

实际上我们要认清一点，我们所说的String字符串并非是指str，而是“abc”与“bcd”，它们一经创建如图：

![image-20200728201543980](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200728201544.png)

**PS：**jdk1.7 及之后常量池已经从方法区中移了出来，在堆中开辟了一块区域存放运行时常量池，JDK1.8开始，取消了方法区，而使用直接位于内存的元空间。

​		一个字符串常量对应一个匿名的字符串对象，即堆中的value所在。String 类型的str，可以改变其内的引用，但“abc”与“bcd”一经确定，就被固定不可变了，即字符串的值一经确定不可更改。str只是对象变量名。

### 2.24.2 常用方法

```java
-	char charAt(int index) 
	返回指定索引 index 处的 char 值。

-   boolean contains(CharSequence s) 
	判断字符串是否包含指定的 字符序列 ，包含返回 true。 

-   boolean endsWith(String 后缀) 
	判断字符串是否以指定的后缀结束。 

-   boolean equals(Object anObject) 
	调用方法的字符串与传入的对象比较。 相同则返回true

-   byte[] getBytes() 
	使用默认的编码表, 将字符串打碎成字节数组 并返回


-   int indexOf(int ch) 
	返回指定字符在此字符串中第一次出现的索引。

-   int indexOf(String str) 
	返回指定字符串在此字符串中第一次出现的索引。

-   int length() 
	返回此字符串的长度。 

-   String replace(CharSequence 查找的文字, CharSequence 替换的新文字) 
	将字符串中匹配查找到的文字, 替换为指定的新文字 , 此操作不会更改原字符串, 而是返回新的字符串!

-   String[] split(String regex) 
	根据给定正则表达式 或 字符串 的匹配拆分此字符串。

-   String substring(int beginIndex, int endIndex) 
	从原字符串中截取一个新字符串并返回 , 截取的字符串，是从beginIndex开始到endIndex结束的  (包含开头 不包含 结尾 ) 

-   char[] toCharArray() 
	将此字符串转换为一个新的字符数组。 

-   String trim() 
	返回新的去除了前导空白和尾部空白的字符串
```
- **案例**

```java
public static void main(String[] args) {
    String text = "好好学习，天天向上！";
    //查
    System.out.println(text.charAt(3));
    System.out.println(text.codePointAt(3)); //获取‘习’字符的unicode编码  20064
    System.out.println(text.length());   //返回字符串长度 10
    System.out.println((char)20064); //习
    System.out.println(text.equals("好好学习，天天向上！")); //true   内容相同
    System.out.println(text=="好好学习，天天向上！"); //true    地址相同
    System.out.println(text.indexOf('习')); //3
    System.out.println(text.indexOf("天向上！")); //6
    System.out.println(text.endsWith("向上！")); //true
	
	//转换
    System.out.println(text.toCharArray());  //好好学习，天天向上！  返回一个char[]，能够输出
    System.out.println(text.getBytes());  //返回一个  byte[]的引用，输出的是[B@1b6d3586
	
    //操作
    String[] arr = text.split("，");
    System.out.println(arr[0]); //好好学习
    System.out.println(arr[1]); //天天向上！
    System.out.println(text.concat("天若有情天亦老"));  //好好学习，天天向上！天若有情天亦老
    System.out.println(text);  //好好学习，天天向上！   可见concat并未改变text的内容,除非text = text.concat("天若有情天亦老")
    System.out.println(text.replace("天天向上","day day up")); //好好学习，day day up！  返回一个新字符串，只有接收之后才会改变原字符串。
    System.out.println(text); //好好学习，天天向上！
    System.out.println(text.subSequence(2,5)); //学习，   前闭后开    返回的是CharSequence
    System.out.println(text.substring(2)); //学习，天天向上！    返回的是string
    System.out.println(text.substring(2,5)); //学习，     返回的是string
    System.out.println("  哈哈哈，嘻嘻嘻   ".trim());  //哈哈哈，嘻嘻嘻
}
```



### 2.24.3 正则表达式

```
一种字符串表达式 , 是一组特定的字符组成的一个规则字符串 ! 
```

- **规则**

```
描述字符的符号: 

    [abcde] :   a/b/c/d/e 中的任意一个字符
    [^abcde]:   除了 a/b/c/d/e 之外的任意一个字符
    [a-z]   :   所有小写字母
    [A-Z]   :   所有的大写字母
    [0-9]   :   所有的数字
    [a-zA-Z0-9]:所有的大小写字母 和 数字
    [a-z&&[^abc]]   :   所有小写字母中除了a/b/c的字符

快捷字符描述:
    .       :   任意一个字符
    \d      :   任意数字  ,与 [0-9]效果一致
    \D      :   任意非数字  ,与 [^0-9]效果一致
    \s      :   所有的空白字符 \n\t\f\r\X0B等等
    \w      :   所有的大小写字母 和 数字 与[a-zA-Z0-9]效果一致
    \W      :   相当于[^\w]

数量符号:
    x?      :   0 或 1个 x
    x*      :   0 或 任意个x
    x+      :   表示1个或以上个x
    x{n}    :   n表示数字, 描述的是n个x
    x{n,}   :   至少n个数字
    x{n,m}  :   表示至少n个x 最多m个x

特殊符号:
    &&      :   与
    |       :   或
    \       :   转义符号 , 例如: .在正则表达式总具备特殊案例, 如果需要匹配.字符 ,则需要使用\.

正则表达式它的应用范围 很广泛,  市面上常见的编程语言都对其进行了支持 !


验证字母开头的帐号, 长度必须8-18位
[a-zA-Z]\w{7,18}
验证一段字符串是否是手机号 ? 
1(3[0-9]|4[57]|5[0-9]|6[5679]|7[0356789]|8[012356789]|99)\d{8}

验证日期格式 : yyyy-MM-dd (2018-01-05)
\d{4}-(1[012]|0[123456789])-(0[123456789]|1[0-9]|2[0-9]|3[01])
```

- **使用**

```
在String类中, 存在正则表达式使用的一些方法: 

-   split(正则表达式)    :   按照正则表达式的规则, 拆分字符串
-   String replaceAll(正则表达式,替换的新文本) :   将匹配正则表达式的文本部分, 替换为指定的新文本
-   boolean matches(正则表达式)  :是否匹配

拆分案例:
    String text = "你好 你吃饭了吗 哈哈哈";
    String[] arr = text.split("\\s");
    for(int i=0;i<arr.length;i++){
        System.out.println(i+":"+arr[i]);
    }

替换案例:
    String text = "你好12321你吃饭了吗12313123哈哈哈";
    text = text.replaceAll("\\d+",",");
    System.out.println("替换后:"+text);

验证案例:
    Scanner input = new Scanner(System.in);
    System.out.println("请输入一个账号 , 规则要求:必须字母开头, 长度8-18位");
    String text = input.nextLine();
    if(text.matches("^[a-zA-Z]\\w{7,18}$")) {
        System.out.println("匹配");
    }else {
        System.out.println("不匹配");
    }


练习:
    通过正则表达式, 匹配指定字符串是否为邮箱:

    [a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+

    Scanner input = new Scanner(System.in);
    System.out.println("请输入一个邮箱:");
    String text = input.nextLine();
    if(text.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
        System.out.println("匹配");
    }else {
        System.out.println("不匹配");
    }
```

### 2.24.4 StringBuffer与StringBuilder

```
是Java中 可变长度的字符序列实现 ! 
默认缓冲区大小为16 , 扩容的默认算法为: 乘二加二 , 如果扩容后依然不足以存储新的数据 ,则缓冲区大小 直接扩容为所需长度!
```

面试题： StringBuilder 与StringBuffer的区别: 
```
    这两个类, 都是AbstractStringBuilder的子类 !
    使用上两者完全一致,不同于String的是可以对字符串进行改变  区别在于: 

 	StringBuffer  是线程安全的, 效率低。
    StringBuilder 是非线程安全的 ,效率高。
```

- 构造方法

```
常用三个: 

    1.  StringBuilder() | StringBuffer()
            创建一个不包含任何字符的字符序列 , 初始容量为16个字符 !
    2.  StringBuilder(int 初始容量) | StringBuffer(int 初始容量)
            创建一个不包含任何字符的字符序列 , 初始容量为指定大小 !
    3.  StringBuilder(String 初始内容) | StringBuffer(String 初始内容)
            根据一个字符串 , 创建一个可变长度的字符序列
```

- 常用方法:

```
-   append(任意内容): *****
        -   将参数中的内容, 追加到原字符串后 ! 此方法return this;

-   insert(int 下标,CharSequence 新的内容):
        -   将新的字符串内容, 插入到原字符串的指定下标位置

-   delete(int 起始位置,int 结束位置):
        -   将指定位置的数据, 从字符序列中移除!

-   replace(int 起始位置,int 结束位置,String 新的字符串);
        -   将指定位置的数据, 替换为新的字符串数据!

-   reverse()   :   反转字符串

-   toString()  :   转换为字符串
```

- **案例**

```java
public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("好好学习，天天向上！");
        stringBuffer.append("奥利给!").append("加油！");
        System.out.println(stringBuffer.toString()); //好好学习，天天向上！奥利给!加油！
        //指定下标插入
        stringBuffer.insert(2, "向他人");
        System.out.println(stringBuffer.toString());  //好好向他人学习，天天向上！奥利给!加油！
        //删除指定范围
        stringBuffer.delete(2, 5);
        System.out.println(stringBuffer.toString());  //好好学习，天天向上！奥利给!加油！
        //替换指定范围的数据
        stringBuffer.replace(2, 4, "上课");
        System.out.println(stringBuffer.toString());  //好好上课，天天向上！奥利给!加油
        //反转字符串
        stringBuffer.reverse();
        System.out.println(stringBuffer.toString());  //！油加!给利奥！上向天天，课上好好
    }
```



### 2.25 日期相关类

#### 2.25.1 Date类
```
Date是Java中描述时间日期的类 !
构造方法:
    -   new Date(): 创建一个描述当前时刻的日期时间对象 !   ps:已经获得了当前时刻。

    -   new Date(long date): 创建一个从1970年1月1日 8点到当前的指定毫秒的日期时间对象

常用方法:
    long date.getTime():
    返回一个整数值，这个整数代表了从 1970 年 1 月 1 日开始计算到 Date 对象中的时间之间的毫秒数，也是常说的时间戳

获取时间戳的另一种方式: 推荐:
    System.currentTimeMillis()
```

- **案例**

```java
public static void main(String[] args) {
    Date date = new Date();  //直接就能获取当前时间，和下边date1的效果相同
    Date date1 = new Date(System.currentTimeMillis());
    System.out.println(date.getTime());  //1596338141883  时间戳
    System.out.println(date); //Sun Aug 02 11:15:41 CST 2020
    System.out.println(date1.toString()); //Sun Aug 02 11:15:41 CST 2020

}
```

#### 2.25.2 时间格式化 SimpleDateFormat *

```java
	-   创建对象: 

    -   new SimpleDateFormat(String 日期格式化字符串);

常用方法:
	-   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss sss"); 
    -   String dateStr = simpleDateFormat.format(Date date); ***  //date格式化为时间字符串
    -   Date date = simpleDateFormat.parse(String 日期格式字符串);  //时间字符串解析为date

使用：
	以下两种情况。
```

- Date对象 转换为 字符串  (常用于显示时间)

```java
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss sss"); //11:33:11 011
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E aHH:mm");  //星期日 上午11:32
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2020-08-02 11:32:54

String dateStr = simpleDateFormat.format(new Date());
//需要更新时间使用：Date date = new Date(); date.getDate();
System.out.println(dateStr);
```

- 字符串 转换为 Date对象（常用于操作数据库 , 或 读取时间）

```java
//字符串转换为Date对象
SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = simpleDateFormat1.parse("2020-08-02 11:32:54");
System.out.println(date.getTime()); //得到时间戳，存到数据库中
```

### 2.25.3 Calendar类

```java
public class MyCalendar {
    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        int a = c.get(Calendar.YEAR);
        System.out.println(a); //2020
        int b = c.get(Calendar.MONTH);
        System.out.println(b); //7
    }
}
```



# 3. Java中的集合

**todo:添加图**

```
Java 集合框架主要包括两种类型的容器，一种是集合（Collection），存储一个元素集合，另一种是图（Map），存储键/值对映射。Collection 接口又有 3 种子类型，List、Set 和 Queue，再下面是一些抽象类，最后是具体实现类，常用的有 ArrayList、LinkedList、HashSet、LinkedHashSet、HashMap、LinkedHashMap 等等。Java 集合框架提供了一套性能优良，使用方便的接口和类，java集合框架位于java.util包中， 所以当使用集合框架的时候需要进行导包。
```



## 3.1 Collection接口

```
集合两大体系中的一个，Collection 是单值存储集合的最大父接口 !
```

**面试题 : Collection 与 Collections 的区别? **

```
Collection 是集合中, 单值存储的最大父接口 ! 是java中单值存储数据的集合的 顶级抽象接口 !!
Collections 是操作集合的工具 , 与Collection 没有关系, 也没有对比性 !
```

### 3.1.1 Collection的List子接口

```java
public interface List<E> extends Collection<E> {}
```

```
List接口是一个有序的 Collection，使用此接口能够精确的控制每个元素插入的位置，能够通过索引(元素在List中位置，类似于数组的下标)来访问List中的元素，第一个元素的索引为 0，而且允许有相同的元素。

List 接口存储一组不唯一，有序（插入顺序）的对象。
```

### 3.1.2  ArrayList类

```
特性:
    来自JDK 1.2 版本
    默认的初始容量 10 ; 
    扩容算法:   原长度 加上 原长度右移一位 (约等于1.5倍)
    允许存储null值
    允许存储重复的值
    因为内部实现是数组, 所以数据的 存储是有序的 , 便于遍历与查找 !
    线程非安全的
```

- **ArrayList常用方法**

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable{}
```



```
基本操作:

-   boolean add(E e) :  向集合中添加一个元素 , 返回值永远为true *****
-   boolean add(int index ,E e) :   向指定的索引位置,插入一个元素, 原数据自动后移!
-   E remove(int index) :   获取并移除指定索引处的元素   *
-   E remove(E e)   :   删除指定的元素
-   boolean set(int index ,E e) :   替换指定索引位置的元素内容 !
-   E get(int index) :  获取指定索引处的元素内容!   *****
-   int size()  :   获取当前集合有效数据的个数 ! *
-   clear() :   清空集合 掌握
-   boolean isEmpty()  如果列表不包含元素，则返回 true。
```



```
对一组数据的操作(了解)
-   boolean addAll(Collection 集合)   :   将参数集合中的所有数据, 追加到当前的集合中 !
-   boolean addAll(int index,Collection 集合) :   将参数集合中的所有数据, 追加到当前集合的指定位置 !
-   boolean removeAll(Collection 集合)    :   从当前集合中, 移除与参数集合匹配的所有元素 !
-   boolean retainAll(Collection 集合)    :   从当前集合中, 保留与参数集合匹配的所有元素 !
```



```
判断集合中是否包含某元素 (掌握)
-   boolean contains(Object o);

判断集合中是否包含某多个元素 (了解)
-   boolean containsAll(Collection collection);
```



```java
将List集合转换为数组 , 然后进行操作 (了解)
-   Object[] toArray();

-   E[] toArray(E[] t);  //传入一个任意类型的泛型数组，返回一个对应的泛型数组
```

- **案例**

```java
ArrayList<String> data1 = new ArrayList<String>();
data1.add("哈哈哈");
data1.add("嘿嘿嘿");

Object[] objs = data1.toArray();
String[] strs = data1.toArray(new String[0]);
```



```
查找集合中元素的位置:

-   int indexOf(E e) (熟悉)
        顺序查找指定元素e 在集合中的位置, 查找成功返回索引值 , 查找失败返回-1
-   int lastIndexOf(E e) (了解)
        倒序查找指定元素e 在集合中的位置, 查找成功返回索引值 , 查找失败返回-1
```



```java
从集合中截取 子集合 (了解)
-   List subList(int 起始下标,int 结束下标);
    从集合中截取子集合, 包含起始下标元素, 不包含结束下标元素 !

注意: 此截取操作, 截取后的新集合 与 旧集合共用一块内存 ! 在操作子集合时, 会影响原有的集合!

特殊操作:  清除集合100下标到200下标的数据

    data.subList(100,200).clear();

案例:
    ArrayList<String> data1 = new ArrayList<String>();
    data1.add("哈哈哈"); 
    data1.add("嘿嘿嘿");
    data1.add("呵呵呵");
    data1.add("嘻嘻嘻");
    data1.add("嘿嘿嘿");
    data1.add("老和尚");
    List<String> data2 = data1.subList(1,3);  //公用了存储空间
    data2.clear();
    System.out.println(data1); //[哈哈哈, 嘻嘻嘻, 嘿嘿嘿, 老和尚]
```

**面试题:** 

```
观察如下代码, 描述执行结果:

ArrayList data = new ArrayList();//未指定泛型, 类型为Object
data.add(1);
data.add(2);
data.add(3);

data.remove(1);
System.out.println(data);

请描述执行结果: "[1,3]"

解释: 
    集合的泛型未指定,  存储的数据类型为Object  也就是对象!
    存储int类型数据时, 其实存储的是Integer , 进行了自动装箱而已 .
    删除时, 传入的是int , 则是根据下标进行删除 ! 
    如果删除时,传入的是new Integer(1), 则删除的就是数据了!
```

### 3.1.3 Vector类

```
1.0版本的集合类, 在1.2版本时, 融入到了新的集合体系中, 
与ArrayList操作基本一致, 但是是线程安全的!
扩容算法:  用户指定每次扩容的增量, 如果增量为0 则每次扩容为两倍
```

### 3.1.4 LinkedList类

```
内部使用链表结构实现, 
线程非安全的, 效率较高
方便删除和数据的插入!
```

**学习这几种list集合, 后期在使用时, 应根据需求选择集合使用:**

```
ArrayList 和 vector 和 LinkedList 的操作基本一致 !

ArrayList 更适合 遍历与 查找
vector 更适合 要求线程安全时
LinkedList 更适合进行大量删除与插入的需求
```

### 3.1.5  Collection的Queue接口   队列（头取，尾添）

```
Queue接口中 使用最多的类是LinkedList
队列是先进先出的!

-   boolean offer(E e)  :   将一个元素, 添加到队列的尾部, 添加成功返回true
-   E   poll()  :   从队列的首部取出一个数据, 并从队列中移除此数据!
-   E   peek()  :   从队列首部取出一个数据 .

Queue<String> q = new LinkedList<>();
```

### 3.1.6 双端队列 Deque接口    (双头添取)

```
Deque接口继承了Queue接口。
Deque接口中 使用最多的类是LinkedList
-   boolean offerLast(E e)  :   将一个元素, 添加到队列的尾部, 添加成功返回true
-   boolean offerFirst(E e) :   将一个元素, 添加到队列的首部, 添加成功返回true
-   E   pollLast()  :   从队列的尾部取出一个数据, 并从队列中移除此数据!
-   E   pollFirst() :   从队列的首部取出一个数据, 并从队列中移除此数据!
-   E   peekLast()  :   从队列尾部取出一个数据 .
-   E   peekFirst() :   从队列首部取出一个数据 .

Deque<String> q = new LinkedList<>();
```

### 3.1.7 Collection的Set子接口

```
Set接口是Collection的子接口 !

Set集合与List集合最大的不同在于 ,Set集合中的内容是不允许重复的 !(所谓的重复指定是: 两个元素通过equals方法比较结果为true)

Set接口没有对Collection接口进行扩充! 也没有提供get方法, 如果需要获取数据 只能通过如下两种方式:
    1.  通过toArray , 转换为数组, 然后操作
    2.  使用迭代器 , 进行迭代操作

Set接口存在两个常用的子类:   比较的对象需实现Comparable接口。
    1.  HashSet (哈希表 又叫做 散列表 数据结构 , 哈希码)
            不允许存储重复的数据, 判断的原理是:  先比较hashCode值是否相同, 不相同时认为不是重复数据,  相同时再使用equlas方法比较!
    2.  TreeSet (中序二叉树 数据结构)
            不允许存储重复的数据, 判断的原理是:  两数据比较大小相同,则表示数据重复! 
```

- **Set集合常用操作方法**

```
 -  boolean add(E e) 
      如果 set 中尚未存在指定的元素，则添加此元素（可选操作）。 
 -  boolean addAll(Collection<? extends E> c) 
          如果 set 中没有指定 collection 中的所有元素，则将其添加到此 set 中（可选操作）。 
 -  void clear() 
          移除此 set 中的所有元素（可选操作）。 
 -  boolean contains(Object o) 
          如果 set 包含指定的元素，则返回 true。 
 -  boolean containsAll(Collection<?> c) 
          如果此 set 包含指定 collection 的所有元素，则返回 true。 
 -  boolean equals(Object o) 
          比较指定对象与此 set 的相等性。 
 -  int hashCode() 
          返回 set 的哈希码值。 
 -  boolean isEmpty() 
          如果 set 不包含元素，则返回 true。 
 -  Iterator<E> iterator() 
          返回在此 set 中的元素上进行迭代的迭代器。 
 -  boolean remove(Object o) 
          如果 set 中存在指定的元素，则将其移除（可选操作）。 
 -  boolean removeAll(Collection<?> c) 
          移除 set 中那些包含在指定 collection 中的元素（可选操作）。 
 -  boolean retainAll(Collection<?> c) 
          仅保留 set 中那些包含在指定 collection 中的元素（可选操作）。 
 -  int size() 
          返回 set 中的元素数（其容量）。 
 -  Object[] toArray() 
          返回一个包含 set 中所有元素的数组。 
 -  <T> T[] toArray(T[] a) 
          返回一个包含此 set 中所有元素的数组；返回数组的运行时类型是指定数组的类型。 
```

### 3.1.8 Iterator 迭代器

```
我们可以使用迭代器, 迭代Collection体系下的所有集合 !

如何获取迭代器? 
    通过集合的iterator方法 , 会返回一个Iterator 对象 !

迭代器如何操作 ? 有哪些方法 ? 

1.  判断需要迭代的下一个元素 ,是否存在
    boolean hasNext()***    :   如果下一个元素存在,则返回true , 且迭代器移动到存在的元素位置 !

2.  取出数据
    E next()**    :   取出数据  如果数据不存在 回导致错误发生!

3.  void remove()   :   删除集合中的最后一个元素
```

- **案例**
```
迭代器使用时的  经典代码: 

    Iterator<E> i = 集合.iterator();
    while(i.hasNext()){
        E e = i.next();
    }
```

### 3.1.9 增强for循环 (foreach)

```
用于快速的迭代 数组, 集合等容器: 

语法结构:

    for(数据类型 变量名:数组或集合对象名){

    }
    //上述的语法中, 就是在遍历数组或集合, 每次循环遍历到的数据, 存储在变量的位置

遍历数组的案例:
    int[] arr = {3,6,9,2,5,8};
    for(int x:arr){
        System.out.println(x);
    }

遍历集合的案例:
    Set<String> set = new TreeSet<>();
    set.add("老和尚");
    set.add("对小和尚");
    set.add("说");
    set.add("山下的女人嘿嘿嘿");

    for(String s:set){
        System.out.println(s);
    }
```



### 3.1.10 Comparable 比较接口    熟悉

```
存在一个抽象方法 , 方法声明如下:
    int compareTo(E e);

我们在编写类时, 如果需要这个类的对象可以排序, 则可以实现Comparable接口, 实现compareTo方法, 

方法的实现有要求: 
    在方法中, 应将this 与传递过来的元素e 进行比较大小 (比较规则根据业务来定)!
    方法的返回值: 
        如果this较大, 则返回正数数字1
        如果this与e相等 , 则返回0
        如果this较小, 则返回负数数字-1


案例:
    @Override
    public int compareTo(Person o) {
        if(this.age > o.age) {
            return 1;
        }else if(this.age<o.age){
            return -1;
        }
        return 0;
    }
```

- **案例**
```java
public class Person implements Comparable<Person>{

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person o) {
		if(this.age > o.age) {
			return 1;
		}else if(this.age<o.age){
			return -1;
		}
		return 0;
	}
	
}

public class Test {

    public static void main(String[] args) {
        Set<Person> ts = new TreeSet<>();
        ts.add( new Person("C++", 23));
        ts.add( new Person("Java", 18));
        ts.add( new Person("Python", 18)); //同是18岁的Python，无法插入，TreeSet的特性
        ts.add( new Person("C", 21));
        ts.add( new Person("Golang", 20));

        for (Person p : ts) {
            System.out.println(p);
        }
        //Person [name=Java, age=18]
        //Person [name=Golang, age=20]
        //Person [name=C, age=21]
        //Person [name=C++, age=23]
    }

}
```



### 3.1.11 Comparator 接口 了解

```java
存在一个抽象方法 , 方法声明如下:
    int compare(E e1,E e2);

使用Comparator时, 与Comparable接口不一样, 不需要任何的类 实现这个接口.  一般是在比较时, 临时创建一个
匿名内部类对象 , 去使用 !

方法实现的要求: 
        在方法中, 应将传递过来的元素e1与传递过来的元素e2 进行比较大小 (比较规则根据业务来定)!
        方法的返回值: 
        如果e1较大, 则返回正数数字1
        如果e1与e2相等 , 则返回0
        如果e1较小, 则返回负数数字-1
案例:

    Collections.sort(data, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()>o2.getAge()) {
                    return 1;
                }else if(o1.getAge()<o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        });
```

- **案例**
```java
public class Person{

    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

}


public class Test {

    public static void main(String[] args) {
        List<Person> data = new ArrayList<Person>();
        data.add(new Person("Python",28));
        data.add(new Person("C++",38));
        data.add(new Person("Java",28));
        data.add(new Person("C",8));
        data.add(new Person("Golang",88));
        //  sort(List集合,Comparator接口实现对象)   //对参数的集合进行数据的排序
        Collections.sort(data, new Comparator<Person>() {
            //匿名内部类
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()>o2.getAge()) {
                    return 1;
                }else if(o1.getAge()<o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        });
        for (Person p : data) {
            System.out.println(p);
        }
        //Person [name=C, age=8]
        //Person [name=Python, age=28]  两个28都在，List可以存储相同的对象
        //Person [name=Java, age=28]
        //Person [name=C++, age=38]
        //Person [name=Golang, age=88]
    }
}
```

Collections 集合的工具类

## 3.2 Map 接口 (映射)

```
双值存储集合 , 存储的是一种映射的关系, 是一个键值对存储的数据 ! 
Map集合中存储的是 一个个的 将键映射到值的 对象 ! 一个Map集合中不能包含重复的键 ! 且每一个键只允许对应一个值
```

### 3.2.1 HashMap

```
哈希表的实现 
什么是哈希表? 
    哈希表, 我们又称其为散列表 ! 指的是根据哈希码值而直接访问的一种数据结构!
    在HashMap中, Java通过对象数组+链表的形式 实现了哈希表 !
    对象数组的每一个下标, 我们称为哈希桶 , 每一个桶中存储的是一个链表结构 !
    我们在使用哈希表存储数据时, 先计算 key 的hash值, 然后通过hash运算得到该key应存储的桶的位置. 
    然后, 判断桶中是否已经存在了数据 ,如果存在 ,则判断是否相同, 如果相同则覆盖值 不更改key !
    如果不同,则存储在链表的下一个位置 !
```

- **HashMap 在JDK 1.8版本进行了重构**

```
在jdk1.8之前, HashMap使用 对象数组+ 链表的方式实现!  相同hash值的键值对存储在相同的桶中! 
但是当一个桶中的数据 过于多时, 链表效率较低 !
在jdk1.8时, 重构了上述逻辑, 当每个桶中的链表长度大于8时 , 将桶中的数据结构从链表修改为 红黑二叉树 (又叫自平衡二叉树)
```

- **HashMap 特征**

```
1.  哈希桶的初始数量是 16 , 我们也可以通过构造方法,  指定初始桶的数量 !
2.  散列因子可以通过构造方法指定 , 默认的值为 0.75 , 表示当百分之75的桶被使用后, 就会扩充桶的数量,  这种扩充,我们称其为散列操作(rehash) !
3.  重新散列哈希表, 会造成大量性能的耗费, 应尽量的避免 !
```

- **HashMap<K,V> 常用方法**

```
HashMap类在使用时, 需指定两个泛型, 第一个表示 键值对中 键的类型, 第二个表示 键值对中值的类型

-   V put(K key ,V value);  *****
    向map集合中 添加一个键值对的方法 ,
    返回值:    如果这个键原本就已经映射了一个值, 则覆盖旧的值, 并将旧的值返回!  如果这个键原本在map不存在,则返回null

-   void putAll(Map map) 了解
    向当前的集合中 添加一个新的集合, 要求: 两个集合的泛型必须一致!

-   V get(K key);   *****
    从map集合中, 通过key 获取 值的方法 !
    返回值:    key映射的value , 如果key不存在,则返回null

-   V remove(K key);   *****
    从Map集合中获取 并 移除一个映射关系! 如果映射关系不存在则返回null

-   boolean containsKey(K key) 了解
    判断map集合中是否包含指定的 key

-   boolean containsValue(V value) 了解
    判断map集合中是否包含指定的 value

-   void clear() 熟悉
    清空这个map集合

-   int size() 熟悉
    获取当前集合中有效的 映射关系 数量!

-   boolean isEmpty() 熟悉
    判断集合中是否不存在任何的映射关系, 是则返回true
```

- **Map 集合如何进行迭代操作**

```
map集合, 没有下标, 也没有迭代器! 无法通过循环以及迭代器来完成遍历操作 !

针对于迭代Map集合, 系统提供了三个方法 , 可以将key 或 值 或 键值对以Collection集合的形式返回 !

1.  Set<K> keySet();   ***
        获取map集合中的所有的key , 以set集合的形式返回!

2.  Collection<V> values()
        获取map集合中所有的value , 以Collection的形式返回

3.  Set<Entry<K,V>> entrySet();  ***
    Entry类, 此类的对象表示一个键值对, 存在两个常用方法
        -   getKey()
        -   getValue()
```

- **迭代操作-1：推荐**

```JAVA
常用于迭代Map集合的第一种方式(推荐)

     *  1.  先获取所有key的Set集合
     *  2.  迭代上述Set集合
     *  3.  根据迭代出的key , 从Map集合中获取值
     *  
     */
    public static void main(String[] args) {  //第一种方式
        HashMap<String,String> data = new HashMap<>();
        data.put("a", "A");
        data.put("b", "B");
        data.put("c", "C");
        data.put("e", "D");
        data.put("d", "E");
        //1.    获取所有的key , 并遍历所有的key
        Set<String> ketSet = data.keySet();
        for (String k : ketSet) {
            //根据遍历时的key , 从集合中取出值
            System.out.println(k+":"+data.get(k));
        }
    }
```

**迭代操作-2：推荐**

```java
常用于迭代Map集合的第二种方式 (推荐)
     * 1.   获取map集合中的键值对 对象(entry)的Set集合
     * 2.   遍历上述的Set集合
     * 3.   获取到其中每一个Entry , 并得到其key与value
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String,String> data = new HashMap<>();
        data.put("a", "A");
        data.put("b", "B");
        data.put("c", "C");
        data.put("e", "D");
        data.put("d", "E");
        //相当于, 将map集合中的每一个键值对, 当作了一个对象!
        //把所有的键值对转换的对象 存储到了Set集合中
        Set<Entry<String,String>> entrySet = data.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
```

**迭代操作-3：不推荐**

```
常用于迭代Map集合的第三种方式:
     *  1.  获取map集合中 所有的value值
     *  2.  循环遍历
     * 
     *  (存在弊端 , 仅仅能获取值, 无法得到键, 不推荐使用)
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String,String> data = new HashMap<>();
        data.put("金苹果", "描述的是苹果树的种植经验");
        data.put("武术教学-猴子偷桃", "描述的是一种武术招式, 叫做猴子偷桃");
        data.put("武术教学-老树盘根", "描述的是一种武术招式, 叫做老树盘根");
        data.put("武术教学-平沙落雁", "描述的是一种武术招式, 叫做平沙落雁");
        data.put("武术教学-老汉推车", "描述的是一种武术招式, 叫做老汉推车");
        Collection<String> values = data.values();
        for (String value : values) {
            System.out.println(value);
        }
    }
```

### 3.2.2 TreeMap

```
上述描述的所有HashMap的操作, 同样适用于TreeMap ! 因为上述的所有方法 都来自Map集合 !
```

- **面试题: HashMap 与 Hashtable 的区别**

```
在操作上, 两个完全一致 !  
就像我们学习的ArrayList 和 Vector的区别一样

HashMap在JDK1.2时推出, 是新的哈希表实现!
Hashtable在JDK1.0时推出, 是旧的哈希表实现!
HashMap 线程非安全的, 性能高!
Hashtable 线程安全的, 性能低
HashMap可以存储null
Hashtable 不能存储null, 会出现空指针异常 !
```

# 4. 异常处理

## 4.1 什么是异常?

```
异常处理的类结构中, 顶级异常类为: Throwable , 他有两个子类: 
    1.  Error
    2.  Exception

我们要处理的是 异常(Exception)!
程序出现Error 是无法处理的, 只能尽量避免 !

无论是Error 或者 Exception , 都会导致程序终止! 
我们学习异常处理, 就是为了当异常发生时, 可以让程序正常的执行下去 !
```

## 4.2 Exception

```
异常分为两种:

1.  运行时异常(非受检异常)
        程序在执行的过程中,产生的异常 , 运行时异常顶级父类: RuntimeException
2.  受检异常(非运行时异常)
        编译器可检测的异常, 在编写代码后, 通过javac执行时, 会报错的异常 !
```





# 4. IO



# 5. 多线程



# 6. 网络编程





# 7. 反射



![image-20200804211223158](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804211223.png)

![image-20200804211538764](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804211538.png)