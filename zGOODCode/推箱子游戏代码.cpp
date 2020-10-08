/*
map[X][Y]
逻辑：
1，人只能在箱子的上面下面左边右边右边才能推动箱子
2，遇到墙就推不动
3，人遇到墙不能走，箱子遇到墙也不能走
4，玩家只能控制人，人再去控制箱子，用户只能改变人的值，
6，A人在箱子上面就是Y相同，人的X轴比箱子大一
   B人在箱子下面就是Y相同，箱子的X轴比人大一
   C人在箱子左边就是X轴相同，箱子的Y轴比人大一
   D人在箱子右边就是X轴相同，人的Y轴比箱子大一


推箱子原理：
1，当小人在箱子的上下左右，并且箱子和人贴在一起，这个时候小人再往上下左右走的时候就可能，“带着箱子往同一个方向移动”也就是推箱子。
2，小人没有和箱子贴在一在，小人就可以随便往空的地方走。
3，小人始终是自由的，随便怎么走都行。
4，箱子只有人去推才会移动
map[PersonCoordinateX][PersonCoordinateY]		代表小人“0”
map[PersonCoordinateX - 1][PersonCoordinateY]   代表小人“0”的上面区域
map[PersonCoordinateX + 1][PersonCoordinateY]   代表小人“0”的下面区域
map[PersonCoordinateX][PersonCoordinateY - 1]   代表小人“0”的左边面区域
map[PersonCoordinateX][PersonCoordinateY + 1]   代表小人“0”的右边边面区域

map[BoxCoordinateX][BoxCoordinateY]				代表箱子 X
map[BoxCoordinateX - 1][BoxCoordinateY]			代表箱子上面的区域
map[BoxCoordinateX + 1][BoxCoordinateY]			代表箱子下面的区域
map[BoxCoordinateX][BoxCoordinateY - 1]			代表箱子左边的区域
map[BoxCoordinateX][BoxCoordinateY + 1]			代表箱子右边的区域
*/

#include <stdio.h>

int main(void)
{
	//打印地图
	char map[][11] = {
			"##########",
			"#O ####  #",
			"# X####  #",
			"#        #",
			"######   #",
			"#  ####  #",
			"#        #",
			"#   ######",
			"#         ",
			"##########"
	};

	int count = sizeof(map) / sizeof(map[0]);
	for (int i = 0; i < count; ++i)
	{
		printf("%s\n", map[i]);
	}

//	printf("%c\n", map[1][1]);
	//提示玩家，s代表向下移动，a代表向左移动，d 代表向右移动，
	//定义4个变量来记录当前小人 和 箱子各自的位置
	int PersonCoordinateX = 1; //人的x坐标
	int	PersonCoordinateY = 1; //人的y坐标
	int BoxCoordinateX = 2; //箱子的x坐标
	int BoxCoordinateY = 2; //箱子的y坐标

	//   定义一个变量记录路
    char street = ' ';

	//    提示用户通过录入w、s、a、d来移动小人
    printf("请通过录入w、s、a、d来移动小人,w向上,s向下,a向左,d向右\n");
	char direction;//控制方向的字符变量，用来接受用户输入的方向 a s d w 的。
	while(1)
	{
		scanf("%c", &direction);
		switch (direction)
		{
			case 's':
			if(map[PersonCoordinateX + 1][PersonCoordinateY] == street)//当小人的下面是空的时候小人往下走
			{//如果小人下面是空的 小人0和空“ ”，换一下位置，小人0的位置变成“ ”，“ ”变成0.
				char temp = map[PersonCoordinateX][PersonCoordinateY];//交换位置
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX+1][PersonCoordinateY];//
				map[PersonCoordinateX+1][PersonCoordinateY] = temp;//
				PersonCoordinateX = PersonCoordinateX +1;//人的x下标加一，改变了地图
			}
			else if( (map[PersonCoordinateX + 1][PersonCoordinateY] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX + 1][BoxCoordinateY] == street ) )
			{//当小人的下面是箱子 并且，箱子的下面是空的，小人就将箱子往下推
				//箱子与它下面的空格换位置
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX + 1][BoxCoordinateY];
				map[BoxCoordinateX + 1][BoxCoordinateY] = temp;
				BoxCoordinateX = BoxCoordinateX +1;//换好了箱子的x坐标加一，改变地图
				//箱子和下面的空格还好位置了，原来空变成了箱子，箱子变成了空格
				//然后小人再和原来箱子现在的空格换位置，空格变成了小人，小人位置又变成了空格，这样小人又再箱子的上面了，形成了一种
				//小人往下推的感觉
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX+1][PersonCoordinateY];
				map[PersonCoordinateX+1][PersonCoordinateY] = temp2;
				PersonCoordinateX = PersonCoordinateX +1;
			}//如果人的下面不是空的，或者人的下面是箱子但是箱子的下面不是空的，就不动，结束switch语句，进入下一个循环。
			break;




			case 'w':
			if(map[PersonCoordinateX - 1][PersonCoordinateY] == street)//当小人的上面是空的小人就网上走
			{//小人和它上面的空格交换位置，原理同上
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX - 1][PersonCoordinateY];
				map[PersonCoordinateX - 1][PersonCoordinateY] = temp;
				PersonCoordinateX = PersonCoordinateX - 1;
			}
			else if ( (map[PersonCoordinateX - 1][PersonCoordinateY] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX - 1][BoxCoordinateY] == street ))
			{//如果小人的上面是箱子 并且箱子的上面是空的，箱子就往上走，原理和往下走一样
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX - 1][BoxCoordinateY];
				map[BoxCoordinateX - 1][BoxCoordinateY] = temp;
				BoxCoordinateX = BoxCoordinateX - 1;

				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX - 1][PersonCoordinateY];
				map[PersonCoordinateX - 1][PersonCoordinateY] = temp2;
				PersonCoordinateX = PersonCoordinateX - 1;
	
			}//如果人的上面不是空的，或者人的上面是箱子但是箱子的上面不是空的，就不动，结束switch语句，进入下一个循环。
			break;







			case 'a':
			if(map[PersonCoordinateX][PersonCoordinateY - 1] == street)//如果人的左边是空的人就往左边走
			{
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY - 1];
				map[PersonCoordinateX][PersonCoordinateY - 1] = temp;
				PersonCoordinateY = PersonCoordinateY - 1;
			}
			else if ( (map[PersonCoordinateX][PersonCoordinateY - 1] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX][BoxCoordinateY - 1] == street) )
			{//如果人的左边是箱子，并且箱子左边是空的，人就把箱子往左边推
				//原理：箱子先和它左边的空格换位置如下，空瓶子交换法。
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX][BoxCoordinateY - 1];
				map[BoxCoordinateX][BoxCoordinateY - 1] = temp;
				BoxCoordinateY = BoxCoordinateY - 1;	
				//然后人在和箱子换下来的空格换位置
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY - 1];
				map[PersonCoordinateX][PersonCoordinateY - 1] = temp2;
				PersonCoordinateY = PersonCoordinateY - 1;
			}//如果人的左边不是空的，或者人的左边是箱子但是箱子的左边不是空的，就不动，结束switch语句，进入下一个循环。
			break;








			case 'd':
			if(map[PersonCoordinateX][PersonCoordinateY + 1] == street)//如果人的右边是空的，人就往右边走
			{
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY + 1];
				map[PersonCoordinateX][PersonCoordinateY + 1] = temp;
				PersonCoordinateY = PersonCoordinateY + 1;
			}
			else if ( (map[PersonCoordinateX][PersonCoordinateY + 1] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX][BoxCoordinateY + 1] == street) )
			{//如果人的右边是箱子并且箱子的右边是空的箱子就被人往右边推了
				//
				//空瓶子交换法交换箱子和箱子右边空格，
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX][BoxCoordinateY + 1];
				map[BoxCoordinateX][BoxCoordinateY + 1] = temp;
				BoxCoordinateY = BoxCoordinateY + 1;
				//空瓶子交换法交换箱子交换后的空格
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY + 1];
				map[PersonCoordinateX][PersonCoordinateY + 1] = temp2;
				PersonCoordinateY = PersonCoordinateY + 1;
			}//如果人的右边不是空的，或者人的右边是箱子但是箱子右边不是空的，就不动，结束switch语句，进入下一个循环。
			break;
			default:
			break;
		}
			
			for (int i = 0; i < count; ++i)
			{
				printf("%s\n", map[i]);
			}//打印地图
			if ( map[8][9] == map[BoxCoordinateX][BoxCoordinateY] )
			{
				printf("你赢，你真的淫了！\n");
				break;
			}
		
	}
	
	return 0;
}