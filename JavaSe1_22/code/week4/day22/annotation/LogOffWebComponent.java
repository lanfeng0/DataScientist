package org.example.week4.day22.annotation;

@MyAnnotation5(urlpattern = "/bbs/loginoff.do")
public class LogOffWebComponent {
    public void doPost(String urlpattern, boolean onload) {
        System.out.println("访问URL：" + urlpattern + "  onload属性为： " + onload);
    }
}
