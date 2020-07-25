<!DOCTYPE html>
<html>
<head>
<title>04_IDEA2018之Tomcat配置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
/* GitHub stylesheet for MarkdownPad (http://markdownpad.com) */
/* Author: Nicolas Hery - http://nicolashery.com */
/* Version: b13fe65ca28d2e568c6ed5d7f06581183df8f2ff */
/* Source: https://github.com/nicolahery/markdownpad-github */

<h1>IDEA2018 之 Tomcat配置</h1>
<hr />
<blockquote>
<p>作者：康哥</p>
<p>时间：2018-7-10</p>
</blockquote>
<hr />
<h2>IDEA配置Tomcat</h2>
<ul>
<li>
<p>新建Web project或者Maven project项目，新建过程(略)，如下图：</p>
<p><img src="https://i.imgur.com/ju8HtVs.png" /></p>
</li>
<li>
<p>点击工具栏中【Run】菜单，下拉选择Edit Conigurations</p>
</li>
<li>
<p>或者在视图工具栏中，直接下拉箭头，选择Edit Conigurations</p>
<p><img src="https://i.imgur.com/2cniEsj.png" /></p>
</li>
<li>
<p>在打开的视图Run/Debug Conigurations 中点击 +，依次选择Tomcat Server--Local，如下图</p>
<p><img src="https://i.imgur.com/fqlD4l2.png" /></p>
</li>
<li>
<p>在打开的视图中，修改Tomcat的显示名称，然后点击按钮【Configure..】，如下图：</p>
<p><img src="https://i.imgur.com/HDCjadB.png" /></p>
</li>
<li>
<p>在打开的配置Tomcat视图中，点击左上角的 +，然后点击选择Tomcat Home路径，最后点击【OK】按钮</p>
<p><img src="https://i.imgur.com/HdzYnB8.png" /></p>
</li>
<li>
<p>选择性的修改tomcat端口号、启动tomcat所需依赖的jdk，略</p>
</li>
<li>
<p>选择标签【Deloyment】,点击 + ，选择部署项目</p>
<p><img src="https://i.imgur.com/XezVnJm.png" /></p>
</li>
<li>
<p>一般web项目会出现两个jar包，建议选择exploded结尾的，然后点击【ok】，如下图：</p>
<p><img src="https://i.imgur.com/bn4yM3A.png" /></p>
</li>
<li>
<p>选择性的修改访问项目名称，默认为&quot;/&quot;，然后点击下方【ok】按钮，如下图</p>
<p><img src="https://i.imgur.com/wIuOLkh.png" /></p>
</li>
<li>
<p>然后在IDEA主页面，选择Tomcat85，点击右侧的Debug模式启动即可，访问的浏览器安装默认的，会自动打开，如下图</p>
<p><img src="https://i.imgur.com/F0aboAC.png" /></p>
<p><img src="https://i.imgur.com/hQnhZGQ.png" /></p>
</li>
<li>
<p>启动成功，访问页面，配置完成</p>
</li>
</ul>