#include<iostream>
#include<queue>
//存放int的 最大值 
using namespace std ;
//用prim算法求最小生成树 
//往优先队列放入的值 方便找到该权值连接的边 很重要 
class node{
	public: 
	int last ;
	int next ; 
	int weight ;
	//仿函数 
	node(int last,int next,int weight)
	{
		this->last = last;
		this->next = next;
		this->weight = weight ;
	}	
}; 
class cmp{
	public:
		bool operator()(const node& t1,const node& t2)const{
		//这个< 决定了大顶堆 >则是小顶堆 
		return t1.weight < t2.weight ;
	} 		
};
int main(void){
    //两个>> 要加空格 > > 
    node n(1,2,3);
    node n1(1,2,5);
    node n2(1,2,4);
    node n3(2,3,100); 
    //cmp这个类中放了一个 仿函数 (重载了()运算符,相当于cmp当函数名来使用 ) 
    priority_queue<node,vector<node>,cmp> q;
    q.push(n);
    q.push(n2);
    q.push(n3);
    q.push(n3);
    q.push(n3);
    while(q.empty()==false)
    {
    	cout<<q.top().weight<<endl;
    	q.pop();
    	
	}



} 
