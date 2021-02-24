package com.lzj.pojo;


import com.sun.xml.internal.txw2.output.SaxSerializer;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;


public class Dom4jTest {

    @Test
    public void test1() throws DocumentException {
        SAXReader reader = new SAXReader();
        //文件的绝对路径  D:\微云同步助手\810968336\Java\JavaWeb\05_xml\.
        Document document = reader.read("xml/books.xml");

        System.out.println(document);

        File file = new File(".");
        System.out.println(file.getAbsoluteFile());
    }


    @Test
    public void test2() throws DocumentException {
        //遍历读取获取xml文档中的内容

        // 需要分四步操作:
        // 第一步，通过创建 SAXReader 对象。来读取 xml 文件，获取 Document 对象
        // 第二步，通过 Document 对象。拿到 XML 的根元素对象
        // 第三步，通过根元素对象。获取所有的 book 标签对象
        // 第四小，遍历每个 book 标签对象。然后获取到 book 标签对象内的每一个元素，再通过 getText() 方法拿到起始标签和结束标签之间的文本内容

        SAXReader reader = new SAXReader();
        Document document = reader.read("xml/books.xml");
        Element root = document.getRootElement();
        //System.out.println(root.asXML());  //xml文件的字符串
        System.out.println(root.elements("book"));
        List<Element> books= root.elements("book");

        for (Element book: books) {
            Element nameElement = book.element("name");
            Element priceElement = book.element("price");
            Element authorElement = book.element("author");
            Attribute id = book.attribute("id");

            System.out.println("书名:" + nameElement.getText() + " , 价格:"
                    + priceElement.getText() + ", 作者：" + authorElement.getText() + ", id:" + id.getText());
        }


    }

}
