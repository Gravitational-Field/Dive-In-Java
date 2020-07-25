

<h1>IDEA2018 之 Maven配置</h1>
<hr />
<blockquote>
<p>作者：康哥</p>
<p>时间：2018-7-10</p>
</blockquote>
<hr />
<h2>IDEA之maven配置</h2>
<p>Maven构建环节：</p>
<ul>
<li>清理：表示在编译代码前将之前生成的内容删除</li>
<li>编译：将源代码编译为字节码</li>
<li>测试：运行单元测试用例程序</li>
<li>报告：测试程序的结果</li>
<li>打包：将 java 项目打成 jar 包；将 Web 项目打成 war 包</li>
<li>安装：将 jar 或 war 生成到 Maven 仓库中</li>
<li>部署：将 jar 或 war 从 Maven 仓库中部署到 Web 服务器上运行</li>
</ul>
<h3>Maven配置</h3>
<ul>
<li>
<p>IDEA安装完毕之后，自带Maven的默认配置，我们可以直接使用，但是建议大家选择自己本地的maven设置，不使用默认的配置，如下：</p>
<p><img src="https://i.imgur.com/cT5plyV.png" /></p>
</li>
<li>
<p>其它配置如下：</p>
<p><img src="https://i.imgur.com/4BWRT42.png" /></p>
<ul>
<li>Import Maven projects automatically：表示  IntelliJ IDEA  会实时监控项目的  pom.xml  文件，进行项目变动设置</li>
<li>Automatically download：在Maven导入依赖包的时候是否自动下载源码和文档。默认是没有勾选的， 也不建议勾选，原因是这样可以加快项目从外网导入依赖包的速度，如果我们需要源码和文档的时候我们到时候再针对某个依赖包进行联网下载即可。IntelliJ IDEA 支持直接从公网下载源码和文档的</li>
<li>VM  options for importer：可以设置导入的  VM  参数。一般这个都不需要主动改，除非项目真的导入太慢了我们再增大此参数</li>
</ul>
</li>
</ul>
<h3>创建Maven工程项目</h3>
<ul>
<li>
<p>选中工程，右键依次选择New--Module</p>
<p><img src="https://i.imgur.com/Tcr6n12.png" /></p>
</li>
<li>
<p>在弹出的窗口中选择Maven，选择对应的JDK版本，然后选中Create from archetype，选择webapp的选项，点击【Next】按钮</p>
<p><img src="https://i.imgur.com/CkcQF3g.png" /></p>
</li>
<li>
<p>输入maven的信息,然后点击【Next】</p>
<p><img src="https://i.imgur.com/wZ2PPFC.png" /></p>
<ul>
<li>Group：组织或公司域名，倒序</li>
<li>Artifact：项目模块名称</li>
<li>Version：默认 maven 生成版本：0.0.1-SNAPSHOT</li>
</ul>
</li>
<li>
<p>选择对应的设置的Maven，点击【Next】按钮</p>
<p><img src="https://i.imgur.com/36xjWtY.png" /></p>
</li>
<li>
<p>确认项目信息，点击【Finish】按钮即可</p>
<p><img src="https://i.imgur.com/a6lIESA.png" /></p>
</li>
<li>
<p>项目结构</p>
<p><img src="https://i.imgur.com/JaUXTJf.png" /></p>
</li>
</ul>
<h3>Maven骨架</h3>
<ul>
<li>
<p>如果在新建Maven项目的过程中，出现卡，慢情况，则是由于Maven骨架创建的问题，需要连接国外网站进行数据下载，有可能被Qiang了，所以可以进行如下配置修改：</p>
<p><img src="https://i.imgur.com/PaSXVkO.png" /></p>
</li>
<li>
<p>打开菜单栏依次选择File--Other Settings -- Default Settings</p>
<p><img src="https://i.imgur.com/nMEp67n.png" /></p>
</li>
<li>
<p>再打开的窗口中，添加如下信息：-DarchetypeCatalog=internal</p>
<p><img src="https://i.imgur.com/s1WHCyU.png" /></p>
</li>
<li>
<p>当然，还有其他解决方式，比如创建Maven过程中，可以添加-DarchetypeCatalog=internal信息</p>
</li>
<li>
<p>也可以将-DarchetypeCatalog的配置文件下载到本地仓库，然后修改为：-DarchetypeCatalog=local</p>
</li>
</ul>


