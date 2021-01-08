package com.lzj.json;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzj.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestJson
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/1/5 14:27
 * @Version 1.0
 **/
public class TestJson {

    /**
    * @Author: Keen
    * @Date:  14:34  2021/1/5
    * @Description:  javaBean与json互转
    * @param: null
    * @Return
    */
    @Test
    public void test1( ) {
        Person person = new Person(1, "root");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString); //{"id":1,"username":"root"}

        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1); //Person{id=1, username='root'}
    }


    @Test
    public void test2( ) {
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person(1, "root"));
        personList.add(new Person(2, "admin"));
        Gson gson = new Gson();
        //将list转换成json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);  //[{"id":1,"username":"root"},{"id":2,"username":"admin"}]

        //将json字符串转换为List
        /*List<Person> personList1 = gson.fromJson(personListJsonString, new ArrayList<Person>().getClass());
        System.out.println(personList1); // [{id=1.0, username=root}, {id=2.0, username=admin}]

        Person person = personList1.get(0);
        //java.lang.ClassCastException: com.google.gson.internal.LinkedTreeMap cannot be cast to com.lzj.pojo.Person
        System.out.println(person); //json转list失败*/

        List<Person> personList2 = gson.fromJson(personListJsonString,new PersonListType().getType());
        System.out.println(personList2); // [Person{id=1, username='root'}, Person{id=2, username='admin'}]
        Person person1 = personList2.get(0);
        System.out.println(person1); //json转list成功  Person{id=1, username='root'}
    }

    @Test
    public void test3( ) {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "root"));
        map.put(2, new Person(2, "admin"));
        System.out.println(map); //{1=Person{id=1, username='root'}, 2=Person{id=2, username='admin'}}

        Gson gson = new Gson();
        String mapJsonString = gson.toJson(map);
        System.out.println(mapJsonString); //{"1":{"id":1,"username":"root"},"2":{"id":2,"username":"admin"}}

        Map<Integer, Person> map2 = gson.fromJson(mapJsonString, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());

        System.out.println(map2.get(1)); //Person{id=1, username='root'}

    }
}
