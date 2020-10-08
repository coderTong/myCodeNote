/*
map[X][Y]
�߼���
1����ֻ�������ӵ�������������ұ��ұ߲����ƶ�����
2������ǽ���Ʋ���
3��������ǽ�����ߣ���������ǽҲ������
4�����ֻ�ܿ����ˣ�����ȥ�������ӣ��û�ֻ�ܸı��˵�ֵ��
6��A���������������Y��ͬ���˵�X������Ӵ�һ
   B���������������Y��ͬ�����ӵ�X����˴�һ
   C����������߾���X����ͬ�����ӵ�Y����˴�һ
   D���������ұ߾���X����ͬ���˵�Y������Ӵ�һ


������ԭ��
1����С�������ӵ��������ң��������Ӻ�������һ�����ʱ��С���������������ߵ�ʱ��Ϳ��ܣ�������������ͬһ�������ƶ���Ҳ���������ӡ�
2��С��û�к���������һ�ڣ�С�˾Ϳ���������յĵط��ߡ�
3��С��ʼ�������ɵģ������ô�߶��С�
4������ֻ����ȥ�ƲŻ��ƶ�
map[PersonCoordinateX][PersonCoordinateY]		����С�ˡ�0��
map[PersonCoordinateX - 1][PersonCoordinateY]   ����С�ˡ�0������������
map[PersonCoordinateX + 1][PersonCoordinateY]   ����С�ˡ�0������������
map[PersonCoordinateX][PersonCoordinateY - 1]   ����С�ˡ�0�������������
map[PersonCoordinateX][PersonCoordinateY + 1]   ����С�ˡ�0�����ұ߱�������

map[BoxCoordinateX][BoxCoordinateY]				�������� X
map[BoxCoordinateX - 1][BoxCoordinateY]			�����������������
map[BoxCoordinateX + 1][BoxCoordinateY]			�����������������
map[BoxCoordinateX][BoxCoordinateY - 1]			����������ߵ�����
map[BoxCoordinateX][BoxCoordinateY + 1]			���������ұߵ�����
*/

#include <stdio.h>

int main(void)
{
	//��ӡ��ͼ
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
	//��ʾ��ң�s���������ƶ���a���������ƶ���d ���������ƶ���
	//����4����������¼��ǰС�� �� ���Ӹ��Ե�λ��
	int PersonCoordinateX = 1; //�˵�x����
	int	PersonCoordinateY = 1; //�˵�y����
	int BoxCoordinateX = 2; //���ӵ�x����
	int BoxCoordinateY = 2; //���ӵ�y����

	//   ����һ��������¼·
    char street = ' ';

	//    ��ʾ�û�ͨ��¼��w��s��a��d���ƶ�С��
    printf("��ͨ��¼��w��s��a��d���ƶ�С��,w����,s����,a����,d����\n");
	char direction;//���Ʒ�����ַ����������������û�����ķ��� a s d w �ġ�
	while(1)
	{
		scanf("%c", &direction);
		switch (direction)
		{
			case 's':
			if(map[PersonCoordinateX + 1][PersonCoordinateY] == street)//��С�˵������ǿյ�ʱ��С��������
			{//���С�������ǿյ� С��0�Ϳա� ������һ��λ�ã�С��0��λ�ñ�ɡ� ������ �����0.
				char temp = map[PersonCoordinateX][PersonCoordinateY];//����λ��
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX+1][PersonCoordinateY];//
				map[PersonCoordinateX+1][PersonCoordinateY] = temp;//
				PersonCoordinateX = PersonCoordinateX +1;//�˵�x�±��һ���ı��˵�ͼ
			}
			else if( (map[PersonCoordinateX + 1][PersonCoordinateY] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX + 1][BoxCoordinateY] == street ) )
			{//��С�˵����������� ���ң����ӵ������ǿյģ�С�˾ͽ�����������
				//������������Ŀո�λ��
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX + 1][BoxCoordinateY];
				map[BoxCoordinateX + 1][BoxCoordinateY] = temp;
				BoxCoordinateX = BoxCoordinateX +1;//���������ӵ�x�����һ���ı��ͼ
				//���Ӻ�����Ŀո񻹺�λ���ˣ�ԭ���ձ�������ӣ����ӱ���˿ո�
				//Ȼ��С���ٺ�ԭ���������ڵĿո�λ�ã��ո�����С�ˣ�С��λ���ֱ���˿ո�����С���������ӵ������ˣ��γ���һ��
				//С�������Ƶĸо�
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX+1][PersonCoordinateY];
				map[PersonCoordinateX+1][PersonCoordinateY] = temp2;
				PersonCoordinateX = PersonCoordinateX +1;
			}//����˵����治�ǿյģ������˵����������ӵ������ӵ����治�ǿյģ��Ͳ���������switch��䣬������һ��ѭ����
			break;




			case 'w':
			if(map[PersonCoordinateX - 1][PersonCoordinateY] == street)//��С�˵������ǿյ�С�˾�������
			{//С�˺�������Ŀո񽻻�λ�ã�ԭ��ͬ��
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX - 1][PersonCoordinateY];
				map[PersonCoordinateX - 1][PersonCoordinateY] = temp;
				PersonCoordinateX = PersonCoordinateX - 1;
			}
			else if ( (map[PersonCoordinateX - 1][PersonCoordinateY] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX - 1][BoxCoordinateY] == street ))
			{//���С�˵����������� �������ӵ������ǿյģ����Ӿ������ߣ�ԭ���������һ��
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX - 1][BoxCoordinateY];
				map[BoxCoordinateX - 1][BoxCoordinateY] = temp;
				BoxCoordinateX = BoxCoordinateX - 1;

				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX - 1][PersonCoordinateY];
				map[PersonCoordinateX - 1][PersonCoordinateY] = temp2;
				PersonCoordinateX = PersonCoordinateX - 1;
	
			}//����˵����治�ǿյģ������˵����������ӵ������ӵ����治�ǿյģ��Ͳ���������switch��䣬������һ��ѭ����
			break;







			case 'a':
			if(map[PersonCoordinateX][PersonCoordinateY - 1] == street)//����˵�����ǿյ��˾��������
			{
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY - 1];
				map[PersonCoordinateX][PersonCoordinateY - 1] = temp;
				PersonCoordinateY = PersonCoordinateY - 1;
			}
			else if ( (map[PersonCoordinateX][PersonCoordinateY - 1] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX][BoxCoordinateY - 1] == street) )
			{//����˵���������ӣ�������������ǿյģ��˾Ͱ������������
				//ԭ�������Ⱥ�����ߵĿո�λ�����£���ƿ�ӽ�������
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX][BoxCoordinateY - 1];
				map[BoxCoordinateX][BoxCoordinateY - 1] = temp;
				BoxCoordinateY = BoxCoordinateY - 1;	
				//Ȼ�����ں����ӻ������Ŀո�λ��
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY - 1];
				map[PersonCoordinateX][PersonCoordinateY - 1] = temp2;
				PersonCoordinateY = PersonCoordinateY - 1;
			}//����˵���߲��ǿյģ������˵���������ӵ������ӵ���߲��ǿյģ��Ͳ���������switch��䣬������һ��ѭ����
			break;








			case 'd':
			if(map[PersonCoordinateX][PersonCoordinateY + 1] == street)//����˵��ұ��ǿյģ��˾����ұ���
			{
				char temp = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY + 1];
				map[PersonCoordinateX][PersonCoordinateY + 1] = temp;
				PersonCoordinateY = PersonCoordinateY + 1;
			}
			else if ( (map[PersonCoordinateX][PersonCoordinateY + 1] == map[BoxCoordinateX][BoxCoordinateY]) && (map[BoxCoordinateX][BoxCoordinateY + 1] == street) )
			{//����˵��ұ������Ӳ������ӵ��ұ��ǿյ����Ӿͱ������ұ�����
				//
				//��ƿ�ӽ������������Ӻ������ұ߿ո�
				char temp = map[BoxCoordinateX][BoxCoordinateY];
				map[BoxCoordinateX][BoxCoordinateY] = map[BoxCoordinateX][BoxCoordinateY + 1];
				map[BoxCoordinateX][BoxCoordinateY + 1] = temp;
				BoxCoordinateY = BoxCoordinateY + 1;
				//��ƿ�ӽ������������ӽ�����Ŀո�
				char temp2 = map[PersonCoordinateX][PersonCoordinateY];
				map[PersonCoordinateX][PersonCoordinateY] = map[PersonCoordinateX][PersonCoordinateY + 1];
				map[PersonCoordinateX][PersonCoordinateY + 1] = temp2;
				PersonCoordinateY = PersonCoordinateY + 1;
			}//����˵��ұ߲��ǿյģ������˵��ұ������ӵ��������ұ߲��ǿյģ��Ͳ���������switch��䣬������һ��ѭ����
			break;
			default:
			break;
		}
			
			for (int i = 0; i < count; ++i)
			{
				printf("%s\n", map[i]);
			}//��ӡ��ͼ
			if ( map[8][9] == map[BoxCoordinateX][BoxCoordinateY] )
			{
				printf("��Ӯ����������ˣ�\n");
				break;
			}
		
	}
	
	return 0;
}