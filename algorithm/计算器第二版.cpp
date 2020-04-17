#include<iostream>
#include<stack>
#include<stdlib.h>
#include<string.h>

using namespace std;
int getGrade(char c)  //获得运算符的等级 
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
void input(char*a)  //输入 
{
	for(int i=0;i<200;i++)
	{
		cin>>a[i];
		if(a[i]=='=')//以等号为结尾 
		{
			break;
		}
	}
	
}
int isLawful(char *a)//判断字符是否合法 
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
		//把读入的运算符合数字分离开来
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
	  if(c[i]!='+'&&c[i]!='-'&&c[i]!='*'&&c[i]!='/'&&c[i]!='('&&c[i]!=')'&&c[i]!='=')//判断运算符是否合法 
	  {
	  	    cout<<"无法处理运算符"; 
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
	        cout<<"括号出错!";  	  	
	  	  	return -1;
		  }
		  temp4--;
	  }
	  	
	}
	
	if(temp4!=0)
	{
		cout<<"括号不匹配!";
		return -1;
	}
	return 0; 	
}
float getFloat(char *a,int*temp)
{  
        //把数字截取出来 
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
    cout<<"请输入一个带=的表达式 注意:必须以=结尾 不然会出问题 输入完之后打个空格"; 
    stack<char>s1; //用于存储运算符， 
    stack<float>s2; //用于存储运算数
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
    int temp = 0;//看看现在处理到第几个字符了 
    for(int j=0;j<=200;j++)
    {
      if(a[temp]>=48&&a[temp]<=57)
      {
      	 s2.push(getFloat(a,&temp));
	  } 
	  if(s1.empty()==true)//第一个运算符必须入栈 
	  {
	    s1.push(a[temp]);
		temp++;	
	  } 
	   //如果此时要入栈的运算符优先级高于栈顶元素的优先级 那么直接入栈
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
	  	   if(temp3=='('&&a[temp]!=')')//如果是(+这种情况+直接入栈 
	  	   {
	  	   	   s1.push(a[temp]); 
	  	   	    temp++;
	  	   	    break;   
		   }
		   if(temp3=='('&&a[temp]==')')//如果是()这种情况 (直接出栈  
	  	   {
	  	   	   s1.pop();
	  	   	    break;   
		   }
	  	   	    
	  	   s1.pop();//操作符出栈 
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
