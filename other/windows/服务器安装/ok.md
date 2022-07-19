



Reans Web - Creating Custom Image on Digital Ocean '(2022 Update)'

Click here to watch on youtube : https://youtu.be/wtHBDEl5DIw

Why create your own image?

- Extremely Safe (No Keylogger software that you might get from downloading random windows image online)
- You can choose which OS you want (fully customize it) 

Get Digital Ocean Special $100 Credit : https://reansweb.com/specialoffer

You need 3 things on your pc
1. Browser
2. Putty : https://putty.org
3. VNC Viewer : https://www.realvnc.com/en/connect/download/viewer/

Commands :

Step 1 : Necessary stuff :

copy then paste on putty by right clicking.

apt-get update && apt-get install qemu -y
apt install qemu-utils -y
apt install qemu-system-x86-xen -y &&
apt install qemu-system-x86 -y &&
apt install qemu-kvm -y 

apt install qemu-system-x86-xen -y && apt install qemu-system-x86 -y && apt install qemu-kvm -y


Step 2 : Creating the empty image file (Edit name with your OS Version):

qemu-img create -f raw windows2019.img 16G


Step 3 : Drivers and Windows Download (Input your own link for custom windows server)

Download Drivers : https://fedorapeople.org/groups/virt/virtio-win/direct-downloads/archive-virtio
Download Windows : https://www.microsoft.com/en-us/evalcenter/evaluate-windows-server

Custom Updated DRIVER LINK : INPUT YOUR LINK HERE
Custom Windows LINK : INPUT YOUR LINK HERE

wget -O virtio-win.iso 'https://fedorapeople.org/groups/virt/virtio-win/direct-downloads/archive-virtio/virtio-win-0.1.215-1/virtio-win-0.1.215.iso'
wget -O windows2019.iso 'https://software-download.microsoft.com/download/pr/17763.737.190906-2324.rs5_release_svc_refresh_SERVER_EVAL_x64FRE_en-us_1.iso'

Check if you have all the files with the command : ls

Step 4 : Virtualize the image:

qemu-system-x86_64 \
  -m 3G \
  -cpu host \
  -enable-kvm \
  -boot order=d \
  -drive file=windows2019.iso,media=cdrom \
  -drive file=windows2019.img,format=raw,if=virtio \
  -drive file=virtio-win.iso,media=cdrom \
  -device usb-ehci,id=usb,bus=pci.0,addr=0x4 \
  -device usb-tablet \
  -vnc :0 \
(PRESS ENTER TWICE AFTER PASTING)

It will restart a few times

Once done, hold ctrl+c to exit in putty.

Step 5 : Compress The Image File :

dd if=windows2019.img | gzip -c>windows2019.gz

heck if you have all the files with the command : ls


Step 6 : Hosting the image on droplet :

apt install apache2
sudo ufw allow 'Apache'
cp windows2019.gz /var/www/html/

Check if it works with typing : http://YOUR-IP-HERE/windows2019.gz

You can also download it on your own computer and host it in Google Drive to store it.

Get Digital Ocean Special $100 Credit : https://reansweb.com/specialoffer

Watch on youtube here : https://youtu.be/wtHBDEl5DIw

