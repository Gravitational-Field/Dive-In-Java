https://www.oracle.com/java/technologies/oracle-java-archive-downloads.html

---

[toc]

---

# Reference

[1] [CS-Note](https://github.com/CyC2018/CS-Notes)



---



# JavaSE

## Day01

2.JavaSE课程体系

2.1 课程内容

(1) Java语言的概述和编程基础(杂、记)  Java语言的背景、搭建开发环境、变量和数据类型、运算符、流程控制语句、数组及应用等  用时5天左右  编写猜数字游戏和双色球抽奖游戏
(2) Java语言的面向对象编程(核心、难点、理解)  类和对象、封装、继承、多态、抽象类、接口、内部类等  用时5天左右  编写五子棋游戏和扫雷游戏
(3) Java语言的核心类库(多、用)  Object类、String类、集合类、异常、IO流、多线程、网络编程、反射、设计、算法等   用时12天左右  编写学生信息管理系统和简易聊天室
-----------------------------------------------------------------------------------今天内容：  (1)计算机的体系结构  (2)Java语言的概述  (3)开发环境的搭建和使用
1.计算机的体系结构(常识)1.1 基本概念  计算机俗称“电脑”，是一种被广泛使用在高级计算等各个领域的设备。  计算机主要有两大部分组成：硬件 + 软件。
1.2 常用的硬件  计算机中常用的硬件：CPU、内存、硬盘、显卡、主板、显示器、键盘、电源、...    CPU - 中央处理器，是计算机中最核心的部件，类似于人的大脑。      - 主要用于解释和执行指令以及处理软件中的数据内容。    内存 - 是计算机中的内部存储部件，主要用于临时存放CPU需要访问的数据。      - CPU可以直接访问，效率比较高      - 容量小，不能实现永久存储，若关机会造成数据丢失。      - 时刻记得 ctrl+s 进行保存    硬盘 - 是计算机中的存储部件。      - CPU不可以直接访问硬盘的数据，若访问则需要先加载到内存中再访问,效率低      - 容量大可以永久存储，若关机不会造成数据丢失。    键盘称为标准输入设备，显示器称为标准输出设备。   
科普：  1TB = 1024GB  1GB = 1024MB  1MB = 1024KB  1KB = 1024Byte(字节)  通常1个英文字母占1个字节，1个汉字占2个字节  1Byte = 8bit(二进制位) 在计算机的底层识别0和1组成的二进制序列     1B即为1个字节扩展：  目前主流的硬盘配置是250G、320G、500G、1T、2T、...为啥我的电脑只有298G呢？  298G = 320*1000*1000*1000/1024/1024/1024解析：  硬件厂商是按照1000作为进率，操作系统是按照1024作为进率
1.3 常用的软件  计算机中常用的软件分为：系统软件 和 应用软件  其中系统软件主要指操作系统，主流操作系统：Windows/Unix/Linux/Android/ios系列    windows系列：xp/vista/win7/win8/win8.1/win10  其中应用软件主要指安装在操作系统上的软件，如：QQ、迅雷、office等
1.4 计算机的体系结构  使用者 => 应用软件 => 操作系统 => 硬件设备     => 操作系统分为：内核(Kernel) 和 外壳(Shell) 
2.Java语言的概述(常识)2.1 Java语言的背景  Java语言诞生于1995年，隶属于sun公司，现在隶属于oracle(甲骨文)公司.  Java语言在编程语言排行榜上占据重要的地位。
2.2 Java语言的主要版本(1)Java SE（Java Platform, Standard Edition）  - 称之为“Java平台标准版”  - 主要学习Java语言的基础知识，可以编写桌面应用。
(2)Java EE（Java Platform，Enterprise Edition）  - 称之为“Java平台企业版”    - 主要学习Java语言的后台框架技术，可以编写具有B/S架构C/S架构的项目。 
(3)Java ME （Java Platform，Micro Edition）  - 称之为Java 平台微型版  - 随着Android系统的普及已经走向淘汰。(如：原诺基亚塞班系统上的安卓小游戏)
3.开发环境的搭建和使用3.1 jdk的下载和安装(1)下载方式

  方式一：从官网下载 [www.sun.com/www.oracle.com](http://www.sun.com/www.oracle.com)

  方式二：使用搜索引擎从第三方网站下载 [www.baidu.com/www.sogou.com](http://www.baidu.com/www.sogou.com)

(2)安装方式

  若下载的是安装版，则一路点击下一步即可。 

  若下载的是绿色版，则直接解压即可。

  切记jdk的安装目录中不应该有中文路径！

**3.2 相关的概念(记住)**

  jdk - Java开发工具包，只要做Java开发就需要安装该部件，其中包含jre；

  jre - Java运行时环境信息，主要运行Java程序就需要安装该部件。

  javac.exe - Java语言编译器，主要用于将Java代码翻译成字节码信息(即将.java文件翻译为.class文件<-字节码文件)。

  java.exe - Java语言解释器，主要用于启动JVM对字节码信息进行边解释边执行。

  JVM - Java虚拟机，是一台虚拟的主机作为Java代码和操作系统的桥梁。(位于OS之上)

3.3 编写Java代码的流程

 (1) 新建文本文档，将默认的后缀xxx.txt修改为xxx.java；

 (2) 使用记事本的方式打开该文件，编写代码后进行保存；

 (3) 启动dos窗口，切换到xxx.java文件所在的目录中；

 (4) 使用javac xxx.java进行翻译生成字节码文件；

 (5) 使用java xxx进行解释执行打印最终结果；

注意：

  若文件后缀无法显示时的处理方式如下：

   组织 => 文件和搜索选项 => 查看 => 隐藏已知文件类型的扩展名 => 去掉勾选 =>确定

3.4 常用的快捷键

  ctrl+s 保存  ctrl+a 全选   ctrl+f 查找

  ctrl+c 复制  ctrl+v 粘贴   ctrl+x 剪切

  ctrl+z 撤销

  windows+d 回到桌面  windows+e 打开计算机 

  windows+l 锁屏    windows+tab 切换任务

  windows+r 打开运行,输入cmd后回车可以打开dos窗口

  alt+tab 切换任务

  ctrl+alt+delete 打开任务管理器

  ctrl+shift 切换输入法，一旦切换到中文输入法后使用shift键进行中英文切换

   

3.5 环境变量的配置

(1)基本概念

  通常情况下可执行文件只能在该文件所在的路径中访问(如jdk/bin目录 需要将要执行编译的文件置于bin目录下)，若希望该可执行文件可以在任意路径中访问，就需要将该文件所在的路径信息放入环境变量Path中(此时系统在进行检索时将会从Path的顺序进行检索)。

(2)配置方式

  计算机 => 右键 => 属性 => 高级系统设置 => 高级 => 环境变量 => 系统变量  

=> 找到Path，点击编辑 => 将javac.exe所在的路径(C:\Program Files\Java\jdk1.8.0_162\bin;C:\Program Files\Java\jdk1.8.0_162\lib;)放入Path变量值的最前面增加英文版分号

=> 一路点击确定即可

  切记Path变量值原来的内容不要更改，并且配置完后重启dos窗口！！！

**3.6 跨平台原理**

  由于不同的操作系统中都提供了Java虚拟机进行翻译字节码文件，因此同一份字节码文件可以被翻译成不同的机器指令，因此赢得了"一次编译，到处使用"的美名。

​     java语言不跨平台，字节码文件跨平台，jvm不跨平台。
