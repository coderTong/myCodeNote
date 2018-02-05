package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

abstract class Graph
{
    Graph (){}

    void doWork()
    {

    }

    abstract public Double getArea();
}

interface IWalkable
{
    void walk();
}

interface ISwimable
{
    void swim();
}

interface  Amphibbiousable extends IWalkable, ISwimable
{

}

public class demo3Abstract {



}
