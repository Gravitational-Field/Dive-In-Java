<!DOCTYPE html>
<html>
<head>
<title>03_IDEA2018之JDK、Tomcat、Maven配置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
/* GitHub stylesheet for MarkdownPad (http://markdownpad.com) */
/* Author: Nicolas Hery - http://nicolashery.com */
/* Version: b13fe65ca28d2e568c6ed5d7f06581183df8f2ff */
/* Source: https://github.com/nicolahery/markdownpad-github */

<h1>IDEA2018 之 JDK、Tomcat、Maven配置</h1>
<hr />
<blockquote>
<p>作者：康哥</p>
<p>时间：2018-7-10</p>
</blockquote>
<hr />
<h2>IDEA配置JDK</h2>
<h3>方式一 - 新建项目之前配置JDK</h3>
<ul>
<li>
<p>打开IDEA集成开发环境工具，点击：File--Project Structure，如下图</p>
<p><img src="https://i.imgur.com/ZZJfexC.png" /></p>
</li>
<li>
<p>在打开的页面中，选择SDKs属性，并点击中间的加号+，选择JDK，如下图</p>
<p><img src="https://i.imgur.com/ueg0jdM.png" /></p>
</li>
<li>
<p>在打开的页面中，选择本地计算机中已经安装的JDK目录(选择bin目录的上一级即可)，然后点击ok按钮，如下图</p>
<p><img src="https://i.imgur.com/7QOhL68.png" /></p>
</li>
<li>
<p>然后在Project Structure窗口，依次点击Apply--OK按钮即可，如下图</p>
<p><img src="https://i.imgur.com/xSH9fEJ.png" /></p>
</li>
<li>
<p>然后在工具中创建项目，下拉选择对应的JDK版本即可，如下图</p>
<p><img src="https://i.imgur.com/GFFmnHA.png" /></p>
</li>
</ul>
<h3>方式二 - 新建项目的时候配置JDK</h3>
<ul>
<li>
<p>打开IDEA集成开发环境工具，点击：File--New--Project，如下图</p>
<p><img src="https://i.imgur.com/zdVvLWZ.png" /></p>
</li>
<li>
<p>在打开的窗口中，选择按钮New，然后选择对应的JDK版本，点击OK按钮，然后Next创建项目，并使用配置的JDK，如下图</p>
<p><img src="https://i.imgur.com/qkbGIAr.png" /></p>
</li>
</ul>
<h3>方式三 - 指定(切换)项目的JDK</h3>
<ul>
<li>
<p>打开IDEA集成开发环境工具，点击：File--Project Structure，如下图</p>
<p><img src="https://i.imgur.com/ZZJfexC.png" /></p>
</li>
<li>
<p>在打开的窗口中，选择Project，然后在详情页面中，选择按钮New，并点击JDK选项，如下图</p>
<p><img src="https://i.imgur.com/SGuMGt2.png" /></p>
</li>
<li>
<p>然后选择对应的JDK版本，点击OK按钮，如下图</p>
<p><img src="https://i.imgur.com/3KjT7Dz.png" /></p>
</li>
</ul>
<h3>方式四 - 开发工具启动页面中配置JDK</h3>
<ul>
<li>
<p>在IDEA启动页面中，下拉Configure，选择Project Defaults -- Project Structure，如下图</p>
<p><img src="https://i.imgur.com/ohdaANV.png" /></p>
</li>
<li>
<p>在打开的窗口中，点击New按钮，并选择JDK，如下图</p>
<p><img src="https://i.imgur.com/WbZj4qK.png" /></p>
</li>
<li>
<p>然后选择对应的JDK版本，点击OK按钮，如下图</p>
<p><img src="https://i.imgur.com/zH913Fg.png" /></p>
</li>
</ul>
<h2>IDEA配置Tomcat</h2>
<h2>IDEA配置Maven</h2>


