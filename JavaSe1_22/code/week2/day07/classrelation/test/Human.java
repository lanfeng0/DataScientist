package org.example.week2.day07.classrelation.test;

//人
public class Human {
  DrivingLicense license;  //一对一  一个人只有一个驾驶证
  CertificateOfHonor[] certificateOfHonors;  //一对多  一个人可以有多个荣誉证书
}
