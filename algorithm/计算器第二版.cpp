#include<iostream>
#include<stack>
#include<stdlib.h>
#include<string.h>

using namespace std;
int getGrade(char c)  //���������ĵȼ� 
{
	if(c=='*'||c=='/')
	{
		
		return 3;
	}
	if(c=='(')
	{
		
		return 4;
	}
	if(c=='+'||c=='-')
	{
		return 2;
	}
	if(c==')')
	{
		return 1;
	}
	if(c=='=')
	{
		return -1;
	}
}
void input(char*a)  //���� 
{
	for(int i=0;i<200;i++)
	{
		cin>>a[i];
		if(a[i]=='=')//�ԵȺ�Ϊ��β 
		{
			break;
		}
	}
	
}
int isLawful(char *a)//�ж��ַ��Ƿ�Ϸ� 
{  
    int len = strlen(a);
    int temp = 0;
    int temp1 = 0;
    char c[100];
	for(int i=0;i<100;i++)
	{
		c[i] = '\0';
	 } 
    while(temp<len)
	{
		//�Ѷ��������������ַ��뿪��
		if((a[temp]<48||a[temp]>57)&&a[temp]!='.')
		{
		    c[temp1] = a[temp];
			temp1++;
			temp++;
			continue;	
		} 
		temp++;
	}
	int temp4 = 0;
	for(int i=0;i<temp1-1;i++)
	{ 
	  if(c[i]!='+'&&c[i]!='-'&&c[i]!='*'&&c[i]!='/'&&c[i]!='('&&c[i]!=')'&&c[i]!='=')//�ж�������Ƿ�Ϸ� 
	  {
	  	    cout<<"�޷����������"; 
	  	    return -1;	
	  } 
	  if(c[i]=='(')
	  {
	  	  temp4++;
	  }
	  if(c[i]==')') 
	  {    
	  	  if(temp4<=0)
	  	  {
	        cout<<"���ų���!";  	  	
	  	  	return -1;
		  }
		  temp4--;
	  }
	  	
	}
	
	if(temp4!=0)
	{
		cout<<"���Ų�ƥ��!";
		return -1;
	}
	return 0; 	
}
float getFloat(char *a,int*temp)
{  
        //�����ֽ�ȡ���� 
		if((a[*temp]>=48&&a[*temp]<=57))
		{  
		    int temp3 = 0;
		    char r[8];
		    for(int i=0;i<8;i++)
		    {
		    	r[i] = '\0';
			}
			while(1)
			{    
				if((a[*temp]>=48&&a[*temp]<=57)||a[*temp]=='.')
				{
					r[temp3] = a[*temp];
					temp3++;
					(*temp)++;
					continue;
				}
				break;
			}
		   return atof(r); 	
		}
}		

int main(void)
{   
    cout<<"������һ����=�ı��ʽ ע��:������=��β ��Ȼ������� ������֮�����ո�"; 
    stack<char>s1; //���ڴ洢������� 
    stack<float>s2; //���ڴ洢������
    char a[200];
    for(int i=0;i<200;i++)
    {
    	a[i] = '\0';
	}
    input(a);
    if(isLawful(a)==-1)
    {
    	return 0;
	}
    int temp = 0;//�������ڴ����ڼ����ַ��� 
    for(int j=0;j<=200;j++)
    {
      if(a[temp]>=48&&a[temp]<=57)
      {
      	 s2.push(getFloat(a,&temp));
	  } 
	  if(s1.empty()==true)//��һ�������������ջ 
	  {
	    s1.push(a[temp]);
		temp++;	
	  } 
	   //�����ʱҪ��ջ����������ȼ�����ջ��Ԫ�ص����ȼ� ��ôֱ����ջ
	  else if(getGrade(a[temp])>getGrade(s1.top()))  
	  {
	      	s1.push(a[temp]); 
	      	temp++;
	  }
	  else if(getGrade(a[temp])<=getGrade(s1.top()))
	  {
	  	while(1)
	  	{  
	  	   if(a[temp]=='='&&s1.empty()==true)
	  	   {
	  	   	  if(s2.empty()!=true)
	  	   	  {
	  	   	      cout<<s2.top();
				  s2.pop();	
			  }
	  	   	  return 0;
			}
			if(a[temp]!='='&&s1.empty()==true)
			{
				s1.push(a[temp]); 
	         	temp++;
				break;
			}
	  	   if(getGrade(a[temp])>getGrade(s1.top()))
	  	   { 
	  	   	  s1.push(a[temp]);
	  	   	  temp++;
	  	   	  break;   	 
		   }
	  	   char temp3 = s1.top();
	  	   if(temp3=='('&&a[temp]!=')')//�����(+�������+ֱ����ջ 
	  	   {
	  	   	   s1.push(a[temp]); 
	  	   	    temp++;
	  	   	    break;   
		   }
		   if(temp3=='('&&a[temp]==')')//�����()������� (ֱ�ӳ�ջ  
	  	   {
	  	   	   s1.pop();
	  	   	    break;   
		   }
	  	   	    
	  	   s1.pop();//��������ջ 
	  	   if(temp3=='*')
		   {
		   	 float temp1 = s2.top();
		   	 s2.pop();
		   	 float temp2 = s2.top();
		   	 s2.pop();
		   	 s2.push(temp1*temp2);	   	
		   } 
		   if(temp3=='/')
		   {
		   	 float temp1 = s2.top();
		   	 s2.pop();
		   	 float temp2 = s2.top();
		   	 s2.pop();
		   	 s2.push(temp1/temp2);	   	
		   }
		  if(temp3=='+')
		   {
		   	 float temp1 = s2.top();
		   	 s2.pop();
		   	 float temp2 = s2.top();
		   	 s2.pop();
		   	  s2.push(temp1+temp2);  	
		   }
		    if(temp3=='-')
		   {
		   	 float temp1 = s2.top();
		   	 s2.pop();
		   	 float temp2 = s2.top();
		   	 s2.pop();
		   	 s2.push(temp1-temp2);	   	
		   }

		}
	  	
	  }
   } 
	
	
  return 0 ;	
} 
