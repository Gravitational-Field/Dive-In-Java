

<h1>IDEA2018 之 创建JAVA工程</h1>
<hr />
<blockquote>
<p>作者：康哥</p>
<p>时间：2018-7-10</p>
</blockquote>
<hr />
<h2>创建第一个Java工程</h2>
<ul>
<li>
<p>双击IDEA的启动程序图标，启动之后，进入首页面，如下：</p>
<p><img src="https://i.imgur.com/ywzE5YD.png" /></p>
</li>
<li>
<p>选择 Create New Project</p>
<ul>
<li>IDEA 没有类似Eclipse的工作空间的概念（Workspaces），最大单元就是Project 。这里可以把 Project 理解为 Eclipse 中的 Workspace</li>
</ul>
<p><img src="https://i.imgur.com/OSkm03q.png" /></p>
</li>
<li>
<p>这里先不勾选，只是创建简单的 Java 工程，点击【new】按钮，可以选择 jdk 的安装路径所在位置，点击【OK】按钮</p>
<p><img src="https://i.imgur.com/ElKQfKP.png" /></p>
</li>
<li>
<p>之后，点击【next】按钮，弹出的页面中不用勾选。直接选择 Next，进入下一个页面：</p>
<p><img src="https://i.imgur.com/NHLDrjz.png" /></p>
</li>
<li>
<p>给创建的工程命名，选择项目生成的路径，之后点击 finish，提示项目路径不存在，是否继续创建路径，选择【ok】即可：</p>
<p><img src="https://i.imgur.com/pkCyquj.png" /></p>
</li>
<li>
<p>工程首页面展示</p>
<p><img src="https://i.imgur.com/rDdSPbF.png" /></p>
<p><img src="https://i.imgur.com/4ZbJA7u.png" /></p>
</li>
<li>
<p>点击src文件夹，右键选择New--Package，输入包名，点击OK：</p>
<p><img src="https://i.imgur.com/lbAuefD.png" /></p>
<p><img src="https://i.imgur.com/ime1Xx2.png" /></p>
</li>
<li>
<p>选择包名，右键选择New--Java Class</p>
<ul>
<li>不管是创建Class，还是Interface，还是Enum等，都是选择New--Java Class</li>
</ul>
<p><img src="https://i.imgur.com/y9XFJoI.png" /></p>
</li>
<li>
<p>输入类名称，下拉选择Class，点击ok：</p>
<p><img src="https://i.imgur.com/svAHTqd.png" /></p>
</li>
<li>
<p>在HelloDemo.java文件中，输入代码即可运行</p>
<p><img src="https://i.imgur.com/9xU0UnO.png" /></p>
</li>
</ul>
<h4>提示</h4>
<ul>
<li>在IDEA开发工具中，书写完代码，不需要点击保存或者快捷键保存，因为IDEA会自动保存代码</li>
</ul>
<h2>模块（Module）</h2>
<ul>
<li>在Eclipse中我们有 Workspace（工作空间）和Project（工程）的概念</li>
<li>在IDEA中只有 Project（工程）和 Module（模块）的概念</li>
<li>
<p>解读：</p>
<ul>
<li>Eclipse 中  workspace  相当于  IDEA 中的 Project</li>
<li>Eclipse 中  Project    相当于  IDEA 中的 Module</li>
</ul>
</li>
<li>
<p>在Eclipse中进行开发的时候，我们的Workspace下，可以展示多个项目，这在IDEA是无法展示的，而IDEA中如果想解决此问题，则需要打开多个窗口，即：一个Project一个窗口</p>
</li>
<li>
<p>在IDEA中最高级别属于Project，其次是Module，一个Project下可以有多个Module(因为目前多数的企业项目都是为分布式部署架构，所以采用这个模式)，从这个层面来看，也可以理解为什么IDEA会如此处理项目结构逻辑</p>
<p><img src="https://i.imgur.com/EyUOaYV.png" /></p>
</li>
<li>
<p>模块之间彼此可以相互依赖</p>
</li>
<li>
<p>也就是说，如果我们想一个视图窗口下展示多个项目，则可以在一个project下，创建多个module来实现，效果是一样的</p>
</li>
</ul>
<h3>创建Module</h3>
<ul>
<li>
<p>选中项目，右键依次选择，New--Module</p>
<p><img src="https://i.imgur.com/xKjSupC.png" /></p>
</li>
<li>
<p>在打开的创建中，选择Java，选中项目的JDK，然后点击【next】</p>
<p><img src="https://i.imgur.com/8wzLuZZ.png" /></p>
</li>
<li>
<p>选择module的路径和指定module的名称，点击【Finish】按钮</p>
<p><img src="https://i.imgur.com/3Wq4SPi.png" /></p>
</li>
<li>
<p>然后可以在module的src目录下，添加java代码，而project中的src则可以删除</p>
<p><img src="https://i.imgur.com/biRVWwX.png" /></p>
</li>
</ul>
<h3>删除Module</h3>
<ul>
<li>
<p>选择要删除的Module，然后右键选择Open Module Settings</p>
<p><img src="https://i.imgur.com/b0GAtCb.png" /></p>
</li>
<li>
<p>在打开的窗口中，选中左侧的module，然后选中module，点击-，之后在弹出的提示框中，选择【OK】按钮，确认删除，之后，点击右下角的【OK】按钮，如下图步骤：</p>
</li>
</ul>
<p><img src="https://i.imgur.com/dznDUJb.png" /></p>
<ul>
<li>
<p>选择Module，右键，点击Delete即可，然后在弹出提示框中，点击【Delete】按钮即可，如下：</p>
<p><img src="https://i.imgur.com/XZp0ivx.png" /></p>
<p><img src="https://i.imgur.com/m7DHoNu.png" /></p>
</li>
</ul>
<h3>项目结构说明</h3>
<ul>
<li>
<p>选中项目，点击工具栏中的图标即可，或者选择File--Project Struture</p>
<p><img src="https://i.imgur.com/oPxkfis.png" /></p>
</li>
</ul>