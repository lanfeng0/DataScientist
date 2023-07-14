package org.example.week4.day27.observable;

//观察者模式测试
public class SimpleTest    
{    
   public static void main(String[] args){    
      SimpleObservable doc = new SimpleObservable ();    
      SimpleObserver view = new SimpleObserver (doc);    
      doc.setData(1);    
      doc.setData(2);    
      doc.setData(2);    
      doc.setData(3);     
   }    
}   
