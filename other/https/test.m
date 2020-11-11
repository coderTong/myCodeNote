yum install pcre pcre-devel -y && wget -q http://nginx.org/download/nginx-1.6.3.tar.gz && useradd www -s /sbin/nologin -M && tar xf nginx-1.6.3.tar.gz && cd nginx-1.6.3 && yum install openssl openssl-devel gcc -y && ./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --prefix=/application/nginx-1.6.3/ && make && make install &&  ln -s /application/nginx-1.6.3/ /application/nginx
: 1599018204:0;cd /application/nginx/sbin
: 1599018207:0;./nginx
: 1599018216:0;cd ../html
: 1599018220:0;vim index.html
: 1599018392:0;ping http://www.domanshow.com/
: 1599018399:0;ping www.domanshow.com/
: 1599018402:0;ping www.domanshow.com
: 1599018512:0;cd
: 1599018514:0;ls
: 1599018516:0;yum install python2-certbot-nginx
: 1599018686:0;echo "export LC_ALL=en_US.UTF-8"  >>  /etc/profile
: 1599018691:0;source /etc/profile
: 1599018694:0;yum install python2-certbot-nginx
: 1599018813:0;vim /etc/yum/pluginconf.d/fastestmirror.conf
: 1599018829:0;yum install python2-certbot-nginx
: 1599019013:0;ls
: 1599019017:0;cd /
: 1599019019:0;mkdir wt
: 1599019020:0;ls
: 1599019024:0;cd wt
: 1599019026:0;ls
: 1599019042:0;wget http://rpmfind.net/linux/centos/7.6.1810/os/x86_64/Packages/python-zope-interface-4.0.5-4.el7.x86_64.rpm
: 1599019087:0;sudo yum install certbot python2-certbot-nginx
: 1599019238:0;yum-config-manager --enable epel-testing
: 1599019245:0;yum update
: 1599019665:0;sudo yum install certbot-nginx
: 1599019689:0;pip uninstall psutil
: 1599019702:0;yum install pip -y
: 1599019919:0;yum -y install epel-release
: 1599019928:0;yum install python2-certbot-nginx
: 1599020006:0;which certbot
: 1599020013:0;certbot -h
: 1599020157:0;cd /application/nginx/conf
: 1599020157:0;ls
: 1599020161:0;vim nginx.conf
: 1599020271:0;cd ../html
: 1599020272:0;ls
: 1599020281:0;mkdir coder
: 1599020296:0;cp index.html coder
: 1599020298:0;cd coder
: 1599020299:0;ls
: 1599020303:0;vim index.html
: 1599020360:0;/application/nginx/sbin/nginx -t
: 1599020366:0;/application/nginx/sbin/nginx -s reload
: 1599020538:0;cd ..
: 1599020542:0;ls
: 1599020546:0;cd conf
: 1599020548:0;pwd
: 1599020624:0;ls
: 1599020627:0;certbot --nginx --nginx-server-root=/application/nginx/conf -d bbs.domanshow.com

: 1599020655:0;which nginx
: 1599020680:0;which ls
: 1599020731:0;ln -s /application/nginx/sbin/nginx /usr/bin/nginx
: 1599020735:0;which ls
: 1599020739:0;which nginx
: 1599020743:0;certbot --nginx --nginx-server-root=/application/nginx/conf -d www.domanshow.com
: 1599020951:0;ls
: 1599020954:0;vim nginx.conf
: 1599020992:0;/application/nginx/sbin/nginx -t
: 1599020997:0;/application/nginx/sbin/nginx -s reload
: 1599022154:0;cd /wt
: 1599022155:0;ls
: 1599022329:0;cd /application/nginx/html
: 1599022330:0;ls
: 1599022333:0;cd coder
: 1599022333:0;ls
: 1599022340:0;mv /wt/* ./
: 1599022342:0;ls
: 1599022528:0;vim index.html
: 1599022672:0;cd /wt
: 1599022673:0;ls
: 1599022677:0;cd -
: 1599022680:0;mv /wt/* ./
: 1599022682:0;ls
: 1599026438:0;cd /wt
: 1599026483:0;ls
: 1599026491:0;cd /application/nginx/html
: 1599026495:0;cd coder
: 1599026496:0;ls
: 1599026502:0;rm digitalCurrency.ipa
: 1599026506:0;cd /wt
: 1599026507:0;ls
: 1599026514:0;l
: 1599026516:0;ll
: 1599026523:0;cd -
: 1599026525:0;ls
: 1599026528:0;mv /wt/* ./
: 1599026529:0;ls
: 1600137498:0;cd /application/nginx/html
: 1600137499:0;ls
: 1600137507:0;cd coder
: 1600137508:0;ls
: 1600137522:0;wget https://github.com/Lerist/FakeLocation/releases/download/1.2.1.2/FakeLocation_CN_v1.2.1.2_724_20200902060649_1212.apk
: 1600137530:0;ll
: 1600137552:0;mv FakeLocation_CN_v1.2.1.2_724_20200902060649_1212.apk fl.apk
: 1600137553:0;ls
: 1600419364:0;cd /application/nginx/html
: 1600419365:0;ls
: 1600419367:0;cd coder
: 1600419368:0;ls
: 1600419373:0;vim index.html
: 1600419477:0;rm digitalCurrency.ipa
: 1600419496:0;ls
: 1600419510:0;mv /wt/* ./
: 1600419511:0;ls
: 1600419514:0;ll
: 1600419580:0;ls
: 1600419585:0;rm s.png
: 1600419586:0;ls
: 1600419592:0;mv /wt/* ./
: 1600419593:0;ls
: 1600681286:0;ccdc /wt
: 1600681289:0;/wt
: 1600681290:0;ls
: 1600681298:0;ll
: 1600681300:0;rm s.png
: 1600681322:0;cd /application/nginx/html
: 1600681323:0;ls
: 1600681325:0;cd coder
: 1600681325:0;ls
: 1600681357:0;rm digitalCurrency.ipa
: 1600681359:0;ls
: 1600681362:0;ls /wt
: 1600681366:0;mv /wt/* ./
: 1600681366:0;ls
: 1600916059:0;ls /wt
: 1600916061:0;cd /wt
: 1600916063:0;ls
: 1600916089:0;cd /application/nginx/html/coder
: 1600916090:0;ls
: 1600916106:0;ls /wt
: 1600916108:0;ls
: 1600916126:0;vim index.html
: 1600916241:0;ls
: 1600916246:0;rm digitalCurrency.ipa
: 1600916248:0;ll
: 1600916252:0;mv /wt/* ./
: 1600916253:0;ls
: 1600939127:0;cd /wt
: 1600939128:0;ls
: 1600939138:0;ll
: 1600939147:0;cd /application/nginx/html/coder
: 1600939148:0;ls
: 1600939152:0;rm digitalCurrency.ipa
: 1600939153:0;ls
: 1600939156:0;mv /wt/* ./
: 1600939157:0;ls
: 1600939220:0;vim index.html
: 1600939251:0;ll
: 1602166731:0;cd /application/nginx/html/coder
: 1602166731:0;ls
: 1602166742:0;git clone git@github.com:Xiaomi-mimc/mimc-ios-sdk.git
: 1602166756:0;ls
: 1602166763:0;git clone https://github.com/Xiaomi-mimc/mimc-ios-sdk.git
: 1602166777:0;ll
: 1602166963:0;ls
: 1602166982:0;tar czvf mi.tar mimc-ios-sdk
: 1602167009:0;ll
: 1602599223:0;cd /wt/w
: 1602599226:0;cd /wt/
: 1602599228:0;ls
: 1602599255:0;git clone https://github.com/QMUI/QMUIDemo_iOS.git
: 1602599261:0;ll
: 1602599321:0;tar czvf mi.tar QMUIDemo_iOS
: 1602599352:0;lll
: 1602599357:0;ll
: 1602599368:0;cd /application/nginx/html/coder
: 1602599369:0;ls
: 1602599509:0;rm mimc-
: 1602599524:0;rm mi.tar
: 1602599526:0;ll
: 1602599549:0;ls /wt
: 1602599563:0;mv /wt/mi.tar ./
: 1602599564:0;ls
: 1602599578:0;mv mi.tar mi2.tar
: 1602599580:0;ll
: 1602817501:0;cd /application/nginx/html/coder
: 1602817502:0;ls
: 1602817538:0;ccd /wt
: 1602817539:0;ls
: 1602817542:0;cd /wt
: 1602817543:0;ls
: 1602817563:0;mkdir ipa
: 1602817566:0;cd -
: 1602817568:0;ls
: 1602817577:0;mv * /wt/ipa
: 1602817579:0;ls
: 1602941044:0;cd /application/nginx/html/coder
: 1602941051:0;wget https://remocdn1.azureedge.net/remosoftware/remo-recover-windows.exe
: 1602941056:0;ll
: 1602941110:0;mv remo-recover-windows.exe ki.exe
: 1603289182:0;ls
: 1603289187:0;cd /wt
: 1603289190:0;ls
: 1603289193:1;wget -q http://nginx.org/download/nginx-1.6.3.tar.gz
: 1603289197:0;ll
: 1603289319:0;ls -all
: 1603289396:0;cd /application/nginx/html/coder
: 1603289398:0;ls
: 1603289405:1;wget -q http://nginx.org/download/nginx-1.6.3.tar.gz
: 1603289410:0;ll
: 1604042645:0;cd /wt
: 1604042646:0;ls
: 1604042655:0;cd /application/nginx/html/coder
: 1604042656:0;ls
: 1604042665:0;cd -
: 1604042666:0;ls
: 1604042674:0;cd ipa
: 1604042761:0;ls
: 1604043639:0;cd /wt
: 1604043640:0;ls
: 1604043645:0;cd /application/nginx/html/coder
: 1604043647:0;ls
: 1604043658:0;cp /wt/ipa/* ./
: 1604043663:0;ls
: 1604043673:0;cd /wt/ipa
: 1604043674:0;ls
: 1604043693:0;cd ls
: 1604043696:0;ls
: 1604043699:0;cd -
: 1604043700:0;ls
: 1604043704:0;rm digitalCurrency.ipa
: 1604043705:0;ls
: 1604043764:0;cd /wt
: 1604043767:0;ls
: 1604043774:0;cd -
: 1604043775:0;ls
: 1604043787:0;mv /wt/digitalCurrency.ipa ./
: 1604043788:0;ls
: 1604043810:17;vim index.html
: 1604043899:0;ll
: 1604300619:0;cd /application/nginx/html/coder
: 1604300620:0;ls
: 1604300786:16;vim manifest.plist
: 1604311416:0;ls
: 1604311422:0;cd /application/nginx/html/coder
: 1604311423:0;ls
: 1604311443:0;cp manifest.plist o.plist
: 1604311529:0;ls
: 1604311535:38;vim manifest.plist
: 1604311702:0;cd ..
: 1604311703:0;ls
: 1604311705:0;cd ..
: 1604311709:0;ls
: 1604311714:0;cd logs
: 1604311715:0;ls
: 1604311726:39;cat access.log
: 1604313166:0;cd /application/nginx/html/coder
: 1604313167:0;ls
: 1604313181:0;mv manifest.plist /wt
: 1604313182:0;ls
: 1604313191:0;mv o.plist manifest.plist
: 1604313301:0;ls
: 1604313312:0;mv digitalCurrency.ipa di.ipa
: 1604313313:0;ls
: 1604313343:0;cd /wt
: 1604313346:0;ls
: 1604313349:0;cd -
: 1604313350:0;ls
: 1604313353:0;mv /wt/digitalCurrency.ipa ./
: 1604313354:0;ls
: 1604313796:0;cd /application/nginx/html/coder
: 1604313797:0;ls
: 1604387322:0;cd /application/nginx/html/coder
: 1604387323:0;ls
: 1604387344:0;mv digitalCurrency.ipa diShare.ipa
: 1604387352:0;ls
: 1604387453:0;cd /wt
: 1604387531:0;ls
: 1604387536:0;cd -
: 1604387537:0;ls
: 1604387541:0;mv /wt/digitalCurrency.ipa ./
: 1604387542:0;ls
: 1604390974:0;cd /application/nginx/html/coder
: 1604390976:0;ls
: 1604391003:0;mkdir ay2
: 1604391005:0;ls
: 1604391029:0;cp digitalCurrency.ipa ay2
: 1604391058:0;cd ay2
: 1604391059:0;ls
: 1604391061:0;cd ..
: 1604391062:0;ls
: 1604391140:0;cp index.html ay2/anycion.html
: 1604391144:0;cd ay2
: 1604391145:0;ls
: 1604391149:0;cd ..
: 1604391151:0;ls
: 1604391171:0;cp manifest.plist ay2
: 1604391180:0;cd ay2
: 1604391182:0;ls
: 1604391228:106;vim anycion.html
: 1604391348:79;vim manifest.plist
: 1604391430:0;ls
: 1604391434:0;rm digitalCurrency.ipa
: 1604391435:0;ls
: 1604391776:0;cd /application/nginx/html/coder
: 1604391777:0;ls
: 1604391779:0;cd ay2
: 1604391780:0;ls
: 1604391792:0;cp anycion.html a.html
: 1604391793:0;ls
: 1604502751:0;cd /application/nginx/html/coder
: 1604502753:0;ls
: 1604502770:1;wget https://github.com/FelisCatus/SwitchyOmega/releases/download/v2.5.20/SwitchyOmega_Chromium.crx
: 1604502776:0;ll
: 1604502796:0;cp SwitchyOmega_Chromium.crx sw.exe
: 1604502797:0;ls
: 1604847732:0;cd /application/nginx/html/coder
: 1604847733:0;ls
: 1604847738:1;git clone https://github.com/tobiasvogel/hexMerger.git
: 1604847747:0;ls
: 1604847772:2;tar czvf mi2.tar hexMerger
: 1604847775:0;ll

