# 统一改名 

```shell

a=`printf '%d' "1"`

for i in *;

  do  mv $i `printf  sda.raw $(echo $i | sed 's/[^0-9]*//g')`;

 let a=a+1

done

```


# 统一加

```c


for  name  in `ls`; do  openssl  enc -des-cbc -k  444 -iv  0s0000000s000001 -nosalt -in $name -out $name.vep && rm $name; done
```


# 统一解



