# ./configure --help 看看可以加的东西


# ==========Mac+x264+fdkAAC+filter+ass



```


brew install automake fdk-aac git lame libass libtool libvorbis libvpx opus sdl shtool texi2html theora wget x264 x265 xvid nasm


```


```


wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz

tar xf yasm-1.3.0.tar.gz

cd yasm-1.3.0

./configure --prefix=/application/yasm-1.3.0/

make

make install



```




```

/**

--yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm
--enable-ffplay
--enable-gpl
--enable-libfdk_aac
--enable-libmp3lame
--enable-nonfree
--enable-libfreetype
--enable-libx264
--enable-libfreetype
--enable-libfontconfig
--prefix=/Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext
--enable-libass
*/



./configure --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --enable-gpl --enable-libfdk_aac --enable-libmp3lame --enable-nonfree --enable-libfreetype --enable-libx264 --enable-libfontconfig --enable-libass --prefix=/Users/codew/Desktop/code4-av/ffmpeg_ass_x264_fdkaac_ffplayer_drawtext



make
make install








ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffprobe /usr/local/bin/ffprobe

ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffmpeg /usr/local/bin/ffmpeg

ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffplay /usr/local/bin/ffplay

```




# ==========Mac+x264+fdkAAC+filter


```

brew install automake fdk-aac git lame libass libtool libvorbis libvpx opus sdl shtool texi2html theora wget x264 x265 xvid nasm





brew install automake fdk-aac git lame libass libtool libvorbis libvpx opus sdl shtool texi2html theora wget x264 x265 xvid nasm

Updating Homebrew...

==>  **Auto-updated Homebrew!**

Updated 1 tap (homebrew/core).

==>  **New Formulae**

click gcc@7 genact  libplctag unp64 xidel

==>  **Updated Formulae**

**gnupg** **✔** ethereum lean pipenv

**libgpg-error** **✔** fastme lean-cli planck

abcm2ps  field3d  leptonica  plantuml

abcmidi  fig2dev  libcouchbase plplot

abyss  flashrom libcue pod2man

acpica fluid-synth  libfixbuf  presto

aircrack-ng  fn libgsm ptex

akamai folly  libofx puzzles

algernon fontconfig libphonenumber pxz

angular-cli  fonttools  libraw qbs

annie  fossil librealsense qrupdate

apache-geode freeipmi libressl r

archivemount freetype librtlsdr  rabbitmq-c

armadillo  frugal libsoup  rakudo-star

armor  fswatch  libuv  ratfor

arpack fwup libvirt  rawtoaces

artifactory  gauge  libxc  rebar@3

asciidoctor  gcc  lmod remarshal

atdtool  get_iplayer  lynis  remctl

azure-cli  gitlab-runner  lysp reposurgeon

bartycrouch  gjs  lz4  restview

bedops gmsh mariadb@10.0 rgbds

binwalk  gnumeric maxwell  root

bit  gnuplot  mbedtls  scala

bitrise  gocr media-info scalapack

bluepill goenv  metabase scamper

bochs  goffice  mikutter scipy

bower  gomplate minisat  shadowsocks-libev

certbot  goose  miniupnpc  silk

cfitsio  grafana  mkvtoolnix siril

cfr-decompiler grib-api mmseqs2  sleuthkit

cgrep  gromacs  mpich  spades

chakra groovy mrboom spigot

chamber  hdf5 mypy sqlmap

check_postgres hdf5@1.8 n  streamlink

chronograf heroku nativefier sundials

cjdns  hh ncmpc  synfig

ckan hlint  neko telegraf

clojurescript  hugo netcdf teleport

composer hypre  nghttp2  terragrunt

conan  ilmbase  nnn  tomcat

convox imagemagick  node traefik

cp2k imagemagick@6  numpy  transmission

ctl  imake  ocrmypdf tundra

dar  imapsync octave txr

dash ivykis odpi u-boot-tools

datetime-fortran jabba  open-mpi unbound

dcd  jags openblas urh

derby  jboss-forge  opencv vagrant-completion

diffoscope jdupes opencv@2 veclibfort

dislocker  jemalloc openexr  vim

django-completion  jenkins  openimageio  wabt

dmd  jenkins-job-builder  openvdb  webpack

docfx  jenkins-lts  ortp wget

docker-compose jfrog-cli-go osm2pgsql  wine

docker-compose-completion  json-fortran packmol  wtf

draco  just pandoc-crossref  xmrig

dscanner kafka  pbrt xonsh

dub  kibana@5.6 pdfpc  yaf

dungeon  krb5 pdns yaz

dxpy kube-aws pegtl  ykman

dynare kubeless petsc  youtube-dl

elixir lammps pgpdump  yq

emscripten landscaper pgplot znc

erlang@19  lapack pilosa

==>  **Deleted Formulae**

i3 i3status

Warning: libtool 2.4.6_1 is already installed and up-to-date

To reinstall 2.4.6_1, run `brew reinstall libtool`

Error: automake 1.15 is already installed

To upgrade to 1.16.1, run `brew upgrade automake`

==>  **Downloading https://homebrew.bintray.com/bottles/fdk-aac-0.1.6.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring fdk-aac-0.1.6.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/fdk-aac/0.1.6: 14 files, 1.8MB

==>  **Downloading https://homebrew.bintray.com/bottles/git-2.17.0.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring git-2.17.0.high_sierra.bottle.tar.gz**

==>  **Caveats**

Bash completion has been installed to:

 /usr/local/etc/bash_completion.d

zsh completions and functions have been installed to:

 /usr/local/share/zsh/site-functions

Emacs Lisp files have been installed to:

 /usr/local/share/emacs/site-lisp/git

==>  **Summary**

🍺 /usr/local/Cellar/git/2.17.0: 1,497 files, 35.6MB

==>  **Downloading https://homebrew.bintray.com/bottles/lame-3.100.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring lame-3.100.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/lame/3.100: 27 files, 2.1MB

==>  **Installing dependencies for libass:** **libpng****,** **freetype****,** **fribidi****,** **graphite2****,** **icu4c****,** **fontconfig****,** **pixman****,** **pcre****,** **glib****,** **cairo****,** **harfbuzz**

==>  **Installing libass dependency:** **libpng**

==>  **Downloading https://homebrew.bintray.com/bottles/libpng-1.6.34.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libpng-1.6.34.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libpng/1.6.34: 26 files, 1.2MB

==>  **Installing libass dependency:** **freetype**

==>  **Downloading https://homebrew.bintray.com/bottles/freetype-2.9.1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring freetype-2.9.1.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/freetype/2.9.1: 60 files, 2.6MB

==>  **Installing libass dependency:** **fribidi**

==>  **Downloading https://homebrew.bintray.com/bottles/fribidi-1.0.2.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring fribidi-1.0.2.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/fribidi/1.0.2: 66 files, 574.9KB

==>  **Installing libass dependency:** **graphite2**

==>  **Downloading https://homebrew.bintray.com/bottles/graphite2-1.3.10.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring graphite2-1.3.10.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/graphite2/1.3.10: 18 files, 259.1KB

==>  **Installing libass dependency:** **icu4c**

==>  **Downloading https://homebrew.bintray.com/bottles/icu4c-61.1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring icu4c-61.1.high_sierra.bottle.tar.gz**

==>  **Caveats**

This formula is keg-only, which means it was not symlinked into /usr/local,

because macOS provides libicucore.dylib (but nothing else).

If you need to have this software first in your PATH run:

 echo 'export PATH="/usr/local/opt/icu4c/bin:$PATH"' >> ~/.zshrc

 echo 'export PATH="/usr/local/opt/icu4c/sbin:$PATH"' >> ~/.zshrc

For compilers to find this software you may need to set:

 LDFLAGS: -L/usr/local/opt/icu4c/lib

 CPPFLAGS: -I/usr/local/opt/icu4c/include

For pkg-config to find this software you may need to set:

 PKG_CONFIG_PATH: /usr/local/opt/icu4c/lib/pkgconfig

==>  **Summary**

🍺 /usr/local/Cellar/icu4c/61.1: 249 files, 67.2MB

==>  **Installing libass dependency:** **fontconfig**

==>  **Downloading https://homebrew.bintray.com/bottles/fontconfig-2.13.0.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring fontconfig-2.13.0.high_sierra.bottle.tar.gz**

==>  **Regenerating font cache, this may take a while**

==>  **/usr/local/Cellar/fontconfig/2.13.0/bin/fc-cache -frv**

🍺 /usr/local/Cellar/fontconfig/2.13.0: 511 files, 3.2MB

==>  **Installing libass dependency:** **pixman**

==>  **Downloading https://homebrew.bintray.com/bottles/pixman-0.34.0_1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring pixman-0.34.0_1.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/pixman/0.34.0_1: 13 files, 1.3MB

==>  **Installing libass dependency:** **pcre**

==>  **Downloading https://homebrew.bintray.com/bottles/pcre-8.42.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring pcre-8.42.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/pcre/8.42: 204 files, 5.3MB

==>  **Installing libass dependency:** **glib**

==>  **Downloading https://homebrew.bintray.com/bottles/glib-2.56.1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring glib-2.56.1.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/glib/2.56.1: 430 files, 23.7MB

==>  **Installing libass dependency:** **cairo**

==>  **Downloading https://homebrew.bintray.com/bottles/cairo-1.14.12.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring cairo-1.14.12.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/cairo/1.14.12: 118 files, 5.8MB

==>  **Installing libass dependency:** **harfbuzz**

==>  **Downloading https://homebrew.bintray.com/bottles/harfbuzz-1.7.6_2.high_sierra.bottle.1.tar.gz**

######################################################################## 100.0%

==>  **Pouring harfbuzz-1.7.6_2.high_sierra.bottle.1.tar.gz**

🍺 /usr/local/Cellar/harfbuzz/1.7.6_2: 150 files, 6.0MB

==>  **Installing** **libass**

==>  **Downloading https://homebrew.bintray.com/bottles/libass-0.14.0_1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libass-0.14.0_1.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libass/0.14.0_1: 10 files, 515.6KB

==>  **Installing dependencies for libvorbis:** **libogg**

==>  **Installing libvorbis dependency:** **libogg**

==>  **Downloading https://homebrew.bintray.com/bottles/libogg-1.3.3.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libogg-1.3.3.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libogg/1.3.3: 97 files, 460.2KB

==>  **Installing** **libvorbis**

==>  **Downloading https://homebrew.bintray.com/bottles/libvorbis-1.3.6.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libvorbis-1.3.6.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libvorbis/1.3.6: 157 files, 2.3MB

==>  **Downloading https://homebrew.bintray.com/bottles/libvpx-1.7.0.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libvpx-1.7.0.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libvpx/1.7.0: 17 files, 1.4MB

==>  **Downloading https://homebrew.bintray.com/bottles/opus-1.2.1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring opus-1.2.1.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/opus/1.2.1: 16 files, 868.7KB

==>  **Downloading https://homebrew.bintray.com/bottles/sdl-1.2.15.high_sierra.bottle.3.tar.gz**

######################################################################## 100.0%

==>  **Pouring sdl-1.2.15.high_sierra.bottle.3.tar.gz**

🍺 /usr/local/Cellar/sdl/1.2.15: 225 files, 1.4MB

==>  **Downloading https://homebrew.bintray.com/bottles/shtool-2.0.8.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring shtool-2.0.8.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/shtool/2.0.8: 51 files, 540.3KB

==>  **Downloading https://homebrew.bintray.com/bottles/texi2html-5.0.high_sierra.bottle.1.tar.gz**

######################################################################## 100.0%

==>  **Pouring texi2html-5.0.high_sierra.bottle.1.tar.gz**

🍺 /usr/local/Cellar/texi2html/5.0: 279 files, 6.2MB

==>  **Downloading https://homebrew.bintray.com/bottles/theora-1.1.1.high_sierra.bottle.2.tar.gz**

######################################################################## 100.0%

==>  **Pouring theora-1.1.1.high_sierra.bottle.2.tar.gz**

🍺 /usr/local/Cellar/theora/1.1.1: 97 files, 2MB

==>  **Installing dependencies for wget:** **libunistring****,** **libidn2****,** **openssl**

==>  **Installing wget dependency:** **libunistring**

==>  **Downloading https://homebrew.bintray.com/bottles/libunistring-0.9.9.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libunistring-0.9.9.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libunistring/0.9.9: 54 files, 4.4MB

==>  **Installing wget dependency:** **libidn2**

==>  **Downloading https://homebrew.bintray.com/bottles/libidn2-2.0.4.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring libidn2-2.0.4.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/libidn2/2.0.4: 46 files, 580.6KB

==>  **Installing wget dependency:** **openssl**

==>  **Downloading https://homebrew.bintray.com/bottles/openssl-1.0.2o_1.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring openssl-1.0.2o_1.high_sierra.bottle.tar.gz**

==>  **Caveats**

A CA file has been bootstrapped using certificates from the SystemRoots

keychain. To add additional certificates (e.g. the certificates added in

the System keychain), place .pem files in

 /usr/local/etc/openssl/certs

and run

 /usr/local/opt/openssl/bin/c_rehash

This formula is keg-only, which means it was not symlinked into /usr/local,

because Apple has deprecated use of OpenSSL in favor of its own TLS and crypto libraries.

If you need to have this software first in your PATH run:

 echo 'export PATH="/usr/local/opt/openssl/bin:$PATH"' >> ~/.zshrc

For compilers to find this software you may need to set:

 LDFLAGS: -L/usr/local/opt/openssl/lib

 CPPFLAGS: -I/usr/local/opt/openssl/include

For pkg-config to find this software you may need to set:

 PKG_CONFIG_PATH: /usr/local/opt/openssl/lib/pkgconfig

==>  **Summary**

🍺 /usr/local/Cellar/openssl/1.0.2o_1: 1,791 files, 12.3MB

==>  **Installing** **wget**

==>  **Downloading https://homebrew.bintray.com/bottles/wget-1.19.5.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring wget-1.19.5.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/wget/1.19.5: 50 files, 3.7MB

==>  **Downloading https://homebrew.bintray.com/bottles/x264-r2854.high_sierra.bottle.1.tar.gz**

######################################################################## 100.0%

==>  **Pouring x264-r2854.high_sierra.bottle.1.tar.gz**

🍺 /usr/local/Cellar/x264/r2854: 11 files, 3.4MB

==>  **Downloading https://homebrew.bintray.com/bottles/x265-2.7.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring x265-2.7.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/x265/2.7: 11 files, 24.0MB

==>  **Downloading https://homebrew.bintray.com/bottles/xvid-1.3.5.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring xvid-1.3.5.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/xvid/1.3.5: 10 files, 1.2MB

==>  **Downloading https://homebrew.bintray.com/bottles/nasm-2.13.03.high_sierra.bottle.tar.gz**

######################################################################## 100.0%

==>  **Pouring nasm-2.13.03.high_sierra.bottle.tar.gz**

🍺 /usr/local/Cellar/nasm/2.13.03: 30 files, 2.6MB

$ **~/Desktop/code4-av/FFmpeg**  (master)  [10:50:31]

**codew$** which wget

/usr/local/bin/wget

$ **~/Desktop/code4-av/FFmpeg**  (master)  [10:54:44]

**codew$** pwd

/Users/codew/Desktop/code4-av/FFmpeg

$ **~/Desktop/code4-av/FFmpeg**  (master)  [10:55:20]

**codew$**



```

```


wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz

tar xf yasm-1.3.0.tar.gz

cd yasm-1.3.0

./configure --prefix=/application/yasm-1.3.0/

make

make install



```




```

/**

--yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm
--enable-ffplay
--enable-gpl
--enable-libfdk_aac
--enable-libmp3lame
--enable-nonfree
--enable-libfreetype
--enable-libx264
--enable-libfreetype
--enable-libfontconfig
--prefix=/Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext
*/



./configure --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --enable-gpl --enable-libfdk_aac --enable-libmp3lame --enable-nonfree --enable-libfreetype --enable-libx264 --enable-libfontconfig --prefix=/Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext



make
make install



ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffprobe /usr/local/bin/ffprobe

ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffmpeg /usr/local/bin/ffmpeg

ln -s /Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext/bin/ffplay /usr/local/bin/ffplay

```







# ================普通的

```

git clone https://github.com/FFmpeg/FFmpeg.git




wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz

tar xf yasm-1.3.0.tar.gz

cd yasm-1.3.0

./configure --prefix=/application/yasm-1.3.0/

make

make install





cd /FFmpeg
./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

make
make install


```




# 1.8 FFmpeg编码支持与定制


```

// FFmpeg不支持的格式, 通过如下命令查看所需要的第三方外部库
./configure --help







// 仅仅支持H.264视频与AAC音频的编码
./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264 --enable-libfdk-aac --enable-gpl --enable-nonfree


./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264 --enable-libfdk-aac --enable-gpl --enable-nonfree




cd /FFmpeg
./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264 --enable-libfdk-aac --enable-gpl --enable-nonfree --prefix=/application/FFmpegH264/

./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264  --enable-gpl --enable-nonfree --prefix=/application/FFmpegH264/


```





# =================================FDKAAC+X264+linux



## 4.1.0 从新安装FFmpeg

这一章我们要用x264 , fdkaac, ffmpeg本身是并不支持, 是以第三方模块支持的, 所以我们得重新编译一个支持的. 

FFmpeg最终我们要装在 `/application/FFmpeg`下面, 注意看`/application/FFmpeg`在下面出现的地方.


首先这里是`centos`哈, 你先登录, 然后创建一个文件夹我这里叫, `/wt`, 然后 `cd /wt`
### 1.必要工具安装   
`yum install autoconf automake bzip2 cmake freetype-devel gcc gcc-c++ git libtool make mercurial pkgconfig zlib-devel -y`

### 2下载FFmpeg源码: 
`git clone https://github.com/FFmpeg/FFmpeg.git`

下载完进入源码文件夹:
`cd FFmpeg`

### 3. 编译FFmpeg必要的汇编工具yasm
现在这步是紧接着上面来的.

下载源码:
`curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz`
解压
`tar xzvf yasm-1.3.0.tar.gz`
进入`yasm`编译`yasm`
`cd yasm-1.3.0`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin`
`make`
`make install`



### 4. x264 要的nasm. 
没有会报错
```

Found no assembler

Minimum version is nasm-2.13

If you really want to compile without asm, configure with --disable-asm.

```

紧接着上面第三步哈
`cd /wt/FFmpeg`

`curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2`

`tar xjvf nasm-2.13.02.tar.bz2`
`cd nasm-2.13.02`
`./autogen.sh`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin`
`make`
`make install`



最后做一个软链接不然还是会报错
`ln -s /application/FFmpeg/bin/nasm /usr/sbin/nasm`
### 5. 装libx264
`cd /wt/FFmpeg`


`git clone --depth 1 http://git.videolan.org/git/x264`
`cd x264`

```

PKG_CONFIG_PATH=/application/FFmpeg/ffmpeg_build/lib/pkgconfig ./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin --enable-static


```
`make`
`make install`


### 6. 装 libfdk_aac

`cd /wt/FFmpeg`
`git clone https://github.com/mstorsjo/fdk-aac`
`cd fdk-aac`
`autoreconf -fiv`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --disable-shared`
`make`
`make install`


### 7.编译FFmpeg

```

cd /wt/FFmpeg

curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2
tar xjvf ffmpeg-snapshot.tar.bz2
cd ffmpeg
PATH="/application/FFmpeg/bin:$PATH" PKG_CONFIG_PATH="/application/FFmpeg/ffmpeg_build/lib/pkgconfig" ./configure \
  --prefix="/application/FFmpeg/ffmpeg_build" \
  --pkg-config-flags="--static" \
  --extra-cflags="-I/application/FFmpeg/ffmpeg_build/include" \
  --extra-ldflags="-L/application/FFmpeg/ffmpeg_build/lib" \
  --extra-libs=-lpthread \
  --extra-libs=-lm \
  --bindir="/application/FFmpeg/bin" \
  --enable-gpl \
  --enable-libfdk_aac \
  --enable-libfreetype \
  --enable-libx264 \
  --enable-libmp3lame \
  --enable-nonfree
make
make install
hash -r



```


