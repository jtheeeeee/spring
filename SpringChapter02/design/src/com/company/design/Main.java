package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.net.SocketOption;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        /*
	    AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aclient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개이 객체가 동일한가?");
        System.out.println(aclient.equals(bClient));
         //같은 객체이다
        */
        /*
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaneer cleaneer = new Cleaneer();
        // connect(cleaneer); 110v에 220v 쓸수 x

        //어댑터를 사온다. 어댑터는 110V, 어댑터에 연결되는 것은 220V
        SocketAdapter adapter = new SocketAdapter(cleaneer);
        //연결되는 것은 어댑터터
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        SocketAdapter airadapter = new SocketAdapter(airConditioner);
        connect(airadapter);
        */
        /*
        Browser browser = new Browser("www.naver.com");

        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser loading html from : www.naver.com
        browser loading html from : www.naver.com
        browser loading html from : www.naver.com
        browser loading html from : www.naver.com
        browser loading html from : www.naver.com

        매번 받아옴
        */
        /*
        IBrowser browser = new BrowserProxy("www.naver.ocom");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();*/
        /*
        BrowserProxy loading html from : www.naver.ocom
        BrowserProxy use cache from : www.naver.ocom
        BrowserProxy use cache from : www.naver.ocom
        BrowserProxy use cache from : www.naver.ocom
        BrowserProxy use cache from : www.naver.ocom
        BrowserProxy use cache from : www.naver.ocom
         */
//
//        AtomicLong start= new AtomicLong();
//        AtomicLong end = new AtomicLong();
//
//        IBrowser aopBrowser = new AopBrowser("www.naver.com",
//                ()->{
//                    System.out.println("before");
//                    start.set(System.currentTimeMillis());
//                },
//                ()->{
//                    long now = System.currentTimeMillis();
//                    end.set(now - start.get());
//                }
//        );
//
//        aopBrowser.show();
//        System.out.println("loading time : "+end.get());
//
//        aopBrowser.show();
//        System.out.println("loading time : "+end.get());
//
//        Icar audi=new Audi(2000);
//        audi.showPrice();
//
//        //a3
//        Icar audi3 = new A3(audi, "A3");
//        audi3.showPrice();
//
//        //a4
//        Icar audi4 = new A4(audi, "A4");
//        audi4.showPrice();
//
//        //a5
//        Icar audi5 = new A5(audi, "A5");
//        audi5.showPrice();

//        Button button = new Button("버튼");
//        button.addListener(new IButtonListener() {
//            @Override
//            public void clickEvent(String event) {
//                System.out.println(event);
//            }
//        });
//
//        button.click("메세지 전달: click 1");
//        button.click("메세지 전달: click 2");
//        button.click("메세지 전달: click 3");
//        button.click("메세지 전달: click 4");

//        Facade객체 없이 했을 경우
//        Ftp ftpClient = new Ftp("www.naver.com",22,"/home/etc");
//        ftpClient.connet();
//        ftpClient.moveDirectory();
//
//        Writer writer = new Writer("text.tmp");
//        writer.fileConnect();
//        writer.write();
//
//        Reader reader = new Reader("text.tmp");
//        reader.fileConnect();
//        reader.fileRead();
//        reader.fileDisconnect();
//        writer.fileDisconnect();
//        ftpClient.disconnect();

////        Facade 객체로 진행했을 경우
//        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etx","text.tmp");
//        sftpClient.connect();
//        sftpClient.write();
//        sftpClient.read();
//        sftpClient.disConnect();

        Encoder encoder = new Encoder();
        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
